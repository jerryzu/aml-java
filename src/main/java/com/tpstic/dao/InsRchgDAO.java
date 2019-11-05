package com.tpstic.dao;

import java.util.List;
import java.sql.SQLException;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.metadata.Sheet;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.tpstic.AppUtils;
import com.tpstic.excel.ExcelInsRchg;


public class InsRchgDAO {
    public static List<ExcelInsRchg> Exp2Excel(QueryRunner runner, ExcelWriter writer, Sheet sheet)
            throws SQLException {
        sheet.setSheetName("InsRchg");
		String sql = AppUtils.getValue("InsRchg");
        List<ExcelInsRchg> result = runner.query(sql, new BeanListHandler<ExcelInsRchg>(ExcelInsRchg.class));
        return result;
    }
}