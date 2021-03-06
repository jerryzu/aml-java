-- *********************************eee************************************************
--  文件名称: 11rpt_fxq_tb_ins_rpay_ms.sql
--  所属主题: 中国人民银行反洗钱执法检查数据提取接口
--  功能描述: 弃用(表适用人身保险业务,太科都是财产险不需上报)
--   表提取数据
--            导入到 () 表
--  创建者:祖新合 
--  输入: 
--  输出:  
--  创建日期: 2019/10/30
--  修改日志: 
--  修改日期: 
--  修改人: 
--  修改内容：
-- 说明：
--   1.本表数据范围为检查业务期限内，检查对象所有给付信息，每一笔业务生成一条完整的记录。  
--   2.本表适用人身保险业务，主要包含生存金给付、满期金给付等业务。注:本表建立索引字段，创建两个组合索引和一个独立索引。

alter table rpt_fxq_tb_ins_rpay_ms truncate partition pt{workday}000000;

--  未将空值处理为-9999或＠N,用来上报前整理数据的临时表
drop table if exists s_rpt_fxq_tb_ins_rpay_ms;

create temporary table s_rpt_fxq_tb_ins_rpay_ms select * from rpt_fxq_tb_ins_rpay_ms where 1 <> 1;

/*
INSERT INTO s_rpt_fxq_tb_ins_rpay_ms(
        company_code1,
        company_code2,
        company_code3,
        company_code4,
        pol_no,
        app_no,
        ins_date,
        eff_date,
        cur_code1,
        pre_amt_all,
        usd_amt_all,
        app_name,
        app_cst_no,
        app_id_no,
        app_cus_pro,
        ins_name,
        ins_cst_no,
        ins_id_no,
        ins_cus_pro,
        benefit_name,
        benefit_id_no,
        benefit_cus_pro,
        relation_1,
        relation_2,
        pay_type,
        rpay_date,
        pay_date,
        cur_code2,
        pay_amt,
        pay_usd_amt,
        tsf_flag,
        acc_name,
        acc_no,
        acc_bank,
        receipt_no,
        pt
)
select
    m.c_dpt_cde as company_codel,-- 机构网点代码
    co.company_code2 as company_code2, -- 金融机构编码，人行科技司制定的14位金融标准化编码  暂时取“监管机构码，机构外部码，列为空”
    '' as company_code3,-- 保单归属机构网点代码
    '' as company_code4,-- 受理业务机构网点代码
    m.c_ply_no as pol_no,-- 保单号
    m.c_app_no as app_no,-- 投保单号
    date_format(m.t_app_tm,'%Y%m%d') as ins_date,-- 投保日期
    date_format(m.t_insrnc_bgn_tm,'%Y%m%d') as eff_date,-- 合同生效日期
    '' as cur_code1,-- 币种
    null as pre_amt_all,-- 累计保费金额
    null as usd_amt_all,-- 累计保费折合美元金额
    a.c_acc_name as app_name,-- 投保人名称
    a.c_cst_no as app_cst_no,-- 投保人客户号
    a.c_cert_cde as app_id_no,-- 投保人证件号码
    a.c_clnt_mrk as app_cus_pro,-- 投保人客户类型 11:个人;12:单位;
    i.c_acc_name as ins_name,-- 被保险人客户名称
    i.c_cst_no as ins_cst_no,-- 被保险人客户号
    i.c_cert_cde as ins_id_no,-- 被保险人证件号码
    i.c_clnt_mrk as ins_cus_pro,-- 被保险人客户类型 11:个人;12:单位;
    b.c_acc_name as benefit_name,-- 受益人名称
    b.c_cert_cde   as benefit_id_no,-- 受益人身份证件号码
    '' as benefit_cus_pro,-- 受益人类型 11:个人;12:单位;
    -- b.c_app_relation as relation_1,-- 投保人被保人之间的关系,无此字段
    a.c_app_ins_relation as relation_1,-- 投保人被保人之间的关系 11:本人;12:配偶;13:父母;14:子女;15:其他近亲属;16:雇佣或劳务;17:其他;
    i.c_ins_bnf_relation as relation_2,-- 受益人被保人之间的关系 11:本人;12:配偶;13:父母;14:子女;15:其他近亲属;16:雇佣或劳务;18:其他;
    '' as pay_type,-- 给付类型  11:生产金给付;12:满期金给付;13:其他
    '' as rpay_date,-- 给付业务办理日期
    '' as pay_date,-- 资金交易日期
    '' as cur_code2,-- 币种
    null as pay_amt,-- 给付金额
    null as pay_usd_amt,-- 折合美元金额
    case m.c_pay_mde_cde when 5 then 11 else 10 end as tsf_flag,-- b.c_pay_mde_cde  as tsf_flag,-- 现转标识 --  SELECT C_CDE, C_CNM, 'codeKind' FROM  WEB_BAS_CODELIST PARTITION(pt20190818000000)   WHERE C_PAR_CDE = 'shoufeifangshi' ORDER BY C_CDE ;
    m.acc_name         as acc_name,-- 交费账号名称
    m.acc_no          as acc_no,-- 交费账号
    m.acc_bank	          as acc_bank,-- 交费账户开户机构名称
    m.c_app_no  as receipt_no,-- 作业流水号,唯一标识号
    '{workday}000000' pt
from x_rpt_fxq_tb_ins_rpol_gpol m
    --  保单人员参于类型: 投保人: [个人:21, 法人:22]; 被保人: [个人:31, 法人:32, 团单被保人:33]; 受益人: [个人:41, 法人:42,团单受益人:43]; 收款人:[11]
	left join edw_cust_ply_party partition(pt{workday}000000) a on m.c_app_no=a.c_app_no  and a.c_per_biztype in (21, 22)
	left join edw_cust_ply_party partition(pt{workday}000000) i on m.c_app_no=i.c_app_no
	left join edw_cust_ply_party partition(pt{workday}000000) b on  m.c_app_no=b.c_app_no
	left join  rpt_fxq_tb_company_ms partition (pt{workday}000000) co on m.c_dpt_cde = co.company_code1
where 1 = 1 and m.t_next_edr_udr_tm > {endday} 
	and m.t_app_tm between {beginday} and {endday} ;
*/
--   本表适用人身保险业务，主要包含生存金给付、满期金给付等业务。注:本表建立索引字段，创建两个组合索引和一个独立索引。

-- rpt_fxq_tb_ins_rpay_ms
insert into rpt_fxq_tb_ins_rpay_ms(
  company_code1
  ,company_code2
  ,company_code3
  ,company_code4
  ,pol_no
  ,app_no
  ,ins_date
  ,eff_date
  ,cur_code1
  ,pre_amt_all
  ,usd_amt_all
  ,app_name
  ,app_cst_no
  ,app_id_no
  ,app_cus_pro
  ,ins_name
  ,ins_cst_no
  ,ins_id_no
  ,ins_cus_pro
  ,benefit_name
  ,benefit_id_no
  ,benefit_cus_pro
  ,relation_1
  ,relation_2
  ,pay_type
  ,rpay_date
  ,pay_date
  ,cur_code2
  ,pay_amt
  ,pay_usd_amt
  ,tsf_flag
  ,acc_name
  ,acc_no
  ,acc_bank
  ,receipt_no
  ,pt
)
select
	ifnull((case when (trim(company_code1) = '') then null else trim(company_code1) end), '@N') as company_code1
	,ifnull((case when (trim(company_code2) = '') then null else trim(company_code2) end), '@N') as company_code2
	,ifnull((case when (trim(company_code3) = '') then null else trim(company_code3) end), '@N') as company_code3
	,ifnull((case when (trim(company_code4) = '') then null else trim(company_code4) end), '@N') as company_code4
	,ifnull((case when (trim(pol_no) = '') then null else trim(pol_no) end), '@N') as pol_no
	,ifnull((case when (trim(app_no) = '') then null else trim(app_no) end), '@N') as app_no
	,ifnull((case when (trim(ins_date) = '') then null else trim(ins_date) end), '@N') as ins_date
	,ifnull((case when (trim(eff_date) = '') then null else trim(eff_date) end), '@N') as eff_date
	,ifnull((case when (trim(cur_code1) = '') then null else trim(cur_code1) end), '@N') as cur_code1
	,ifnull(pre_amt_all, -9999) as pre_amt_all
	,ifnull(usd_amt_all, -9999) as usd_amt_all
	,ifnull((case when (trim(app_name) = '') then null else trim(app_name) end), '@N') as app_name
	,ifnull((case when (trim(app_cst_no) = '') then null else trim(app_cst_no) end), '@N') as app_cst_no
	,ifnull((case when (trim(app_id_no) = '') then null else trim(app_id_no) end), '@N') as app_id_no
	,ifnull((case when (trim(app_cus_pro) = '') then null else trim(app_cus_pro) end), '@N') as app_cus_pro
	,ifnull((case when (trim(ins_name) = '') then null else trim(ins_name) end), '@N') as ins_name
	,ifnull((case when (trim(ins_cst_no) = '') then null else trim(ins_cst_no) end), '@N') as ins_cst_no
	,ifnull((case when (trim(ins_id_no) = '') then null else trim(ins_id_no) end), '@N') as ins_id_no
	,ifnull((case when (trim(ins_cus_pro) = '') then null else trim(ins_cus_pro) end), '@N') as ins_cus_pro
	,ifnull((case when (trim(benefit_name) = '') then null else trim(benefit_name) end), '@N') as benefit_name
	,ifnull((case when (trim(benefit_id_no) = '') then null else trim(benefit_id_no) end), '@N') as benefit_id_no
	,ifnull((case when (trim(benefit_cus_pro) = '') then null else trim(benefit_cus_pro) end), '@N') as benefit_cus_pro
	,ifnull((case when (trim(relation_1) = '') then null else trim(relation_1) end), '@N') as relation_1
	,ifnull((case when (trim(relation_2) = '') then null else trim(relation_2) end), '@N') as relation_2
	,ifnull((case when (trim(pay_type) = '') then null else trim(pay_type) end), '@N') as pay_type
	,ifnull((case when (trim(rpay_date) = '') then null else trim(rpay_date) end), '@N') as rpay_date
	,ifnull((case when (trim(pay_date) = '') then null else trim(pay_date) end), '@N') as pay_date
	,ifnull((case when (trim(cur_code2) = '') then null else trim(cur_code2) end), '@N') as cur_code2
	,ifnull(pay_amt, -9999) as pay_amt
	,ifnull(pay_usd_amt, -9999) as pay_usd_amt
	,ifnull((case when (trim(tsf_flag) = '') then null else trim(tsf_flag) end), '@N') as tsf_flag
	,ifnull((case when (trim(acc_name) = '') then null else trim(acc_name) end), '@N') as acc_name
	,ifnull((case when (trim(acc_no) = '') then null else trim(acc_no) end), '@N') as acc_no
	,ifnull((case when (trim(acc_bank) = '') then null else trim(acc_bank) end), '@N') as acc_bank
	,ifnull((case when (trim(receipt_no) = '') then null else trim(receipt_no) end), '@N') as receipt_no
	,'{workday}000000' as pt
from s_rpt_fxq_tb_ins_rpay_ms;