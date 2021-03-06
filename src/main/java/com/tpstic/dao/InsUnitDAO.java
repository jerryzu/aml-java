package com.tpstic.dao;

import java.util.List;
import java.sql.SQLException;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.metadata.Sheet;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.tpstic.AppUtils;
import com.tpstic.excel.ExcelInsUnit;

public class InsUnitDAO {
    public static List<ExcelInsUnit> Exp2Excel(QueryRunner runner, ExcelWriter writer, Sheet sheet)
            throws SQLException {
        sheet.setSheetName("InsUnit");
		String sql = AppUtils.getValue("InsUnit");
        List<ExcelInsUnit> result = runner.query(sql, new BeanListHandler<ExcelInsUnit>(ExcelInsUnit.class));
        return result;
    }
}