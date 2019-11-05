package com.tpstic.dao;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.metadata.Sheet;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
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

	public static void writeCsv(QueryRunner runner, String filePath) {

		String sql = AppUtils.getValue("Company");
		List<ExcelCompany> companylist;
		try {
			// 初始化csvformat
			CSVFormat formator = CSVFormat.DEFAULT.withRecordSeparator("\n").withQuote('"');
			// 创建FileWriter对象
			FileWriter fileWriter = new FileWriter(filePath, true);
			// 创建CSVPrinter对象
			CSVPrinter printer = new CSVPrinter(fileWriter, formator);

			companylist = runner.query(sql, new BeanListHandler<ExcelCompany>(ExcelCompany.class));

			// 写入列头数据
			// printer.printRecord(headers);
			if (null != companylist) {
				// 循环写入数据
				for (ExcelCompany lineData : companylist) {
					printer.printRecord(lineData);
				}
			}
			fileWriter.flush();
			printer.close(true);
			fileWriter.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}