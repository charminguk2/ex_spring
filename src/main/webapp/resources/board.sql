--board.sql

drop table board;

create table board(
   bno number primary key,  -- �۹�ȣ
   title varchar2(200) not null, --������
   content varchar2(500),   -- �۳���
   writer varchar2(50) not null,  -- �ۼ���
   regdate date default sysdate,  -- �ۼ�����
   viewcnt number default 0    --��ȸ��
);

insert into BOARD (bno,title,content,writer) (select  board_seq.nextval, title,content,writer from BOARD);


drop sequence board_seq;
create sequence board_seq
    start with 1
    increment by 1
    nocycle
    nocache;
 
alter table board 
add (replycnt number default 0);

select * from BOARD;

update board
set replycnt=(select count(*)
              from REPLY
              where bno=board.bno);




