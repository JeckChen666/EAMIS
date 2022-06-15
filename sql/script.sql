create table TB_USER
(
    ID        CHAR(19)         not null,
    USERNAME  VARCHAR2(64)     not null,
    PASSWORD  VARCHAR2(64)     not null,
    PHONE     CHAR(11)         not null,
    SEX       NUMBER default 1,
    BIRTHDAY  DATE,
    JOB       VARCHAR2(255),
    ENTRYTIME DATE,
    STATE     NUMBER default 1 not null,
    constraint USER_PK
        primary key (ID)
);

comment on table TB_USER is '用户表';

create unique index USER_PHONE_UINDEX
    on TB_USER (PHONE);

create table TB_ATTENDANCE
(
    ID          CHAR(19) not null,
    USER_ID     CHAR(19),
    STATE       NUMBER default 1,
    CREATE_TIME DATE,
    constraint ATTENDANCE_PK
        primary key (ID),
    constraint ATTENDANCE_USER_ID_FK
        foreign key (USER_ID) references TB_USER
);

comment on table TB_ATTENDANCE is '出勤表';

create table "tb_workOvertime"
(
    ID          CHAR(19) not null,
    USER_ID     CHAR(19),
    REASON      VARCHAR2(255),
    START_TIME  DATE,
    END_TIME    DATE,
    STATE       NUMBER default 1,
    CREATE_TIME DATE,
    constraint TB_WORKOVERTIME_PK
        primary key (ID),
    constraint TB_WORKOVERTIME_TB_USER_ID_FK
        foreign key (USER_ID) references TB_USER
);

comment on table "tb_workOvertime" is '加班表';

create table TB_VACATE
(
    ID          CHAR(19) not null,
    USER_ID     CHAR(19),
    REASON      CLOB,
    START_TIME  DATE,
    END_TIME    DATE,
    STATE       NUMBER default 1,
    CREATE_TIME DATE,
    constraint TB_VACATE_PK
        primary key (ID),
    constraint TB_VACATE_TB_USER_ID_FK
        foreign key (USER_ID) references TB_USER
);

comment on table TB_VACATE is '请销假表';

create table "tb_businessTrip"
(
    ID          CHAR(19) not null,
    REASON      CLOB,
    LOCATION    VARCHAR2(255),
    COST        NUMBER(10, 2),
    START_TIME  DATE,
    END_TIME    DATE,
    STATE       NUMBER default 1,
    CREATE_TIME DATE,
    constraint TB_BUSINESSTRIP_PK
        primary key (ID)
);

comment on table "tb_businessTrip" is '出差表';

create table "tb_trip_user"
(
    ID      CHAR(19) not null,
    USER_ID CHAR(19),
    TRIP_ID CHAR(19),
    constraint TB_TRIP_USER_PK
        primary key (ID),
    constraint TB_TRIP_USER_TB_TRIP_ID_FK
        foreign key (TRIP_ID) references "tb_businessTrip",
    constraint TB_TRIP_USER_TB_USER_ID_FK
        foreign key (USER_ID) references TB_USER
);

comment on table "tb_trip_user" is '加班_用户_关系表';


