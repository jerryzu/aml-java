package com.tpstic.dao;

import java.util.List;
import java.sql.SQLException;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.metadata.Sheet;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.tpstic.AppUtils;
import com.tpstic.excel.ExcelInsPers;

public class InsPersDAO {
    public static List<ExcelInsPers> Exp2Excel(QueryRunner runner, ExcelWriter writer, Sheet sheet)
            throws SQLException {
        sheet.setSheetName("InsPers");
		String sql = AppUtils.getValue("InsPers");
        List<ExcelInsPers> result = runner.query(sql, new BeanListHandler<ExcelInsPers>(ExcelInsPers.class));
        return result;
    }
}