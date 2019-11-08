## 提取范围内有效保单
rpt_fxq_tb_ins_pers_ms
rpt_fxq_tb_ins_units_ms
	edw_cust_ply_party
		x_edw_cust_per_units_info
			inner join ods_cthx_web_ply_base c_app_no

select '	rpt_fxq_tb_ins_fav_cst_ms	', count(1) rc from 	rpt_fxq_tb_ins_fav_cst_ms	 union all
select '	rpt_fxq_tb_ins_gpol_ms	', count(1) rc from 	rpt_fxq_tb_ins_gpol_ms	 union all
select '	rpt_fxq_tb_ins_rtype_ms	', count(1) rc from 	rpt_fxq_tb_ins_rtype_ms	 union all
select '	rpt_fxq_tb_ins_renewal_ms	', count(1) rc from 	rpt_fxq_tb_ins_renewal_ms	 union all
select '	rpt_fxq_tb_ins_risk_ms	', count(1) rc from 	rpt_fxq_tb_ins_risk_ms	 union all
select '	rpt_fxq_tb_ins_risk_new_ms	', count(1) rc from 	rpt_fxq_tb_ins_risk_new_ms	 union all
select '	rpt_fxq_tb_ins_rpol_ms	', count(1) rc from 	rpt_fxq_tb_ins_rpol_ms	 union all
select '	rpt_fxq_tb_ins_rchg_ms	', count(1) rc from 	rpt_fxq_tb_ins_rchg_ms	 union all
select '	rpt_fxq_tb_lar_report_ms	', count(1) rc from 	rpt_fxq_tb_lar_report_ms	 union all
select '	rpt_fxq_tb_ins_rpay_ms	', count(1) rc from 	rpt_fxq_tb_ins_rpay_ms	 union all
select '	rpt_fxq_tb_ins_unit_ms	', count(1) rc from 	rpt_fxq_tb_ins_unit_ms	 union all
select '	rpt_fxq_tb_ins_rsur_ms	', count(1) rc from 	rpt_fxq_tb_ins_rsur_ms	 union all
select '	rpt_fxq_tb_ins_rcla_ms	', count(1) rc from 	rpt_fxq_tb_ins_rcla_ms	 union all
select '	rpt_fxq_tb_ins_pers_ms	', count(1) rc from 	rpt_fxq_tb_ins_pers_ms	 union all
select '	rpt_fxq_tb_company_ms	', count(1) rc from 	rpt_fxq_tb_company_ms	 union all
select '	rpt_fxq_tb_ins_bo_ms	', count(1) rc from 	rpt_fxq_tb_ins_bo_ms	 union all
select '	rpt_fxq_tb_sus_report_ms	', count(1) rc from 	rpt_fxq_tb_sus_report_ms
order by 1;

truncate table 	rpt_fxq_tb_ins_fav_cst_ms	;
truncate table 	rpt_fxq_tb_ins_gpol_ms	;
truncate table 	rpt_fxq_tb_ins_rtype_ms	;
truncate table 	rpt_fxq_tb_ins_renewal_ms	;
truncate table 	rpt_fxq_tb_ins_risk_ms	;
truncate table 	rpt_fxq_tb_ins_risk_new_ms	;
truncate table 	rpt_fxq_tb_ins_rpol_ms	;
truncate table 	rpt_fxq_tb_ins_rchg_ms	;
truncate table 	rpt_fxq_tb_lar_report_ms	;
truncate table 	rpt_fxq_tb_ins_rpay_ms	;
truncate table 	rpt_fxq_tb_ins_unit_ms	;
truncate table 	rpt_fxq_tb_ins_rsur_ms	;
truncate table 	rpt_fxq_tb_ins_rcla_ms	;
truncate table 	rpt_fxq_tb_ins_pers_ms	;
truncate table 	rpt_fxq_tb_company_ms	;
truncate table 	rpt_fxq_tb_ins_bo_ms	;
truncate table 	rpt_fxq_tb_sus_report_ms	;
