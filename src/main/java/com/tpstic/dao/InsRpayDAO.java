package com.tpstic.dao;

import java.util.List;
import java.sql.SQLException;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.metadata.Sheet;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.tpstic.AppUtils;
import com.tpstic.excel.ExcelInsRpay;

public class InsRpayDAO {
    public static List<ExcelInsRpay> Exp2Excel(QueryRunner runner, ExcelWriter writer, Sheet sheet)
            throws SQLException {
        sheet.setSheetName("InsRpay");
		String sql = AppUtils.getValue("InsRpay");
        List<ExcelInsRpay> result = runner.query(sql, new BeanListHandler<ExcelInsRpay>(ExcelInsRpay.class));
        return result;
    }
}