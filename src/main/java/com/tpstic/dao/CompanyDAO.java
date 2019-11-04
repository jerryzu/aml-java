package lab.crazyspark.dao;

import java.sql.SQLException;
import java.util.List;

import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.metadata.Sheet;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import lab.crazyspark.aml.BeanCfg;
import lab.crazyspark.bean.Company;
import lab.crazyspark.excel.ExcelCompany;
import lab.crazyspark.utils.DBUtils;

public class CompanyDAO {
    public static void ConvertData(QueryRunner runner, QueryRunner targetqr) {
        try {
            BeanCfg beanCfg = DBUtils.GetBeanConfig(Company.class, "Company");
            String sql = beanCfg.getSql_imp();
            String inssql = "INSERT INTO tb_company(head_no,company_code1,company_code2,company_name,bord_flag)VALUES(?,?,?,?,?)";
            List<Company> companys = runner.query(sql, new BeanListHandler<Company>(Company.class));
            for (Company company : companys) {
                Object[] params = { company.getHead_no(), company.getCompany_code1(), company.getCompany_code2(),
                        company.getCompany_name(), company.getBord_flag() };
                targetqr.update(inssql, params);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static List<ExcelCompany> Exp2Excel(QueryRunner runner, ExcelWriter writer, Sheet sheet)
            throws SQLException {
        sheet.setSheetName("Company");
        String sql = "SELECT * from tb_company";
        List<ExcelCompany> result = runner.query(sql, new BeanListHandler<ExcelCompany>(ExcelCompany.class));
        return result;
    }
}