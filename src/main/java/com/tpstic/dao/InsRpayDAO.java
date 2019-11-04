package lab.crazyspark.dao;

import java.util.List;
import java.sql.SQLException;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.metadata.Sheet;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import lab.crazyspark.aml.BeanCfg;
import lab.crazyspark.bean.InsRpay;
import lab.crazyspark.excel.ExcelInsRpay;
import lab.crazyspark.utils.DBUtils;

public class InsRpayDAO {

    public static void ConvertData(QueryRunner runner, QueryRunner targetqr) {
        try {
            BeanCfg beanCfg  = DBUtils.GetBeanConfig(InsRpay.class, "InsRpay");
            String sql = beanCfg.getSql_imp();
            String inssql = "INSERT INTO tb_ins_rpay(company_code1, company_code2, company_code3, company_code4, pol_no, app_no, ins_date, eff_date, cur_code1, pre_amt_all, usd_amt_all, app_name, app_cst_no, app_id_no, app_cus_pro, ins_name, ins_cst_no, ins_id_no, ins_cus_pro, benefit_name, benefit_id_no, benefit_pro, relation_1, relation_2, pay_type, rpay_date, pay_date, cur_code2, pay_amt, pay_usd_amt, tsf_flag, acc_name, acc_no, acc_bank, receipt_no)VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            List<InsRpay> insRpays = runner.query(sql, new BeanListHandler<InsRpay>(InsRpay.class));
            for (InsRpay insRpay : insRpays) {
                Object[] params = { insRpay.getcompany_code1(), insRpay.getCompany_code2(), insRpay.getCompany_code3(),
                        insRpay.getCompany_code4(), insRpay.getPol_no(), insRpay.getApp_no(), insRpay.getIns_date(),
                        insRpay.getEff_date(), insRpay.getCur_code1(), insRpay.getPre_amt_all(),
                        insRpay.getUsd_amt_all(), insRpay.getApp_name(), insRpay.getApp_cst_no(),
                        insRpay.getApp_id_no(), insRpay.getApp_cus_pro(), insRpay.getIns_name(),
                        insRpay.getIns_cst_no(), insRpay.getIns_id_no(), insRpay.getIns_cus_pro(),
                        insRpay.getBenefit_name(), insRpay.getBenefit_id_no(), insRpay.getBenefit_pro(),
                        insRpay.getRelation_1(), insRpay.getRelation_2(), insRpay.getPay_type(), insRpay.getRpay_date(),
                        insRpay.getPay_date(), insRpay.getCur_code2(), insRpay.getPay_amt(), insRpay.getPay_usd_amt(),
                        insRpay.getTsf_flag(), insRpay.getAcc_name(), insRpay.getAcc_no(), insRpay.getAcc_bank(),
                        insRpay.getReceipt_no() };
                targetqr.update(inssql, params);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static List<ExcelInsRpay> Exp2Excel(QueryRunner runner, ExcelWriter writer, Sheet sheet)
            throws SQLException {
        sheet.setSheetName("InsRpay");
        String sql = "SELECT * from tb_ins_rpay";
        List<ExcelInsRpay> result = runner.query(sql, new BeanListHandler<ExcelInsRpay>(ExcelInsRpay.class));
        return result;
    }
}