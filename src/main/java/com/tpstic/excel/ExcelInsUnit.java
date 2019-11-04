package lab.crazyspark.excel;

import java.sql.SQLException;
import java.util.List;

import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;
import com.alibaba.excel.metadata.Sheet;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

public class ExcelInsUnit extends BaseRowModel {
    @ExcelProperty(value = "company_code1", index = 0)
    private String company_code1;
    @ExcelProperty(value = "company_code2", index = 1)
    private String company_code2;
    @ExcelProperty(value = "cst_no", index = 2)
    private String cst_no;
    @ExcelProperty(value = "open_time", index = 3)
    private String open_time;
    @ExcelProperty(value = "close_time", index = 4)
    private String close_time;
    @ExcelProperty(value = "acc_name", index = 5)
    private String acc_name;
    @ExcelProperty(value = "address", index = 6)
    private String address;
    @ExcelProperty(value = "operate", index = 7)
    private String operate;
    @ExcelProperty(value = "set_file", index = 8)
    private String set_file;
    @ExcelProperty(value = "license", index = 9)
    private String license;
    @ExcelProperty(value = "id_deadline", index = 10)
    private String id_deadline;
    @ExcelProperty(value = "org_no", index = 11)
    private String org_no;
    @ExcelProperty(value = "tax_no", index = 12)
    private String tax_no;
    @ExcelProperty(value = "rep_name", index = 13)
    private String rep_name;
    @ExcelProperty(value = "id_type2", index = 14)
    private String id_type2;
    @ExcelProperty(value = "id_no2", index = 15)
    private String id_no2;
    @ExcelProperty(value = "id_deadline2", index = 16)
    private String id_deadline2;
    @ExcelProperty(value = "man_name", index = 17)
    private String man_name;
    @ExcelProperty(value = "id_type3", index = 18)
    private String id_type3;
    @ExcelProperty(value = "id_no3", index = 19)
    private String id_no3;
    @ExcelProperty(value = "id_deadline3", index = 20)
    private String id_deadline3;
    @ExcelProperty(value = "ope_name", index = 21)
    private String ope_name;
    @ExcelProperty(value = "id_type4", index = 22)
    private String id_type4;
    @ExcelProperty(value = "id_no4", index = 23)
    private String id_no4;
    @ExcelProperty(value = "id_deadline4", index = 24)
    private String id_deadline4;
    @ExcelProperty(value = "industry_code", index = 25)
    private String industry_code;
    @ExcelProperty(value = "industry", index = 26)
    private String industry;
    @ExcelProperty(value = "reg_amt", index = 27)
    private double reg_amt;
    @ExcelProperty(value = "code", index = 28)
    private String code;
    @ExcelProperty(value = "sys_name", index = 29)
    private String sys_name;

    public void print() {
        System.out.println(String.format(
                "InsUnit:  company_code1%s  company_code2%s  cst_no%s  open_time%s  close_time%s  acc_name%s  address%s  operate%s  set_file%s  license%s  id_deadline%s  org_no%s  tax_no%s  rep_name%s  id_type2%s  id_no2%s  id_deadline2%s  man_name%s  id_type3%s  id_no3%s  id_deadline3%s  ope_name%s  id_type4%s  id_no4%s  id_deadline4%s  industry_code%s  industry%s  reg_amt%s  code%s  sys_name%s",
                company_code1, company_code2, cst_no, open_time, close_time, acc_name, address, operate, set_file,
                license, id_deadline, org_no, tax_no, rep_name, id_type2, id_no2, id_deadline2, man_name, id_type3,
                id_no3, id_deadline3, ope_name, id_type4, id_no4, id_deadline4, industry_code, industry, reg_amt, code,
                sys_name));
    }

    public static List<ExcelInsUnit> Exp2Excel(QueryRunner runner, ExcelWriter writer, Sheet sheet)
            throws SQLException {
        sheet.setSheetName("InsUnit");
        String sql = "SELECT * from tb_ins_unit";
        List<ExcelInsUnit> result = runner.query(sql, new BeanListHandler<ExcelInsUnit>(ExcelInsUnit.class));
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

    public String getcst_no() {
        return cst_no;
    }

    public void setcst_no(String cst_no) {
        this.cst_no = cst_no;
    }

    public String getopen_time() {
        return open_time;
    }

    public void setopen_time(String open_time) {
        this.open_time = open_time;
    }

    public String getclose_time() {
        return close_time;
    }

    public void setclose_time(String close_time) {
        this.close_time = close_time;
    }

    public String getacc_name() {
        return acc_name;
    }

    public void setacc_name(String acc_name) {
        this.acc_name = acc_name;
    }

    public String getaddress() {
        return address;
    }

    public void setaddress(String address) {
        this.address = address;
    }

    public String getoperate() {
        return operate;
    }

    public void setoperate(String operate) {
        this.operate = operate;
    }

    public String getset_file() {
        return set_file;
    }

    public void setset_file(String set_file) {
        this.set_file = set_file;
    }

    public String getlicense() {
        return license;
    }

    public void setlicense(String license) {
        this.license = license;
    }

    public String getid_deadline() {
        return id_deadline;
    }

    public void setid_deadline(String id_deadline) {
        this.id_deadline = id_deadline;
    }

    public String getorg_no() {
        return org_no;
    }

    public void setorg_no(String org_no) {
        this.org_no = org_no;
    }

    public String gettax_no() {
        return tax_no;
    }

    public void settax_no(String tax_no) {
        this.tax_no = tax_no;
    }

    public String getrep_name() {
        return rep_name;
    }

    public void setrep_name(String rep_name) {
        this.rep_name = rep_name;
    }

    public String getid_type2() {
        return id_type2;
    }

    public void setid_type2(String id_type2) {
        this.id_type2 = id_type2;
    }

    public String getid_no2() {
        return id_no2;
    }

    public void setid_no2(String id_no2) {
        this.id_no2 = id_no2;
    }

    public String getid_deadline2() {
        return id_deadline2;
    }

    public void setid_deadline2(String id_deadline2) {
        this.id_deadline2 = id_deadline2;
    }

    public String getman_name() {
        return man_name;
    }

    public void setman_name(String man_name) {
        this.man_name = man_name;
    }

    public String getid_type3() {
        return id_type3;
    }

    public void setid_type3(String id_type3) {
        this.id_type3 = id_type3;
    }

    public String getid_no3() {
        return id_no3;
    }

    public void setid_no3(String id_no3) {
        this.id_no3 = id_no3;
    }

    public String getid_deadline3() {
        return id_deadline3;
    }

    public void setid_deadline3(String id_deadline3) {
        this.id_deadline3 = id_deadline3;
    }

    public String getope_name() {
        return ope_name;
    }

    public void setope_name(String ope_name) {
        this.ope_name = ope_name;
    }

    public String getid_type4() {
        return id_type4;
    }

    public void setid_type4(String id_type4) {
        this.id_type4 = id_type4;
    }

    public String getid_no4() {
        return id_no4;
    }

    public void setid_no4(String id_no4) {
        this.id_no4 = id_no4;
    }

    public String getid_deadline4() {
        return id_deadline4;
    }

    public void setid_deadline4(String id_deadline4) {
        this.id_deadline4 = id_deadline4;
    }

    public String getindustry_code() {
        return industry_code;
    }

    public void setindustry_code(String industry_code) {
        this.industry_code = industry_code;
    }

    public String getindustry() {
        return industry;
    }

    public void setindustry(String industry) {
        this.industry = industry;
    }

    public double getreg_amt() {
        return reg_amt;
    }

    public void setreg_amt(double reg_amt) {
        this.reg_amt = reg_amt;
    }

    public String getcode() {
        return code;
    }

    public void setcode(String code) {
        this.code = code;
    }

    public String getsys_name() {
        return sys_name;
    }

    public void setsys_name(String sys_name) {
        this.sys_name = sys_name;
    }
}
