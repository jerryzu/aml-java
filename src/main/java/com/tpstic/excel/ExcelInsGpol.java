package lab.crazyspark.excel;

import java.sql.SQLException;
import java.util.List;

import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;
import com.alibaba.excel.metadata.Sheet;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

public class ExcelInsGpol extends BaseRowModel {
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
    @ExcelProperty(value = "app_type", index = 6)
    private String app_type;
    @ExcelProperty(value = "sale_type", index = 7)
    private String sale_type;
    @ExcelProperty(value = "sale_name", index = 8)
    private String sale_name;
    @ExcelProperty(value = "ins_date", index = 9)
    private String ins_date;
    @ExcelProperty(value = "eff_date", index = 10)
    private String eff_date;
    @ExcelProperty(value = "app_name", index = 11)
    private String app_name;
    @ExcelProperty(value = "app_cst_no", index = 12)
    private String app_cst_no;
    @ExcelProperty(value = "app_id_type", index = 13)
    private String app_id_type;
    @ExcelProperty(value = "app_id_no", index = 14)
    private String app_id_no;
    @ExcelProperty(value = "state_owned", index = 15)
    private String state_owned;
    @ExcelProperty(value = "ins_num", index = 16)
    private String ins_num;
    @ExcelProperty(value = "ins_no", index = 17)
    private String ins_no;
    @ExcelProperty(value = "cur_code", index = 18)
    private String cur_code;
    @ExcelProperty(value = "pre_amt", index = 19)
    private double pre_amt;
    @ExcelProperty(value = "usd_amt", index = 20)
    private double usd_amt;
    @ExcelProperty(value = "del_way", index = 21)
    private String del_way;
    @ExcelProperty(value = "del_period", index = 22)
    private String del_period;
    @ExcelProperty(value = "limit", index = 23)
    private String limit;
    @ExcelProperty(value = "subject", index = 24)
    private String subject;
    @ExcelProperty(value = "tsf_flag", index = 25)
    private String tsf_flag;
    @ExcelProperty(value = "acc_name", index = 26)
    private String acc_name;
    @ExcelProperty(value = "acc_no", index = 27)
    private String acc_no;
    @ExcelProperty(value = "acc_bank", index = 28)
    private String acc_bank;

    public void print() {
        System.out.println(String.format(
                "InsGpol:  company_code1%s  company_code2%s  company_code3%s  pol_no%s  app_no%s  ins_state%s  app_type%s  sale_type%s  sale_name%s  ins_date%s  eff_date%s  app_name%s  app_cst_no%s  app_id_type%s  app_id_no%s  state_owned%s  ins_num%s  ins_no%s  cur_code%s  pre_amt%s  usd_amt%s  del_way%s  del_period%s  limit%s  subject%s  tsf_flag%s  acc_name%s  acc_no%s  acc_bank%s",
                company_code1, company_code2, company_code3, pol_no, app_no, ins_state, app_type, sale_type, sale_name,
                ins_date, eff_date, app_name, app_cst_no, app_id_type, app_id_no, state_owned, ins_num, ins_no,
                cur_code, pre_amt, usd_amt, del_way, del_period, limit, subject, tsf_flag, acc_name, acc_no, acc_bank));
    }

    public static List<ExcelInsGpol> Exp2Excel(QueryRunner runner, ExcelWriter writer, Sheet sheet)
            throws SQLException {
        sheet.setSheetName("InsGpol");
        String sql = "SELECT * from tb_ins_gpol";
        List<ExcelInsGpol> result = runner.query(sql, new BeanListHandler<ExcelInsGpol>(ExcelInsGpol.class));
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

    public String getapp_type() {
        return app_type;
    }

    public void setapp_type(String app_type) {
        this.app_type = app_type;
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

    public String getstate_owned() {
        return state_owned;
    }

    public void setstate_owned(String state_owned) {
        this.state_owned = state_owned;
    }

    public String getins_num() {
        return ins_num;
    }

    public void setins_num(String ins_num) {
        this.ins_num = ins_num;
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
}
