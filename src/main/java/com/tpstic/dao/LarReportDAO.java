package com.tpstic.dao;

import java.util.List;
import java.sql.SQLException;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.metadata.Sheet;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.tpstic.AppUtils;
import com.tpstic.excel.ExcelLarReport;

public class LarReportDAO  {
    public static List<ExcelLarReport> Exp2Excel(QueryRunner runner, ExcelWriter writer, Sheet sheet)
            throws SQLException {
        sheet.setSheetName("LarReport");
		String sql = AppUtils.getValue("LarReport");
        List<ExcelLarReport> result = runner.query(sql, new BeanListHandler<ExcelLarReport>(ExcelLarReport.class));
        return result;
    }
}