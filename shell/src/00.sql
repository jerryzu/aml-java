/*
alter table rpt_fxq_tb_company_ms add partition(partition report values less than(maxvalue));
alter table rpt_fxq_tb_ins_rtype_ms add partition(partition report values less than(maxvalue));
alter table rpt_fxq_tb_ins_pers_ms add partition(partition report values less than(maxvalue));
alter table rpt_fxq_tb_ins_unit_ms add partition(partition report values less than(maxvalue));
alter table rpt_fxq_tb_ins_bo_ms add partition(partition report values less than(maxvalue));
alter table rpt_fxq_tb_ins_rpol_ms add partition(partition report values less than(maxvalue));
alter table rpt_fxq_tb_ins_gpol_ms add partition(partition report values less than(maxvalue));
alter table rpt_fxq_tb_ins_fav_cst_ms add partition(partition report values less than(maxvalue));
alter table rpt_fxq_tb_ins_renewal_ms add partition(partition report values less than(maxvalue));
alter table rpt_fxq_tb_ins_rsur_ms add partition(partition report values less than(maxvalue));
alter table rpt_fxq_tb_ins_rpay_ms add partition(partition report values less than(maxvalue));
alter table rpt_fxq_tb_ins_rcla_ms add partition(partition report values less than(maxvalue));
alter table rpt_fxq_tb_ins_rchg_ms add partition(partition report values less than(maxvalue));
alter table rpt_fxq_tb_ins_risk_new_ms add partition(partition report values less than(maxvalue));
alter table rpt_fxq_tb_ins_risk_ms add partition(partition report values less than(maxvalue));
alter table rpt_fxq_tb_lar_report_ms add partition(partition report values less than(maxvalue));
alter table rpt_fxq_tb_sus_report_ms add partition(partition report values less than(maxvalue));
*/


alter table rpt_fxq_tb_company_ms reorganize partition report into(partition pt{workday}000000 values less than('{workday}999999'), partition report values less than(maxvalue));
alter table rpt_fxq_tb_ins_rtype_ms reorganize partition report into(partition pt{workday}000000 values less than('{workday}1000000'), partition report values less than(maxvalue));
alter table rpt_fxq_tb_ins_pers_ms reorganize partition report into(partition pt{workday}000000 values less than('{workday}1000001'), partition report values less than(maxvalue));
alter table rpt_fxq_tb_ins_unit_ms reorganize partition report into(partition pt{workday}000000 values less than('{workday}1000002'), partition report values less than(maxvalue));
alter table rpt_fxq_tb_ins_bo_ms reorganize partition report into(partition pt{workday}000000 values less than('{workday}1000003'), partition report values less than(maxvalue));
alter table rpt_fxq_tb_ins_rpol_ms reorganize partition report into(partition pt{workday}000000 values less than('{workday}1000004'), partition report values less than(maxvalue));
alter table rpt_fxq_tb_ins_gpol_ms reorganize partition report into(partition pt{workday}000000 values less than('{workday}1000005'), partition report values less than(maxvalue));
alter table rpt_fxq_tb_ins_fav_cst_ms reorganize partition report into(partition pt{workday}000000 values less than('{workday}1000006'), partition report values less than(maxvalue));
alter table rpt_fxq_tb_ins_renewal_ms reorganize partition report into(partition pt{workday}000000 values less than('{workday}1000007'), partition report values less than(maxvalue));
alter table rpt_fxq_tb_ins_rsur_ms reorganize partition report into(partition pt{workday}000000 values less than('{workday}1000008'), partition report values less than(maxvalue));
alter table rpt_fxq_tb_ins_rpay_ms reorganize partition report into(partition pt{workday}000000 values less than('{workday}1000009'), partition report values less than(maxvalue));
alter table rpt_fxq_tb_ins_rcla_ms reorganize partition report into(partition pt{workday}000000 values less than('{workday}1000010'), partition report values less than(maxvalue));
alter table rpt_fxq_tb_ins_rchg_ms reorganize partition report into(partition pt{workday}000000 values less than('{workday}1000011'), partition report values less than(maxvalue));
alter table rpt_fxq_tb_ins_risk_new_ms reorganize partition report into(partition pt{workday}000000 values less than('{workday}1000012'), partition report values less than(maxvalue));
alter table rpt_fxq_tb_ins_risk_ms reorganize partition report into(partition pt{workday}000000 values less than('{workday}1000013'), partition report values less than(maxvalue));
alter table rpt_fxq_tb_lar_report_ms reorganize partition report into(partition pt{workday}000000 values less than('{workday}1000014'), partition report values less than(maxvalue));
alter table rpt_fxq_tb_sus_report_ms reorganize partition report into(partition pt{workday}000000 values less than('{workday}1000015'), partition report values less than(maxvalue));