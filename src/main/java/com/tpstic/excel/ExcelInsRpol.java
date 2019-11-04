package lab.crazyspark.excel;

import java.sql.SQLException;
import java.util.List;

import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;
import com.alibaba.excel.metadata.Sheet;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

public class ExcelInsRpol extends BaseRowModel {
    @ExcelProperty(value = "company_code1", index = 0)
    private String company_code1;
    @ExcelProperty(value = "company_code2", index = 1)
    private String company_code2;
    @ExcelProperty(value = "company_code3", index = 2)
    private String company_code3;
    @ExcelProperty(value = "pol_no", index = 3)
    private String pol_no;
    @ExcelProperty(value = "app_no", index = 4)
    private String app_no;
    @ExcelProperty(value = "ins_state", index = 5)
    private String ins_state;
    @ExcelProperty(value = "sale_type", index = 6)
    private String sale_type;
    @ExcelProperty(value = "sale_name", index = 7)
    private String sale_name;
    @ExcelProperty(value = "ins_date", index = 8)
    private String ins_date;
    @ExcelProperty(value = "eff_date", index = 9)
    private String eff_date;
    @ExcelProperty(value = "app_name", index = 10)
    private String app_name;
    @ExcelProperty(value = "app_cst_no", index = 11)
    private String app_cst_no;
    @ExcelProperty(value = "app_id_type", index = 12)
    private String app_id_type;
    @ExcelProperty(value = "app_id_no", index = 13)
    private String app_id_no;
    @ExcelProperty(value = "ins_name", index = 14)
    private String ins_name;
    @ExcelProperty(value = "ins_cst_no", index = 15)
    private String ins_cst_no;
    @ExcelProperty(value = "ins_id_no", index = 16)
    private String ins_id_no;
    @ExcelProperty(value = "ins_cus_pro", index = 17)
    private String ins_cus_pro;
    @ExcelProperty(value = "relation", index = 18)
    private String relation;
    @ExcelProperty(value = "legal_type", index = 19)
    private String legal_type;
    @ExcelProperty(value = "benefit_cus_pro", index = 20)
    private String benefit_cus_pro;
    @ExcelProperty(value = "benefit_name", index = 21)
    private String benefit_name;
    @ExcelProperty(value = "benefit_cst_no", index = 22)
    private String benefit_cst_no;
    @ExcelProperty(value = "benefit_id_no", index = 23)
    private String benefit_id_no;
    @ExcelProperty(value = "ins_no", index = 24)
    private String ins_no;
    @ExcelProperty(value = "cur_code", index = 25)
    private String cur_code;
    @ExcelProperty(value = "pre_amt", index = 26)
    private double pre_amt;
    @ExcelProperty(value = "usd_amt", index = 27)
    private double usd_amt;
    @ExcelProperty(value = "prof_type", index = 28)
    private String prof_type;
    @ExcelProperty(value = "del_way", index = 29)
    private String del_way;
    @ExcelProperty(value = "del_period", index = 30)
    private String del_period;
    @ExcelProperty(value = "limit", index = 31)
    private String limit;
    @ExcelProperty(value = "subject", index = 32)
    private String subject;
    @ExcelProperty(value = "tsf_flag", index = 33)
    private String tsf_flag;
    @ExcelProperty(value = "acc_name", index = 34)
    private String acc_name;
    @ExcelProperty(value = "acc_no", index = 35)
    private String acc_no;
    @ExcelProperty(value = "acc_bank", index = 36)
    private String acc_bank;
    @ExcelProperty(value = "receipt_no", index = 37)
    private String receipt_no;

    public void print() {
        System.out.println(String.format(
                "InsRpol:  company_code1%s  company_code2%s  company_code3%s  pol_no%s  app_no%s  ins_state%s  sale_type%s  sale_name%s  ins_date%s  eff_date%s  app_name%s  app_cst_no%s  app_id_type%s  app_id_no%s  ins_name%s  ins_cst_no%s  ins_id_no%s  ins_cus_pro%s  relation%s  legal_type%s  benefit_cus_pro%s  benefit_name%s  benefit_cst_no%s  benefit_id_no%s  ins_no%s  cur_code%s  pre_amt%s  usd_amt%s  prof_type%s  del_way%s  del_period%s  limit%s  subject%s  tsf_flag%s  acc_name%s  acc_no%s  acc_bank%s  receipt_no%s",
                company_code1, company_code2, company_code3, pol_no, app_no, ins_state, sale_type, sale_name, ins_date,
                eff_date, app_name, app_cst_no, app_id_type, app_id_no, ins_name, ins_cst_no, ins_id_no, ins_cus_pro,
                relation, legal_type, benefit_cus_pro, benefit_name, benefit_cst_no, benefit_id_no, ins_no, cur_code,
                pre_amt, usd_amt, prof_type, del_way, del_period, limit, subject, tsf_flag, acc_name, acc_no, acc_bank,
                receipt_no));
    }

    public static List<ExcelInsRpol> Exp2Excel(QueryRunner runner, ExcelWriter writer, Sheet sheet)
            throws SQLException {
        sheet.setSheetName("InsRpol");
        String sql = "SELECT * from tb_ins_rpol";
        List<ExcelInsRpol> result = runner.query(sql, new BeanListHandler<ExcelInsRpol>(ExcelInsRpol.class));
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

    public String getins_state() {
        return ins_state;
    }

    public void setins_state(String ins_state) {
        this.ins_state = ins_state;
    }

    public String getsale_type() {
        return sale_type;
    }

    public void setsale_type(String sale_type) {
        this.sale_type = sale_type;
    }

    public String getsale_name() {
        return sale_name;
    }

    public void setsale_name(String sale_name) {
        this.sale_name = sale_name;
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

    public String getrelation() {
        return relation;
    }

    public void setrelation(String relation) {
        this.relation = relation;
    }

    public String getlegal_type() {
        return legal_type;
    }

    public void setlegal_type(String legal_type) {
        this.legal_type = legal_type;
    }

    public String getbenefit_cus_pro() {
        return benefit_cus_pro;
    }

    public void setbenefit_cus_pro(String benefit_cus_pro) {
        this.benefit_cus_pro = benefit_cus_pro;
    }

    public String getbenefit_name() {
        return benefit_name;
    }

    public void setbenefit_name(String benefit_name) {
        this.benefit_name = benefit_name;
    }

    public String getbenefit_cst_no() {
        return benefit_cst_no;
    }

    public void setbenefit_cst_no(String benefit_cst_no) {
        this.benefit_cst_no = benefit_cst_no;
    }

    public String getbenefit_id_no() {
        return benefit_id_no;
    }

    public void setbenefit_id_no(String benefit_id_no) {
        this.benefit_id_no = benefit_id_no;
    }

    public String getins_no() {
        return ins_no;
    }

    public void setins_no(String ins_no) {
        this.ins_no = ins_no;
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

    public String getprof_type() {
        return prof_type;
    }

    public void setprof_type(String prof_type) {
        this.prof_type = prof_type;
    }

    public String getdel_way() {
        return del_way;
    }

    public void setdel_way(String del_way) {
        this.del_way = del_way;
    }

    public String getdel_period() {
        return del_period;
    }

    public void setdel_period(String del_period) {
        this.del_period = del_period;
    }

    public String getlimit() {
        return limit;
    }

    public void setlimit(String limit) {
        this.limit = limit;
    }

    public String getsubject() {
        return subject;
    }

    public void setsubject(String subject) {
        this.subject = subject;
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
