package com.tpstic.dao;

import java.sql.SQLException;
import java.util.List;

import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.metadata.Sheet;
import org.apache.commons.dbutils.QueryRunner;

import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.tpstic.AppUtils;
import com.tpstic.excel.ExcelCompany;

public class CompanyDAO {
	public static List<ExcelCompany> Exp2Excel(QueryRunner runner, ExcelWriter writer, Sheet sheet)
			throws SQLException {
		sheet.setSheetName("Company");
		String sql = AppUtils.getValue("Company");
		List<ExcelCompany> result = runner.query(sql, new BeanListHandler<ExcelCompany>(ExcelCompany.class));
		return result;
	}
}