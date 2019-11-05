package com.tpstic.dao;

import java.util.List;
import java.sql.SQLException;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.metadata.Sheet;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.tpstic.AppUtils;
import com.tpstic.excel.ExcelInsRType;

public class InsRTypeDAO {
    public static List<ExcelInsRType> Exp2Excel(QueryRunner runner, ExcelWriter writer, Sheet sheet)
            throws SQLException {
        sheet.setSheetName("InsRType");
		String sql = AppUtils.getValue("InsRType");
        List<ExcelInsRType> result = runner.query(sql, new BeanListHandler<ExcelInsRType>(ExcelInsRType.class));
        return result;
    }
}