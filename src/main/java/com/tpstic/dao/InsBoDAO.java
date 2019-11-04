package lab.crazyspark.dao;

import java.util.List;
import java.sql.SQLException;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.metadata.Sheet;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import lab.crazyspark.aml.BeanCfg;
import lab.crazyspark.bean.InsBo;
import lab.crazyspark.excel.ExcelInsBo;
import lab.crazyspark.utils.DBUtils;

public class InsBoDAO {

    public static void ConvertData(QueryRunner runner, QueryRunner targetqr) {
        try {
            BeanCfg beanCfg  = DBUtils.GetBeanConfig(InsBo.class, "InsBo");
            String sql = beanCfg.getSql_imp();
            String inssql = "INSERT INTO tb_ins_bo(company_code1, company_code2, acc_name, cst_no, license, bnf_name, bnf_type, shareholding_ratio, bnf_address, id_type5, id_no5, id_deadline5, sys_name)VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            List<InsBo> insBos = runner.query(sql, new BeanListHandler<InsBo>(InsBo.class));
            for (InsBo insBo : insBos) {
                Object[] params = { insBo.getcompany_code1(), insBo.getCompany_code2(), insBo.getAcc_name(),
                        insBo.getCst_no(), insBo.getLicense(), insBo.getBnf_name(), insBo.getBnf_type(),
                        insBo.getShareholding_ratio(), insBo.getBnf_address(), insBo.getId_type5(), insBo.getId_no5(),
                        insBo.getId_deadline5(), insBo.getSys_name() };
                targetqr.update(inssql, params);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static List<ExcelInsBo> Exp2Excel(QueryRunner runner, ExcelWriter writer, Sheet sheet) throws SQLException {
        sheet.setSheetName("InsBo");
        String sql = "SELECT * from tb_ins_bo";
        List<ExcelInsBo> result = runner.query(sql, new BeanListHandler<ExcelInsBo>(ExcelInsBo.class));
        return result;
    }
}