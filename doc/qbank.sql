drop table if exists exercise;

/*==============================================================*/
/* Table: exercise                                             */
/*==============================================================*/
create table exercise
(
  id                   int not null auto_increment comment 'id',
  category             int comment '所属分类: 0-练习题；1-历年真题；2-同学分享题',
  type                 int comment '类型: 0-单选题，1-多选题，2-判断改错题，3-简答题，4-案例分析，5-论文',
  question             text comment '问题',
  option_a             varchar(300) comment '选项A',
  option_b             varchar(300) comment '选项B',
  option_c             varchar(300) comment '选项C',
  option_d             varchar(300) comment '选项D',
  option_e             varchar(300) comment '选项E',
  option_f             varchar(300) comment '选项F',
  option_g             varchar(300) comment '选项G',
  answer_single        varchar(500) comment '选择题答案',
  answer_short         varchar(500) comment '简答题答案',
  analysis             varchar(500) comment '答案解析',
  chapter              varchar(50) comment '所属课本章节',
  cert_level           int comment '所属证书等级：1-一级, 2-二级， 3-三级',
  attr1                varchar(200) comment '扩展字段1',
  attr2                varchar(200) comment '扩展字段2',
  attr3                varchar(200) comment '扩展字段3',
  attr4                varchar(200) comment '扩展字段4',
  create_time          timestamp comment '创建时间',
  primary key (id)
);

alter table exercise comment '习题库';

drop table if exists recharge_record;

/*==============================================================*/
/* Table: recharge_record                                       */
/*==============================================================*/
create table recharge_record
(
  id                   bigint not null,
  user_id              bigint,
  amount               double,
  channel              int,
  result_code          varchar(5),
  result_desc          varchar(100),
  time                 datetime,
  primary key (id)
);

alter table recharge_record comment '用户充值记录';

drop table if exists user;

/*==============================================================*/
/* Table: user                                                  */
/*==============================================================*/
CREATE TABLE user
(
  id                   int not null auto_increment comment 'id',
  user_type            int default 0 comment '用户类型：0-注册用户，1-qq用户，2-微信用户，3-新浪微博，4-facebook。。。。。',
  user_name            varchar(32) comment '用户名',
  nick_name            varchar(32) comment '昵称',
  email                varchar(50) comment '邮箱',
  qq                   varchar(20) comment 'qq',
  weixin               varchar(50) comment '微信',
  telephone            varchar(20) comment '手机号码',
  head_picture         varchar(250) comment '用户头像',
  user_profile         text comment '用户介绍',
  user_level           int default 0 comment '用户等级：0-普通用户，1-赞赏用户，2-会员用户',
  password             varchar(32) comment '登录密码',
  status               int default 0 comment '用户状态:0-新注册，1-正常，2-过期，3-冻结，4-禁用',
  balance              float default 0 comment '账户余额',
  appre_amount         float default 0 comment '赞赏金额',
  create_time          timestamp default CURRENT_TIMESTAMP comment '创建时间',
  primary key (id)
);

alter table user comment '题库用户';


/*==============================================================*/
/* Table: order                                                  */
/*==============================================================*/
CREATE TABLE order_list
(
  id                  int not null auto_increment comment 'id',
  username            varchar(32) DEFAULT NULL comment '用户名',
  id_card             varchar(32) comment '身份证号码',
  email               varchar(50) comment '邮箱',
  weixin              varchar(50) comment '微信',
  telephone           varchar(20) comment '手机号码',
  area_code           varchar(16) comment '预约区域编码',
  area_name           varchar(100) comment '预约区域名称',
  order_type          tinyint(2) comment '预约类型: 1-预约, 2-捡漏',
  residence_way       tinyint(2) default 0 comment '入户渠道: 1-, 2-, 3-, 4-, 5-',
  order_money         decimal(10,2) DEFAULT NULL comment '应付费用',
  paid_money          DECIMAL (10, 2) comment '已付费用',
  require_date        datetime comment '预约要求日期时间',
  status              int default 0 comment '状态:1-新提交，2-预约成功，3-预约失败，4-预约撤销，5-预约重试',
  create_time         datetime default CURRENT_TIMESTAMP comment '创建时间',
  modify_time         datetime default CURRENT_TIMESTAMP comment '修改时间',
  primary key (id)
);

alter table order_list comment '订单表';

