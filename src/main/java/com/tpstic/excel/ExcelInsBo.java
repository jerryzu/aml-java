package lab.crazyspark.excel;

import java.sql.SQLException;
import java.util.List;

import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;
import com.alibaba.excel.metadata.Sheet;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

public class ExcelInsBo extends BaseRowModel {
    @ExcelProperty(value = "company_code1", index = 0)
    private String company_code1;
    @ExcelProperty(value = "company_code2", index = 1)
    private String company_code2;
    @ExcelProperty(value = "acc_name", index = 2)
    private String acc_name;
    @ExcelProperty(value = "cst_no", index = 3)
    private String cst_no;
    @ExcelProperty(value = "license", index = 4)
    private String license;
    @ExcelProperty(value = "bnf_name", index = 5)
    private String bnf_name;
    @ExcelProperty(value = "bnf_type", index = 6)
    private String bnf_type;
    @ExcelProperty(value = "shareholding_ratio", index = 7)
    private double shareholding_ratio;
    @ExcelProperty(value = "bnf_address", index = 8)
    private String bnf_address;
    @ExcelProperty(value = "id_type5", index = 9)
    private String id_type5;
    @ExcelProperty(value = "id_no5", index = 10)
    private String id_no5;
    @ExcelProperty(value = "id_deadline5", index = 11)
    private String id_deadline5;
    @ExcelProperty(value = "sys_name", index = 12)
    private String sys_name;

    public void print() {
        System.out.println(String.format(
                "InsBo:  company_code1%s  company_code2%s  acc_name%s  cst_no%s  license%s  bnf_name%s  bnf_type%s  shareholding_ratio%s  bnf_address%s  id_type5%s  id_no5%s  id_deadline5%s  sys_name%s",
                company_code1, company_code2, acc_name, cst_no, license, bnf_name, bnf_type, shareholding_ratio,
                bnf_address, id_type5, id_no5, id_deadline5, sys_name));
    }

    public static List<ExcelInsBo> Exp2Excel(QueryRunner runner, ExcelWriter writer, Sheet sheet) throws SQLException {
        sheet.setSheetName("InsBo");
        String sql = "SELECT * from tb_ins_bo";
        List<ExcelInsBo> result = runner.query(sql, new BeanListHandler<ExcelInsBo>(ExcelInsBo.class));
        return result;
    }

    public String getcompany_code1() {
        return company_code1;
    }

    public void setcompany_code1(String company_code1) {
        this.company_code1 = company_code1;
    }

    public String getcompany_code2() {
        return company_code2;
    }

    public void setcompany_code2(String company_code2) {
        this.company_code2 = company_code2;
    }

    public String getacc_name() {
        return acc_name;
    }

    public void setacc_name(String acc_name) {
        this.acc_name = acc_name;
    }

    public String getcst_no() {
        return cst_no;
    }

    public void setcst_no(String cst_no) {
        this.cst_no = cst_no;
    }

    public String getlicense() {
        return license;
    }

    public void setlicense(String license) {
        this.license = license;
    }

    public String getbnf_name() {
        return bnf_name;
    }

    public void setbnf_name(String bnf_name) {
        this.bnf_name = bnf_name;
    }

    public String getbnf_type() {
        return bnf_type;
    }

    public void setbnf_type(String bnf_type) {
        this.bnf_type = bnf_type;
    }

    public double getshareholding_ratio() {
        return shareholding_ratio;
    }

    public void setshareholding_ratio(double shareholding_ratio) {
        this.shareholding_ratio = shareholding_ratio;
    }

    public String getbnf_address() {
        return bnf_address;
    }

    public void setbnf_address(String bnf_address) {
        this.bnf_address = bnf_address;
    }

    public String getid_type5() {
        return id_type5;
    }

    public void setid_type5(String id_type5) {
        this.id_type5 = id_type5;
    }

    public String getid_no5() {
        return id_no5;
    }

    public void setid_no5(String id_no5) {
        this.id_no5 = id_no5;
    }

    public String getid_deadline5() {
        return id_deadline5;
    }

    public void setid_deadline5(String id_deadline5) {
        this.id_deadline5 = id_deadline5;
    }

    public String getsys_name() {
        return sys_name;
    }

    public void setsys_name(String sys_name) {
        this.sys_name = sys_name;
    }
}
