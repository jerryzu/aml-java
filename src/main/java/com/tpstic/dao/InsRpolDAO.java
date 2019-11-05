package com.tpstic.dao;

import java.util.List;
import java.sql.SQLException;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.metadata.Sheet;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.tpstic.AppUtils;
import com.tpstic.excel.ExcelInsRpol;

public class InsRpolDAO {
    public static List<ExcelInsRpol> Exp2Excel(QueryRunner runner, ExcelWriter writer, Sheet sheet)
            throws SQLException {
        sheet.setSheetName("InsRpol");
		String sql = AppUtils.getValue("InsRpol");
        List<ExcelInsRpol> result = runner.query(sql, new BeanListHandler<ExcelInsRpol>(ExcelInsRpol.class));
        return result;
    }
}