/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2016/4/4 20:12:35                            */
/*==============================================================*/


drop table if exists GLOBAL_TABLE;

drop table if exists INDEX_PAGE;

drop table if exists MINGPINTHUI;

drop table if exists PING_LIFE;

drop table if exists RICH_TEXT;

drop table if exists SYS_USER;

/*==============================================================*/
/* Table: GLOBAL_TABLE                                          */
/*==============================================================*/
create table GLOBAL_TABLE
(
   GLOBAL_TABLE_CUID    int not null comment '全局表CUID',
   GLOBAL_TABLE_TABLE_NAME varchar(50) comment '全局表对应创建表名称',
   GLOBAL_TABLE_NOTES   varchar(50) comment '全局表创建注释',
   GLOBAL_TABLE_CREATE_TIME datetime comment '全局表创建时间',
   primary key (GLOBAL_TABLE_CUID)
);

alter table GLOBAL_TABLE comment '全局CUID表';

/*==============================================================*/
/* Table: INDEX_PAGE                                            */
/*==============================================================*/
create table INDEX_PAGE
(
   INDEX_PAGE_CUID      varchar(50) not null comment '主页表CUID',
   INDEX_PAGE_IMAGE_URL varchar(200) comment '主页表图片URL',
   INDEX_PAGE_IMAGE_NOTES varchar(200) comment '主页表图片提示',
   INDEX_PAGE_SUB_CONTENT varchar(200) comment '主页表图片后续文字',
   INDEX_PAGE_TO_URL    varchar(100) comment '主页表跳转链接(待用)',
   INDEX_PAGE_TITLE_NAME varchar(200) comment '主页表介绍标题',
   INDEX_PAGE_MAIN_CONTENT varchar(1024) comment '主页表介绍主要内容',
   INDEX_PAGE_TYPE      int not null comment '主页表对应内容类型(1:4张主图;2:公司介绍;3:介绍旁图片;4:最下面三张图片)',
   INDEX_PAGE_STATE     int comment '主页表状态',
   INDEX_PAGE_CREATE_TIME datetime not null comment '主页表创建时间',
   INDEX_PAGE_UPDATE_TIME datetime comment '主页表更新时间',
   primary key (INDEX_PAGE_CUID)
);

alter table INDEX_PAGE comment '主页表';

/*==============================================================*/
/* Table: MINGPINTHUI                                           */
/*==============================================================*/
create table MINGPINTHUI
(
   MINGPINTHUI_CUID     varchar(50) not null comment '名品汇CUID',
   MINGPINTHUI_NAME     varchar(100) comment '名品汇名称',
   MINGPINTHUI_TITLE    varchar(100) comment '名品汇标题',
   MINGPINTHUI_THUMB_URL varchar(200) comment '名品汇缩略图标',
   MINGPINTHUI_MAIN_CONTENT varchar(1024) comment '名品汇主要文字',
   MINGPINTHUI_MAIN_IMAGE_URL1 varchar(200) comment '名品汇主图1',
   MINGPINTHUI_MAIN_IMAGE_URL2 varchar(200) comment '名品汇主图2',
   MINGPINTHUI_MAIN_IMAGE_URL3 varchar(200) comment '名品汇主图3',
   MINGPINTHUI_MAIN_IMAGE_URL4 varchar(200) comment '名品汇主图4',
   MINGPINTHUI_MAIN_IMAGE_URL5 varchar(200) comment '名品汇主图5',
   MINGPINTHUI_STATE    int comment '名品汇状态',
   MINGPINTHUI_CREATE_TIME datetime not null comment '名品汇创建时间',
   MINGPINTHUI_UPDATE_TIME datetime comment '名品汇更新时间',
   primary key (MINGPINTHUI_CUID)
);

alter table MINGPINTHUI comment '名品汇';

/*==============================================================*/
/* Table: PING_LIFE                                             */
/*==============================================================*/
create table PING_LIFE
(
   PING_LIFE_CUID       varchar(50) not null comment '品生活CUID',
   PING_LIFE_MAIN_URL   varchar(200) comment '品生活主图URL',
   PING_LIFE_MAIN_NOTES varchar(200) comment '品生活主图提示',
   PING_LIFE_CATEGORY   varchar(100) comment '品生活类别名称',
   PING_LIFE_CATEGORY_CODE varchar(50) comment '品生活类别编码',
   PING_LIFE_TITLE_NAME varchar(100) comment '品生活小标题名称',
   PING_LIFE_TYPE       int not null comment '品生活类型',
   PING_LIFE_STATE      int comment '品生活状态',
   PING_LIFE_CREATE_TIME datetime not null comment '品生活创建时间',
   PING_LIFE_UPDATE_TIME datetime comment '品生活更新时间',
   primary key (PING_LIFE_CUID)
);

alter table PING_LIFE comment '品生活';

/*==============================================================*/
/* Table: RICH_TEXT                                             */
/*==============================================================*/
create table RICH_TEXT
(
   RICH_TEXT_CUID       varchar(50) not null comment '富文本内容CUID',
   PING_LIFE_CUID       varchar(50) comment '品生活CUID',
   RICH_TEXT_THUMB_URL  varchar(200) comment '富文本内容缩略图',
   RICH_TEXT_TITLE      varchar(100) comment '富文本内容标题',
   RICH_TEXT_CONTENT    text comment '富文本内容主要内容',
   RICH_TEXT_STATE      int comment '富文本内容状态',
   RICH_TEXT_CREATE_TIME datetime not null comment '富文本内容创建时间',
   RICH_TEXT_UPDATE_TIME datetime comment '富文本内容更新时间',
   primary key (RICH_TEXT_CUID)
);

alter table RICH_TEXT comment '富文本内容';

/*==============================================================*/
/* Table: SYS_USER                                              */
/*==============================================================*/
create table SYS_USER
(
   SYS_USER_CUID        varchar(50) not null comment '系统用户CUID',
   SYS_USER_LOGIN_NAME  varchar(100) comment '系统用户登录名',
   SYS_USER_REL_NAME    varchar(100) comment '系统用户真实姓名',
   SYS_USER_PASSWORD    varchar(100) comment '系统用户登录密码',
   SYS_USER_TELE        varchar(20) comment '系统用户电话',
   SYS_USER_ADDRESS     varchar(100) comment '系统用户地址',
   SYS_USER_STATE       int comment '系统用户状态',
   SYS_USER_CREATE_TIME datetime not null comment '系统用户创建时间',
   SYS_USER_UPDATE_TIME datetime comment '系统用户更新时间',
   primary key (SYS_USER_CUID)
);

alter table SYS_USER comment '系统用户';

alter table RICH_TEXT add constraint FK_Relationship_1 foreign key (PING_LIFE_CUID)
      references PING_LIFE (PING_LIFE_CUID) on delete restrict on update restrict;

