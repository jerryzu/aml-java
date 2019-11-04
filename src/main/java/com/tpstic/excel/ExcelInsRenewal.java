package lab.crazyspark.excel;

import java.sql.SQLException;
import java.util.List;

import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;
import com.alibaba.excel.metadata.Sheet;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

public class ExcelInsRenewal extends BaseRowModel {
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
    @ExcelProperty(value = "ins_date", index = 6)
    private String ins_date;
    @ExcelProperty(value = "app_name", index = 7)
    private String app_name;
    @ExcelProperty(value = "app_cst_no", index = 8)
    private String app_cst_no;
    @ExcelProperty(value = "app_id_type", index = 9)
    private String app_id_type;
    @ExcelProperty(value = "app_id_no", index = 10)
    private String app_id_no;
    @ExcelProperty(value = "ins_no", index = 11)
    private String ins_no;
    @ExcelProperty(value = "renew_date", index = 12)
    private String renew_date;
    @ExcelProperty(value = "pay_date", index = 13)
    private String pay_date;
    @ExcelProperty(value = "cur_code", index = 14)
    private String cur_code;
    @ExcelProperty(value = "pre_amt", index = 15)
    private double pre_amt;
    @ExcelProperty(value = "usd_amt", index = 16)
    private double usd_amt;
    @ExcelProperty(value = "tsf_flag", index = 17)
    private String tsf_flag;
    @ExcelProperty(value = "acc_name", index = 18)
    private String acc_name;
    @ExcelProperty(value = "acc_no", index = 19)
    private String acc_no;
    @ExcelProperty(value = "acc_bank", index = 20)
    private String acc_bank;
    @ExcelProperty(value = "receipt_no", index = 21)
    private String receipt_no;
    @ExcelProperty(value = "endorse_no", index = 22)
    private String endorse_no;

    public void print() {
        System.out.println(String.format(
                "InsRenewal:  company_code1%s  company_code2%s  company_code3%s  company_code4%s  pol_no%s  app_no%s  ins_date%s  app_name%s  app_cst_no%s  app_id_type%s  app_id_no%s  ins_no%s  renew_date%s  pay_date%s  cur_code%s  pre_amt%s  usd_amt%s  tsf_flag%s  acc_name%s  acc_no%s  acc_bank%s  receipt_no%s  endorse_no%s",
                company_code1, company_code2, company_code3, company_code4, pol_no, app_no, ins_date, app_name,
                app_cst_no, app_id_type, app_id_no, ins_no, renew_date, pay_date, cur_code, pre_amt, usd_amt, tsf_flag,
                acc_name, acc_no, acc_bank, receipt_no, endorse_no));
    }

    public static List<ExcelInsRenewal> Exp2Excel(QueryRunner runner, ExcelWriter writer, Sheet sheet)
            throws SQLException {
        sheet.setSheetName("InsRenewal");
        String sql = "SELECT * from tb_ins_renewal";
        List<ExcelInsRenewal> result = runner.query(sql, new BeanListHandler<ExcelInsRenewal>(ExcelInsRenewal.class));
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

    public String getins_date() {
        return ins_date;
    }

    public void setins_date(String ins_date) {
        this.ins_date = ins_date;
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

    public String getapp_id_type() {
        return app_id_type;
    }

    public void setapp_id_type(String app_id_type) {
        this.app_id_type = app_id_type;
    }

    public String getapp_id_no() {
        return app_id_no;
    }

    public void setapp_id_no(String app_id_no) {
        this.app_id_no = app_id_no;
    }

    public String getins_no() {
        return ins_no;
    }

    public void setins_no(String ins_no) {
        this.ins_no = ins_no;
    }

    public String getrenew_date() {
        return renew_date;
    }

    public void setrenew_date(String renew_date) {
        this.renew_date = renew_date;
    }

    public String getpay_date() {
        return pay_date;
    }

    public void setpay_date(String pay_date) {
        this.pay_date = pay_date;
    }

    public String getcur_code() {
        return cur_code;
    }

    public void setcur_code(String cur_code) {
        this.cur_code = cur_code;
    }

    public double getpre_amt() {
        return pre_amt;
    }

    public void setpre_amt(double pre_amt) {
        this.pre_amt = pre_amt;
    }

    public double getusd_amt() {
        return usd_amt;
    }

    public void setusd_amt(double usd_amt) {
        this.usd_amt = usd_amt;
    }

    public String gettsf_flag() {
        return tsf_flag;
    }

    public void settsf_flag(String tsf_flag) {
        this.tsf_flag = tsf_flag;
    }

    public String getacc_name() {
        return acc_name;
    }

    public void setacc_name(String acc_name) {
        this.acc_name = acc_name;
    }

    public String getacc_no() {
        return acc_no;
    }

    public void setacc_no(String acc_no) {
        this.acc_no = acc_no;
    }

    public String getacc_bank() {
        return acc_bank;
    }

    public void setacc_bank(String acc_bank) {
        this.acc_bank = acc_bank;
    }

    public String getreceipt_no() {
        return receipt_no;
    }

    public void setreceipt_no(String receipt_no) {
        this.receipt_no = receipt_no;
    }

    public String getendorse_no() {
        return endorse_no;
    }

    public void setendorse_no(String endorse_no) {
        this.endorse_no = endorse_no;
    }
}
