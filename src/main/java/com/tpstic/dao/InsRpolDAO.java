package lab.crazyspark.dao;

import java.util.List;
import java.sql.SQLException;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.metadata.Sheet;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import lab.crazyspark.aml.BeanCfg;
import lab.crazyspark.bean.InsRpol;
import lab.crazyspark.excel.ExcelInsRpol;
import lab.crazyspark.utils.DBUtils;

public class InsRpolDAO {

    public static void ConvertData(QueryRunner runner, QueryRunner targetqr) {
        try {
            BeanCfg beanCfg  = DBUtils.GetBeanConfig(InsRpol.class, "InsRpol");
            String sql = beanCfg.getSql_imp();
            String inssql = "INSERT INTO tb_ins_rpol(company_code1, company_code2, company_code3, pol_no, app_no, ins_state, sale_type, sale_name, ins_date, eff_date, app_name, app_cst_no, app_id_type, app_id_no, ins_name, ins_cst_no, ins_id_no, ins_cus_pro, relation, legal_type, benefit_cus_pro, benefit_name, benefit_cst_no, benefit_id_no, ins_no, cur_code, pre_amt, usd_amt, prof_type, del_way, del_period, limit_, subject, tsf_flag, acc_name, acc_no, acc_bank, receipt_no)VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            List<InsRpol> insRpols = runner.query(sql, new BeanListHandler<InsRpol>(InsRpol.class));
            for (InsRpol insRpol : insRpols) {
                Object[] params = { insRpol.getcompany_code1(), insRpol.getCompany_code2(), insRpol.getCompany_code3(),
                        insRpol.getPol_no(), insRpol.getApp_no(), insRpol.getIns_state(), insRpol.getSale_type(),
                        insRpol.getSale_name(), insRpol.getIns_date(), insRpol.getEff_date(), insRpol.getApp_name(),
                        insRpol.getApp_cst_no(), insRpol.getApp_id_type(), insRpol.getApp_id_no(),
                        insRpol.getIns_name(), insRpol.getIns_cst_no(), insRpol.getIns_id_no(),
                        insRpol.getIns_cus_pro(), insRpol.getRelation(), insRpol.getLegal_type(),
                        insRpol.getBenefit_cus_pro(), insRpol.getBenefit_name(), insRpol.getBenefit_cst_no(),
                        insRpol.getBenefit_id_no(), insRpol.getIns_no(), insRpol.getCur_code(), insRpol.getPre_amt(),
                        insRpol.getUsd_amt(), insRpol.getProf_type(), insRpol.getDel_way(), insRpol.getDel_period(),
                        insRpol.getLimit(), insRpol.getSubject(), insRpol.getTsf_flag(), insRpol.getAcc_name(),
                        insRpol.getAcc_no(), insRpol.getAcc_bank(), insRpol.getReceipt_no() };
                targetqr.update(inssql, params);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static List<ExcelInsRpol> Exp2Excel(QueryRunner runner, ExcelWriter writer, Sheet sheet)
            throws SQLException {
        sheet.setSheetName("InsRpol");
        String sql = "SELECT * from tb_ins_rpol";
        List<ExcelInsRpol> result = runner.query(sql, new BeanListHandler<ExcelInsRpol>(ExcelInsRpol.class));
        return result;
    }
}