package lab.crazyspark.dao;

import java.util.List;
import java.sql.SQLException;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.metadata.Sheet;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import lab.crazyspark.aml.BeanCfg;
import lab.crazyspark.bean.InsFavCst;
import lab.crazyspark.excel.ExcelInsFavCst;
import lab.crazyspark.utils.DBUtils;

public class InsFavCstDAO {

    public static void ConvertData(QueryRunner runner, QueryRunner targetqr) {
        try {
            BeanCfg beanCfg  = DBUtils.GetBeanConfig(InsFavCst.class, "InsFavCst");
            String sql = beanCfg.getSql_imp();
            String inssql = "INSERT INTO tb_ins_fav_cst(company_code1, company_code2, company_code3, pol_no, ins_date, app_name, app_cst_no, app_id_no, insfav_type, insbene_cus_pro, relation, fav_type, name, insbene_cst_no, insbene_id_no)VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            List<InsFavCst> insFavCsts = runner.query(sql, new BeanListHandler<InsFavCst>(InsFavCst.class));
            for (InsFavCst insFavCst : insFavCsts) {
                Object[] params = { insFavCst.getcompany_code1(), insFavCst.getCompany_code2(),
                        insFavCst.getCompany_code3(), insFavCst.getPol_no(), insFavCst.getIns_date(),
                        insFavCst.getApp_name(), insFavCst.getApp_cst_no(), insFavCst.getApp_id_no(),
                        insFavCst.getInsfav_type(), insFavCst.getInsbene_cus_pro(), insFavCst.getRelation(),
                        insFavCst.getFav_type(), insFavCst.getName(), insFavCst.getInsbene_cst_no(),
                        insFavCst.getInsbene_id_no() };
                targetqr.update(inssql, params);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static List<ExcelInsFavCst> Exp2Excel(QueryRunner runner, ExcelWriter writer, Sheet sheet)
            throws SQLException {
        sheet.setSheetName("InsFavCst");
        String sql = "SELECT * from tb_ins_fav_cst";
        List<ExcelInsFavCst> result = runner.query(sql, new BeanListHandler<ExcelInsFavCst>(ExcelInsFavCst.class));
        return result;
    }
}