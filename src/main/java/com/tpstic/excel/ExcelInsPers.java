package lab.crazyspark.excel;

import java.sql.SQLException;
import java.util.List;

import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;
import com.alibaba.excel.metadata.Sheet;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

public class ExcelInsPers extends BaseRowModel {
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
    @ExcelProperty(value = "cst_sex", index = 6)
    private String cst_sex;
    @ExcelProperty(value = "nation", index = 7)
    private String nation;
    @ExcelProperty(value = "id_type", index = 8)
    private String id_type;
    @ExcelProperty(value = "id_no", index = 9)
    private String id_no;
    @ExcelProperty(value = "id_deadline", index = 10)
    private String id_deadline;
    @ExcelProperty(value = "occupation_code", index = 11)
    private String occupation_code;
    @ExcelProperty(value = "occupation", index = 12)
    private String occupation;
    @ExcelProperty(value = "income", index = 13)
    private double income;
    @ExcelProperty(value = "contact1", index = 14)
    private String contact1;
    @ExcelProperty(value = "contact2", index = 15)
    private String contact2;
    @ExcelProperty(value = "contact3", index = 16)
    private String contact3;
    @ExcelProperty(value = "address1", index = 17)
    private String address1;
    @ExcelProperty(value = "address2", index = 18)
    private String address2;
    @ExcelProperty(value = "address3", index = 19)
    private String address3;
    @ExcelProperty(value = "company", index = 20)
    private String company;
    @ExcelProperty(value = "sys_name", index = 21)
    private String sys_name;

    public void print() {
        System.out.println(String.format(
                "InsPers:  company_code1%s  company_code2%s  cst_no%s  open_time%s  close_time%s  acc_name%s  cst_sex%s  nation%s  id_type%s  id_no%s  id_deadline%s  occupation_code%s  occupation%s  income%s  contact1%s  contact2%s  contact3%s  address1%s  address2%s  address3%s  company%s  sys_name%s",
                company_code1, company_code2, cst_no, open_time, close_time, acc_name, cst_sex, nation, id_type, id_no,
                id_deadline, occupation_code, occupation, income, contact1, contact2, contact3, address1, address2,
                address3, company, sys_name));
    }

    public static List<ExcelInsPers> Exp2Excel(QueryRunner runner, ExcelWriter writer, Sheet sheet)
            throws SQLException {
        sheet.setSheetName("InsPers");
        String sql = "SELECT * from tb_ins_pers";
        List<ExcelInsPers> result = runner.query(sql, new BeanListHandler<ExcelInsPers>(ExcelInsPers.class));
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

    public String getcst_sex() {
        return cst_sex;
    }

    public void setcst_sex(String cst_sex) {
        this.cst_sex = cst_sex;
    }

    public String getnation() {
        return nation;
    }

    public void setnation(String nation) {
        this.nation = nation;
    }

    public String getid_type() {
        return id_type;
    }

    public void setid_type(String id_type) {
        this.id_type = id_type;
    }

    public String getid_no() {
        return id_no;
    }

    public void setid_no(String id_no) {
        this.id_no = id_no;
    }

    public String getid_deadline() {
        return id_deadline;
    }

    public void setid_deadline(String id_deadline) {
        this.id_deadline = id_deadline;
    }

    public String getoccupation_code() {
        return occupation_code;
    }

    public void setoccupation_code(String occupation_code) {
        this.occupation_code = occupation_code;
    }

    public String getoccupation() {
        return occupation;
    }

    public void setoccupation(String occupation) {
        this.occupation = occupation;
    }

    public double getincome() {
        return income;
    }

    public void setincome(double income) {
        this.income = income;
    }

    public String getcontact1() {
        return contact1;
    }

    public void setcontact1(String contact1) {
        this.contact1 = contact1;
    }

    public String getcontact2() {
        return contact2;
    }

    public void setcontact2(String contact2) {
        this.contact2 = contact2;
    }

    public String getcontact3() {
        return contact3;
    }

    public void setcontact3(String contact3) {
        this.contact3 = contact3;
    }

    public String getaddress1() {
        return address1;
    }

    public void setaddress1(String address1) {
        this.address1 = address1;
    }

    public String getaddress2() {
        return address2;
    }

    public void setaddress2(String address2) {
        this.address2 = address2;
    }

    public String getaddress3() {
        return address3;
    }

    public void setaddress3(String address3) {
        this.address3 = address3;
    }

    public String getcompany() {
        return company;
    }

    public void setcompany(String company) {
        this.company = company;
    }

    public String getsys_name() {
        return sys_name;
    }

    public void setsys_name(String sys_name) {
        this.sys_name = sys_name;
    }
}
