package lab.crazyspark.excel;

import java.sql.SQLException;
import java.util.List;

import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;
import com.alibaba.excel.metadata.Sheet;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

public class ExcelInsRpay extends BaseRowModel {
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
    @ExcelProperty(value = "eff_date", index = 7)
    private String eff_date;
    @ExcelProperty(value = "cur_code1", index = 8)
    private String cur_code1;
    @ExcelProperty(value = "pre_amt_all", index = 9)
    private double pre_amt_all;
    @ExcelProperty(value = "usd_amt_all", index = 10)
    private double usd_amt_all;
    @ExcelProperty(value = "app_name", index = 11)
    private String app_name;
    @ExcelProperty(value = "app_cst_no", index = 12)
    private String app_cst_no;
    @ExcelProperty(value = "app_id_no", index = 13)
    private String app_id_no;
    @ExcelProperty(value = "app_cus_pro", index = 14)
    private String app_cus_pro;
    @ExcelProperty(value = "ins_name", index = 15)
    private String ins_name;
    @ExcelProperty(value = "ins_cst_no", index = 16)
    private String ins_cst_no;
    @ExcelProperty(value = "ins_id_no", index = 17)
    private String ins_id_no;
    @ExcelProperty(value = "ins_cus_pro", index = 18)
    private String ins_cus_pro;
    @ExcelProperty(value = "benefit_name", index = 19)
    private String benefit_name;
    @ExcelProperty(value = "benefit_id_no", index = 20)
    private String benefit_id_no;
    @ExcelProperty(value = "benefit_pro", index = 21)
    private String benefit_pro;
    @ExcelProperty(value = "relation_1", index = 22)
    private String relation_1;
    @ExcelProperty(value = "relation_2", index = 23)
    private String relation_2;
    @ExcelProperty(value = "pay_type", index = 24)
    private String pay_type;
    @ExcelProperty(value = "rpay_date", index = 25)
    private String rpay_date;
    @ExcelProperty(value = "pay_date", index = 26)
    private String pay_date;
    @ExcelProperty(value = "cur_code2", index = 27)
    private String cur_code2;
    @ExcelProperty(value = "pay_amt", index = 28)
    private double pay_amt;
    @ExcelProperty(value = "pay_usd_amt", index = 29)
    private double pay_usd_amt;
    @ExcelProperty(value = "tsf_flag", index = 30)
    private String tsf_flag;
    @ExcelProperty(value = "acc_name", index = 31)
    private String acc_name;
    @ExcelProperty(value = "acc_no", index = 32)
    private String acc_no;
    @ExcelProperty(value = "acc_bank", index = 33)
    private String acc_bank;
    @ExcelProperty(value = "receipt_no", index = 34)
    private String receipt_no;

    public void print() {
        System.out.println(String.format(
                "InsRpay:  company_code1%s  company_code2%s  company_code3%s  company_code4%s  pol_no%s  app_no%s  ins_date%s  eff_date%s  cur_code1%s  pre_amt_all%s  usd_amt_all%s  app_name%s  app_cst_no%s  app_id_no%s  app_cus_pro%s  ins_name%s  ins_cst_no%s  ins_id_no%s  ins_cus_pro%s  benefit_name%s  benefit_id_no%s  benefit_pro%s  relation_1%s  relation_2%s  pay_type%s  rpay_date%s  pay_date%s  cur_code2%s  pay_amt%s  pay_usd_amt%s  tsf_flag%s  acc_name%s  acc_no%s  acc_bank%s  receipt_no%s",
                company_code1, company_code2, company_code3, company_code4, pol_no, app_no, ins_date, eff_date,
                cur_code1, pre_amt_all, usd_amt_all, app_name, app_cst_no, app_id_no, app_cus_pro, ins_name, ins_cst_no,
                ins_id_no, ins_cus_pro, benefit_name, benefit_id_no, benefit_pro, relation_1, relation_2, pay_type,
                rpay_date, pay_date, cur_code2, pay_amt, pay_usd_amt, tsf_flag, acc_name, acc_no, acc_bank,
                receipt_no));
    }

    public static List<ExcelInsRpay> Exp2Excel(QueryRunner runner, ExcelWriter writer, Sheet sheet)
            throws SQLException {
        sheet.setSheetName("InsRpay");
        String sql = "SELECT * from tb_ins_rpay";
        List<ExcelInsRpay> result = runner.query(sql, new BeanListHandler<ExcelInsRpay>(ExcelInsRpay.class));
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

    public String geteff_date() {
        return eff_date;
    }

    public void seteff_date(String eff_date) {
        this.eff_date = eff_date;
    }

    public String getcur_code1() {
        return cur_code1;
    }

    public void setcur_code1(String cur_code1) {
        this.cur_code1 = cur_code1;
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

    public String getapp_id_no() {
        return app_id_no;
    }

    public void setapp_id_no(String app_id_no) {
        this.app_id_no = app_id_no;
    }

    public String getapp_cus_pro() {
        return app_cus_pro;
    }

    public void setapp_cus_pro(String app_cus_pro) {
        this.app_cus_pro = app_cus_pro;
    }

    public String getins_name() {
        return ins_name;
    }

    public void setins_name(String ins_name) {
        this.ins_name = ins_name;
    }

    public String getins_cst_no() {
        return ins_cst_no;
    }

    public void setins_cst_no(String ins_cst_no) {
        this.ins_cst_no = ins_cst_no;
    }

    public String getins_id_no() {
        return ins_id_no;
    }

    public void setins_id_no(String ins_id_no) {
        this.ins_id_no = ins_id_no;
    }

    public String getins_cus_pro() {
        return ins_cus_pro;
    }

    public void setins_cus_pro(String ins_cus_pro) {
        this.ins_cus_pro = ins_cus_pro;
    }

    public String getbenefit_name() {
        return benefit_name;
    }

    public void setbenefit_name(String benefit_name) {
        this.benefit_name = benefit_name;
    }

    public String getbenefit_id_no() {
        return benefit_id_no;
    }

    public void setbenefit_id_no(String benefit_id_no) {
        this.benefit_id_no = benefit_id_no;
    }

    public String getbenefit_pro() {
        return benefit_pro;
    }

    public void setbenefit_pro(String benefit_pro) {
        this.benefit_pro = benefit_pro;
    }

    public String getrelation_1() {
        return relation_1;
    }

    public void setrelation_1(String relation_1) {
        this.relation_1 = relation_1;
    }

    public String getrelation_2() {
        return relation_2;
    }

    public void setrelation_2(String relation_2) {
        this.relation_2 = relation_2;
    }

    public String getpay_type() {
        return pay_type;
    }

    public void setpay_type(String pay_type) {
        this.pay_type = pay_type;
    }

    public String getrpay_date() {
        return rpay_date;
    }

    public void setrpay_date(String rpay_date) {
        this.rpay_date = rpay_date;
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

    public double getpay_amt() {
        return pay_amt;
    }

    public void setpay_amt(double pay_amt) {
        this.pay_amt = pay_amt;
    }

    public double getpay_usd_amt() {
        return pay_usd_amt;
    }

    public void setpay_usd_amt(double pay_usd_amt) {
        this.pay_usd_amt = pay_usd_amt;
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
}
