/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2017/10/29 14:17:31                          */
/*==============================================================*/

/* 根据外键调整了顺序 */
drop table if exists Operation_Api;

drop table if exists User_Role;

drop table if exists Page_Api;

drop table if exists Permission;

drop table if exists Operation;

drop table if exists Page;

drop table if exists Role;

drop table if exists Api;

drop table if exists User;

/*==============================================================*/
/* Table: Api                                                   */
/*==============================================================*/
create table Api
(
   Id                   char(36) not null,
   Name                 varchar(50) not null,
   Http_Method          varchar(50) not null,
   Url                  varchar(50) not null,
   Enterprise_Id        char(36) not null,
   primary key (Id)
);

/*==============================================================*/
/* Table: Operation                                             */
/*==============================================================*/
create table Operation
(
   Id                   char(36) not null,
   Code                 varchar(50) not null,
   Name                 varchar(50) not null,
   Page_Id              char(36) not null,
   Enterprise_Id        char(36) not null,
   primary key (Id)
);

/*==============================================================*/
/* Table: Operation_Api                                         */
/*==============================================================*/
create table Operation_Api
(
   Operation_Id         char(36) not null,
   Api_Id               char(36) not null,
   primary key (Operation_Id, Api_Id)
);

/*==============================================================*/
/* Table: Page                                                  */
/*==============================================================*/
create table Page
(
   Id                   char(36) not null,
   Name                 varchar(50) not null,
   Url                  varchar(50),
   Icon                 varchar(50),
   Weight               int not null,
   Level                int not null,
   parent_Id            char(36),
   Enterprise_Id        char(36) not null,
   primary key (Id)
);

/*==============================================================*/
/* Table: Page_Api                                              */
/*==============================================================*/
create table Page_Api
(
   Page_Id              char(36) not null,
   Api_Id               char(36) not null,
   primary key (Api_Id, Page_Id)
);

/*==============================================================*/
/* Table: Permission                                            */
/*==============================================================*/
create table Permission
(
   Role_Id              char(36) not null,
   Related_Id           char(36) not null,
   Type                 int not null comment '0: 页面;
            1: 业务操作;',
   primary key (Role_Id, Related_Id)
);

/*==============================================================*/
/* Table: Role                                                  */
/*==============================================================*/
create table Role
(
   Id                   char(36) not null,
   Name                 varchar(50) not null,
   Create_Time          datetime,
   Creator              varchar(50),
   Enterprise_Id        char(36) not null,
   Status               int comment '2:正常;
            0:作废;',
   RowVersion           timestamp not null,
   primary key (Id)
);

/*==============================================================*/
/* Table: User                                                  */
/*==============================================================*/
create table User
(
   Id                   char(36) not null,
   Name                 varchar(50) not null,
   Username             varchar(50) not null,
   Create_Time          datetime,
   Creator              varchar(50),
   Modify_Time          datetime,
   Enterprise_Id        char(36) not null,
   Status               int not null comment '2:正常;
            0:冻结/作废;',
   RowVersion           timestamp not null,
   primary key (Id)
);

/*==============================================================*/
/* Table: User_Role                                             */
/*==============================================================*/
create table User_Role
(
   User_Id              char(36) not null,
   Role_Id              char(36) not null,
   primary key (Role_Id, User_Id)
);

alter table Operation add constraint FK_Relationship_10 foreign key (Page_Id)
      references Page (Id) on delete restrict on update restrict;

alter table Operation_Api add constraint FK_Relationship_5 foreign key (Operation_Id)
      references Operation (Id) on delete restrict on update restrict;

alter table Operation_Api add constraint FK_Relationship_6 foreign key (Api_Id)
      references Api (Id) on delete restrict on update restrict;

alter table Page_Api add constraint FK_Relationship_7 foreign key (Api_Id)
      references Api (Id) on delete restrict on update restrict;

alter table Page_Api add constraint FK_Relationship_8 foreign key (Page_Id)
      references Page (Id) on delete restrict on update restrict;

alter table Permission add constraint FK_Relationship_3 foreign key (Role_Id)
      references Role (Id) on delete restrict on update restrict;

alter table User_Role add constraint FK_Relationship_1 foreign key (Role_Id)
      references Role (Id) on delete restrict on update restrict;

alter table User_Role add constraint FK_Relationship_2 foreign key (User_Id)
      references User (Id) on delete restrict on update restrict;


