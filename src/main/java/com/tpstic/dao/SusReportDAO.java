package lab.crazyspark.dao;

import java.util.List;
import java.sql.SQLException;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.metadata.Sheet;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import lab.crazyspark.aml.BeanCfg;
import lab.crazyspark.bean.SusReport;
import lab.crazyspark.excel.ExcelSusReport;
import lab.crazyspark.utils.DBUtils;

public class SusReportDAO {

    public static void ConvertData(QueryRunner runner, QueryRunner targetqr) {
        try {
            BeanCfg beanCfg  = DBUtils.GetBeanConfig(SusReport.class, "SusReport");
            String sql = beanCfg.getSql_imp();
            String inssql = "INSERT INTO tb_sus_report(ricd, finc, senm, setp, seid, sevc, srnm, srit, srid, scnm, scit, scid, stnt, detr, torp, dorp, tptr, stcb, aosp, tosc, stcr, icnm, istp, isnm, isps, alnm, aitp, alid, altp, istn, iitp, isid, rltp, bnnm, bitp, bnid, isog, isat, isfe, ispt, ctes, tstm, trcd, ittp, crtp, crat, crdr, cstp, caoi, tcan, rotf, code, itnm, bntn, mirs, otpr, stnm, ocit, odrp, oitp, orit, orxn, rpnm, sctl, rpdt, sear, seei, setn)VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            List<SusReport> susReports = runner.query(sql, new BeanListHandler<SusReport>(SusReport.class));
            for (SusReport susReport : susReports) {
                Object[] params = { susReport.getRicd(), susReport.getFinc(), susReport.getSenm(), susReport.getSetp(),
                        susReport.getSeid(), susReport.getSevc(), susReport.getSrnm(), susReport.getSrit(),
                        susReport.getSrid(), susReport.getScnm(), susReport.getScit(), susReport.getScid(),
                        susReport.getStnt(), susReport.getDetr(), susReport.getTorp(), susReport.getDorp(),
                        susReport.getTptr(), susReport.getStcb(), susReport.getAosp(), susReport.getTosc(),
                        susReport.getStcr(), susReport.getIcnm(), susReport.getIstp(), susReport.getIsnm(),
                        susReport.getIsps(), susReport.getAlnm(), susReport.getAitp(), susReport.getAlid(),
                        susReport.getAltp(), susReport.getIstn(), susReport.getIitp(), susReport.getIsid(),
                        susReport.getRltp(), susReport.getBnnm(), susReport.getBitp(), susReport.getBnid(),
                        susReport.getIsog(), susReport.getIsat(), susReport.getIsfe(), susReport.getIspt(),
                        susReport.getCtes(), susReport.getTstm(), susReport.getTrcd(), susReport.getIttp(),
                        susReport.getCrtp(), susReport.getCrat(), susReport.getCrdr(), susReport.getCstp(),
                        susReport.getCaoi(), susReport.getTcan(), susReport.getRotf(), susReport.getCode(),
                        susReport.getItnm(), susReport.getBntn(), susReport.getMirs(), susReport.getOtpr(),
                        susReport.getStnm(), susReport.getOcit(), susReport.getOdrp(), susReport.getOitp(),
                        susReport.getOrit(), susReport.getOrxn(), susReport.getRpnm(), susReport.getSctl(),
                        susReport.getRpdt(), susReport.getSear(), susReport.getSeei(), susReport.getSetn() };
                targetqr.update(inssql, params);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static List<ExcelSusReport> Exp2Excel(QueryRunner runner, ExcelWriter writer, Sheet sheet)
            throws SQLException {
        sheet.setSheetName("SusReport");
        String sql = "SELECT * from tb_sus_report";
        List<ExcelSusReport> result = runner.query(sql, new BeanListHandler<ExcelSusReport>(ExcelSusReport.class));
        return result;
    }
}
