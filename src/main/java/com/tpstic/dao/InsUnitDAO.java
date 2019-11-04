package lab.crazyspark.dao;

import java.util.List;
import java.sql.SQLException;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.metadata.Sheet;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import lab.crazyspark.aml.BeanCfg;
import lab.crazyspark.bean.InsUnit;
import lab.crazyspark.excel.ExcelInsUnit;
import lab.crazyspark.utils.DBUtils;

public class InsUnitDAO {

    public static void ConvertData(QueryRunner runner, QueryRunner targetqr) {
        try {
            BeanCfg beanCfg  = DBUtils.GetBeanConfig(InsUnit.class, "InsUnit");
            String sql = beanCfg.getSql_imp();
            String inssql = "INSERT INTO tb_ins_unit(company_code1, company_code2, cst_no, open_time, close_time, acc_name, address, operate, set_file, license, id_deadline, org_no, tax_no, rep_name, id_type2, id_no2, id_deadline2, man_name, id_type3, id_no3, id_deadline3, ope_name, id_type4, id_no4, id_deadline4, industry_code, industry, reg_amt, code, sys_name)VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            List<InsUnit> insUnits = runner.query(sql, new BeanListHandler<InsUnit>(InsUnit.class));
            for (InsUnit insUnit : insUnits) {
                Object[] params = { insUnit.getcompany_code1(), insUnit.getCompany_code2(), insUnit.getCst_no(),
                        insUnit.getOpen_time(), insUnit.getClose_time(), insUnit.getAcc_name(), insUnit.getAddress(),
                        insUnit.getOperate(), insUnit.getSet_file(), insUnit.getLicense(), insUnit.getId_deadline(),
                        insUnit.getOrg_no(), insUnit.getTax_no(), insUnit.getRep_name(), insUnit.getId_type2(),
                        insUnit.getId_no2(), insUnit.getId_deadline2(), insUnit.getMan_name(), insUnit.getId_type3(),
                        insUnit.getId_no3(), insUnit.getId_deadline3(), insUnit.getOpe_name(), insUnit.getId_type4(),
                        insUnit.getId_no4(), insUnit.getId_deadline4(), insUnit.getIndustry_code(),
                        insUnit.getIndustry(), insUnit.getReg_amt(), insUnit.getCode(), insUnit.getSys_name() };
                targetqr.update(inssql, params);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static List<ExcelInsUnit> Exp2Excel(QueryRunner runner, ExcelWriter writer, Sheet sheet)
            throws SQLException {
        sheet.setSheetName("InsUnit");
        String sql = "SELECT * from tb_ins_unit";
        List<ExcelInsUnit> result = runner.query(sql, new BeanListHandler<ExcelInsUnit>(ExcelInsUnit.class));
        return result;
    }
}