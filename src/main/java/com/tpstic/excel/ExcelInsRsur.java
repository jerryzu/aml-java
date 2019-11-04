package lab.crazyspark.excel;

import java.sql.SQLException;
import java.util.List;

import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;
import com.alibaba.excel.metadata.Sheet;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

public class ExcelInsRsur extends BaseRowModel {
    @ExcelProperty(value = "company_code1", index = 0)
    private String company_code1;
    @ExcelProperty(value = "company_code2", index = 1)
    private String company_code2;
    @ExcelProperty(value = "company_code3", index = 2)
    private String company_code3;
    @ExcelProperty(value = "company_code4", index = 3)
    private String company_code4;
    @ExcelProperty(value = "pay_type", index = 4)
    private String pay_type;
    @ExcelProperty(value = "pol_no", index = 5)
    private String pol_no;
    @ExcelProperty(value = "app_no", index = 6)
    private String app_no;
    @ExcelProperty(value = "ins_date", index = 7)
    private String ins_date;
    @ExcelProperty(value = "eff_date", index = 8)
    private String eff_date;
    @ExcelProperty(value = "cur_code", index = 9)
    private String cur_code;
    @ExcelProperty(value = "pre_amt_all", index = 10)
    private double pre_amt_all;
    @ExcelProperty(value = "usd_amt_all", index = 11)
    private double usd_amt_all;
    @ExcelProperty(value = "pay_amt_all", index = 12)
    private double pay_amt_all;
    @ExcelProperty(value = "usd_pay_amt_all", index = 13)
    private double usd_pay_amt_all;
    @ExcelProperty(value = "app_name", index = 14)
    private String app_name;
    @ExcelProperty(value = "app_cst_no", index = 15)
    private String app_cst_no;
    @ExcelProperty(value = "id_no", index = 16)
    private String id_no;
    @ExcelProperty(value = "cus_pro", index = 17)
    private String cus_pro;
    @ExcelProperty(value = "sur_name", index = 18)
    private String sur_name;
    @ExcelProperty(value = "sur_id_no", index = 19)
    private String sur_id_no;
    @ExcelProperty(value = "sur_date", index = 20)
    private String sur_date;
    @ExcelProperty(value = "pay_date", index = 21)
    private String pay_date;
    @ExcelProperty(value = "cur_code2", index = 22)
    private String cur_code2;
    @ExcelProperty(value = "sur_amt", index = 23)
    private double sur_amt;
    @ExcelProperty(value = "usd_sur_amt", index = 24)
    private double usd_sur_amt;
    @ExcelProperty(value = "tsf_flag", index = 25)
    private String tsf_flag;
    @ExcelProperty(value = "acc_name", index = 26)
    private String acc_name;
    @ExcelProperty(value = "acc_no", index = 27)
    private String acc_no;
    @ExcelProperty(value = "acc_bank", index = 28)
    private String acc_bank;
    @ExcelProperty(value = "receipt_no", index = 29)
    private String receipt_no;
    @ExcelProperty(value = "endorse_no", index = 30)
    private String endorse_no;

    public void print() {
        System.out.println(String.format(
                "InsRsur:  company_code1%s  company_code2%s  company_code3%s  company_code4%s  pay_type%s  pol_no%s  app_no%s  ins_date%s  eff_date%s  cur_code%s  pre_amt_all%s  usd_amt_all%s  pay_amt_all%s  usd_pay_amt_all%s  app_name%s  app_cst_no%s  id_no%s  cus_pro%s  sur_name%s  sur_id_no%s  sur_date%s  pay_date%s  cur_code2%s  sur_amt%s  usd_sur_amt%s  tsf_flag%s  acc_name%s  acc_no%s  acc_bank%s  receipt_no%s  endorse_no%s",
                company_code1, company_code2, company_code3, company_code4, pay_type, pol_no, app_no, ins_date,
                eff_date, cur_code, pre_amt_all, usd_amt_all, pay_amt_all, usd_pay_amt_all, app_name, app_cst_no, id_no,
                cus_pro, sur_name, sur_id_no, sur_date, pay_date, cur_code2, sur_amt, usd_sur_amt, tsf_flag, acc_name,
                acc_no, acc_bank, receipt_no, endorse_no));
    }

    public static List<ExcelInsRsur> Exp2Excel(QueryRunner runner, ExcelWriter writer, Sheet sheet)
            throws SQLException {
        sheet.setSheetName("InsRsur");
        String sql = "SELECT * from tb_ins_rsur";
        List<ExcelInsRsur> result = runner.query(sql, new BeanListHandler<ExcelInsRsur>(ExcelInsRsur.class));
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

    public String getpay_type() {
        return pay_type;
    }

    public void setpay_type(String pay_type) {
        this.pay_type = pay_type;
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

    public String geteff_date() {
        return eff_date;
    }

    public void seteff_date(String eff_date) {
        this.eff_date = eff_date;
    }

    public String getcur_code() {
        return cur_code;
    }

    public void setcur_code(String cur_code) {
        this.cur_code = cur_code;
    }

    public double getpre_amt_all() {
        return pre_amt_all;
    }

    public void setpre_amt_all(double pre_amt_all) {
        this.pre_amt_all = pre_amt_all;
    }

    public double getusd_amt_all() {
        return usd_amt_all;
    }

    public void setusd_amt_all(double usd_amt_all) {
        this.usd_amt_all = usd_amt_all;
    }

    public double getpay_amt_all() {
        return pay_amt_all;
    }

    public void setpay_amt_all(double pay_amt_all) {
        this.pay_amt_all = pay_amt_all;
    }

    public double getusd_pay_amt_all() {
        return usd_pay_amt_all;
    }

    public void setusd_pay_amt_all(double usd_pay_amt_all) {
        this.usd_pay_amt_all = usd_pay_amt_all;
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

    public String getid_no() {
        return id_no;
    }

    public void setid_no(String id_no) {
        this.id_no = id_no;
    }

    public String getcus_pro() {
        return cus_pro;
    }

    public void setcus_pro(String cus_pro) {
        this.cus_pro = cus_pro;
    }

    public String getsur_name() {
        return sur_name;
    }

    public void setsur_name(String sur_name) {
        this.sur_name = sur_name;
    }

    public String getsur_id_no() {
        return sur_id_no;
    }

    public void setsur_id_no(String sur_id_no) {
        this.sur_id_no = sur_id_no;
    }

    public String getsur_date() {
        return sur_date;
    }

    public void setsur_date(String sur_date) {
        this.sur_date = sur_date;
    }

    public String getpay_date() {
        return pay_date;
    }

    public void setpay_date(String pay_date) {
        this.pay_date = pay_date;
    }

    public String getcur_code2() {
        return cur_code2;
    }

    public void setcur_code2(String cur_code2) {
        this.cur_code2 = cur_code2;
    }

    public double getsur_amt() {
        return sur_amt;
    }

    public void setsur_amt(double sur_amt) {
        this.sur_amt = sur_amt;
    }

    public double getusd_sur_amt() {
        return usd_sur_amt;
    }

    public void setusd_sur_amt(double usd_sur_amt) {
        this.usd_sur_amt = usd_sur_amt;
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
