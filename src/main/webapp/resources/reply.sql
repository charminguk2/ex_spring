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

insert into reply (rno,bno,replytext,replyer) values (reply_seq.nextval,84,'´ñ±Û3','È«±æµ¿3');
insert into reply (rno,bno,replytext,replyer) values (reply_seq.nextval,84,'´ñ±Û4','È«±æµ¿4');
insert into reply (rno,bno,replytext,replyer) values (reply_seq.nextval,84,'´ñ±Û5','È«±æµ¿5');
insert into reply (rno,bno,replytext,replyer) values (reply_seq.nextval,84,'´ñ±Û6','È«±æµ¿6');
insert into reply (rno,bno,replytext,replyer) values (reply_seq.nextval,84,'´ñ±Û7','È«±æµ¿7');
insert into reply (rno,bno,replytext,replyer) values (reply_seq.nextval,84,'´ñ±Û8','È«±æµ¿8');
insert into reply (rno,bno,replytext,replyer) values (reply_seq.nextval,84,'´ñ±Û9','È«±æµ¿9');
insert into reply (rno,bno,replytext,replyer) values (reply_seq.nextval,84,'´ñ±Û10','È«±æµ¿10');



