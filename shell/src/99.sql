alter table rpt_fxq_tb_company_ms truncate partition report;
alter table rpt_fxq_tb_ins_rtype_ms truncate partition report;
alter table rpt_fxq_tb_ins_pers_ms truncate partition report;
alter table rpt_fxq_tb_ins_unit_ms truncate partition report;
alter table rpt_fxq_tb_ins_bo_ms truncate partition report;
alter table rpt_fxq_tb_ins_rpol_ms truncate partition report;
alter table rpt_fxq_tb_ins_gpol_ms truncate partition report;
alter table rpt_fxq_tb_ins_fav_cst_ms truncate partition report;
alter table rpt_fxq_tb_ins_renewal_ms truncate partition report;
alter table rpt_fxq_tb_ins_rsur_ms truncate partition report;
alter table rpt_fxq_tb_ins_rpay_ms truncate partition report;
alter table rpt_fxq_tb_ins_rcla_ms truncate partition report;
alter table rpt_fxq_tb_ins_rchg_ms truncate partition report;
alter table rpt_fxq_tb_ins_risk_new_ms truncate partition report;
alter table rpt_fxq_tb_ins_risk_ms truncate partition report;
alter table rpt_fxq_tb_lar_report_ms truncate partition report;
alter table rpt_fxq_tb_sus_report_ms truncate partition report;

-- rpt_fxq_tb_company_ms

insert into rpt_fxq_tb_company_ms(
	head_no
	,company_code1
	,company_code2
	,company_name
	,bord_flag
	,pt
)
select
  ifnull((case when (trim(head_no) = '') then null else trim(head_no) end), '@N') as head_no
  ,ifnull((case when (trim(company_code1) = '') then null else trim(company_code1) end), '@N') as company_code1
  ,ifnull((case when (trim(company_code2) = '') then null else trim(company_code2) end), '@N') as company_code2
  ,ifnull((case when (trim(company_name) = '') then null else trim(company_name) end), '@N') as company_name
  ,ifnull((case when (trim(bord_flag) = '') then null else trim(bord_flag) end), '@N') as bord_flag
  ,'99991231000000' as pt
from rpt_fxq_tb_company_ms partition(pt{workday}000000);

-- rpt_fxq_tb_ins_rtype_ms
insert into rpt_fxq_tb_ins_rtype_ms(
  head_no
  ,company_code1
  ,ins_type
  ,ins_no
  ,ins_name
  ,pt
)
select
  ifnull((case when (trim(head_no) = '') then null else trim(head_no) end), '@N') as head_no
  ,ifnull((case when (trim(company_code1) = '') then null else trim(company_code1) end), '@N') as company_code1
  ,ifnull((case when (trim(ins_type) = '') then null else trim(ins_type) end), '@N') as ins_type
  ,ifnull((case when (trim(ins_no) = '') then null else trim(ins_no) end), '@N') as ins_no
  ,ifnull((case when (trim(ins_name) = '') then null else trim(ins_name) end), '@N') as ins_name
  ,'99991231000000' as pt
from rpt_fxq_tb_ins_rtype_ms partition(pt{workday}000000);

-- rpt_fxq_tb_ins_pers_ms
insert into rpt_fxq_tb_ins_pers_ms(
  company_code1
  ,company_code2
  ,cst_no
  ,open_time
  ,close_time
  ,acc_name
  ,cst_sex
  ,nation
  ,id_type
  ,id_no
  ,id_deadline
  ,occupation_code
  ,occupation
  ,income
  ,contact1
  ,contact2
  ,contact3
  ,address1
  ,address2
  ,address3
  ,company
  ,sys_name
  ,pt
)
select
	ifnull((case when (trim(company_code1) = '') then null else trim(company_code1) end), '@N') as company_code1
	,ifnull((case when (trim(company_code2) = '') then null else trim(company_code2) end), '@N') as company_code2
	,ifnull((case when (trim(cst_no) = '') then null else trim(cst_no) end), '@N') as cst_no
	,ifnull((case when (trim(open_time) = '') then null else trim(open_time) end), '@N') as open_time
	,ifnull((case when (trim(close_time) = '') then null else trim(close_time) end), '@N') as close_time
	,ifnull((case when (trim(acc_name) = '') then null else trim(acc_name) end), '@N') as acc_name
	,ifnull((case when (trim(cst_sex) = '') then null else trim(cst_sex) end), '@N') as cst_sex
	,ifnull((case when (trim(nation) = '') then null else trim(nation) end), '@N') as nation
	,ifnull((case when (trim(id_type) = '') then null else trim(id_type) end), '@N') as id_type
	,ifnull((case when (trim(id_no) = '') then null else trim(id_no) end), '@N') as id_no
	,ifnull((case when (trim(id_deadline) = '') then null else trim(id_deadline) end), '@N') as id_deadline
	,ifnull((case when (trim(occupation_code) = '') then null else trim(occupation_code) end), '@N') as occupation_code
	,ifnull((case when (trim(occupation) = '') then null else trim(occupation) end), '@N') as occupation
	,ifnull(income, -9999) as income
	,ifnull((case when (trim(contact1) = '') then null else trim(contact1) end), '@N') as contact1
	,ifnull((case when (trim(contact2) = '') then null else trim(contact2) end), '@N') as contact2
	,ifnull((case when (trim(contact3) = '') then null else trim(contact3) end), '@N') as contact3
	,ifnull((case when (trim(address1) = '') then null else trim(address1) end), '@N') as address1
	,ifnull((case when (trim(address2) = '') then null else trim(address2) end), '@N') as address2
	,ifnull((case when (trim(address3) = '') then null else trim(address3) end), '@N') as address3
	,ifnull((case when (trim(company) = '') then null else trim(company) end), '@N') as company
	,ifnull((case when (trim(sys_name) = '') then null else trim(sys_name) end), '@N') as sys_name
	,'99991231000000' as pt
from rpt_fxq_tb_ins_pers_ms partition(pt{workday}000000);

-- rpt_fxq_tb_ins_unit_ms
insert into rpt_fxq_tb_ins_unit_ms(
  company_code1
  ,company_code2
  ,cst_no
  ,open_time
  ,close_time
  ,acc_name
  ,address
  ,operate
  ,set_file
  ,license
  ,id_deadline
  ,org_no
  ,tax_no
  ,rep_name
  ,id_type2
  ,id_no2
  ,id_deadline2
  ,man_name
  ,id_type3
  ,id_no3
  ,id_deadline3
  ,ope_name
  ,id_type4
  ,id_no4
  ,id_deadline4
  ,industry_code
  ,industry
  ,reg_amt
  ,code
  ,sys_name
  ,pt
)
select
	ifnull((case when (trim(company_code1) = '') then null else trim(company_code1) end), '@N') as company_code1
	,ifnull((case when (trim(company_code2) = '') then null else trim(company_code2) end), '@N') as company_code2
	,ifnull((case when (trim(cst_no) = '') then null else trim(cst_no) end), '@N') as cst_no
	,ifnull((case when (trim(open_time) = '') then null else trim(open_time) end), '@N') as open_time
	,ifnull((case when (trim(close_time) = '') then null else trim(close_time) end), '@N') as close_time
	,ifnull((case when (trim(acc_name) = '') then null else trim(acc_name) end), '@N') as acc_name
	,ifnull((case when (trim(address) = '') then null else trim(address) end), '@N') as address
	,ifnull((case when (trim(operate) = '') then null else trim(operate) end), '@N') as operate
	,ifnull((case when (trim(set_file) = '') then null else trim(set_file) end), '@N') as set_file
	,ifnull((case when (trim(license) = '') then null else trim(license) end), '@N') as license
	,ifnull((case when (trim(id_deadline) = '') then null else trim(id_deadline) end), '@N') as id_deadline
	,ifnull((case when (trim(org_no) = '') then null else trim(org_no) end), '@N') as org_no
	,ifnull((case when (trim(tax_no) = '') then null else trim(tax_no) end), '@N') as tax_no
	,ifnull((case when (trim(rep_name) = '') then null else trim(rep_name) end), '@N') as rep_name
	,ifnull((case when (trim(id_type2) = '') then null else trim(id_type2) end), '@N') as id_type2
	,ifnull((case when (trim(id_no2) = '') then null else trim(id_no2) end), '@N') as id_no2
	,ifnull((case when (trim(id_deadline2) = '') then null else trim(id_deadline2) end), '@N') as id_deadline2
	,ifnull((case when (trim(man_name) = '') then null else trim(man_name) end), '@N') as man_name
	,ifnull((case when (trim(id_type3) = '') then null else trim(id_type3) end), '@N') as id_type3
	,ifnull((case when (trim(id_no3) = '') then null else trim(id_no3) end), '@N') as id_no3
	,ifnull((case when (trim(id_deadline3) = '') then null else trim(id_deadline3) end), '@N') as id_deadline3
	,ifnull((case when (trim(ope_name) = '') then null else trim(ope_name) end), '@N') as ope_name
	,ifnull((case when (trim(id_type4) = '') then null else trim(id_type4) end), '@N') as id_type4
	,ifnull((case when (trim(id_no4) = '') then null else trim(id_no4) end), '@N') as id_no4
	,ifnull((case when (trim(id_deadline4) = '') then null else trim(id_deadline4) end), '@N') as id_deadline4
	,ifnull((case when (trim(industry_code) = '') then null else trim(industry_code) end), '@N') as industry_code
	,ifnull((case when (trim(industry) = '') then null else trim(industry) end), '@N') as industry
	,ifnull(reg_amt, -9999) as reg_amt
	,ifnull((case when (trim(code) = '') then null else trim(code) end), '@N') as code
	,ifnull((case when (trim(sys_name) = '') then null else trim(sys_name) end), '@N') as sys_name
  ,'99991231000000' as pt
from rpt_fxq_tb_ins_unit_ms partition(pt{workday}000000);

-- rpt_fxq_tb_ins_bo_ms
insert into rpt_fxq_tb_ins_bo_ms(
  company_code1
  ,company_code2
  ,acc_name
  ,cst_no
  ,license
  ,bnf_name
  ,bnf_type
  ,shareholding_ratio
  ,bnf_address
  ,id_type5
  ,id_no5
  ,id_deadline5
  ,sys_name
  ,pt
)
select
  ifnull((case when (trim(company_code1) = '') then null else trim(company_code1) end), '@N') as company_code1
	,ifnull((case when (trim(company_code2) = '') then null else trim(company_code2) end), '@N') as company_code2
	,ifnull((case when (trim(acc_name) = '') then null else trim(acc_name) end), '@N') as acc_name
	,ifnull((case when (trim(cst_no) = '') then null else trim(cst_no) end), '@N') as cst_no
	,ifnull((case when (trim(license) = '') then null else trim(license) end), '@N') as license
	,ifnull((case when (trim(bnf_name) = '') then null else trim(bnf_name) end), '@N') as bnf_name
	,ifnull((case when (trim(bnf_type) = '') then null else trim(bnf_type) end), '@N') as bnf_type
	,ifnull(shareholding_ratio, -9999) as shareholding_ratio
	,ifnull((case when (trim(bnf_address) = '') then null else trim(bnf_address) end), '@N') as bnf_address
	,ifnull((case when (trim(id_type5) = '') then null else trim(id_type5) end), '@N') as id_type5
	,ifnull((case when (trim(id_no5) = '') then null else trim(id_no5) end), '@N') as id_no5
	,ifnull((case when (trim(id_deadline5) = '') then null else trim(id_deadline5) end), '@N') as id_deadline5
	,ifnull((case when (trim(sys_name) = '') then null else trim(sys_name) end), '@N') as sys_name
  ,'99991231000000' as pt
from rpt_fxq_tb_ins_bo_ms partition(pt{workday}000000);

-- rpt_fxq_tb_ins_rpol_ms
insert into rpt_fxq_tb_ins_rpol_ms(
  company_code1
  ,company_code2
  ,company_code3
  ,pol_no
  ,app_no
  ,ins_state
  ,sale_type
  ,sale_name
  ,ins_date
  ,eff_date
  ,app_name
  ,app_cst_no
  ,app_id_type
  ,app_id_no
  ,ins_name
  ,ins_cst_no
  ,ins_id_no
  ,ins_cus_pro
  ,relation
  ,legal_type
  ,benefit_cus_pro
  ,benefit_name
  ,benefit_cst_no
  ,benefit_id_no
  ,ins_no
  ,cur_code
  ,pre_amt
  ,usd_amt
  ,prof_type
  ,del_way
  ,del_period
  ,`limit`
  ,subject
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
	,ifnull((case when (trim(pol_no) = '') then null else trim(pol_no) end), '@N') as pol_no
	,ifnull((case when (trim(app_no) = '') then null else trim(app_no) end), '@N') as app_no
	,ifnull((case when (trim(ins_state) = '') then null else trim(ins_state) end), '@N') as ins_state
	,ifnull((case when (trim(sale_type) = '') then null else trim(sale_type) end), '@N') as sale_type
	,ifnull((case when (trim(sale_name) = '') then null else trim(sale_name) end), '@N') as sale_name
	,ifnull((case when (trim(ins_date) = '') then null else trim(ins_date) end), '@N') as ins_date
	,ifnull((case when (trim(eff_date) = '') then null else trim(eff_date) end), '@N') as eff_date
	,ifnull((case when (trim(app_name) = '') then null else trim(app_name) end), '@N') as app_name
	,ifnull((case when (trim(app_cst_no) = '') then null else trim(app_cst_no) end), '@N') as app_cst_no
	,ifnull((case when (trim(app_id_type) = '') then null else trim(app_id_type) end), '@N') as app_id_type
	,ifnull((case when (trim(app_id_no) = '') then null else trim(app_id_no) end), '@N') as app_id_no
	,ifnull((case when (trim(ins_name) = '') then null else trim(ins_name) end), '@N') as ins_name
	,ifnull((case when (trim(ins_cst_no) = '') then null else trim(ins_cst_no) end), '@N') as ins_cst_no
	,ifnull((case when (trim(ins_id_no) = '') then null else trim(ins_id_no) end), '@N') as ins_id_no
	,ifnull((case when (trim(ins_cus_pro) = '') then null else trim(ins_cus_pro) end), '@N') as ins_cus_pro
	,ifnull((case when (trim(relation) = '') then null else trim(relation) end), '@N') as relation
	,ifnull((case when (trim(legal_type) = '') then null else trim(legal_type) end), '@N') as legal_type
	,ifnull((case when (trim(benefit_cus_pro) = '') then null else trim(benefit_cus_pro) end), '@N') as benefit_cus_pro
	,ifnull((case when (trim(benefit_name) = '') then null else trim(benefit_name) end), '@N') as benefit_name
	,ifnull((case when (trim(benefit_cst_no) = '') then null else trim(benefit_cst_no) end), '@N') as benefit_cst_no
	,ifnull((case when (trim(benefit_id_no) = '') then null else trim(benefit_id_no) end), '@N') as benefit_id_no
	,ifnull((case when (trim(ins_no) = '') then null else trim(ins_no) end), '@N') as ins_no
	,ifnull((case when (trim(cur_code) = '') then null else trim(cur_code) end), '@N') as cur_code
	,ifnull(pre_amt, -9999) as pre_amt
	,ifnull(usd_amt, -9999) as usd_amt
	,ifnull((case when (trim(prof_type) = '') then null else trim(prof_type) end), '@N') as prof_type
	,ifnull((case when (trim(del_way) = '') then null else trim(del_way) end), '@N') as del_way
	,ifnull((case when (trim(del_period) = '') then null else trim(del_period) end), '@N') as del_period
	,ifnull((case when (trim(`limit`) = '') then null else trim(`limit`) end), '@N') as `limit`
	,ifnull((case when (trim(subject) = '') then null else trim(subject) end), '@N') as subject
	,ifnull((case when (trim(tsf_flag) = '') then null else trim(tsf_flag) end), '@N') as tsf_flag
	,ifnull((case when (trim(acc_name) = '') then null else trim(acc_name) end), '@N') as acc_name
	,ifnull((case when (trim(acc_no) = '') then null else trim(acc_no) end), '@N') as acc_no
	,ifnull((case when (trim(acc_bank) = '') then null else trim(acc_bank) end), '@N') as acc_bank
	,ifnull((case when (trim(receipt_no) = '') then null else trim(receipt_no) end), '@N') as receipt_no
  	,'99991231000000' as pt
from rpt_fxq_tb_ins_rpol_ms partition(pt{workday}000000);

-- rpt_fxq_tb_ins_gpol_ms
insert into rpt_fxq_tb_ins_gpol_ms(
  company_code1
  ,company_code2
  ,company_code3
  ,pol_no
  ,app_no
  ,ins_state
  ,app_type
  ,sale_type
  ,sale_name
  ,ins_date
  ,eff_date
  ,app_name
  ,app_cst_no
  ,app_id_type
  ,app_id_no
  ,state_owned
  ,ins_num
  ,ins_no
  ,cur_code
  ,pre_amt
  ,usd_amt
  ,del_way
  ,del_period
  ,`limit`
  ,subject
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
	,ifnull((case when (trim(pol_no) = '') then null else trim(pol_no) end), '@N') as pol_no
	,ifnull((case when (trim(app_no) = '') then null else trim(app_no) end), '@N') as app_no
	,ifnull((case when (trim(ins_state) = '') then null else trim(ins_state) end), '@N') as ins_state
	,ifnull((case when (trim(app_type) = '') then null else trim(app_type) end), '@N') as app_type
	,ifnull((case when (trim(sale_type) = '') then null else trim(sale_type) end), '@N') as sale_type
	,ifnull((case when (trim(sale_name) = '') then null else trim(sale_name) end), '@N') as sale_name
	,ifnull((case when (trim(ins_date) = '') then null else trim(ins_date) end), '@N') as ins_date
	,ifnull((case when (trim(eff_date) = '') then null else trim(eff_date) end), '@N') as eff_date
	,ifnull((case when (trim(app_name) = '') then null else trim(app_name) end), '@N') as app_name
	,ifnull((case when (trim(app_cst_no) = '') then null else trim(app_cst_no) end), '@N') as app_cst_no
	,ifnull((case when (trim(app_id_type) = '') then null else trim(app_id_type) end), '@N') as app_id_type
	,ifnull((case when (trim(app_id_no) = '') then null else trim(app_id_no) end), '@N') as app_id_no
	,ifnull((case when (trim(state_owned) = '') then null else trim(state_owned) end), '@N') as state_owned
	,ifnull((case when (trim(ins_num) = '') then null else trim(ins_num) end), '@N') as ins_num
	,ifnull((case when (trim(ins_no) = '') then null else trim(ins_no) end), '@N') as ins_no
	,ifnull((case when (trim(cur_code) = '') then null else trim(cur_code) end), '@N') as cur_code
	,ifnull(pre_amt, -9999) as pre_amt
	,ifnull(usd_amt, -9999) as usd_amt
	,ifnull((case when (trim(del_way) = '') then null else trim(del_way) end), '@N') as del_way
	,ifnull((case when (trim(del_period) = '') then null else trim(del_period) end), '@N') as del_period
	,ifnull((case when (trim(`limit`) = '') then null else trim(`limit`) end), '@N') as `limit`
	,ifnull((case when (trim(subject) = '') then null else trim(subject) end), '@N') as subject
	,ifnull((case when (trim(tsf_flag) = '') then null else trim(tsf_flag) end), '@N') as tsf_flag
	,ifnull((case when (trim(acc_name) = '') then null else trim(acc_name) end), '@N') as acc_name
	,ifnull((case when (trim(acc_no) = '') then null else trim(acc_no) end), '@N') as acc_no
	,ifnull((case when (trim(acc_bank) = '') then null else trim(acc_bank) end), '@N') as acc_bank
	,ifnull((case when (trim(receipt_no) = '') then null else trim(receipt_no) end), '@N') as receipt_no
  	,'99991231000000' as pt
from rpt_fxq_tb_ins_gpol_ms partition(pt{workday}000000);

-- rpt_fxq_tb_ins_fav_cst_ms
insert into rpt_fxq_tb_ins_fav_cst_ms(
  company_code1
  ,company_code2
  ,company_code3
  ,pol_no
  ,ins_date
  ,app_name
  ,app_cst_no
  ,app_id_no
  ,insfav_type
  ,insbene_cus_pro
  ,relation
  ,fav_type
  ,name
  ,insbene_cst_no
  ,insbene_id_no
  ,pt
)
select
  	ifnull((case when (trim(company_code1) = '') then null else trim(company_code1) end), '@N') as company_code1
	,ifnull((case when (trim(company_code2) = '') then null else trim(company_code2) end), '@N') as company_code2
	,ifnull((case when (trim(company_code3) = '') then null else trim(company_code3) end), '@N') as company_code3
	,ifnull((case when (trim(pol_no) = '') then null else trim(pol_no) end), '@N') as pol_no
	,ifnull((case when (trim(ins_date) = '') then null else trim(ins_date) end), '@N') as ins_date
	,ifnull((case when (trim(app_name) = '') then null else trim(app_name) end), '@N') as app_name
	,ifnull((case when (trim(app_cst_no) = '') then null else trim(app_cst_no) end), '@N') as app_cst_no
	,ifnull((case when (trim(app_id_no) = '') then null else trim(app_id_no) end), '@N') as app_id_no
	,ifnull((case when (trim(insfav_type) = '') then null else trim(insfav_type) end), '@N') as insfav_type
	,ifnull((case when (trim(insbene_cus_pro) = '') then null else trim(insbene_cus_pro) end), '@N') as insbene_cus_pro
	,ifnull((case when (trim(relation) = '') then null else trim(relation) end), '@N') as relation
	,ifnull((case when (trim(fav_type) = '') then null else trim(fav_type) end), '@N') as fav_type
	,ifnull((case when (trim(name) = '') then null else trim(name) end), '@N') as name
	,ifnull((case when (trim(insbene_cst_no) = '') then null else trim(insbene_cst_no) end), '@N') as insbene_cst_no
	,ifnull((case when (trim(insbene_id_no) = '') then null else trim(insbene_id_no) end), '@N') as insbene_id_no
  	,'99991231000000' as pt
from rpt_fxq_tb_ins_fav_cst_ms partition(pt{workday}000000);

-- rpt_fxq_tb_ins_renewal_ms
insert into rpt_fxq_tb_ins_renewal_ms(
  company_code1
  ,company_code2
  ,company_code3
  ,company_code4
  ,pol_no
  ,app_no
  ,ins_date
  ,app_name
  ,app_cst_no
  ,app_id_type
  ,app_id_no
  ,ins_no
  ,renew_date
  ,pay_date
  ,cur_code
  ,pre_amt
  ,usd_amt
  ,tsf_flag
  ,acc_name
  ,acc_no
  ,acc_bank
  ,receipt_no
  ,endorse_no
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
	,ifnull((case when (trim(app_name) = '') then null else trim(app_name) end), '@N') as app_name
	,ifnull((case when (trim(app_cst_no) = '') then null else trim(app_cst_no) end), '@N') as app_cst_no
	,ifnull((case when (trim(app_id_type) = '') then null else trim(app_id_type) end), '@N') as app_id_type
	,ifnull((case when (trim(app_id_no) = '') then null else trim(app_id_no) end), '@N') as app_id_no
	,ifnull((case when (trim(ins_no) = '') then null else trim(ins_no) end), '@N') as ins_no
	,ifnull((case when (trim(renew_date) = '') then null else trim(renew_date) end), '@N') as renew_date
	,ifnull((case when (trim(pay_date) = '') then null else trim(pay_date) end), '@N') as pay_date
	,ifnull((case when (trim(cur_code) = '') then null else trim(cur_code) end), '@N') as cur_code
	,ifnull(pre_amt, -9999) as pre_amt
	,ifnull(usd_amt, -9999) as usd_amt
	,ifnull((case when (trim(tsf_flag) = '') then null else trim(tsf_flag) end), '@N') as tsf_flag
	,ifnull((case when (trim(acc_name) = '') then null else trim(acc_name) end), '@N') as acc_name
	,ifnull((case when (trim(acc_no) = '') then null else trim(acc_no) end), '@N') as acc_no
	,ifnull((case when (trim(acc_bank) = '') then null else trim(acc_bank) end), '@N') as acc_bank
	,ifnull((case when (trim(receipt_no) = '') then null else trim(receipt_no) end), '@N') as receipt_no
	,ifnull((case when (trim(endorse_no) = '') then null else trim(endorse_no) end), '@N') as endorse_no
	,'99991231000000' as pt
from rpt_fxq_tb_ins_renewal_ms partition(pt{workday}000000);

-- rpt_fxq_tb_ins_rsur_ms
insert into rpt_fxq_tb_ins_rsur_ms(
  company_code1
  ,company_code2
  ,company_code3
  ,company_code4
  ,pay_type
  ,pol_no
  ,app_no
  ,ins_date
  ,eff_date
  ,cur_code
  ,pre_amt_all
  ,usd_amt_all
  ,pay_amt_all
  ,usd_pay_amt_all
  ,app_name
  ,app_cst_no
  ,id_no
  ,cus_pro
  ,sur_name
  ,sur_id_no
  ,sur_date
  ,pay_date
  ,cur_code2
  ,sur_amt
  ,usd_sur_amt
  ,tsf_flag
  ,acc_name
  ,acc_no
  ,acc_bank
  ,receipt_no
  ,endorse_no
  ,pt
)
select
	ifnull((case when (trim(company_code1) = '') then null else trim(company_code1) end), '@N') as company_code1
	,ifnull((case when (trim(company_code2) = '') then null else trim(company_code2) end), '@N') as company_code2
	,ifnull((case when (trim(company_code3) = '') then null else trim(company_code3) end), '@N') as company_code3
	,ifnull((case when (trim(company_code4) = '') then null else trim(company_code4) end), '@N') as company_code4
	,ifnull((case when (trim(pay_type) = '') then null else trim(pay_type) end), '@N') as pay_type
	,ifnull((case when (trim(pol_no) = '') then null else trim(pol_no) end), '@N') as pol_no
	,ifnull((case when (trim(app_no) = '') then null else trim(app_no) end), '@N') as app_no
	,ifnull((case when (trim(ins_date) = '') then null else trim(ins_date) end), '@N') as ins_date
	,ifnull((case when (trim(eff_date) = '') then null else trim(eff_date) end), '@N') as eff_date
	,ifnull((case when (trim(cur_code) = '') then null else trim(cur_code) end), '@N') as cur_code
	,ifnull(pre_amt_all, -9999) as pre_amt_all
	,ifnull(usd_amt_all, -9999) as usd_amt_all
	,ifnull(pay_amt_all, -9999) as pay_amt_all
	,ifnull(usd_pay_amt_all, -9999) as usd_pay_amt_all
	,ifnull((case when (trim(app_name) = '') then null else trim(app_name) end), '@N') as app_name
	,ifnull((case when (trim(app_cst_no) = '') then null else trim(app_cst_no) end), '@N') as app_cst_no
	,ifnull((case when (trim(id_no) = '') then null else trim(id_no) end), '@N') as id_no
	,ifnull((case when (trim(cus_pro) = '') then null else trim(cus_pro) end), '@N') as cus_pro
	,ifnull((case when (trim(sur_name) = '') then null else trim(sur_name) end), '@N') as sur_name
	,ifnull((case when (trim(sur_id_no) = '') then null else trim(sur_id_no) end), '@N') as sur_id_no
	,ifnull((case when (trim(sur_date) = '') then null else trim(sur_date) end), '@N') as sur_date
	,ifnull((case when (trim(pay_date) = '') then null else trim(pay_date) end), '@N') as pay_date
	,ifnull((case when (trim(cur_code2) = '') then null else trim(cur_code2) end), '@N') as cur_code2
	,ifnull(sur_amt, -9999) as sur_amt
	,ifnull(usd_sur_amt, -9999) as usd_sur_amt
	,ifnull((case when (trim(tsf_flag) = '') then null else trim(tsf_flag) end), '@N') as tsf_flag
	,ifnull((case when (trim(acc_name) = '') then null else trim(acc_name) end), '@N') as acc_name
	,ifnull((case when (trim(acc_no) = '') then null else trim(acc_no) end), '@N') as acc_no
	,ifnull((case when (trim(acc_bank) = '') then null else trim(acc_bank) end), '@N') as acc_bank
	,ifnull((case when (trim(receipt_no) = '') then null else trim(receipt_no) end), '@N') as receipt_no
	,ifnull((case when (trim(endorse_no) = '') then null else trim(endorse_no) end), '@N') as endorse_no
	,'99991231000000' as pt
from rpt_fxq_tb_ins_rsur_ms partition(pt{workday}000000);

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
	,'99991231000000' as pt
from rpt_fxq_tb_ins_rpay_ms partition(pt{workday}000000);

-- rpt_fxq_tb_ins_rcla_ms
insert into rpt_fxq_tb_ins_rcla_ms(
  company_code1
  ,company_code2
  ,company_code3
  ,company_code4
  ,pol_no
  ,app_no
  ,ins_date
  ,eff_date
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
  ,benefit_type
  ,relation_1
  ,relation_2
  ,cla_app_name
  ,cla_id_type
  ,cla_id_no
  ,cla_pro
  ,cla_date
  ,pay_date
  ,cur_code
  ,cla_amt
  ,cla_usd_amt
  ,cla_no
  ,tsf_flag
  ,acc_name
  ,acc_no
  ,acc_bank
  ,acc_type
  ,acc_id_type
  ,acc_id_no
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
	,ifnull((case when (trim(benefit_type) = '') then null else trim(benefit_type) end), '@N') as benefit_type
	,ifnull((case when (trim(relation_1) = '') then null else trim(relation_1) end), '@N') as relation_1
	,ifnull((case when (trim(relation_2) = '') then null else trim(relation_2) end), '@N') as relation_2
	,ifnull((case when (trim(cla_app_name) = '') then null else trim(cla_app_name) end), '@N') as cla_app_name
	,ifnull((case when (trim(cla_id_type) = '') then null else trim(cla_id_type) end), '@N') as cla_id_type
	,ifnull((case when (trim(cla_id_no) = '') then null else trim(cla_id_no) end), '@N') as cla_id_no
	,ifnull((case when (trim(cla_pro) = '') then null else trim(cla_pro) end), '@N') as cla_pro
	,ifnull((case when (trim(cla_date) = '') then null else trim(cla_date) end), '@N') as cla_date
	,ifnull((case when (trim(pay_date) = '') then null else trim(pay_date) end), '@N') as pay_date
	,ifnull((case when (trim(cur_code) = '') then null else trim(cur_code) end), '@N') as cur_code
	,ifnull(cla_amt, -9999) as cla_amt
	,ifnull(cla_usd_amt, -9999) as cla_usd_amt
	,ifnull((case when (trim(cla_no) = '') then null else trim(cla_no) end), '@N') as cla_no
	,ifnull((case when (trim(tsf_flag) = '') then null else trim(tsf_flag) end), '@N') as tsf_flag
	,ifnull((case when (trim(acc_name) = '') then null else trim(acc_name) end), '@N') as acc_name
	,ifnull((case when (trim(acc_no) = '') then null else trim(acc_no) end), '@N') as acc_no
	,ifnull((case when (trim(acc_bank) = '') then null else trim(acc_bank) end), '@N') as acc_bank
	,ifnull((case when (trim(acc_type) = '') then null else trim(acc_type) end), '@N') as acc_type
	,ifnull((case when (trim(acc_id_type) = '') then null else trim(acc_id_type) end), '@N') as acc_id_type
	,ifnull((case when (trim(acc_id_no) = '') then null else trim(acc_id_no) end), '@N') as acc_id_no
	,ifnull((case when (trim(receipt_no) = '') then null else trim(receipt_no) end), '@N') as receipt_no
	,'99991231000000' as pt
from rpt_fxq_tb_ins_rcla_ms partition(pt{workday}000000);


-- rpt_fxq_tb_ins_rchg_ms
insert into rpt_fxq_tb_ins_rchg_ms(
  company_code1
  ,company_code2
  ,company_code3
  ,company_code4
  ,pol_no
  ,app_no
  ,app_name
  ,app_cst_no
  ,app_date
  ,chg_date
  ,chg_no
  ,item
  ,con_bef
  ,pt
)
select
	ifnull((case when (trim(company_code1) = '') then null else trim(company_code1) end), '@N') as company_code1
	,ifnull((case when (trim(company_code2) = '') then null else trim(company_code2) end), '@N') as company_code2
	,ifnull((case when (trim(company_code3) = '') then null else trim(company_code3) end), '@N') as company_code3
	,ifnull((case when (trim(company_code4) = '') then null else trim(company_code4) end), '@N') as company_code4
	,ifnull((case when (trim(pol_no) = '') then null else trim(pol_no) end), '@N') as pol_no
	,ifnull((case when (trim(app_no) = '') then null else trim(app_no) end), '@N') as app_no
	,ifnull((case when (trim(app_name) = '') then null else trim(app_name) end), '@N') as app_name
	,ifnull((case when (trim(app_cst_no) = '') then null else trim(app_cst_no) end), '@N') as app_cst_no
	,ifnull((case when (trim(app_date) = '') then null else trim(app_date) end), '@N') as app_date
	,ifnull((case when (trim(chg_date) = '') then null else trim(chg_date) end), '@N') as chg_date
	,ifnull((case when (trim(chg_no) = '') then null else trim(chg_no) end), '@N') as chg_no
	,ifnull((case when (trim(item) = '') then null else trim(item) end), '@N') as item
	,ifnull((case when (trim(con_bef) = '') then null else trim(con_bef) end), '@N') as con_bef
	,'99991231000000' as pt
from rpt_fxq_tb_ins_rchg_ms partition(pt{workday}000000);

-- rpt_fxq_tb_ins_risk_new_ms
insert into rpt_fxq_tb_ins_risk_new_ms(
  company_code1
  ,company_code2
  ,company_code3
  ,app_name
  ,app_cst_no
  ,app_id_no
  ,risk_code
  ,div_date
  ,score
  ,norm
  ,pt
)
select
	ifnull((case when (trim(company_code1) = '') then null else trim(company_code1) end), '@N') as company_code1
	,ifnull((case when (trim(company_code2) = '') then null else trim(company_code2) end), '@N') as company_code2
	,ifnull((case when (trim(company_code3) = '') then null else trim(company_code3) end), '@N') as company_code3
	,ifnull((case when (trim(app_name) = '') then null else trim(app_name) end), '@N') as app_name
	,ifnull((case when (trim(app_cst_no) = '') then null else trim(app_cst_no) end), '@N') as app_cst_no
	,ifnull((case when (trim(app_id_no) = '') then null else trim(app_id_no) end), '@N') as app_id_no
	,ifnull((case when (trim(risk_code) = '') then null else trim(risk_code) end), '@N') as risk_code
	,ifnull((case when (trim(div_date) = '') then null else trim(div_date) end), '@N') as div_date
	,ifnull(score, -9999) as score
	,ifnull((case when (trim(norm) = '') then null else trim(norm) end), '@N') as norm
	,'99991231000000' as pt
from rpt_fxq_tb_ins_risk_new_ms partition(pt{workday}000000);

-- rpt_fxq_tb_ins_risk_ms
insert into rpt_fxq_tb_ins_risk_ms(
  company_code1
  ,company_code2
  ,company_code3
  ,app_name
  ,app_cst_no
  ,app_id_no
  ,risk_code
  ,div_date
  ,first_type
  ,score
  ,norm
  ,pt
)
select
	ifnull((case when (trim(company_code1) = '') then null else trim(company_code1) end), '@N') as company_code1
	,ifnull((case when (trim(company_code2) = '') then null else trim(company_code2) end), '@N') as company_code2
	,ifnull((case when (trim(company_code3) = '') then null else trim(company_code3) end), '@N') as company_code3
	,ifnull((case when (trim(app_name) = '') then null else trim(app_name) end), '@N') as app_name
	,ifnull((case when (trim(app_cst_no) = '') then null else trim(app_cst_no) end), '@N') as app_cst_no
	,ifnull((case when (trim(app_id_no) = '') then null else trim(app_id_no) end), '@N') as app_id_no
	,ifnull((case when (trim(risk_code) = '') then null else trim(risk_code) end), '@N') as risk_code
	,ifnull((case when (trim(div_date) = '') then null else trim(div_date) end), '@N') as div_date
	,ifnull((case when (trim(first_type) = '') then null else trim(first_type) end), '@N') as first_type
	,ifnull(score, -9999) as score
	,ifnull((case when (trim(norm) = '') then null else trim(norm) end), '@N') as norm
	,'99991231000000' as pt
from rpt_fxq_tb_ins_risk_ms partition(pt{workday}000000);

-- rpt_fxq_tb_lar_report_ms
insert into rpt_fxq_tb_lar_report_ms(
  ricd
  ,finc
  ,sbdt
  ,cttn
  ,code
  ,rlfc
  ,ctnm
  ,citp
  ,oitp
  ,ctid
  ,csnm
  ,catp
  ,ctac
  ,cbct
  ,ocbt
  ,cbcn
  ,ctvc
  ,cctl
  ,ccei
  ,ctar
  ,ctnt
  ,oatm
  ,crcd
  ,tbnm
  ,tbit
  ,tbid
  ,tbnt
  ,tstm
  ,trcd
  ,ticd
  ,rpmt
  ,rpmn
  ,tstp
  ,tsct
  ,tsdr
  ,crpp
  ,crtp
  ,crat
  ,crmb
  ,cusd
  ,ttnm
  ,cfin
  ,cfct
  ,cfic
  ,cfrc
  ,tcnm
  ,tcit
  ,tcid
  ,tcat
  ,tcac
  ,octt
  ,ooct
  ,ocec
  ,rotf
  ,pt
)
select
	ifnull((case when (trim(ricd) = '') then null else trim(ricd) end), '@N') as ricd
	,ifnull((case when (trim(finc) = '') then null else trim(finc) end), '@N') as finc
	,ifnull((case when (trim(sbdt) = '') then null else trim(sbdt) end), '@N') as sbdt
	,ifnull(cttn, -9999) as cttn
	,ifnull((case when (trim(code) = '') then null else trim(code) end), '@N') as code
	,ifnull((case when (trim(rlfc) = '') then null else trim(rlfc) end), '@N') as rlfc
	,ifnull((case when (trim(ctnm) = '') then null else trim(ctnm) end), '@N') as ctnm
	,ifnull((case when (trim(citp) = '') then null else trim(citp) end), '@N') as citp
	,ifnull((case when (trim(oitp) = '') then null else trim(oitp) end), '@N') as oitp
	,ifnull((case when (trim(ctid) = '') then null else trim(ctid) end), '@N') as ctid
	,ifnull((case when (trim(csnm) = '') then null else trim(csnm) end), '@N') as csnm
	,ifnull((case when (trim(catp) = '') then null else trim(catp) end), '@N') as catp
	,ifnull((case when (trim(ctac) = '') then null else trim(ctac) end), '@N') as ctac
	,ifnull((case when (trim(cbct) = '') then null else trim(cbct) end), '@N') as cbct
	,ifnull((case when (trim(ocbt) = '') then null else trim(ocbt) end), '@N') as ocbt
	,ifnull((case when (trim(cbcn) = '') then null else trim(cbcn) end), '@N') as cbcn
	,ifnull((case when (trim(ctvc) = '') then null else trim(ctvc) end), '@N') as ctvc
	,ifnull((case when (trim(cctl) = '') then null else trim(cctl) end), '@N') as cctl
	,ifnull((case when (trim(ccei) = '') then null else trim(ccei) end), '@N') as ccei
	,ifnull((case when (trim(ctar) = '') then null else trim(ctar) end), '@N') as ctar
	,ifnull((case when (trim(ctnt) = '') then null else trim(ctnt) end), '@N') as ctnt
	,ifnull((case when (trim(oatm) = '') then null else trim(oatm) end), '@N') as oatm
	,ifnull((case when (trim(crcd) = '') then null else trim(crcd) end), '@N') as crcd
	,ifnull((case when (trim(tbnm) = '') then null else trim(tbnm) end), '@N') as tbnm
	,ifnull((case when (trim(tbit) = '') then null else trim(tbit) end), '@N') as tbit
	,ifnull((case when (trim(tbid) = '') then null else trim(tbid) end), '@N') as tbid
	,ifnull((case when (trim(tbnt) = '') then null else trim(tbnt) end), '@N') as tbnt
	,ifnull((case when (trim(tstm) = '') then null else trim(tstm) end), '@N') as tstm
	,ifnull((case when (trim(trcd) = '') then null else trim(trcd) end), '@N') as trcd
	,ifnull((case when (trim(ticd) = '') then null else trim(ticd) end), '@N') as ticd
	,ifnull((case when (trim(rpmt) = '') then null else trim(rpmt) end), '@N') as rpmt
	,ifnull((case when (trim(rpmn) = '') then null else trim(rpmn) end), '@N') as rpmn
	,ifnull((case when (trim(tstp) = '') then null else trim(tstp) end), '@N') as tstp
	,ifnull(tsct, -9999) as tsct
	,ifnull((case when (trim(tsdr) = '') then null else trim(tsdr) end), '@N') as tsdr
	,ifnull((case when (trim(crpp) = '') then null else trim(crpp) end), '@N') as crpp
	,ifnull((case when (trim(crtp) = '') then null else trim(crtp) end), '@N') as crtp
	,ifnull(crat, -9999) as crat
	,ifnull(crmb, -9999) as crmb
	,ifnull(cusd, -9999) as cusd
	,ifnull(ttnm, -9999) as ttnm
	,ifnull((case when (trim(cfin) = '') then null else trim(cfin) end), '@N') as cfin
	,ifnull((case when (trim(cfct) = '') then null else trim(cfct) end), '@N') as cfct
	,ifnull((case when (trim(cfic) = '') then null else trim(cfic) end), '@N') as cfic
	,ifnull((case when (trim(cfrc) = '') then null else trim(cfrc) end), '@N') as cfrc
	,ifnull((case when (trim(tcnm) = '') then null else trim(tcnm) end), '@N') as tcnm
	,ifnull((case when (trim(tcit) = '') then null else trim(tcit) end), '@N') as tcit
	,ifnull((case when (trim(tcid) = '') then null else trim(tcid) end), '@N') as tcid
	,ifnull((case when (trim(tcat) = '') then null else trim(tcat) end), '@N') as tcat
	,ifnull((case when (trim(tcac) = '') then null else trim(tcac) end), '@N') as tcac
	,ifnull((case when (trim(octt) = '') then null else trim(octt) end), '@N') as octt
	,ifnull((case when (trim(ooct) = '') then null else trim(ooct) end), '@N') as ooct
	,ifnull((case when (trim(ocec) = '') then null else trim(ocec) end), '@N') as ocec
	,ifnull((case when (trim(rotf) = '') then null else trim(rotf) end), '@N') as rotf	
	,'99991231000000' as pt
from rpt_fxq_tb_lar_report_ms partition(pt{workday}000000);

-- rpt_fxq_tb_sus_report_ms
insert into rpt_fxq_tb_sus_report_ms(
  ricd
  ,finc
  ,senm
  ,setp
  ,seid
  ,sevc
  ,srnm
  ,srit
  ,srid
  ,scnm
  ,scit
  ,scid
  ,stnt
  ,detr
  ,torp
  ,dorp
  ,tptr
  ,stcb
  ,aosp
  ,tosc
  ,stcr
  ,icnm
  ,istp
  ,isnm
  ,isps
  ,alnm
  ,aitp
  ,alid
  ,altp
  ,istn
  ,iitp
  ,isid
  ,rltp
  ,bnnm
  ,bitp
  ,bnid
  ,isog
  ,isat
  ,isfe
  ,ispt
  ,ctes
  ,tstm
  ,trcd
  ,ittp
  ,crtp
  ,crat
  ,crdr
  ,cstp
  ,caoi
  ,tcan
  ,rotf
  ,code
  ,itnm
  ,bntn
  ,mirs
  ,otpr
  ,stnm
  ,ocit
  ,odrp
  ,oitp
  ,orit
  ,orxn
  ,rpnm
  ,sctl
  ,rpdt
  ,sear
  ,seei
  ,setn
  ,pt
)
select
	ifnull((case when (trim(ricd) = '') then null else trim(ricd) end), '@N') as ricd
	,ifnull((case when (trim(finc) = '') then null else trim(finc) end), '@N') as finc
	,ifnull((case when (trim(senm) = '') then null else trim(senm) end), '@N') as senm
	,ifnull((case when (trim(setp) = '') then null else trim(setp) end), '@N') as setp
	,ifnull((case when (trim(seid) = '') then null else trim(seid) end), '@N') as seid
	,ifnull((case when (trim(sevc) = '') then null else trim(sevc) end), '@N') as sevc
	,ifnull((case when (trim(srnm) = '') then null else trim(srnm) end), '@N') as srnm
	,ifnull((case when (trim(srit) = '') then null else trim(srit) end), '@N') as srit
	,ifnull((case when (trim(srid) = '') then null else trim(srid) end), '@N') as srid
	,ifnull((case when (trim(scnm) = '') then null else trim(scnm) end), '@N') as scnm
	,ifnull((case when (trim(scit) = '') then null else trim(scit) end), '@N') as scit
	,ifnull((case when (trim(scid) = '') then null else trim(scid) end), '@N') as scid
	,ifnull((case when (trim(stnt) = '') then null else trim(stnt) end), '@N') as stnt
	,ifnull((case when (trim(detr) = '') then null else trim(detr) end), '@N') as detr
	,ifnull((case when (trim(torp) = '') then null else trim(torp) end), '@N') as torp
	,ifnull((case when (trim(dorp) = '') then null else trim(dorp) end), '@N') as dorp
	,ifnull((case when (trim(tptr) = '') then null else trim(tptr) end), '@N') as tptr
	,ifnull((case when (trim(stcb) = '') then null else trim(stcb) end), '@N') as stcb
	,ifnull((case when (trim(aosp) = '') then null else trim(aosp) end), '@N') as aosp
	,ifnull((case when (trim(tosc) = '') then null else trim(tosc) end), '@N') as tosc
	,ifnull((case when (trim(stcr) = '') then null else trim(stcr) end), '@N') as stcr
	,ifnull((case when (trim(icnm) = '') then null else trim(icnm) end), '@N') as icnm
	,ifnull((case when (trim(istp) = '') then null else trim(istp) end), '@N') as istp
	,ifnull((case when (trim(isnm) = '') then null else trim(isnm) end), '@N') as isnm
	,ifnull((case when (trim(isps) = '') then null else trim(isps) end), '@N') as isps
	,ifnull((case when (trim(alnm) = '') then null else trim(alnm) end), '@N') as alnm
	,ifnull((case when (trim(aitp) = '') then null else trim(aitp) end), '@N') as aitp
	,ifnull((case when (trim(alid) = '') then null else trim(alid) end), '@N') as alid
	,ifnull((case when (trim(altp) = '') then null else trim(altp) end), '@N') as altp
	,ifnull((case when (trim(istn) = '') then null else trim(istn) end), '@N') as istn
	,ifnull((case when (trim(iitp) = '') then null else trim(iitp) end), '@N') as iitp
	,ifnull((case when (trim(isid) = '') then null else trim(isid) end), '@N') as isid
	,ifnull((case when (trim(rltp) = '') then null else trim(rltp) end), '@N') as rltp
	,ifnull((case when (trim(bnnm) = '') then null else trim(bnnm) end), '@N') as bnnm
	,ifnull((case when (trim(bitp) = '') then null else trim(bitp) end), '@N') as bitp
	,ifnull((case when (trim(bnid) = '') then null else trim(bnid) end), '@N') as bnid
	,ifnull((case when (trim(isog) = '') then null else trim(isog) end), '@N') as isog
	,ifnull(isat, -9999) as isat
	,ifnull(isfe, -9999) as isfe
	,ifnull((case when (trim(ispt) = '') then null else trim(ispt) end), '@N') as ispt
	,ifnull((case when (trim(ctes) = '') then null else trim(ctes) end), '@N') as ctes
	,ifnull((case when (trim(tstm) = '') then null else trim(tstm) end), '@N') as tstm
	,ifnull((case when (trim(trcd) = '') then null else trim(trcd) end), '@N') as trcd
	,ifnull((case when (trim(ittp) = '') then null else trim(ittp) end), '@N') as ittp
	,ifnull((case when (trim(crtp) = '') then null else trim(crtp) end), '@N') as crtp
	,ifnull(crat, -9999) as crat
	,ifnull((case when (trim(crdr) = '') then null else trim(crdr) end), '@N') as crdr
	,ifnull((case when (trim(cstp) = '') then null else trim(cstp) end), '@N') as cstp
	,ifnull((case when (trim(caoi) = '') then null else trim(caoi) end), '@N') as caoi
	,ifnull((case when (trim(tcan) = '') then null else trim(tcan) end), '@N') as tcan
	,ifnull((case when (trim(rotf) = '') then null else trim(rotf) end), '@N') as rotf
	,ifnull((case when (trim(code) = '') then null else trim(code) end), '@N') as code
	,ifnull(itnm, -9999) as itnm
	,ifnull(bntn, -9999) as bntn
	,ifnull((case when (trim(mirs) = '') then null else trim(mirs) end), '@N') as mirs
	,ifnull((case when (trim(otpr) = '') then null else trim(otpr) end), '@N') as otpr
	,ifnull(stnm, -9999) as stnm
	,ifnull((case when (trim(ocit) = '') then null else trim(ocit) end), '@N') as ocit
	,ifnull((case when (trim(odrp) = '') then null else trim(odrp) end), '@N') as odrp
	,ifnull((case when (trim(oitp) = '') then null else trim(oitp) end), '@N') as oitp
	,ifnull((case when (trim(orit) = '') then null else trim(orit) end), '@N') as orit
	,ifnull((case when (trim(orxn) = '') then null else trim(orxn) end), '@N') as orxn
	,ifnull((case when (trim(rpnm) = '') then null else trim(rpnm) end), '@N') as rpnm
	,ifnull((case when (trim(sctl) = '') then null else trim(sctl) end), '@N') as sctl
	,ifnull((case when (trim(rpdt) = '') then null else trim(rpdt) end), '@N') as rpdt
	,ifnull((case when (trim(sear) = '') then null else trim(sear) end), '@N') as sear
	,ifnull((case when (trim(seei) = '') then null else trim(seei) end), '@N') as seei
	,ifnull(setn, -9999) as setn
	,'99991231000000' as pt
from rpt_fxq_tb_sus_report_ms partition(pt{workday}000000);