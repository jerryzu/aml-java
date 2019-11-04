package lab.crazyspark.excel;

import java.sql.SQLException;
import java.util.List;

import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;
import com.alibaba.excel.metadata.Sheet;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

public class ExcelLarReport extends BaseRowModel {
    @ExcelProperty(value = "ricd", index = 0)
    private String ricd;
    @ExcelProperty(value = "finc", index = 1)
    private String finc;
    @ExcelProperty(value = "sbdt", index = 2)
    private String sbdt;
    @ExcelProperty(value = "cttn", index = 3)
    private String cttn;
    @ExcelProperty(value = "code", index = 4)
    private String code;
    @ExcelProperty(value = "rlfc", index = 5)
    private String rlfc;
    @ExcelProperty(value = "ctnm", index = 6)
    private String ctnm;
    @ExcelProperty(value = "citp", index = 7)
    private String citp;
    @ExcelProperty(value = "oitp", index = 8)
    private String oitp;
    @ExcelProperty(value = "ctid", index = 9)
    private String ctid;
    @ExcelProperty(value = "csnm", index = 10)
    private String csnm;
    @ExcelProperty(value = "catp", index = 11)
    private String catp;
    @ExcelProperty(value = "ctac", index = 12)
    private String ctac;
    @ExcelProperty(value = "cbct", index = 13)
    private String cbct;
    @ExcelProperty(value = "ocbt", index = 14)
    private String ocbt;
    @ExcelProperty(value = "cbcn", index = 15)
    private String cbcn;
    @ExcelProperty(value = "ctvc", index = 16)
    private String ctvc;
    @ExcelProperty(value = "cctl", index = 17)
    private String cctl;
    @ExcelProperty(value = "ccei", index = 18)
    private String ccei;
    @ExcelProperty(value = "ctar", index = 19)
    private String ctar;
    @ExcelProperty(value = "ctnt", index = 20)
    private String ctnt;
    @ExcelProperty(value = "oatm", index = 21)
    private String oatm;
    @ExcelProperty(value = "crcd", index = 22)
    private String crcd;
    @ExcelProperty(value = "tbnm", index = 23)
    private String tbnm;
    @ExcelProperty(value = "tbit", index = 24)
    private String tbit;
    @ExcelProperty(value = "tbid", index = 25)
    private String tbid;
    @ExcelProperty(value = "tbnt", index = 26)
    private String tbnt;
    @ExcelProperty(value = "tstm", index = 27)
    private String tstm;
    @ExcelProperty(value = "trcd", index = 28)
    private String trcd;
    @ExcelProperty(value = "ticd", index = 29)
    private String ticd;
    @ExcelProperty(value = "rpmt", index = 30)
    private String rpmt;
    @ExcelProperty(value = "rpmn", index = 31)
    private String rpmn;
    @ExcelProperty(value = "tstp", index = 32)
    private String tstp;
    @ExcelProperty(value = "tsct", index = 33)
    private String tsct;
    @ExcelProperty(value = "tsdr", index = 34)
    private String tsdr;
    @ExcelProperty(value = "crpp", index = 35)
    private String crpp;
    @ExcelProperty(value = "crtp", index = 36)
    private String crtp;
    @ExcelProperty(value = "crat", index = 37)
    private double crat;
    @ExcelProperty(value = "crmb", index = 38)
    private String crmb;
    @ExcelProperty(value = "cusd", index = 39)
    private double cusd;
    @ExcelProperty(value = "ttnm", index = 40)
    private String ttnm;
    @ExcelProperty(value = "cfin", index = 41)
    private String cfin;
    @ExcelProperty(value = "cfct", index = 42)
    private String cfct;
    @ExcelProperty(value = "cfic", index = 43)
    private String cfic;
    @ExcelProperty(value = "cfrc", index = 44)
    private String cfrc;
    @ExcelProperty(value = "tcnm", index = 45)
    private String tcnm;
    @ExcelProperty(value = "tcit", index = 46)
    private String tcit;
    @ExcelProperty(value = "tcid", index = 47)
    private String tcid;
    @ExcelProperty(value = "tcat", index = 48)
    private String tcat;
    @ExcelProperty(value = "tcac", index = 49)
    private String tcac;
    @ExcelProperty(value = "octt", index = 50)
    private String octt;
    @ExcelProperty(value = "ooct", index = 51)
    private String ooct;
    @ExcelProperty(value = "ocec", index = 52)
    private String ocec;
    @ExcelProperty(value = "rotf", index = 53)
    private String rotf;

    public void print() {
        System.out.println(String.format(
                "LarReport:  ricd%s  finc%s  sbdt%s  cttn%s  code%s  rlfc%s  ctnm%s  citp%s  oitp%s  ctid%s  csnm%s  catp%s  ctac%s  cbct%s  ocbt%s  cbcn%s  ctvc%s  cctl%s  ccei%s  ctar%s  ctnt%s  oatm%s  crcd%s  tbnm%s  tbit%s  tbid%s  tbnt%s  tstm%s  trcd%s  ticd%s  rpmt%s  rpmn%s  tstp%s  tsct%s  tsdr%s  crpp%s  crtp%s  crat%s  crmb%s  cusd%s  ttnm%s  cfin%s  cfct%s  cfic%s  cfrc%s  tcnm%s  tcit%s  tcid%s  tcat%s  tcac%s  octt%s  ooct%s  ocec%s  rotf%s",
                ricd, finc, sbdt, cttn, code, rlfc, ctnm, citp, oitp, ctid, csnm, catp, ctac, cbct, ocbt, cbcn, ctvc,
                cctl, ccei, ctar, ctnt, oatm, crcd, tbnm, tbit, tbid, tbnt, tstm, trcd, ticd, rpmt, rpmn, tstp, tsct,
                tsdr, crpp, crtp, crat, crmb, cusd, ttnm, cfin, cfct, cfic, cfrc, tcnm, tcit, tcid, tcat, tcac, octt,
                ooct, ocec, rotf));
    }

    public static List<ExcelLarReport> Exp2Excel(QueryRunner runner, ExcelWriter writer, Sheet sheet)
            throws SQLException {
        sheet.setSheetName("LarReport");
        String sql = "SELECT * from tb_lar_report";
        List<ExcelLarReport> result = runner.query(sql, new BeanListHandler<ExcelLarReport>(ExcelLarReport.class));
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

    public String getsbdt() {
        return sbdt;
    }

    public void setsbdt(String sbdt) {
        this.sbdt = sbdt;
    }

    public String getcttn() {
        return cttn;
    }

    public void setcttn(String cttn) {
        this.cttn = cttn;
    }

    public String getcode() {
        return code;
    }

    public void setcode(String code) {
        this.code = code;
    }

    public String getrlfc() {
        return rlfc;
    }

    public void setrlfc(String rlfc) {
        this.rlfc = rlfc;
    }

    public String getctnm() {
        return ctnm;
    }

    public void setctnm(String ctnm) {
        this.ctnm = ctnm;
    }

    public String getcitp() {
        return citp;
    }

    public void setcitp(String citp) {
        this.citp = citp;
    }

    public String getoitp() {
        return oitp;
    }

    public void setoitp(String oitp) {
        this.oitp = oitp;
    }

    public String getctid() {
        return ctid;
    }

    public void setctid(String ctid) {
        this.ctid = ctid;
    }

    public String getcsnm() {
        return csnm;
    }

    public void setcsnm(String csnm) {
        this.csnm = csnm;
    }

    public String getcatp() {
        return catp;
    }

    public void setcatp(String catp) {
        this.catp = catp;
    }

    public String getctac() {
        return ctac;
    }

    public void setctac(String ctac) {
        this.ctac = ctac;
    }

    public String getcbct() {
        return cbct;
    }

    public void setcbct(String cbct) {
        this.cbct = cbct;
    }

    public String getocbt() {
        return ocbt;
    }

    public void setocbt(String ocbt) {
        this.ocbt = ocbt;
    }

    public String getcbcn() {
        return cbcn;
    }

    public void setcbcn(String cbcn) {
        this.cbcn = cbcn;
    }

    public String getctvc() {
        return ctvc;
    }

    public void setctvc(String ctvc) {
        this.ctvc = ctvc;
    }

    public String getcctl() {
        return cctl;
    }

    public void setcctl(String cctl) {
        this.cctl = cctl;
    }

    public String getccei() {
        return ccei;
    }

    public void setccei(String ccei) {
        this.ccei = ccei;
    }

    public String getctar() {
        return ctar;
    }

    public void setctar(String ctar) {
        this.ctar = ctar;
    }

    public String getctnt() {
        return ctnt;
    }

    public void setctnt(String ctnt) {
        this.ctnt = ctnt;
    }

    public String getoatm() {
        return oatm;
    }

    public void setoatm(String oatm) {
        this.oatm = oatm;
    }

    public String getcrcd() {
        return crcd;
    }

    public void setcrcd(String crcd) {
        this.crcd = crcd;
    }

    public String gettbnm() {
        return tbnm;
    }

    public void settbnm(String tbnm) {
        this.tbnm = tbnm;
    }

    public String gettbit() {
        return tbit;
    }

    public void settbit(String tbit) {
        this.tbit = tbit;
    }

    public String gettbid() {
        return tbid;
    }

    public void settbid(String tbid) {
        this.tbid = tbid;
    }

    public String gettbnt() {
        return tbnt;
    }

    public void settbnt(String tbnt) {
        this.tbnt = tbnt;
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

    public String getticd() {
        return ticd;
    }

    public void setticd(String ticd) {
        this.ticd = ticd;
    }

    public String getrpmt() {
        return rpmt;
    }

    public void setrpmt(String rpmt) {
        this.rpmt = rpmt;
    }

    public String getrpmn() {
        return rpmn;
    }

    public void setrpmn(String rpmn) {
        this.rpmn = rpmn;
    }

    public String gettstp() {
        return tstp;
    }

    public void settstp(String tstp) {
        this.tstp = tstp;
    }

    public String gettsct() {
        return tsct;
    }

    public void settsct(String tsct) {
        this.tsct = tsct;
    }

    public String gettsdr() {
        return tsdr;
    }

    public void settsdr(String tsdr) {
        this.tsdr = tsdr;
    }

    public String getcrpp() {
        return crpp;
    }

    public void setcrpp(String crpp) {
        this.crpp = crpp;
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

    public String getcrmb() {
        return crmb;
    }

    public void setcrmb(String crmb) {
        this.crmb = crmb;
    }

    public double getcusd() {
        return cusd;
    }

    public void setcusd(double cusd) {
        this.cusd = cusd;
    }

    public String getttnm() {
        return ttnm;
    }

    public void setttnm(String ttnm) {
        this.ttnm = ttnm;
    }

    public String getcfin() {
        return cfin;
    }

    public void setcfin(String cfin) {
        this.cfin = cfin;
    }

    public String getcfct() {
        return cfct;
    }

    public void setcfct(String cfct) {
        this.cfct = cfct;
    }

    public String getcfic() {
        return cfic;
    }

    public void setcfic(String cfic) {
        this.cfic = cfic;
    }

    public String getcfrc() {
        return cfrc;
    }

    public void setcfrc(String cfrc) {
        this.cfrc = cfrc;
    }

    public String gettcnm() {
        return tcnm;
    }

    public void settcnm(String tcnm) {
        this.tcnm = tcnm;
    }

    public String gettcit() {
        return tcit;
    }

    public void settcit(String tcit) {
        this.tcit = tcit;
    }

    public String gettcid() {
        return tcid;
    }

    public void settcid(String tcid) {
        this.tcid = tcid;
    }

    public String gettcat() {
        return tcat;
    }

    public void settcat(String tcat) {
        this.tcat = tcat;
    }

    public String gettcac() {
        return tcac;
    }

    public void settcac(String tcac) {
        this.tcac = tcac;
    }

    public String getoctt() {
        return octt;
    }

    public void setoctt(String octt) {
        this.octt = octt;
    }

    public String getooct() {
        return ooct;
    }

    public void setooct(String ooct) {
        this.ooct = ooct;
    }

    public String getocec() {
        return ocec;
    }

    public void setocec(String ocec) {
        this.ocec = ocec;
    }

    public String getrotf() {
        return rotf;
    }

    public void setrotf(String rotf) {
        this.rotf = rotf;
    }
}
