package com.tpstic.dao;

import java.util.List;
import java.sql.SQLException;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.metadata.Sheet;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.tpstic.AppUtils;
import com.tpstic.excel.ExcelInsRiskNew;

public class InsRiskNewDAO {
    public static List<ExcelInsRiskNew> Exp2Excel(QueryRunner runner, ExcelWriter writer, Sheet sheet)
            throws SQLException {
        sheet.setSheetName("InsRiskNew");
		String sql = AppUtils.getValue("InsRiskNew");
        List<ExcelInsRiskNew> result = runner.query(sql, new BeanListHandler<ExcelInsRiskNew>(ExcelInsRiskNew.class));
        return result;
    }
}