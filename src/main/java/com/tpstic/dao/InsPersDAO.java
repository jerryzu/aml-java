package lab.crazyspark.dao;

import java.util.List;
import java.sql.SQLException;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.metadata.Sheet;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import lab.crazyspark.aml.BeanCfg;
import lab.crazyspark.bean.InsPers;
import lab.crazyspark.excel.ExcelInsPers;
import lab.crazyspark.utils.DBUtils;

public class InsPersDAO {

    public static void ConvertData(QueryRunner runner, QueryRunner targetqr) {
        try {
            BeanCfg beanCfg  = DBUtils.GetBeanConfig(InsPers.class, "InsPers");
            String sql = beanCfg.getSql_imp();
            String inssql = "INSERT INTO tb_ins_pers(company_code1, company_code2, cst_no, open_time, close_time, acc_name, cst_sex, nation, id_type, id_no, id_deadline, occupation_code, occupation, income, contact1, contact2, contact3, address1, address2, address3, company, sys_name)VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            List<InsPers> insPerss = runner.query(sql, new BeanListHandler<InsPers>(InsPers.class));
            for (InsPers insPers : insPerss) {
                Object[] params = { insPers.getcompany_code1(), insPers.getCompany_code2(), insPers.getCst_no(),
                        insPers.getOpen_time(), insPers.getClose_time(), insPers.getAcc_name(), insPers.getCst_sex(),
                        insPers.getNation(), insPers.getId_type(), insPers.getId_no(), insPers.getId_deadline(),
                        insPers.getOccupation_code(), insPers.getOccupation(), insPers.getIncome(),
                        insPers.getContact1(), insPers.getContact2(), insPers.getContact3(), insPers.getAddress1(),
                        insPers.getAddress2(), insPers.getAddress3(), insPers.getCompany(), insPers.getSys_name() };
                targetqr.update(inssql, params);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static List<ExcelInsPers> Exp2Excel(QueryRunner runner, ExcelWriter writer, Sheet sheet)
            throws SQLException {
        sheet.setSheetName("InsPers");
        String sql = "SELECT * from tb_ins_pers";
        List<ExcelInsPers> result = runner.query(sql, new BeanListHandler<ExcelInsPers>(ExcelInsPers.class));
        return result;
    }
}