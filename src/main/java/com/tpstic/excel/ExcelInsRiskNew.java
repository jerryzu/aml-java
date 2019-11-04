package lab.crazyspark.excel;

import java.sql.SQLException;
import java.util.List;

import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;
import com.alibaba.excel.metadata.Sheet;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

public class ExcelInsRiskNew extends BaseRowModel {
    @ExcelProperty(value = "company_code1", index = 0)
    private String company_code1;
    @ExcelProperty(value = "company_code2", index = 1)
    private String company_code2;
    @ExcelProperty(value = "company_code3", index = 2)
    private String company_code3;
    @ExcelProperty(value = "app_name", index = 3)
    private String app_name;
    @ExcelProperty(value = "app_cst_no", index = 4)
    private String app_cst_no;
    @ExcelProperty(value = "app_id_no", index = 5)
    private String app_id_no;
    @ExcelProperty(value = "risk_code", index = 6)
    private String risk_code;
    @ExcelProperty(value = "div_date", index = 7)
    private String div_date;
    @ExcelProperty(value = "score", index = 8)
    private double score;
    @ExcelProperty(value = "norm", index = 9)
    private String norm;

    public void print() {
        System.out.println(String.format(
                "InsRiskNew:  company_code1%s  company_code2%s  company_code3%s  app_name%s  app_cst_no%s  app_id_no%s  risk_code%s  div_date%s  score%s  norm%s",
                company_code1, company_code2, company_code3, app_name, app_cst_no, app_id_no, risk_code, div_date,
                score, norm));
    }

    public static List<ExcelInsRiskNew> Exp2Excel(QueryRunner runner, ExcelWriter writer, Sheet sheet)
            throws SQLException {
        sheet.setSheetName("InsRiskNew");
        String sql = "SELECT * from tb_ins_risk_new";
        List<ExcelInsRiskNew> result = runner.query(sql, new BeanListHandler<ExcelInsRiskNew>(ExcelInsRiskNew.class));
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

    public String getrisk_code() {
        return risk_code;
    }

    public void setrisk_code(String risk_code) {
        this.risk_code = risk_code;
    }

    public String getdiv_date() {
        return div_date;
    }

    public void setdiv_date(String div_date) {
        this.div_date = div_date;
    }

    public double getscore() {
        return score;
    }

    public void setscore(double score) {
        this.score = score;
    }

    public String getnorm() {
        return norm;
    }

    public void setnorm(String norm) {
        this.norm = norm;
    }
}
