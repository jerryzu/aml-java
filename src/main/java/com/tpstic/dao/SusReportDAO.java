package com.tpstic.dao;

import java.util.List;
import java.sql.SQLException;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.metadata.Sheet;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.tpstic.AppUtils;
import com.tpstic.excel.ExcelSusReport;

public class SusReportDAO {
    public static List<ExcelSusReport> Exp2Excel(QueryRunner runner, ExcelWriter writer, Sheet sheet)
            throws SQLException {
        sheet.setSheetName("SusReport");
		String sql = AppUtils.getValue("SusReport");
        List<ExcelSusReport> result = runner.query(sql, new BeanListHandler<ExcelSusReport>(ExcelSusReport.class));
        return result;
    }
}
