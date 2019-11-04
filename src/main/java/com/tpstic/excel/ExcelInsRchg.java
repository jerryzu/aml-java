package lab.crazyspark.excel;

import java.sql.SQLException;
import java.util.List;

import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;
import com.alibaba.excel.metadata.Sheet;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

public class ExcelInsRchg extends BaseRowModel {
    @ExcelProperty(value = "company_code1", index = 0)
    private String company_code1;
    @ExcelProperty(value = "company_code2", index = 1)
    private String company_code2;
    @ExcelProperty(value = "company_code3", index = 2)
    private String company_code3;
    @ExcelProperty(value = "company_code4", index = 3)
    private String company_code4;
    @ExcelProperty(value = "pol_no", index = 4)
    private String pol_no;
    @ExcelProperty(value = "app_no", index = 5)
    private String app_no;
    @ExcelProperty(value = "app_name", index = 6)
    private String app_name;
    @ExcelProperty(value = "app_cst_no", index = 7)
    private String app_cst_no;
    @ExcelProperty(value = "app_date", index = 8)
    private String app_date;
    @ExcelProperty(value = "chg_date", index = 9)
    private String chg_date;
    @ExcelProperty(value = "chg_no", index = 10)
    private String chg_no;
    @ExcelProperty(value = "item", index = 11)
    private String item;
    @ExcelProperty(value = "con_bef", index = 12)
    private String con_bef;

    public void print() {
        System.out.println(String.format(
                "InsRchg:  company_code1%s  company_code2%s  company_code3%s  company_code4%s  pol_no%s  app_no%s  app_name%s  app_cst_no%s  app_date%s  chg_date%s  chg_no%s  item%s  con_bef%s",
                company_code1, company_code2, company_code3, company_code4, pol_no, app_no, app_name, app_cst_no,
                app_date, chg_date, chg_no, item, con_bef));
    }

    public static List<ExcelInsRchg> Exp2Excel(QueryRunner runner, ExcelWriter writer, Sheet sheet)
            throws SQLException {
        sheet.setSheetName("InsRchg");
        String sql = "SELECT * from tb_ins_rchg";
        List<ExcelInsRchg> result = runner.query(sql, new BeanListHandler<ExcelInsRchg>(ExcelInsRchg.class));
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

    public String getcompany_code3() {
        return company_code3;
    }

    public void setcompany_code3(String company_code3) {
        this.company_code3 = company_code3;
    }

    public String getcompany_code4() {
        return company_code4;
    }

    public void setcompany_code4(String company_code4) {
        this.company_code4 = company_code4;
    }

    public String getpol_no() {
        return pol_no;
    }

    public void setpol_no(String pol_no) {
        this.pol_no = pol_no;
    }

    public String getapp_no() {
        return app_no;
    }

    public void setapp_no(String app_no) {
        this.app_no = app_no;
    }

    public String getapp_name() {
        return app_name;
    }

    public void setapp_name(String app_name) {
        this.app_name = app_name;
    }

    public String getapp_cst_no() {
        return app_cst_no;
    }

    public void setapp_cst_no(String app_cst_no) {
        this.app_cst_no = app_cst_no;
    }

    public String getapp_date() {
        return app_date;
    }

    public void setapp_date(String app_date) {
        this.app_date = app_date;
    }

    public String getchg_date() {
        return chg_date;
    }

    public void setchg_date(String chg_date) {
        this.chg_date = chg_date;
    }

    public String getchg_no() {
        return chg_no;
    }

    public void setchg_no(String chg_no) {
        this.chg_no = chg_no;
    }

    public String getitem() {
        return item;
    }

    public void setitem(String item) {
        this.item = item;
    }

    public String getcon_bef() {
        return con_bef;
    }

    public void setcon_bef(String con_bef) {
        this.con_bef = con_bef;
    }
}
