package com.tpstic;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import javax.sql.DataSource;
import org.apache.commons.dbcp2.BasicDataSourceFactory;

public class DbcpFactory {
	public static DataSource Source;
	static {
		Properties pps = new Properties();
		try {
			String root = System.getProperty("user.dir");
			String FileName = "dbcp.properties";
			String filePath = root + File.separator + "conf" + File.separator + FileName;
			pps.load(new FileReader(filePath));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		BasicDataSourceFactory factory = new BasicDataSourceFactory();
		try {
			Source = factory.createDataSource(pps);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}