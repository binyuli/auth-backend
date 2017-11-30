/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2017/11/30 16:43:28                          */
/*==============================================================*/


drop table if exists api;

drop table if exists enterprise;

drop table if exists operation;

drop table if exists operation_api;

drop table if exists page;

drop table if exists page_api;

drop table if exists permission;

drop table if exists role;

drop table if exists user;

drop table if exists user_credential;

drop table if exists user_role;

/*==============================================================*/
/* Table: api                                                   */
/*==============================================================*/
create table api
(
   id                   char(36) not null,
   name                 varchar(50) not null,
   http_method          varchar(50) not null,
   url                  varchar(50) not null,
   enterprise_id        char(36) not null,
   primary key (id)
);

/*==============================================================*/
/* Table: enterprise                                            */
/*==============================================================*/
create table enterprise
(
   id                   char(36) not null,
   code                 varchar(50) not null,
   name                 varchar(50) not null,
   primary key (id)
);

/*==============================================================*/
/* Table: operation                                             */
/*==============================================================*/
create table operation
(
   id                   char(36) not null,
   code                 varchar(50) not null,
   name                 varchar(50) not null,
   page_id              char(36) not null,
   enterprise_id        char(36) not null,
   primary key (id)
);

/*==============================================================*/
/* Table: operation_api                                         */
/*==============================================================*/
create table operation_api
(
   operation_id         char(36) not null,
   api_id               char(36) not null,
   primary key (operation_id, api_id)
);

/*==============================================================*/
/* Table: page                                                  */
/*==============================================================*/
create table page
(
   id                   char(36) not null,
   code                 varchar(50) not null,
   name                 varchar(50) not null,
   pinyin               varchar(200),
   initial              varchar(50),
   url                  varchar(100),
   icon                 varchar(50),
   weight               int not null,
   level                int not null,
   parent_id            char(36),
   enterprise_id        char(36) not null,
   primary key (id)
);

/*==============================================================*/
/* Table: page_api                                              */
/*==============================================================*/
create table page_api
(
   page_id              char(36) not null,
   api_id               char(36) not null,
   primary key (api_id, page_id)
);

/*==============================================================*/
/* Table: permission                                            */
/*==============================================================*/
create table permission
(
   role_id              char(36) not null,
   related_id           char(36) not null,
   type                 int not null comment '0: 页面;
            1: 业务操作;',
   primary key (role_id, related_id)
);

/*==============================================================*/
/* Table: role                                                  */
/*==============================================================*/
create table role
(
   id                   char(36) not null,
   name                 varchar(50) not null,
   create_time          datetime,
   creator              varchar(50),
   enterprise_id        char(36) not null,
   status               int comment '2:正常;
            0:作废;',
   row_version          timestamp(6) not null,
   primary key (id)
);

/*==============================================================*/
/* Table: user                                                  */
/*==============================================================*/
create table user
(
   id                   char(36) not null,
   name                 varchar(50) not null,
   open_id              varchar(100),
   username             varchar(50) not null comment '用户名',
   create_time          datetime,
   creator              varchar(50),
   modify_time          datetime,
   enterprise_id        char(36) not null,
   status               int not null comment '2:正常;
            0:冻结/作废;',
   row_version          timestamp(6) not null,
   primary key (id)
);

/*==============================================================*/
/* Table: user_credential                                       */
/*==============================================================*/
create table user_credential
(
   user_id              char(36) not null,
   username             varchar(50) not null,
   password             varchar(50) not null,
   enterprise_id        char(36) not null,
   enterprise_code      varchar(50) not null,
   status               int not null,
   row_version          timestamp(6) not null,
   primary key (user_id)
);

/*==============================================================*/
/* Table: user_role                                             */
/*==============================================================*/
create table user_role
(
   user_id              char(36) not null,
   role_id              char(36) not null,
   primary key (role_id, user_id)
);

