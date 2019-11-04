package lab.crazyspark.dao;

import java.util.List;
import java.sql.SQLException;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.metadata.Sheet;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import lab.crazyspark.aml.BeanCfg;
import lab.crazyspark.bean.InsGpol;
import lab.crazyspark.excel.ExcelInsGpol;
import lab.crazyspark.utils.DBUtils;

public class InsGpolDAO {

    public static void ConvertData(QueryRunner runner, QueryRunner targetqr) {
        try {
            BeanCfg beanCfg  = DBUtils.GetBeanConfig(InsGpol.class, "InsGpol");
            String sql = beanCfg.getSql_imp();
            String inssql = "INSERT INTO tb_ins_gpol(company_code1, company_code2, company_code3, pol_no, app_no, ins_state, app_type, sale_type, sale_name, ins_date, eff_date, app_name, app_cst_no, app_id_type, app_id_no, state_owned, ins_num, ins_no, cur_code, pre_amt, usd_amt, del_way, del_period, limit_, subject, tsf_flag, acc_name, acc_no, acc_bank)VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            List<InsGpol> insGpols = runner.query(sql, new BeanListHandler<InsGpol>(InsGpol.class));
            for (InsGpol insGpol : insGpols) {
                Object[] params = { insGpol.getcompany_code1(), insGpol.getCompany_code2(), insGpol.getCompany_code3(),
                        insGpol.getPol_no(), insGpol.getApp_no(), insGpol.getIns_state(), insGpol.getApp_type(),
                        insGpol.getSale_type(), insGpol.getSale_name(), insGpol.getIns_date(), insGpol.getEff_date(),
                        insGpol.getApp_name(), insGpol.getApp_cst_no(), insGpol.getApp_id_type(),
                        insGpol.getApp_id_no(), insGpol.getState_owned(), insGpol.getIns_num(), insGpol.getIns_no(),
                        insGpol.getCur_code(), insGpol.getPre_amt(), insGpol.getUsd_amt(), insGpol.getDel_way(),
                        insGpol.getDel_period(), insGpol.getLimit(), insGpol.getSubject(), insGpol.getTsf_flag(),
                        insGpol.getAcc_name(), insGpol.getAcc_no(), insGpol.getAcc_bank() };
                targetqr.update(inssql, params);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static List<ExcelInsGpol> Exp2Excel(QueryRunner runner, ExcelWriter writer, Sheet sheet)
            throws SQLException {
        sheet.setSheetName("InsGpol");
        String sql = "SELECT * from tb_ins_gpol";
        List<ExcelInsGpol> result = runner.query(sql, new BeanListHandler<ExcelInsGpol>(ExcelInsGpol.class));
        return result;
    }
}