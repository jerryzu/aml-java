package lab.crazyspark.excel;

import java.sql.SQLException;
import java.util.List;

import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;
import com.alibaba.excel.metadata.Sheet;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

public class ExcelCompany extends BaseRowModel {
    @ExcelProperty(value = "head_no", index = 0)
    private String head_no;

    @ExcelProperty(value = "company_code1", index = 1)
    private String company_code1;

    @ExcelProperty(value = "company_code2", index = 2)
    private String company_code2;

    @ExcelProperty(value = "company_name", index = 3)
    private String company_name;

    @ExcelProperty(value = "bord_flag", index = 4)
    private String bord_flag;

    public void print() {
        System.out
                .println(String.format("Company: head_no%s company_code1%s company_code2%s company_name%s bord_flag%s",
                        head_no, company_code1, company_code2, company_name, bord_flag));
    }

    // public static List<ExcelCompany> Exp2Excel(QueryRunner runner, ExcelWriter
    // writer, Sheet sheet)
    // throws SQLException {
    // sheet.setSheetName("Company");
    // String sql = "SELECT * from tb_company";
    // List<ExcelCompany> result = runner.query(sql, new
    // BeanListHandler<ExcelCompany>(ExcelCompany.class));
    // return result;
    // }

    public String getHead_no() {
        return head_no;
    }

    public void setHead_no(String head_no) {
        this.head_no = head_no;
    }

    public String getCompany_code1() {
        return company_code1;
    }

    public void setCompany_code1(String company_code1) {
        this.company_code1 = company_code1;
    }

    public String getCompany_code2() {
        return company_code2;
    }

    public void setCompany_code2(String company_code2) {
        this.company_code2 = company_code2;
    }

    public String getCompany_name() {
        return company_name;
    }

    public void setCompany_name(String company_name) {
        this.company_name = company_name;
    }

    public String getBord_flag() {
        return bord_flag;
    }

    public void setBord_flag(String bord_flag) {
        this.bord_flag = bord_flag;
    }
}