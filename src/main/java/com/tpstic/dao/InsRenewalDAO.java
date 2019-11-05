package com.tpstic.dao;

import java.util.List;
import java.sql.SQLException;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.metadata.Sheet;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.tpstic.AppUtils;
import com.tpstic.excel.ExcelInsRenewal;

public class InsRenewalDAO {
    public static List<ExcelInsRenewal> Exp2Excel(QueryRunner runner, ExcelWriter writer, Sheet sheet)
            throws SQLException {
        sheet.setSheetName("InsRenewal");
		String sql = AppUtils.getValue("InsRenewal");
        List<ExcelInsRenewal> result = runner.query(sql, new BeanListHandler<ExcelInsRenewal>(ExcelInsRenewal.class));
        return result;
    }
}