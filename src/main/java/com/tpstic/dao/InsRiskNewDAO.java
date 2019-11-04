package lab.crazyspark.dao;

import java.util.List;
import java.sql.SQLException;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.metadata.Sheet;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import lab.crazyspark.aml.BeanCfg;
import lab.crazyspark.bean.InsRiskNew;
import lab.crazyspark.excel.ExcelInsRiskNew;
import lab.crazyspark.utils.DBUtils;

public class InsRiskNewDAO {

    public static void ConvertData(QueryRunner runner, QueryRunner targetqr) {
        try {
            BeanCfg beanCfg  = DBUtils.GetBeanConfig(InsRiskNew.class, "InsRiskNew");
            String sql = beanCfg.getSql_imp();
            String inssql = "INSERT INTO tb_ins_risk_new(company_code1, company_code2, company_code3, app_name, app_cst_no, app_id_no, risk_code, div_date, score, norm)VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            List<InsRiskNew> insRiskNews = runner.query(sql, new BeanListHandler<InsRiskNew>(InsRiskNew.class));
            for (InsRiskNew insRiskNew : insRiskNews) {
                Object[] params = { insRiskNew.getcompany_code1(), insRiskNew.getCompany_code2(),
                        insRiskNew.getCompany_code3(), insRiskNew.getApp_name(), insRiskNew.getApp_cst_no(),
                        insRiskNew.getApp_id_no(), insRiskNew.getRisk_code(), insRiskNew.getDiv_date(),
                        insRiskNew.getScore(), insRiskNew.getNorm() };
                targetqr.update(inssql, params);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static List<ExcelInsRiskNew> Exp2Excel(QueryRunner runner, ExcelWriter writer, Sheet sheet)
            throws SQLException {
        sheet.setSheetName("InsRiskNew");
        String sql = "SELECT * from tb_ins_risk_new";
        List<ExcelInsRiskNew> result = runner.query(sql, new BeanListHandler<ExcelInsRiskNew>(ExcelInsRiskNew.class));
        return result;
    }
}