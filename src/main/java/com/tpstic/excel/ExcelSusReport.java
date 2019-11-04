
package lab.crazyspark.excel;

import java.sql.SQLException;
import java.util.List;

import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;
import com.alibaba.excel.metadata.Sheet;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

public class ExcelSusReport extends BaseRowModel {
    @ExcelProperty(value = "ricd", index = 0)
    private String ricd;
    @ExcelProperty(value = "finc", index = 1)
    private String finc;
    @ExcelProperty(value = "senm", index = 2)
    private String senm;
    @ExcelProperty(value = "setp", index = 3)
    private String setp;
    @ExcelProperty(value = "seid", index = 4)
    private String seid;
    @ExcelProperty(value = "sevc", index = 5)
    private String sevc;
    @ExcelProperty(value = "srnm", index = 6)
    private String srnm;
    @ExcelProperty(value = "srit", index = 7)
    private String srit;
    @ExcelProperty(value = "srid", index = 8)
    private String srid;
    @ExcelProperty(value = "scnm", index = 9)
    private String scnm;
    @ExcelProperty(value = "scit", index = 10)
    private String scit;
    @ExcelProperty(value = "scid", index = 11)
    private String scid;
    @ExcelProperty(value = "stnt", index = 12)
    private String stnt;
    @ExcelProperty(value = "detr", index = 13)
    private String detr;
    @ExcelProperty(value = "torp", index = 14)
    private String torp;
    @ExcelProperty(value = "dorp", index = 15)
    private String dorp;
    @ExcelProperty(value = "tptr", index = 16)
    private String tptr;
    @ExcelProperty(value = "stcb", index = 17)
    private String stcb;
    @ExcelProperty(value = "aosp", index = 18)
    private String aosp;
    @ExcelProperty(value = "tosc", index = 19)
    private String tosc;
    @ExcelProperty(value = "stcr", index = 20)
    private String stcr;
    @ExcelProperty(value = "icnm", index = 21)
    private String icnm;
    @ExcelProperty(value = "istp", index = 22)
    private String istp;
    @ExcelProperty(value = "isnm", index = 23)
    private String isnm;
    @ExcelProperty(value = "isps", index = 24)
    private String isps;
    @ExcelProperty(value = "alnm", index = 25)
    private String alnm;
    @ExcelProperty(value = "aitp", index = 26)
    private String aitp;
    @ExcelProperty(value = "alid", index = 27)
    private String alid;
    @ExcelProperty(value = "altp", index = 28)
    private String altp;
    @ExcelProperty(value = "istn", index = 29)
    private String istn;
    @ExcelProperty(value = "iitp", index = 30)
    private String iitp;
    @ExcelProperty(value = "isid", index = 31)
    private String isid;
    @ExcelProperty(value = "rltp", index = 32)
    private String rltp;
    @ExcelProperty(value = "bnnm", index = 33)
    private String bnnm;
    @ExcelProperty(value = "bitp", index = 34)
    private String bitp;
    @ExcelProperty(value = "bnid", index = 35)
    private String bnid;
    @ExcelProperty(value = "isog", index = 36)
    private String isog;
    @ExcelProperty(value = "isat", index = 37)
    private double isat;
    @ExcelProperty(value = "isfe", index = 38)
    private double isfe;
    @ExcelProperty(value = "ispt", index = 39)
    private String ispt;
    @ExcelProperty(value = "ctes", index = 40)
    private String ctes;
    @ExcelProperty(value = "tstm", index = 41)
    private String tstm;
    @ExcelProperty(value = "trcd", index = 42)
    private String trcd;
    @ExcelProperty(value = "ittp", index = 43)
    private String ittp;
    @ExcelProperty(value = "crtp", index = 44)
    private String crtp;
    @ExcelProperty(value = "crat", index = 45)
    private double crat;
    @ExcelProperty(value = "crdr", index = 46)
    private String crdr;
    @ExcelProperty(value = "cstp", index = 47)
    private String cstp;
    @ExcelProperty(value = "caoi", index = 48)
    private String caoi;
    @ExcelProperty(value = "tcan", index = 49)
    private String tcan;
    @ExcelProperty(value = "rotf", index = 50)
    private String rotf;
    @ExcelProperty(value = "code", index = 51)
    private String code;
    @ExcelProperty(value = "itnm", index = 52)
    private String itnm;
    @ExcelProperty(value = "bntn", index = 53)
    private String bntn;
    @ExcelProperty(value = "mirs", index = 54)
    private String mirs;
    @ExcelProperty(value = "otpr", index = 55)
    private String otpr;
    @ExcelProperty(value = "stnm", index = 56)
    private String stnm;
    @ExcelProperty(value = "ocit", index = 57)
    private String ocit;
    @ExcelProperty(value = "odrp", index = 58)
    private String odrp;
    @ExcelProperty(value = "oitp", index = 59)
    private String oitp;
    @ExcelProperty(value = "orit", index = 60)
    private String orit;
    @ExcelProperty(value = "orxn", index = 61)
    private String orxn;
    @ExcelProperty(value = "rpnm", index = 62)
    private String rpnm;
    @ExcelProperty(value = "sctl", index = 63)
    private String sctl;
    @ExcelProperty(value = "rpdt", index = 64)
    private String rpdt;
    @ExcelProperty(value = "sear", index = 65)
    private String sear;
    @ExcelProperty(value = "seei", index = 66)
    private String seei;
    @ExcelProperty(value = "setn", index = 67)
    private String setn;

    public void print() {
        System.out.println(String.format(
                "SusReport:  ricd%s  finc%s  senm%s  setp%s  seid%s  sevc%s  srnm%s  srit%s  srid%s  scnm%s  scit%s  scid%s  stnt%s  detr%s  torp%s  dorp%s  tptr%s  stcb%s  aosp%s  tosc%s  stcr%s  icnm%s  istp%s  isnm%s  isps%s  alnm%s  aitp%s  alid%s  altp%s  istn%s  iitp%s  isid%s  rltp%s  bnnm%s  bitp%s  bnid%s  isog%s  isat%s  isfe%s  ispt%s  ctes%s  tstm%s  trcd%s  ittp%s  crtp%s  crat%s  crdr%s  cstp%s  caoi%s  tcan%s  rotf%s  code%s  itnm%s  bntn%s  mirs%s  otpr%s  stnm%s  ocit%s  odrp%s  oitp%s  orit%s  orxn%s  rpnm%s  sctl%s  rpdt%s  sear%s  seei%s  setn%s",
                ricd, finc, senm, setp, seid, sevc, srnm, srit, srid, scnm, scit, scid, stnt, detr, torp, dorp, tptr,
                stcb, aosp, tosc, stcr, icnm, istp, isnm, isps, alnm, aitp, alid, altp, istn, iitp, isid, rltp, bnnm,
                bitp, bnid, isog, isat, isfe, ispt, ctes, tstm, trcd, ittp, crtp, crat, crdr, cstp, caoi, tcan, rotf,
                code, itnm, bntn, mirs, otpr, stnm, ocit, odrp, oitp, orit, orxn, rpnm, sctl, rpdt, sear, seei, setn));
    }

    public static List<ExcelSusReport> Exp2Excel(QueryRunner runner, ExcelWriter writer, Sheet sheet)
            throws SQLException {
        sheet.setSheetName("SusReport");
        String sql = "SELECT * from tb_sus_report";
        List<ExcelSusReport> result = runner.query(sql, new BeanListHandler<ExcelSusReport>(ExcelSusReport.class));
        return result;
    }

    public String getricd() {
        return ricd;
    }

    public void setricd(String ricd) {
        this.ricd = ricd;
    }

    public String getfinc() {
        return finc;
    }

    public void setfinc(String finc) {
        this.finc = finc;
    }

    public String getsenm() {
        return senm;
    }

    public void setsenm(String senm) {
        this.senm = senm;
    }

    public String getsetp() {
        return setp;
    }

    public void setsetp(String setp) {
        this.setp = setp;
    }

    public String getseid() {
        return seid;
    }

    public void setseid(String seid) {
        this.seid = seid;
    }

    public String getsevc() {
        return sevc;
    }

    public void setsevc(String sevc) {
        this.sevc = sevc;
    }

    public String getsrnm() {
        return srnm;
    }

    public void setsrnm(String srnm) {
        this.srnm = srnm;
    }

    public String getsrit() {
        return srit;
    }

    public void setsrit(String srit) {
        this.srit = srit;
    }

    public String getsrid() {
        return srid;
    }

    public void setsrid(String srid) {
        this.srid = srid;
    }

    public String getscnm() {
        return scnm;
    }

    public void setscnm(String scnm) {
        this.scnm = scnm;
    }

    public String getscit() {
        return scit;
    }

    public void setscit(String scit) {
        this.scit = scit;
    }

    public String getscid() {
        return scid;
    }

    public void setscid(String scid) {
        this.scid = scid;
    }

    public String getstnt() {
        return stnt;
    }

    public void setstnt(String stnt) {
        this.stnt = stnt;
    }

    public String getdetr() {
        return detr;
    }

    public void setdetr(String detr) {
        this.detr = detr;
    }

    public String gettorp() {
        return torp;
    }

    public void settorp(String torp) {
        this.torp = torp;
    }

    public String getdorp() {
        return dorp;
    }

    public void setdorp(String dorp) {
        this.dorp = dorp;
    }

    public String gettptr() {
        return tptr;
    }

    public void settptr(String tptr) {
        this.tptr = tptr;
    }

    public String getstcb() {
        return stcb;
    }

    public void setstcb(String stcb) {
        this.stcb = stcb;
    }

    public String getaosp() {
        return aosp;
    }

    public void setaosp(String aosp) {
        this.aosp = aosp;
    }

    public String gettosc() {
        return tosc;
    }

    public void settosc(String tosc) {
        this.tosc = tosc;
    }

    public String getstcr() {
        return stcr;
    }

    public void setstcr(String stcr) {
        this.stcr = stcr;
    }

    public String geticnm() {
        return icnm;
    }

    public void seticnm(String icnm) {
        this.icnm = icnm;
    }

    public String getistp() {
        return istp;
    }

    public void setistp(String istp) {
        this.istp = istp;
    }

    public String getisnm() {
        return isnm;
    }

    public void setisnm(String isnm) {
        this.isnm = isnm;
    }

    public String getisps() {
        return isps;
    }

    public void setisps(String isps) {
        this.isps = isps;
    }

    public String getalnm() {
        return alnm;
    }

    public void setalnm(String alnm) {
        this.alnm = alnm;
    }

    public String getaitp() {
        return aitp;
    }

    public void setaitp(String aitp) {
        this.aitp = aitp;
    }

    public String getalid() {
        return alid;
    }

    public void setalid(String alid) {
        this.alid = alid;
    }

    public String getaltp() {
        return altp;
    }

    public void setaltp(String altp) {
        this.altp = altp;
    }

    public String getistn() {
        return istn;
    }

    public void setistn(String istn) {
        this.istn = istn;
    }

    public String getiitp() {
        return iitp;
    }

    public void setiitp(String iitp) {
        this.iitp = iitp;
    }

    public String getisid() {
        return isid;
    }

    public void setisid(String isid) {
        this.isid = isid;
    }

    public String getrltp() {
        return rltp;
    }

    public void setrltp(String rltp) {
        this.rltp = rltp;
    }

    public String getbnnm() {
        return bnnm;
    }

    public void setbnnm(String bnnm) {
        this.bnnm = bnnm;
    }

    public String getbitp() {
        return bitp;
    }

    public void setbitp(String bitp) {
        this.bitp = bitp;
    }

    public String getbnid() {
        return bnid;
    }

    public void setbnid(String bnid) {
        this.bnid = bnid;
    }

    public String getisog() {
        return isog;
    }

    public void setisog(String isog) {
        this.isog = isog;
    }

    public double getisat() {
        return isat;
    }

    public void setisat(double isat) {
        this.isat = isat;
    }

    public double getisfe() {
        return isfe;
    }

    public void setisfe(double isfe) {
        this.isfe = isfe;
    }

    public String getispt() {
        return ispt;
    }

    public void setispt(String ispt) {
        this.ispt = ispt;
    }

    public String getctes() {
        return ctes;
    }

    public void setctes(String ctes) {
        this.ctes = ctes;
    }

    public String gettstm() {
        return tstm;
    }

    public void settstm(String tstm) {
        this.tstm = tstm;
    }

    public String gettrcd() {
        return trcd;
    }

    public void settrcd(String trcd) {
        this.trcd = trcd;
    }

    public String getittp() {
        return ittp;
    }

    public void setittp(String ittp) {
        this.ittp = ittp;
    }

    public String getcrtp() {
        return crtp;
    }

    public void setcrtp(String crtp) {
        this.crtp = crtp;
    }

    public double getcrat() {
        return crat;
    }

    public void setcrat(double crat) {
        this.crat = crat;
    }

    public String getcrdr() {
        return crdr;
    }

    public void setcrdr(String crdr) {
        this.crdr = crdr;
    }

    public String getcstp() {
        return cstp;
    }

    public void setcstp(String cstp) {
        this.cstp = cstp;
    }

    public String getcaoi() {
        return caoi;
    }

    public void setcaoi(String caoi) {
        this.caoi = caoi;
    }

    public String gettcan() {
        return tcan;
    }

    public void settcan(String tcan) {
        this.tcan = tcan;
    }

    public String getrotf() {
        return rotf;
    }

    public void setrotf(String rotf) {
        this.rotf = rotf;
    }

    public String getcode() {
        return code;
    }

    public void setcode(String code) {
        this.code = code;
    }

    public String getitnm() {
        return itnm;
    }

    public void setitnm(String itnm) {
        this.itnm = itnm;
    }

    public String getbntn() {
        return bntn;
    }

    public void setbntn(String bntn) {
        this.bntn = bntn;
    }

    public String getmirs() {
        return mirs;
    }

    public void setmirs(String mirs) {
        this.mirs = mirs;
    }

    public String getotpr() {
        return otpr;
    }

    public void setotpr(String otpr) {
        this.otpr = otpr;
    }

    public String getstnm() {
        return stnm;
    }

    public void setstnm(String stnm) {
        this.stnm = stnm;
    }

    public String getocit() {
        return ocit;
    }

    public void setocit(String ocit) {
        this.ocit = ocit;
    }

    public String getodrp() {
        return odrp;
    }

    public void setodrp(String odrp) {
        this.odrp = odrp;
    }

    public String getoitp() {
        return oitp;
    }

    public void setoitp(String oitp) {
        this.oitp = oitp;
    }

    public String getorit() {
        return orit;
    }

    public void setorit(String orit) {
        this.orit = orit;
    }

    public String getorxn() {
        return orxn;
    }

    public void setorxn(String orxn) {
        this.orxn = orxn;
    }

    public String getrpnm() {
        return rpnm;
    }

    public void setrpnm(String rpnm) {
        this.rpnm = rpnm;
    }

    public String getsctl() {
        return sctl;
    }

    public void setsctl(String sctl) {
        this.sctl = sctl;
    }

    public String getrpdt() {
        return rpdt;
    }

    public void setrpdt(String rpdt) {
        this.rpdt = rpdt;
    }

    public String getsear() {
        return sear;
    }

    public void setsear(String sear) {
        this.sear = sear;
    }

    public String getseei() {
        return seei;
    }

    public void setseei(String seei) {
        this.seei = seei;
    }

    public String getsetn() {
        return setn;
    }

    public void setsetn(String setn) {
        this.setn = setn;
    }
}
