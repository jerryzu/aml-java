package com.tpstic;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ArrayListHandler;
import org.apache.commons.dbutils.handlers.MapHandler;

import java.io.FileWriter;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class AppUtils {
	static Properties pps;

	public static String workDay;
	public static String beginDay;
	public static String endDay;

	static {
		pps = new Properties();
		try {
			String root = System.getProperty("user.dir");
			String FileName = "excel.properties";
			String filePath = root + File.separator + "conf" + File.separator + FileName;
			pps.load(new FileReader(filePath));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static String getWorkDay() {
		return AppUtils.workDay;
	}

	public static void setWorkDay(String WorkDay) {
		AppUtils.workDay = WorkDay;
	}

	public static String getBeginDay() {
		return AppUtils.beginDay;
	}

	public static void setBeginDay(String beginDay) {
		AppUtils.beginDay = beginDay;
	}

	public static String getEndDay() {
		return AppUtils.endDay;
	}

	public static void setEndDay(String endDay) {
		AppUtils.endDay = endDay;
	}

	static String compiling(String template, String jsonStr) {
		Gson gson = new Gson();
		HashMap jsonMap = gson.fromJson(jsonStr, HashMap.class);
		for (Object s : jsonMap.keySet()) {
			template = template.replaceAll("\\$\\{".concat(s.toString()).concat("\\}"),
					jsonMap.get(s.toString()).toString());
		}
		return template;
	}

	public static String getValue(String Key) {
		String macroStr = String.format("{\"workday\":\"%s\", \"beginday\":\"%s\", \"endday\":\"%s\"}", AppUtils.workDay,
		AppUtils.beginDay, AppUtils.endDay);
		String oldSQL = pps.getProperty(Key);
		return compiling(oldSQL, macroStr);
	}

	public static String getTitle(String Key) {
		String macroStr = String.format("{\"workday\":\"%s\", \"beginday\":\"%s\", \"endday\":\"%s\"}", AppUtils.workDay,
		AppUtils.beginDay, AppUtils.endDay);
		String oldSQL = pps.getProperty(Key + "_Title");
		if (oldSQL == null) {
			return "";
		}
		return compiling(oldSQL, macroStr);

	}

	public static String toConvert(Object[] a) {
		if (a == null)
			return "";

		int iMax = a.length - 1;
		if (iMax == -1)
			return "";

		StringBuilder b = new StringBuilder();
		for (int i = 0;; i++) {
			b.append(String.valueOf(a[i]));
			if (i == iMax)
				return b.toString();
			b.append("|");
		}
	}

	public static List<Object[]> Exp2CSV(QueryRunner runner, String sql) throws SQLException {
		List<Object[]> result = runner.query(sql, new ArrayListHandler());
		return result;
	}

	public static Map<String, Object> Title(QueryRunner runner, String sql) throws SQLException {
		Map<String, Object> result = runner.query(sql, new MapHandler());
		return result;
	}
}