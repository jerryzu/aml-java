package com.tpstic.dao;

import java.util.List;
import java.sql.SQLException;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.metadata.Sheet;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.tpstic.AppUtils;
import com.tpstic.excel.ExcelInsRcla;

public class InsRclaDAO {
    public static List<ExcelInsRcla> Exp2Excel(QueryRunner runner, ExcelWriter writer, Sheet sheet)
            throws SQLException {
        sheet.setSheetName("InsRcla");
		String sql = AppUtils.getValue("InsRcla");
        List<ExcelInsRcla> result = runner.query(sql, new BeanListHandler<ExcelInsRcla>(ExcelInsRcla.class));
        return result;
    }
}