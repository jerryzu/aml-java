package com.tpstic.dao;

import java.util.List;
import java.sql.SQLException;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.metadata.Sheet;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.tpstic.AppUtils;
import com.tpstic.excel.ExcelInsBo;

public class InsBoDAO {

    public static List<ExcelInsBo> Exp2Excel(QueryRunner runner, ExcelWriter writer, Sheet sheet) throws SQLException {
        sheet.setSheetName("InsBo");
		String sql = AppUtils.getValue("InsBo");
        List<ExcelInsBo> result = runner.query(sql, new BeanListHandler<ExcelInsBo>(ExcelInsBo.class));
        return result;
    }
}