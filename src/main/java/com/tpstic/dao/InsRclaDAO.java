package lab.crazyspark.dao;

import java.util.List;
import java.sql.SQLException;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.metadata.Sheet;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import lab.crazyspark.aml.BeanCfg;
import lab.crazyspark.bean.InsRcla;
import lab.crazyspark.excel.ExcelInsRcla;
import lab.crazyspark.utils.DBUtils;

public class InsRclaDAO {

    public static void ConvertData(QueryRunner runner, QueryRunner targetqr) {
        try {
            BeanCfg beanCfg  = DBUtils.GetBeanConfig(InsRcla.class, "InsRcla");
            String sql = beanCfg.getSql_imp();
            String inssql = "INSERT INTO tb_ins_rcla(company_code1, company_code2, company_code3, company_code4, pol_no, app_no, ins_date, eff_date, app_name, app_cst_no, app_id_no, app_cus_pro, ins_name, ins_cst_no, ins_id_no, ins_cus_pro, benefit_name, benefit_id_no, benefit_type, relation_1, relation_2, cla_app_name, cla_id_type, cla_id_no, cla_pro, cla_date, cur_code, cla_amt, cla_usd_amt, cla_no, tsf_flag, acc_name, acc_no, acc_bank, acc_type, acc_id_type, acc_id_no)VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            List<InsRcla> insRclas = runner.query(sql, new BeanListHandler<InsRcla>(InsRcla.class));
            for (InsRcla insRcla : insRclas) {
                Object[] params = { insRcla.getcompany_code1(), insRcla.getCompany_code2(), insRcla.getCompany_code3(),
                        insRcla.getCompany_code4(), insRcla.getPol_no(), insRcla.getApp_no(), insRcla.getIns_date(),
                        insRcla.getEff_date(), insRcla.getApp_name(), insRcla.getApp_cst_no(), insRcla.getApp_id_no(),
                        insRcla.getApp_cus_pro(), insRcla.getIns_name(), insRcla.getIns_cst_no(),
                        insRcla.getIns_id_no(), insRcla.getIns_cus_pro(), insRcla.getBenefit_name(),
                        insRcla.getBenefit_id_no(), insRcla.getBenefit_type(), insRcla.getRelation_1(),
                        insRcla.getRelation_2(), insRcla.getCla_app_name(), insRcla.getCla_id_type(),
                        insRcla.getCla_id_no(), insRcla.getCla_pro(), insRcla.getCla_date(), insRcla.getCur_code(),
                        insRcla.getCla_amt(), insRcla.getCla_usd_amt(), insRcla.getCla_no(), insRcla.getTsf_flag(),
                        insRcla.getAcc_name(), insRcla.getAcc_no(), insRcla.getAcc_bank(), insRcla.getAcc_type(),
                        insRcla.getAcc_id_type(), insRcla.getAcc_id_no() };
                targetqr.update(inssql, params);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static List<ExcelInsRcla> Exp2Excel(QueryRunner runner, ExcelWriter writer, Sheet sheet)
            throws SQLException {
        sheet.setSheetName("InsRcla");
        String sql = "SELECT * from tb_ins_rcla";
        List<ExcelInsRcla> result = runner.query(sql, new BeanListHandler<ExcelInsRcla>(ExcelInsRcla.class));
        return result;
    }
}