package com.tpstic;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import javax.sql.DataSource;
import java.util.HashMap;
import com.google.gson.Gson;

public class AppUtils {
	static Properties pps;

	public static DataSource Source;
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
		String macroStr = String.format("{\"workday\":%s\", \"beginday\":%s\", \"endday\":%s\"}", AppUtils.workDay,
		AppUtils.beginDay, AppUtils.endDay);
		String oldSQL = pps.getProperty(Key);
		return compiling(oldSQL, macroStr);
	}
}