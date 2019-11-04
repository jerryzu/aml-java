package lab.crazyspark.excel;

import java.sql.SQLException;
import java.util.List;

import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;
import com.alibaba.excel.metadata.Sheet;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

public class ExcelInsFavCst extends BaseRowModel {
    @ExcelProperty(value = "company_code1", index = 0)
    private String company_code1;
    @ExcelProperty(value = "company_code2", index = 1)
    private String company_code2;
    @ExcelProperty(value = "company_code3", index = 2)
    private String company_code3;
    @ExcelProperty(value = "pol_no", index = 3)
    private String pol_no;
    @ExcelProperty(value = "ins_date", index = 4)
    private String ins_date;
    @ExcelProperty(value = "app_name", index = 5)
    private String app_name;
    @ExcelProperty(value = "app_cst_no", index = 6)
    private String app_cst_no;
    @ExcelProperty(value = "app_id_no", index = 7)
    private String app_id_no;
    @ExcelProperty(value = "insfav_type", index = 8)
    private String insfav_type;
    @ExcelProperty(value = "insbene_cus_pro", index = 9)
    private String insbene_cus_pro;
    @ExcelProperty(value = "relation", index = 10)
    private String relation;
    @ExcelProperty(value = "fav_type", index = 11)
    private String fav_type;
    @ExcelProperty(value = "name", index = 12)
    private String name;
    @ExcelProperty(value = "insbene_cst_no", index = 13)
    private String insbene_cst_no;
    @ExcelProperty(value = "insbene_id_no", index = 14)
    private String insbene_id_no;

    public void print() {
        System.out.println(String.format(
                "InsFavCst:  company_code1%s  company_code2%s  company_code3%s  pol_no%s  ins_date%s  app_name%s  app_cst_no%s  app_id_no%s  insfav_type%s  insbene_cus_pro%s  relation%s  fav_type%s  name%s  insbene_cst_no%s  insbene_id_no%s",
                company_code1, company_code2, company_code3, pol_no, ins_date, app_name, app_cst_no, app_id_no,
                insfav_type, insbene_cus_pro, relation, fav_type, name, insbene_cst_no, insbene_id_no));
    }

    public static List<ExcelInsFavCst> Exp2Excel(QueryRunner runner, ExcelWriter writer, Sheet sheet)
            throws SQLException {
        sheet.setSheetName("InsFavCst");
        String sql = "SELECT * from tb_ins_fav_cst";
        List<ExcelInsFavCst> result = runner.query(sql, new BeanListHandler<ExcelInsFavCst>(ExcelInsFavCst.class));
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

    public String getapp_id_no() {
        return app_id_no;
    }

    public void setapp_id_no(String app_id_no) {
        this.app_id_no = app_id_no;
    }

    public String getinsfav_type() {
        return insfav_type;
    }

    public void setinsfav_type(String insfav_type) {
        this.insfav_type = insfav_type;
    }

    public String getinsbene_cus_pro() {
        return insbene_cus_pro;
    }

    public void setinsbene_cus_pro(String insbene_cus_pro) {
        this.insbene_cus_pro = insbene_cus_pro;
    }

    public String getrelation() {
        return relation;
    }

    public void setrelation(String relation) {
        this.relation = relation;
    }

    public String getfav_type() {
        return fav_type;
    }

    public void setfav_type(String fav_type) {
        this.fav_type = fav_type;
    }

    public String getname() {
        return name;
    }

    public void setname(String name) {
        this.name = name;
    }

    public String getinsbene_cst_no() {
        return insbene_cst_no;
    }

    public void setinsbene_cst_no(String insbene_cst_no) {
        this.insbene_cst_no = insbene_cst_no;
    }

    public String getinsbene_id_no() {
        return insbene_id_no;
    }

    public void setinsbene_id_no(String insbene_id_no) {
        this.insbene_id_no = insbene_id_no;
    }
}
