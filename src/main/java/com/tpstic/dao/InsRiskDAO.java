package lab.crazyspark.dao;

import java.util.List;
import java.sql.SQLException;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.metadata.Sheet;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import lab.crazyspark.aml.BeanCfg;
import lab.crazyspark.bean.InsRisk;
import lab.crazyspark.excel.ExcelInsRisk;
import lab.crazyspark.utils.DBUtils;

public class InsRiskDAO {

    public static void ConvertData(QueryRunner runner, QueryRunner targetqr) {
        try {
            BeanCfg beanCfg = DBUtils.GetBeanConfig(InsRisk.class, "InsRisk");
            String sql = beanCfg.getSql_imp();
            String inssql = "INSERT INTO tb_ins_risk(company_code1, company_code2, company_code3, app_name, app_cst_no, app_id_no, risk_code, div_date, first_type, score, norm)VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            List<InsRisk> insRisks = runner.query(sql, new BeanListHandler<InsRisk>(InsRisk.class));
            for (InsRisk insRisk : insRisks) {
                Object[] params = { insRisk.getcompany_code1(), insRisk.getCompany_code2(), insRisk.getCompany_code3(),
                        insRisk.getApp_name(), insRisk.getApp_cst_no(), insRisk.getApp_id_no(), insRisk.getRisk_code(),
                        insRisk.getDiv_date(), insRisk.getFirst_type(), insRisk.getScore(), insRisk.getNorm() };
                targetqr.update(inssql, params);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static List<ExcelInsRisk> Exp2Excel(QueryRunner runner, ExcelWriter writer, Sheet sheet)
            throws SQLException {
        sheet.setSheetName("InsRisk");
        String sql = "SELECT * from tb_ins_risk";
        List<ExcelInsRisk> result = runner.query(sql, new BeanListHandler<ExcelInsRisk>(ExcelInsRisk.class));
        return result;
    }
}