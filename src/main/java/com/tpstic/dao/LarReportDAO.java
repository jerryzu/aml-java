package lab.crazyspark.dao;

import java.util.List;
import java.sql.SQLException;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.metadata.Sheet;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import lab.crazyspark.aml.BeanCfg;
import lab.crazyspark.bean.LarReport;
import lab.crazyspark.excel.ExcelLarReport;
import lab.crazyspark.utils.DBUtils;

public class LarReportDAO  {

    public static void ConvertData(QueryRunner runner, QueryRunner targetqr) {
        try {
            BeanCfg beanCfg  = DBUtils.GetBeanConfig(LarReport.class, "LarReport");
            String sql = beanCfg.getSql_imp();
            String inssql = "INSERT INTO tb_lar_report(ricd, finc, sbdt, cttn, code, rlfc, ctnm, citp, oitp, ctid, csnm, catp, ctac, cbct, ocbt, cbcn, ctvc, cctl, ccei, ctar, ctnt, oatm, crcd, tbnm, tbit, tbid, tbnt, tstm, trcd, ticd, rpmt, rpmn, tstp, tsct, tsdr, crpp, crtp, crat, crmb, cusd, ttnm, cfin, cfct, cfic, cfrc, tcnm, tcit, tcid, tcat, tcac, octt, ooct, ocec, rotf)VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            List<LarReport> larReports = runner.query(sql, new BeanListHandler<LarReport>(LarReport.class));
            for (LarReport larReport : larReports) {
                Object[] params = {larReport.getRicd(), larReport.getFinc(), larReport.getSbdt(), larReport.getCttn(), larReport.getCode(), larReport.getRlfc(), larReport.getCtnm(), larReport.getCitp(), larReport.getOitp(), larReport.getCtid(), larReport.getCsnm(), larReport.getCatp(), larReport.getCtac(), larReport.getCbct(), larReport.getOcbt(), larReport.getCbcn(), larReport.getCtvc(), larReport.getCctl(), larReport.getCcei(), larReport.getCtar(), larReport.getCtnt(), larReport.getOatm(), larReport.getCrcd(), larReport.getTbnm(), larReport.getTbit(), larReport.getTbid(), larReport.getTbnt(), larReport.getTstm(), larReport.getTrcd(), larReport.getTicd(), larReport.getRpmt(), larReport.getRpmn(), larReport.getTstp(), larReport.getTsct(), larReport.getTsdr(), larReport.getCrpp(), larReport.getCrtp(), larReport.getCrat(), larReport.getCrmb(), larReport.getCusd(), larReport.getTtnm(), larReport.getCfin(), larReport.getCfct(), larReport.getCfic(), larReport.getCfrc(), larReport.getTcnm(), larReport.getTcit(), larReport.getTcid(), larReport.getTcat(), larReport.getTcac(), larReport.getOctt(), larReport.getOoct(), larReport.getOcec(), larReport.getRotf() };
                        targetqr.update(inssql, params);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static List<ExcelLarReport> Exp2Excel(QueryRunner runner, ExcelWriter writer, Sheet sheet)
            throws SQLException {
        sheet.setSheetName("LarReport");
        String sql = "SELECT * from tb_lar_report";
        List<ExcelLarReport> result = runner.query(sql, new BeanListHandler<ExcelLarReport>(ExcelLarReport.class));
        return result;
    }
}