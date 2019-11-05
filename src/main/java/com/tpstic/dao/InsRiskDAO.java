package com.tpstic.dao;

import java.util.List;
import java.sql.SQLException;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.metadata.Sheet;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.tpstic.AppUtils;
import com.tpstic.excel.ExcelInsRisk;

public class InsRiskDAO {
    public static List<ExcelInsRisk> Exp2Excel(QueryRunner runner, ExcelWriter writer, Sheet sheet)
            throws SQLException {
        sheet.setSheetName("InsRisk");
		String sql = AppUtils.getValue("InsRisk");
        List<ExcelInsRisk> result = runner.query(sql, new BeanListHandler<ExcelInsRisk>(ExcelInsRisk.class));
        return result;
    }
}