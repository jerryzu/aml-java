package com.tpstic;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Map;

import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.metadata.Sheet;
import com.alibaba.excel.support.ExcelTypeEnum;
import com.tpstic.dao.*;
import com.tpstic.excel.*;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.GnuParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.OptionBuilder;
import org.apache.commons.cli.Options;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.MapHandler;

public class App {
	private static Notifier notifier;

	public static Notifier getNotifier() {
		return notifier;
	}

	public static void setNotifier(Notifier notifier) {
		App.notifier = notifier;
	}

	public static void main(String[] args) throws IOException {
		// args = new String[] { "-t", "csv", "-f", "/app/work/aml-java/work/", "-DWorkDay=20190101" };
		notifier = new Notifier();
		CallListener a = new CallListener("aml-java");
		notifier.regist(a);
		App.setNotifier(notifier);

		try {
			Options options = new Options();
			options.addOption(new Option("t", "type", true, "xls or csv"));
			options.addOption(new Option("f", "file", true, "use given file(File)"));

			@SuppressWarnings("static-access")
			Option property = OptionBuilder.withArgName("property=value").hasArgs().withValueSeparator()
					.withDescription("use value for given property(property=value)").create("D");
			property.setRequired(true);
			options.addOption(property);

			// HelpFormatter formatter = new HelpFormatter();
			// formatter.printHelp("AntOptsCommonsCLI", options);
			System.out.println();

			CommandLineParser parser = new GnuParser();
			CommandLine cmd = parser.parse(options, args);
			String FileType = cmd.getOptionValue("t");
			String file = cmd.getOptionValue("f");

			String WorkDay = cmd.getOptionProperties("D").getProperty("WorkDay");
			String BeginDay = cmd.getOptionProperties("D").getProperty("BeginDay");
			String EndDay = cmd.getOptionProperties("D").getProperty("EndDay");

			AppUtils.workDay = WorkDay;
			AppUtils.beginDay = BeginDay;
			AppUtils.endDay = EndDay;
			System.out.println("file" + file);
			switch (FileType) {
			case "xls":
				Exp2Excel(file);
				System.out.println("exporting xls");
				break;
			case "csv":
				System.out.println("exporting csv");
				Exp2CSV(file);
				break;
			default:
				System.out.println("please choice export filetype!");
			}
		} catch (Exception ex) {
			System.out.println("Unexpected exception:" + ex.getMessage());
		}
	}

	public static void Exp2CSV(String file) {
		{
			QueryRunner runner = new QueryRunner(DbcpFactory.Source) {
				@Override
				protected ResultSet wrap(ResultSet rs) {
					return CSVResultSet.wrap(rs);
				}
			};
			Exp2CSVD(runner, "Company", file);
			Exp2CSVD(runner, "InsBo", file);
			Exp2CSVD(runner, "InsFavCst", file);
			Exp2CSVD(runner, "InsGpol", file);
			Exp2CSVD(runner, "InsPers", file);
			Exp2CSVD(runner, "InsRchg", file);
			Exp2CSVD(runner, "InsRcla", file);
			Exp2CSVD(runner, "InsRenewal", file);
			Exp2CSVD(runner, "InsRisk", file);
			Exp2CSVD(runner, "InsRiskNew", file);
			Exp2CSVD(runner, "InsRpay", file);
			Exp2CSVD(runner, "InsRpol", file);
			Exp2CSVD(runner, "InsRsur", file);
			Exp2CSVD(runner, "InsRType", file);
			Exp2CSVD(runner, "InsUnit", file);
			Exp2CSVD(runner, "LarReport", file);
			Exp2CSVD(runner, "SusReport", file);
		}
	}

	public static void Exp2CSVD(QueryRunner runner, String table, String path) {
		// private static CSVFormat csvFormat =
		// CSVFormat.DEFAULT.withRecordSeparator('\n'); // 每条记录间隔符
		// csvPrinter = new CSVPrinter(fileWriter, csvFormat);
		String filepath = path + File.separator + table + ".csv";
		String StartSheetInfo = "生成文件%s";
		String EndSheetInfo = "已生成文件%s";
		notifier.doWork(String.format(StartSheetInfo, filepath));
		try {
			Appendable out = new PrintWriter(filepath);
			// CSVPrinter printer =
			// CSVFormat.DEFAULT.withRecordSeparator("\r\n").print(out);
			FileWriter fw = new FileWriter(filepath);
			String titleSql = AppUtils.getTitle(table);
			String sql = AppUtils.getValue(table);
			if (titleSql.isEmpty()) {
				titleSql = sql + " where 1 = 2";
			}

			try {
				Statement stat = DbcpFactory.Source.getConnection().createStatement();
				ResultSet rs = stat.executeQuery(titleSql);
				ResultSetMetaData metaData = rs.getMetaData();

				int columnCount = metaData.getColumnCount();
				String TitleBank = "";
				for (int i = 1; i <= columnCount; i++) {
					TitleBank = TitleBank + "|" + metaData.getColumnName(i);
				}
				// printer.printRecord( TitleBank.substring(1) );
				fw.write(TitleBank.substring(1));
				fw.write("\r\n");
			} catch (SQLException e) {
				e.printStackTrace();
			}

			// Map<String, Object> res = AppUtils.Title(runner, titleSql);

			// printer.printRecord(AppUtils.toConvert(res.keySet().toArray()));

			List<Object[]> list = AppUtils.Exp2CSV(runner, sql);
			for (Object[] objects : list) {
				// printer.printRecord(AppUtils.toConvert(objects));
				fw.write(AppUtils.toConvert(objects));
				fw.write("\r\n");
			}
			// printer.flush();
			// printer.close();
			fw.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		notifier.doWork(String.format(EndSheetInfo, table));
	}

	public static void Exp2Excel(String file) {
		String StartSheetInfo = "开始导出%s";
		String EndSheetInfo = "已导出%s";

		try {
			QueryRunner runner = new QueryRunner(DbcpFactory.Source);
			OutputStream os = new FileOutputStream(new File(file));
			ExcelWriter writer = new ExcelWriter(os, ExcelTypeEnum.XLSX, true);

			notifier.doWork(String.format(StartSheetInfo, "company"));
			Sheet company = new Sheet(1, 5, ExcelCompany.class);
			List<ExcelCompany> companyresult = CompanyDAO.Exp2Excel(runner, writer, company);
			writer.write(companyresult, company);
			notifier.doWork(String.format(EndSheetInfo, "company"));

			notifier.doWork(String.format(StartSheetInfo, "insRType"));
			Sheet insRType = new Sheet(2, 5, ExcelInsRType.class);
			List<ExcelInsRType> insRtyperesult = InsRTypeDAO.Exp2Excel(runner, writer, insRType);
			writer.write(insRtyperesult, insRType);
			notifier.doWork(String.format(EndSheetInfo, "insRType"));

			notifier.doWork(String.format(StartSheetInfo, "insPers"));
			Sheet insPers = new Sheet(3, 5, ExcelInsPers.class);
			List<ExcelInsPers> insPersresult = InsPersDAO.Exp2Excel(runner, writer, insPers);
			writer.write(insPersresult, insPers);
			notifier.doWork(String.format(EndSheetInfo, "insPers"));

			notifier.doWork(String.format(StartSheetInfo, "insUnit"));
			Sheet insUnit = new Sheet(4, 5, ExcelInsUnit.class);
			List<ExcelInsUnit> insUnitresult = InsUnitDAO.Exp2Excel(runner, writer, insUnit);
			writer.write(insUnitresult, insUnit);
			notifier.doWork(String.format(EndSheetInfo, "insUnit"));

			notifier.doWork(String.format(StartSheetInfo, "insBo"));
			Sheet insBo = new Sheet(5, 5, ExcelInsBo.class);
			List<ExcelInsBo> insBoresult = InsBoDAO.Exp2Excel(runner, writer, insBo);
			writer.write(insBoresult, insBo);
			notifier.doWork(String.format(EndSheetInfo, "insBo"));

			notifier.doWork(String.format(StartSheetInfo, "insRpol"));
			Sheet insRpol = new Sheet(6, 5, ExcelInsRpol.class);
			List<ExcelInsRpol> insRpolresult = InsRpolDAO.Exp2Excel(runner, writer, insRpol);
			writer.write(insRpolresult, insRpol);
			notifier.doWork(String.format(EndSheetInfo, "insRpol"));

			notifier.doWork(String.format(StartSheetInfo, "insGpol"));
			Sheet insGpol = new Sheet(7, 5, ExcelInsGpol.class);
			List<ExcelInsGpol> insGpolresult = InsGpolDAO.Exp2Excel(runner, writer, insGpol);
			writer.write(insGpolresult, insGpol);
			notifier.doWork(String.format(EndSheetInfo, "insGpol"));

			notifier.doWork(String.format(StartSheetInfo, "insFavCst"));
			Sheet insFavCst = new Sheet(8, 5, ExcelInsFavCst.class);
			List<ExcelInsFavCst> insFavCstresult = InsFavCstDAO.Exp2Excel(runner, writer, insFavCst);
			writer.write(insFavCstresult, insFavCst);
			notifier.doWork(String.format(EndSheetInfo, "insFavCst"));

			notifier.doWork(String.format(StartSheetInfo, "insRenewal"));
			Sheet insRenewal = new Sheet(9, 5, ExcelInsRenewal.class);
			List<ExcelInsRenewal> insRenewalresult = InsRenewalDAO.Exp2Excel(runner, writer, insRenewal);
			writer.write(insRenewalresult, insRenewal);
			notifier.doWork(String.format(EndSheetInfo, "insRenewal"));

			notifier.doWork(String.format(StartSheetInfo, "insRsur"));
			Sheet insRsur = new Sheet(10, 5, ExcelInsRsur.class);
			List<ExcelInsRsur> insRsurresult = InsRsurDAO.Exp2Excel(runner, writer, insRsur);
			writer.write(insRsurresult, insRsur);
			notifier.doWork(String.format(EndSheetInfo, "insRsur"));

			notifier.doWork(String.format(StartSheetInfo, "insRpay"));
			Sheet insRpay = new Sheet(11, 5, ExcelInsRpay.class);
			List<ExcelInsRpay> insRpayresult = InsRpayDAO.Exp2Excel(runner, writer, insRpay);
			writer.write(insRpayresult, insRpay);
			notifier.doWork(String.format(EndSheetInfo, "insRpay"));

			notifier.doWork(String.format(StartSheetInfo, "insRcla"));
			Sheet insRcla = new Sheet(12, 5, ExcelInsRcla.class);
			List<ExcelInsRcla> insRclaresult = InsRclaDAO.Exp2Excel(runner, writer, insRcla);
			writer.write(insRclaresult, insRcla);
			notifier.doWork(String.format(EndSheetInfo, "insRcla"));

			notifier.doWork(String.format(StartSheetInfo, "insRchg"));
			Sheet insRchg = new Sheet(13, 5, ExcelInsRchg.class);
			List<ExcelInsRchg> insRchgresult = InsRchgDAO.Exp2Excel(runner, writer, insRchg);
			writer.write(insRchgresult, insRchg);
			notifier.doWork(String.format(EndSheetInfo, "insRchg"));

			notifier.doWork(String.format(StartSheetInfo, "insRiskNew"));
			Sheet insRiskNew = new Sheet(14, 5, ExcelInsRiskNew.class);
			List<ExcelInsRiskNew> insRiskNewresult = InsRiskNewDAO.Exp2Excel(runner, writer, insRiskNew);
			writer.write(insRiskNewresult, insRiskNew);
			notifier.doWork(String.format(EndSheetInfo, "insRiskNew"));

			notifier.doWork(String.format(StartSheetInfo, "insRisk"));
			Sheet insRisk = new Sheet(15, 5, ExcelInsRisk.class);
			List<ExcelInsRisk> insRiskresult = InsRiskDAO.Exp2Excel(runner, writer, insRisk);
			writer.write(insRiskresult, insRisk);
			notifier.doWork(String.format(EndSheetInfo, "insRisk"));

			notifier.doWork(String.format(StartSheetInfo, "larReport"));
			Sheet larReport = new Sheet(16, 5, ExcelLarReport.class);
			List<ExcelLarReport> larReportresult = LarReportDAO.Exp2Excel(runner, writer, larReport);
			writer.write(larReportresult, larReport);
			notifier.doWork(String.format(EndSheetInfo, "larReport"));

			notifier.doWork(String.format(StartSheetInfo, "susReport"));
			Sheet susReport = new Sheet(17, 5, ExcelSusReport.class);
			List<ExcelSusReport> susReportresult = SusReportDAO.Exp2Excel(runner, writer, susReport);
			writer.write(susReportresult, susReport);
			notifier.doWork(String.format(EndSheetInfo, "susReport"));

			writer.finish();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
