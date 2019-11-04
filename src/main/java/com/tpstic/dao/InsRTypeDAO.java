package lab.crazyspark.dao;

import java.util.List;
import java.sql.SQLException;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.metadata.Sheet;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import lab.crazyspark.aml.BeanCfg;
import lab.crazyspark.bean.InsRType;
import lab.crazyspark.excel.ExcelInsRType;
import lab.crazyspark.utils.DBUtils;

public class InsRTypeDAO {

    public static void ConvertData(QueryRunner runner, QueryRunner targetqr) {
        try {
            BeanCfg beanCfg  = DBUtils.GetBeanConfig(InsRType.class, "InsRType");
            String sql = beanCfg.getSql_imp();
            String inssql = "INSERT INTO tb_ins_rtype(head_no, company_code1, ins_type, ins_no, ins_name)VALUES(?, ?, ?, ?, ?)";
            List<InsRType> insRTypes = runner.query(sql, new BeanListHandler<InsRType>(InsRType.class));
            for (InsRType insRType : insRTypes) {
                Object[] params = { insRType.getHead_no(), insRType.getcompany_code1(), insRType.getIns_type(),
                        insRType.getIns_no(), insRType.getIns_name() };
                targetqr.update(inssql, params);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static List<ExcelInsRType> Exp2Excel(QueryRunner runner, ExcelWriter writer, Sheet sheet)
            throws SQLException {
        sheet.setSheetName("InsRType");
        String sql = "SELECT * from tb_ins_rtype";
        List<ExcelInsRType> result = runner.query(sql, new BeanListHandler<ExcelInsRType>(ExcelInsRType.class));
        return result;
    }
}