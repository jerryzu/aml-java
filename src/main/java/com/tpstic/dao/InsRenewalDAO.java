package lab.crazyspark.dao;

import java.util.List;
import java.sql.SQLException;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.metadata.Sheet;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import lab.crazyspark.aml.BeanCfg;
import lab.crazyspark.bean.InsRenewal;
import lab.crazyspark.excel.ExcelInsRenewal;
import lab.crazyspark.utils.DBUtils;

public class InsRenewalDAO {

    public static void ConvertData(QueryRunner runner, QueryRunner targetqr) {
        try {
            BeanCfg beanCfg  = DBUtils.GetBeanConfig(InsRenewal.class, "InsRenewal");
            String sql = beanCfg.getSql_imp();
            String inssql = "INSERT INTO tb_ins_renewal(company_code1, company_code2, company_code3, company_code4, pol_no, app_no, ins_date, app_name, app_cst_no, app_id_type, app_id_no, ins_no, renew_date, pay_date, cur_code, pre_amt, usd_amt, tsf_flag, acc_name, acc_no, acc_bank, receipt_no, endorse_no)VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            List<InsRenewal> insRenewals = runner.query(sql, new BeanListHandler<InsRenewal>(InsRenewal.class));
            for (InsRenewal insRenewal : insRenewals) {
                Object[] params = { insRenewal.getcompany_code1(), insRenewal.getCompany_code2(),
                        insRenewal.getCompany_code3(), insRenewal.getCompany_code4(), insRenewal.getPol_no(),
                        insRenewal.getApp_no(), insRenewal.getIns_date(), insRenewal.getApp_name(),
                        insRenewal.getApp_cst_no(), insRenewal.getApp_id_type(), insRenewal.getApp_id_no(),
                        insRenewal.getIns_no(), insRenewal.getRenew_date(), insRenewal.getPay_date(),
                        insRenewal.getCur_code(), insRenewal.getPre_amt(), insRenewal.getUsd_amt(),
                        insRenewal.getTsf_flag(), insRenewal.getAcc_name(), insRenewal.getAcc_no(),
                        insRenewal.getAcc_bank(), insRenewal.getReceipt_no(), insRenewal.getEndorse_no() };
                targetqr.update(inssql, params);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static List<ExcelInsRenewal> Exp2Excel(QueryRunner runner, ExcelWriter writer, Sheet sheet)
            throws SQLException {
        sheet.setSheetName("InsRenewal");
        String sql = "SELECT * from tb_ins_renewal";
        List<ExcelInsRenewal> result = runner.query(sql, new BeanListHandler<ExcelInsRenewal>(ExcelInsRenewal.class));
        return result;
    }
}