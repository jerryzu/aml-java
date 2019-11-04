package lab.crazyspark.excel;

import java.sql.SQLException;
import java.util.List;

import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;
import com.alibaba.excel.metadata.Sheet;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

public class ExcelInsRcla extends BaseRowModel {
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
    @ExcelProperty(value = "app_name", index = 8)
    private String app_name;
    @ExcelProperty(value = "app_cst_no", index = 9)
    private String app_cst_no;
    @ExcelProperty(value = "app_id_no", index = 10)
    private String app_id_no;
    @ExcelProperty(value = "app_cus_pro", index = 11)
    private String app_cus_pro;
    @ExcelProperty(value = "ins_name", index = 12)
    private String ins_name;
    @ExcelProperty(value = "ins_cst_no", index = 13)
    private String ins_cst_no;
    @ExcelProperty(value = "ins_id_no", index = 14)
    private String ins_id_no;
    @ExcelProperty(value = "ins_cus_pro", index = 15)
    private String ins_cus_pro;
    @ExcelProperty(value = "benefit_name", index = 16)
    private String benefit_name;
    @ExcelProperty(value = "benefit_id_no", index = 17)
    private String benefit_id_no;
    @ExcelProperty(value = "benefit_type", index = 18)
    private String benefit_type;
    @ExcelProperty(value = "relation_1", index = 19)
    private String relation_1;
    @ExcelProperty(value = "relation_2", index = 20)
    private String relation_2;
    @ExcelProperty(value = "cla_app_name", index = 21)
    private String cla_app_name;
    @ExcelProperty(value = "cla_id_type", index = 22)
    private String cla_id_type;
    @ExcelProperty(value = "cla_id_no", index = 23)
    private String cla_id_no;
    @ExcelProperty(value = "cla_pro", index = 24)
    private String cla_pro;
    @ExcelProperty(value = "cla_date", index = 25)
    private String cla_date;
    @ExcelProperty(value = "cur_code", index = 26)
    private String cur_code;
    @ExcelProperty(value = "cla_amt", index = 27)
    private double cla_amt;
    @ExcelProperty(value = "cla_usd_amt", index = 28)
    private double cla_usd_amt;
    @ExcelProperty(value = "cla_no", index = 29)
    private String cla_no;
    @ExcelProperty(value = "tsf_flag", index = 30)
    private String tsf_flag;
    @ExcelProperty(value = "acc_name", index = 31)
    private String acc_name;
    @ExcelProperty(value = "acc_no", index = 32)
    private String acc_no;
    @ExcelProperty(value = "acc_bank", index = 33)
    private String acc_bank;
    @ExcelProperty(value = "acc_type", index = 34)
    private String acc_type;
    @ExcelProperty(value = "acc_id_type", index = 35)
    private String acc_id_type;
    @ExcelProperty(value = "acc_id_no", index = 36)
    private String acc_id_no;

    public void print() {
        System.out.println(String.format(
                "InsRcla:  company_code1%s  company_code2%s  company_code3%s  company_code4%s  pol_no%s  app_no%s  ins_date%s  eff_date%s  app_name%s  app_cst_no%s  app_id_no%s  app_cus_pro%s  ins_name%s  ins_cst_no%s  ins_id_no%s  ins_cus_pro%s  benefit_name%s  benefit_id_no%s  benefit_type%s  relation_1%s  relation_2%s  cla_app_name%s  cla_id_type%s  cla_id_no%s  cla_pro%s  cla_date%s  cur_code%s  cla_amt%s  cla_usd_amt%s  cla_no%s  tsf_flag%s  acc_name%s  acc_no%s  acc_bank%s  acc_type%s  acc_id_type%s  acc_id_no%s",
                company_code1, company_code2, company_code3, company_code4, pol_no, app_no, ins_date, eff_date,
                app_name, app_cst_no, app_id_no, app_cus_pro, ins_name, ins_cst_no, ins_id_no, ins_cus_pro,
                benefit_name, benefit_id_no, benefit_type, relation_1, relation_2, cla_app_name, cla_id_type, cla_id_no,
                cla_pro, cla_date, cur_code, cla_amt, cla_usd_amt, cla_no, tsf_flag, acc_name, acc_no, acc_bank,
                acc_type, acc_id_type, acc_id_no));
    }

    public static List<ExcelInsRcla> Exp2Excel(QueryRunner runner, ExcelWriter writer, Sheet sheet)
            throws SQLException {
        sheet.setSheetName("InsRcla");
        String sql = "SELECT * from tb_ins_rcla";
        List<ExcelInsRcla> result = runner.query(sql, new BeanListHandler<ExcelInsRcla>(ExcelInsRcla.class));
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

    public String getbenefit_type() {
        return benefit_type;
    }

    public void setbenefit_type(String benefit_type) {
        this.benefit_type = benefit_type;
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

    public String getcla_app_name() {
        return cla_app_name;
    }

    public void setcla_app_name(String cla_app_name) {
        this.cla_app_name = cla_app_name;
    }

    public String getcla_id_type() {
        return cla_id_type;
    }

    public void setcla_id_type(String cla_id_type) {
        this.cla_id_type = cla_id_type;
    }

    public String getcla_id_no() {
        return cla_id_no;
    }

    public void setcla_id_no(String cla_id_no) {
        this.cla_id_no = cla_id_no;
    }

    public String getcla_pro() {
        return cla_pro;
    }

    public void setcla_pro(String cla_pro) {
        this.cla_pro = cla_pro;
    }

    public String getcla_date() {
        return cla_date;
    }

    public void setcla_date(String cla_date) {
        this.cla_date = cla_date;
    }

    public String getcur_code() {
        return cur_code;
    }

    public void setcur_code(String cur_code) {
        this.cur_code = cur_code;
    }

    public double getcla_amt() {
        return cla_amt;
    }

    public void setcla_amt(double cla_amt) {
        this.cla_amt = cla_amt;
    }

    public double getcla_usd_amt() {
        return cla_usd_amt;
    }

    public void setcla_usd_amt(double cla_usd_amt) {
        this.cla_usd_amt = cla_usd_amt;
    }

    public String getcla_no() {
        return cla_no;
    }

    public void setcla_no(String cla_no) {
        this.cla_no = cla_no;
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

    public String getacc_type() {
        return acc_type;
    }

    public void setacc_type(String acc_type) {
        this.acc_type = acc_type;
    }

    public String getacc_id_type() {
        return acc_id_type;
    }

    public void setacc_id_type(String acc_id_type) {
        this.acc_id_type = acc_id_type;
    }

    public String getacc_id_no() {
        return acc_id_no;
    }

    public void setacc_id_no(String acc_id_no) {
        this.acc_id_no = acc_id_no;
    }
}
