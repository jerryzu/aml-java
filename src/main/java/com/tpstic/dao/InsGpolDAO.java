package com.tpstic.dao;

import java.util.List;
import java.sql.SQLException;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.metadata.Sheet;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.tpstic.AppUtils;
import com.tpstic.excel.ExcelInsGpol;

public class InsGpolDAO {
    public static List<ExcelInsGpol> Exp2Excel(QueryRunner runner, ExcelWriter writer, Sheet sheet)
            throws SQLException {
        sheet.setSheetName("InsGpol");
		String sql = AppUtils.getValue("InsGpol");
        List<ExcelInsGpol> result = runner.query(sql, new BeanListHandler<ExcelInsGpol>(ExcelInsGpol.class));
        return result;
    }
}