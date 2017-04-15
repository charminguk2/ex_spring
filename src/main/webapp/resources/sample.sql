-- sample.sql

create table tbl_user(
   userid varchar2(50) primary key,
   userpw varchar2(50) not null,
   username varchar2(50) not null,
   userpoint number default 0
);

create table tbl_message(
   mid number primary key, --�޽��� ��ȣ
   targetid varchar2(50) not null, -- uid(�޽����� �޴� ���̵�)
   sender varchar2(50) not null,   -- uid(�޽����� ���� ���̵�)
   message varchar2(200) not null,
   opendate date,
   senddate date default sysdate,
   foreign key (targetid) references tbl_user (userid),
   foreign key (sender) references tbl_user (userid)
);

create sequence tbl_message_seq
    start with 1
    increment by 1
    nocycle
    nocache;
    
insert into  tbl_user (userid, userpw, username) values ('user01','user01','�浿');
insert into  tbl_user (userid, userpw, username) values ('user02','user02','����');
insert into  tbl_user (userid, userpw, username) values ('user03','user03','�ֿ�');
insert into  tbl_user (userid, userpw, username) values ('user04','user04','����');
insert into  tbl_user (userid, userpw, username) values ('user05','user05','����');


select * from tbl_message;
select * from tbl_user;
select * from BOARD;

alter table tbl_user
add (sessionlimit date);





