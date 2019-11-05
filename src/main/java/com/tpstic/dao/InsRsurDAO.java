package com.tpstic.dao;

import java.util.List;
import java.sql.SQLException;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.metadata.Sheet;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.tpstic.AppUtils;
import com.tpstic.excel.ExcelInsRsur;

public class InsRsurDAO {
    public static List<ExcelInsRsur> Exp2Excel(QueryRunner runner, ExcelWriter writer, Sheet sheet)
            throws SQLException {
        sheet.setSheetName("InsRsur");
		String sql = AppUtils.getValue("InsRsur");
        List<ExcelInsRsur> result = runner.query(sql, new BeanListHandler<ExcelInsRsur>(ExcelInsRsur.class));
        return result;
    }
}