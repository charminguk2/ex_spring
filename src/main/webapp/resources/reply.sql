--reply.sql

drop table reply;

create table reply(
   rno number primary key,
   bno number default 0,
   replytext varchar2(200) not null,
   replyer varchar2(30) not null,
   regdate date default sysdate,
   updatedate date default sysdate,
   foreign key (bno) references board (bno)
);

drop sequence reply_seq;

create sequence reply_seq
    start with 1
    increment by 1
    nocycle
    nocache;

insert into reply (rno,bno,replytext,replyer) values (reply_seq.nextval,84,'���3','ȫ�浿3');
insert into reply (rno,bno,replytext,replyer) values (reply_seq.nextval,84,'���4','ȫ�浿4');
insert into reply (rno,bno,replytext,replyer) values (reply_seq.nextval,84,'���5','ȫ�浿5');
insert into reply (rno,bno,replytext,replyer) values (reply_seq.nextval,84,'���6','ȫ�浿6');
insert into reply (rno,bno,replytext,replyer) values (reply_seq.nextval,84,'���7','ȫ�浿7');
insert into reply (rno,bno,replytext,replyer) values (reply_seq.nextval,84,'���8','ȫ�浿8');
insert into reply (rno,bno,replytext,replyer) values (reply_seq.nextval,84,'���9','ȫ�浿9');
insert into reply (rno,bno,replytext,replyer) values (reply_seq.nextval,84,'���10','ȫ�浿10');



