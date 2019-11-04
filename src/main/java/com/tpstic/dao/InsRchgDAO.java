package lab.crazyspark.dao;

import java.util.List;
import java.sql.SQLException;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.metadata.Sheet;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import lab.crazyspark.aml.BeanCfg;
import lab.crazyspark.bean.InsRchg;
import lab.crazyspark.excel.ExcelInsRchg;
import lab.crazyspark.utils.DBUtils;

public class InsRchgDAO {

    public static void ConvertData(QueryRunner runner, QueryRunner targetqr) {
        try {
            BeanCfg beanCfg  = DBUtils.GetBeanConfig(InsRchg.class, "InsRchg");
            String sql = beanCfg.getSql_imp();
            String inssql = "INSERT INTO tb_ins_rchg(company_code1, company_code2, company_code3, company_code4, pol_no, app_no, app_name, app_cst_no, app_date, chg_date, chg_no, item, con_bef)VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            List<InsRchg> insRchgs = runner.query(sql, new BeanListHandler<InsRchg>(InsRchg.class));
            for (InsRchg insRchg : insRchgs) {
                Object[] params = { insRchg.getcompany_code1(), insRchg.getCompany_code2(), insRchg.getCompany_code3(),
                        insRchg.getCompany_code4(), insRchg.getPol_no(), insRchg.getApp_no(), insRchg.getApp_name(),
                        insRchg.getApp_cst_no(), insRchg.getApp_date(), insRchg.getChg_date(), insRchg.getChg_no(),
                        insRchg.getItem(), insRchg.getCon_bef() };
                targetqr.update(inssql, params);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static List<ExcelInsRchg> Exp2Excel(QueryRunner runner, ExcelWriter writer, Sheet sheet)
            throws SQLException {
        sheet.setSheetName("InsRchg");
        String sql = "SELECT * from tb_ins_rchg";
        List<ExcelInsRchg> result = runner.query(sql, new BeanListHandler<ExcelInsRchg>(ExcelInsRchg.class));
        return result;
    }
}