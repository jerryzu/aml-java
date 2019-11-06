package com.tpstic;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.dbutils.ProxyFactory;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ArrayListHandler;

public class smart {

	public static void main(String[] args) {
		csv(args);
	}

	public static void csv(String[] args) {
		String sql = AppUtils.getValue("Company");
		sql = "select * from rpt_fxq_tb_amltp_risk";
		QueryRunner runner = new QueryRunner(DbcpFactory.Source) {
			@Override
			protected ResultSet wrap(ResultSet rs) {
				return CSVResultSet.wrap(rs);
			}
		};
		List<Object[]> list;
		try {
			list = runner.query(sql, new ArrayListHandler());
			for (Object[] objects : list) {
				System.out.println(AppUtils.toConvert(objects));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void ToISO(String[] args) {
		try {
			Statement stat = DbcpFactory.Source.getConnection().createStatement();
			ResultSet rs = stat.executeQuery("select * from demo");
			MySqlNullCheckedResultSet wrapper = new MySqlNullCheckedResultSet(rs);
			wrapper.setNullString("@N"); // Set null string
			wrapper.setNullInt(-9999); // Set null integer
			rs = ProxyFactory.instance().createResultSet(wrapper);
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				System.out.println(id);
				System.out.println(name);
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}