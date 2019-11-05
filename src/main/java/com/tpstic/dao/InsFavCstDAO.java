package com.tpstic.dao;

import java.util.List;
import java.sql.SQLException;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.metadata.Sheet;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.tpstic.AppUtils;
import com.tpstic.excel.ExcelInsFavCst;

public class InsFavCstDAO {
    public static List<ExcelInsFavCst> Exp2Excel(QueryRunner runner, ExcelWriter writer, Sheet sheet)
            throws SQLException {
		sheet.setSheetName("InsFavCst");		
		String sql = AppUtils.getValue("InsFavCst");
        List<ExcelInsFavCst> result = runner.query(sql, new BeanListHandler<ExcelInsFavCst>(ExcelInsFavCst.class));
        return result;
    }
}