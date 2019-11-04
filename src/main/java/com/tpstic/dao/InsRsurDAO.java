package lab.crazyspark.dao;

import java.util.List;
import java.sql.SQLException;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.metadata.Sheet;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import lab.crazyspark.aml.BeanCfg;
import lab.crazyspark.bean.InsRsur;
import lab.crazyspark.excel.ExcelInsRsur;
import lab.crazyspark.utils.DBUtils;

public class InsRsurDAO {

    public static void ConvertData(QueryRunner runner, QueryRunner targetqr) {
        try {
            BeanCfg beanCfg  = DBUtils.GetBeanConfig(InsRsur.class, "InsRsur");
            String sql = beanCfg.getSql_imp();
            String inssql = "INSERT INTO tb_ins_rsur(company_code1, company_code2, company_code3, company_code4, pay_type, pol_no, app_no, ins_date, eff_date, cur_code, pre_amt_all, usd_amt_all, pay_amt_all, usd_pay_amt_all, app_name, app_cst_no, id_no, cus_pro, sur_name, sur_id_no, sur_date, pay_date, cur_code2, sur_amt, usd_sur_amt, tsf_flag, acc_name, acc_no, acc_bank, receipt_no, endorse_no)VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            List<InsRsur> insRsurs = runner.query(sql, new BeanListHandler<InsRsur>(InsRsur.class));
            for (InsRsur insRsur : insRsurs) {
                Object[] params = { insRsur.getcompany_code1(), insRsur.getCompany_code2(), insRsur.getCompany_code3(),
                        insRsur.getCompany_code4(), insRsur.getPay_type(), insRsur.getPol_no(), insRsur.getApp_no(),
                        insRsur.getIns_date(), insRsur.getEff_date(), insRsur.getCur_code(), insRsur.getPre_amt_all(),
                        insRsur.getUsd_amt_all(), insRsur.getPay_amt_all(), insRsur.getUsd_pay_amt_all(),
                        insRsur.getApp_name(), insRsur.getApp_cst_no(), insRsur.getId_no(), insRsur.getCus_pro(),
                        insRsur.getSur_name(), insRsur.getSur_id_no(), insRsur.getSur_date(), insRsur.getPay_date(),
                        insRsur.getCur_code2(), insRsur.getSur_amt(), insRsur.getUsd_sur_amt(), insRsur.getTsf_flag(),
                        insRsur.getAcc_name(), insRsur.getAcc_no(), insRsur.getAcc_bank(), insRsur.getReceipt_no(),
                        insRsur.getEndorse_no() };
                targetqr.update(inssql, params);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static List<ExcelInsRsur> Exp2Excel(QueryRunner runner, ExcelWriter writer, Sheet sheet)
            throws SQLException {
        sheet.setSheetName("InsRsur");
        String sql = "SELECT * from tb_ins_rsur";
        List<ExcelInsRsur> result = runner.query(sql, new BeanListHandler<ExcelInsRsur>(ExcelInsRsur.class));
        return result;
    }
}