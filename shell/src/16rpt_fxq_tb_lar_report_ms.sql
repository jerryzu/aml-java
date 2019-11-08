-- *********************************************************************************
--  文件名称: 16rpt_fxq_tb_lar_report_ms.sql
--  所属主题: 中国人民银行反洗钱执法检查数据提取接口
--  功能描述:  
--   表提取数据
--            导入到 (rpt_fxq_tb_lar_report_ms) 表
--  创建者:祖新合 
--  输入: 
--  ods_amltp_t_lat_data
--  ods_amltp_t_lat_customer
--  ods_amltp_t_ih_tsdt
--  输出:
--    rpt_fxq_tb_lar_report_ms
--  创建日期: 2019/10/30
--  修改日志: 
--  修改日期: 
--  修改人: 
--  修改内容：
--  说明：
--   1.本表数据范围为检查期限内，检查对象的客户涉及的大额交易报告明细。  
--   2.本表数据基础内容为向中国反洗钱监测分析中心成功上报的大额交易报告明细，按照《金融机构大额交易和可疑交易报告管理办法》（中国人民银行令〔2016〕第3号发布）数据报送字典提供字段，即《中国反洗钱监测分析中心关于印发〈金融机构大额交易和可疑交易报告数据报送接口规范（V 1.0）〉的通知》（银反洗中心发〔2017〕19号）、《中国反洗钱监测分析中心关于进一步明确大额交易和可疑交易报告数据报送要求的通知》（银反洗中心发〔2018〕13号）。  
--   3.本表数据释义请参考《中国人民银行关于大额交易和可疑交易报告要素及释义的通知》（银发〔2017〕98 号）。 

alter table rpt_fxq_tb_lar_report_ms truncate partition pt{workday}000000;

--  未将空值处理为-9999或＠N,用来上报前整理数据的临时表
drop table if exists s_rpt_fxq_tb_lar_report_ms;

create temporary table s_rpt_fxq_tb_lar_report_ms select * from rpt_fxq_tb_lar_report_ms where 1 <> 1;

insert into s_rpt_fxq_tb_lar_report_ms(
    ricd,
    finc,
    sbdt,
    cttn,
    code,
    rlfc,
    ctnm,
    citp,
    oitp,
    ctid,
    csnm,
    catp,
    ctac,
    cbct,
    ocbt,
    cbcn,
    ctvc,
    cctl,
    ccei,
    ctar,
    ctnt,
    oatm,
    crcd,
    tbnm,
    tbit,
    tbid,
    tbnt,
    tstm,
    trcd,
    ticd,
    rpmt,
    rpmn,
    tstp,
    tsct,
    tsdr,
    crpp,
    crtp,
    crat,
    crmb,
    cusd,
    ttnm,
    cfin,
    cfct,
    cfic,
    cfrc,
    tcnm,
    tcit,
    tcid,
    tcat,
    tcac,
    octt,
    ooct,
    ocec,
    rotf,
    pt
)
select
    'f1008933000019'		ricd	  --  	报告机构编码
    ,'f1008933000019'		finc	  --  	金融机构代码
    ,c.trans_date		sbdt	  --  	大额交易提取时间
	/* 大额交易客户总数 unpass*/  -- 大额交易客户总数>=大额交易客户序号
    ,null		cttn	  --  	大额交易客户总数 -- '计数'
    ,null		code	  --  	案例编号 -- 每份大额交易报告的唯一编号
	/* 金融机构与客户的关系 unpass*/  -- 00: 客户通过在境内金融机构开立的账户或者银行卡所发生的交易, "金融机构"为开立账户的机构或发卡银行; 01: 客户通过境外银行卡所发生的交易, "金融机构"为收单行; 02: 客户不通过账户或者银行卡发生的交易, "金融机构"为办理业务的机构
    ,t.rltp		rlfc	  --  	金融机构与客户关系 --  00:客户通过在境内金融机构开立账户或银行卡发生的交易 "金融机构"为开立账户的机构或发卡银行; 01:客户通过境外银行卡所发生的交易 "金融机构"为收单行; 02:客户不通过账户或银行卡发生的交易,"金融机构"为办理业务机构
    ,c.real_name		ctnm	  --  	客户姓名名称
    ,c.certi_type		citp	  --  	客户身份证件证明文件类型
    ,c.certi_type		oitp	  --  	其他身份证件/证明文件类型
    ,c.certi_code		ctid	  --  	客户身份证件/证明文件号码
    ,c.customer_id		csnm	  --  	客户号
	/* 客户账户类型 unpass*/  -- 按照10.2节账户类型代码表填写
    ,t.catp		catp	  --  	客户账户类型
    ,t.ctac		ctac	  --  	客户账号
	/* 客户银行卡类型 unpass*/    -- 10: 借记卡; 20: 贷记卡; 30: 准贷记卡; 90: 其他 
    ,t.ctac		cbct	  --  	客户银行卡类型 --  10:借记卡;20:贷记卡;30:准贷记卡;90:其他;
	/* 客户银行卡其他类型 unpass*/    -- 如果字段"客户银行卡类型(CBCT)"选择为"90", 此项须填写具体的银行卡类型, 否则填写"@N"
    ,null		ocbt	  --  	客户银行卡其他类型 --  如果字段"客户银行卡类型"为90此项必填 否则为@N
    ,t.ctac		cbcn	  --  	客户银行卡号码
	/* 客户职业(对私) 或客户行业(对公) unpass*/    -- 1.客户职业按照GB/T6565-2015职业分类与代码填写, 可根据实际情况填写可疑主体职业的"大类"、"中类"或"小类"; 2.客户行业按照GB/T4754-2011国民经济行业分类与代码标准填写, 可根据实际情况填写可疑主体行业的"门类"、"大类"、"中类"或"小类"; 3.对于客户处于失业、无业或离退休等情况, 填写"99999"
    ,null		ctvc	  --  	客户职业(对私)或客户职业(对公) -- 若失业则填99999
	/* 客户联系电话 unpass*/    -- 1.电话号码应按照如下两种方式之一填写: 手机: 手机号码; 固定电话: 区号+"-"+固定电话; 2.如果报告机构掌握客户的多个联系电话, 则应设置多个"客户联系电话"字段, 每个字段填写一个联系电话
    ,null		cctl	  --  	客户联系电话
    ,null		ccei	  --  	客户其他联系方式
    ,null		ctar	  --  	客户住址/经营地址
    ,'CHN'		ctnt	  --  	国籍
    ,null		oatm	  --  	客户账户开立时间
    ,d.crcd		crcd	  --  	大额交易特征代码 -- 参考中国人民银行关于印发证券期货保险机构反洗钱执法检查数据提取接口规范的通知-银发【2019】63号'
    ,t.tbnm		tbnm	  --  	交易代办人姓名
	/* 交易代办人身份证件/证明文件类型 unpass*/    -- 按照10.1节身份证件/证明文件代码表填写。
    ,t.tbit		tbit	  --  	交易代办人身份证件/证明文件类型
	/* 交易代办人身份证件/证明文件号码 unpass*/    -- 居民身份证号长度应为15位或者18位。
    ,t.tbid		tbid	  --  	交易代办人身份证件/证明文件号码
	/* 交易代办人国籍 unpass*/    -- 按照GB/T2659-2000世界各国和地区名称代码标准填写。
    ,t.tbnt		tbnt	  --  	交易代办人国籍
    ,c.trans_date		tstm	  --  	交易时间  --  年年年年月月日日时时分分秒秒
    ,'CHN330104'		trcd	  --  	交易发生地
    ,t.ticd		ticd	  --  	业务标识号
	/* 收付款方匹配号类型 unpass*/    -- 按照10.5节收付款方匹配号类型代码表填写
    ,null		rpmt	  --  	收付款方匹配号类型
	/* 收付款方匹配号 unpass*/    -- 按照10.5节收付款方匹配号类型代码表的规定填写
    ,null		rpmn	  --  	收付款方匹配号
    ,'000020'		tstp	  --  	交易方式
	/* 涉外收支交易分类与代码 unpass*/    -- 按照GB/T19583-2014涉外收支交易分类与代码标准填写。
    ,if(t.tsct='@N',null,t.tsct)		tsct	  --  	涉外收支交易分类与代码
	/* 资金收付标志 unpass*/    -- 01: 收; 02: 付
    ,t.tsdr		tsdr	  --  	资金收付标志  --  01:收 02:付
    ,t.crpp		crpp	  --  	资金用途
	/* 交易币种 unpass*/    -- 按照GB/T12406-2008表示货币和资金的代码标准填写。
    ,t.crtp		crtp	  --  	交易币种
    ,t.crat		crat	  --  	交易金额与币种一致
    ,t.crat		crmb	  --  	交易金额折合人民币
    ,0		cusd	  --  	交易金额折合美元
    ,-9 ttnm-- ,d.	ttnm		ttnm	  --  	交易总数 根据客户分组计算该客户总交易的次数
    ,t.cfin		cfin	  --  	对方金融机构网点名称
	/* 对方金融机构网点代码类型 unpass*/    -- 11: 现代化支付系统行号; 12: 人民币结算账户管理系统行号; 13: 银行内部机构号; 14: 金融机构代码; 99: 其他
    ,t.cfct		cfct	  --  	对方金融机构网点类型  --  11:现代化支付系统行号;12:人民币结算系统行号;13银行内部机构号;14:金融机构代码;99:其他
    ,t.cfic		cfic	  --  	对方金融机构网点代码
	/* 对方金融机构网点行政区划代码 unpass*/    -- 1.当网点在中国大陆地区时, 前3位填写CHN或特殊经济区类型代码, 后6位按照大陆地区行政区划代码填写区、县级的代码; 2.当网点中国大陆地区以外的国家或地区时, 前3位填写国别代码, 后6位填写000000; 3.行政区划代码以国家统计局公布的最新县及县以上行政区划代码为准; 4.国别代码使用GB/T2659-2000世界各国和地区名称代码中的3位字符代码; 5.特殊经济区类型代码按照10.4节特殊经济区类型代码表填写
    ,null		cfrc	  --  	对方金融机构网点行政区域划分代码
    ,t.tcnm		tcnm	  --  	交易对手姓名/名称
	/* 交易对手身份证件/证明文件类型 unpass*/    -- 按照10.1节身份证件/证明文件代码表填写。
    ,t.tcit		tcit	  --  	交易对手身份证件/证明文件类型
	/* 交易对手身份证件/证明文件号码 unpass*/    -- 1.居民身份证号长度应为15位或者18位; 2.组织机构代码长度应为9位(如为10位则去掉最后一位校验码前的连接符"-")。
    ,t.tcid		tcid	  --  	交易对手身份证件/证明文件号码
	/* 交易对手账户类型 unpass*/    -- 按照10.2节账户类型代码表填写
    ,t.tcat		tcat	  --  	交易对手账户类型
    ,t.tcac		tcac	  --  	交易对手账号
    ,11		octt	  --  	非柜台交易方式  --  11:网上交易;12:通过POS机交易;13:通过电话交易;14:通过热键机交易;15:通过ATM机;16:通过传真交易;17:营业场所交易;99其他
    /* 其他非柜台交易方式 unpass*/    -- 如字段"非柜台交易方式(OCTT)"选择为"99", 本字段须填写非柜台交易方式的具体类型, 否则填写替代符"@N"
	,null		ooct	  --  	其他非柜台交易方式
	/* 非柜台交易方式的设备代码 unpass*/    -- 1.对于网上交易, 填写IP地址和MAC地址, 之间使用"@"分隔, 如果客户使用手机登录网络进行交易, 可填写手机号码和设备信息(IMEI、UDID等), 中间使用分割; 2.对于POS交易, 填写POS机编号; 3.对于电话交易, 填写电话号码; 4.对于热键机交易, 填写MAC地址; 5.对于ATM交易, 填写ATM编号; 6.对于传真交易, 填写传真号码; 7.对于营业场所交易, 填写营业场所网点代码地址(仅针对证券期货业); 8.对于其他未列出的非柜台交易方式, 填写其对应的设备代码
    ,null		ocec	  --  	非柜台交易方式的设备代码
	/* 交易信息备注 */  -- 暂填写"@N"
    ,null		rotf	  --  	交易信息备注
    ,'{workday}000000' pt	--	分区字段
from ods_amltp_t_lat_data  partition(pt{workday}000000)  d 
    inner join ods_amltp_t_lat_customer  partition(pt{workday}000000)  c on d.r_cust_id = c.r_cust_id
    inner join ods_amltp_t_ih_tsdt  partition(pt{workday}000000)  t on d.app_no = t.app_no;

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
	,'{workday}000000' as pt
from s_rpt_fxq_tb_lar_report_ms;