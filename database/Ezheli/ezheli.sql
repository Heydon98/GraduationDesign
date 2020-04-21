/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2020/4/21 15:51:41                           */
/*==============================================================*/


alter table check_result
   drop primary key;

drop table if exists check_result;

alter table tbl_award
   drop primary key;

drop table if exists tbl_award;

alter table tbl_award_big_type
   drop primary key;

drop table if exists tbl_award_big_type;

alter table tbl_award_small_type
   drop primary key;

drop table if exists tbl_award_small_type;

alter table tbl_award_state
   drop primary key;

drop table if exists tbl_award_state;

alter table tbl_class
   drop primary key;

drop table if exists tbl_class;

alter table tbl_college
   drop primary key;

drop table if exists tbl_college;

alter table tbl_major
   drop primary key;

drop table if exists tbl_major;

alter table tbl_stu_award
   drop primary key;

drop table if exists tbl_stu_award;

alter table tbl_stu_course
   drop primary key;

drop table if exists tbl_stu_course;

alter table tbl_student
   drop primary key;

drop table if exists tbl_student;

alter table tbl_teacher
   drop primary key;

drop table if exists tbl_teacher;

/*==============================================================*/
/* Table: check_result                                          */
/*==============================================================*/
create table check_result
(
   check_result_id      int not null,
   check_result_name    varchar(10) not null
);

alter table check_result
   add primary key (check_result_id);

/*==============================================================*/
/* Table: tbl_award                                             */
/*==============================================================*/
create table tbl_award
(
   award_id             int not null,
   award_big_type_id    int not null,
   award_small_type_id  int not null,
   college_id           int not null,
   award_total_name     varchar(100) not null,
   start_time           datetime not null,
   end_apply_time       datetime not null,
   end_time             datetime,
   introduce            varchar(200) not null,
   limit_number         int not null,
   teac_id              bigint not null,
   award_state_id       int
);

alter table tbl_award
   add primary key (award_id);

/*==============================================================*/
/* Table: tbl_award_big_type                                    */
/*==============================================================*/
create table tbl_award_big_type
(
   award_big_type_id    int not null,
   award_big_type_name  varchar(50) not null
);

alter table tbl_award_big_type
   add primary key (award_big_type_id);

/*==============================================================*/
/* Table: tbl_award_small_type                                  */
/*==============================================================*/
create table tbl_award_small_type
(
   award_big_type_id    int not null,
   award_small_type_id  int not null,
   award_small_type_name varchar(50) not null
);

alter table tbl_award_small_type
   add primary key (award_small_type_id);

/*==============================================================*/
/* Table: tbl_award_state                                       */
/*==============================================================*/
create table tbl_award_state
(
   award_state_id       int not null,
   award_state_name     varchar(20) not null
);

alter table tbl_award_state
   add primary key (award_state_id);

/*==============================================================*/
/* Table: tbl_class                                             */
/*==============================================================*/
create table tbl_class
(
   college_id           int not null,
   major_id             int not null,
   class_id             int not null,
   class_name           varchar(50) not null,
   class_year           int not null
);

alter table tbl_class
   add primary key (class_id);

/*==============================================================*/
/* Table: tbl_college                                           */
/*==============================================================*/
create table tbl_college
(
   college_id           int not null,
   college_name         varchar(50) not null
);

alter table tbl_college
   add primary key (college_id);

/*==============================================================*/
/* Table: tbl_major                                             */
/*==============================================================*/
create table tbl_major
(
   college_id           int not null,
   major_id             int not null,
   major_name           varchar(50) not null
);

alter table tbl_major
   add primary key (major_id);

/*==============================================================*/
/* Table: tbl_stu_award                                         */
/*==============================================================*/
create table tbl_stu_award
(
   stu_award_id         int not null,
   stu_id               bigint,
   award_id             int,
   reason               varchar(200),
   check_result_id      int,
   teac_id              bigint,
   apply_time           datetime,
   check_time           datetime
);

alter table tbl_stu_award
   add primary key (stu_award_id);

/*==============================================================*/
/* Table: tbl_stu_course                                        */
/*==============================================================*/
create table tbl_stu_course
(
   stu_id               bigint not null,
   course_id            int not null,
   course_year          char(9) not null,
   course_term          int not null,
   course_teacher       varchar(50) not null,
   course_location      varchar(100) not null,
   start_week           int not null,
   end_week             int not null,
   start_order          int not null,
   end_order            int not null,
   score                float,
   gpa                  float
);

alter table tbl_stu_course
   add primary key (stu_id, course_id, course_year, course_term);

/*==============================================================*/
/* Table: tbl_student                                           */
/*==============================================================*/
create table tbl_student
(
   stu_id               bigint not null,
   password             varchar(26) not null,
   name                 varchar(50),
   sex                  char(2),
   college_id           int,
   major_id             int,
   class_id             int
);

alter table tbl_student
   add primary key (stu_id);

/*==============================================================*/
/* Table: tbl_teacher                                           */
/*==============================================================*/
create table tbl_teacher
(
   teac_id              bigint not null,
   college_id           int,
   password             varchar(26) not null,
   name                 varchar(50),
   sex                  char(2)
);

alter table tbl_teacher
   add primary key (teac_id);

alter table tbl_award add constraint FK_Reference_11 foreign key (award_small_type_id)
      references tbl_award_small_type (award_small_type_id) on delete restrict on update restrict;

alter table tbl_award add constraint FK_Reference_15 foreign key (award_state_id)
      references tbl_award_state (award_state_id) on delete restrict on update restrict;

alter table tbl_award add constraint FK_Reference_9 foreign key (teac_id)
      references tbl_teacher (teac_id) on delete restrict on update restrict;

alter table tbl_award_small_type add constraint FK_Reference_10 foreign key (award_big_type_id)
      references tbl_award_big_type (award_big_type_id) on delete restrict on update restrict;

alter table tbl_class add constraint FK_Reference_2 foreign key (major_id)
      references tbl_major (major_id) on delete restrict on update restrict;

alter table tbl_major add constraint FK_Reference_1 foreign key (college_id)
      references tbl_college (college_id) on delete restrict on update restrict;

alter table tbl_stu_award add constraint FK_Reference_12 foreign key (stu_id)
      references tbl_student (stu_id) on delete restrict on update restrict;

alter table tbl_stu_award add constraint FK_Reference_13 foreign key (award_id)
      references tbl_award (award_id) on delete restrict on update restrict;

alter table tbl_stu_award add constraint FK_Reference_14 foreign key (teac_id)
      references tbl_teacher (teac_id) on delete restrict on update restrict;

alter table tbl_stu_award add constraint FK_Reference_17 foreign key (check_result_id)
      references check_result (check_result_id) on delete restrict on update restrict;

alter table tbl_stu_course add constraint FK_Reference_5 foreign key (stu_id)
      references tbl_student (stu_id) on delete restrict on update restrict;

alter table tbl_student add constraint FK_Reference_3 foreign key (class_id)
      references tbl_class (class_id) on delete restrict on update restrict;

alter table tbl_teacher add constraint FK_Reference_4 foreign key (college_id)
      references tbl_college (college_id) on delete restrict on update restrict;

