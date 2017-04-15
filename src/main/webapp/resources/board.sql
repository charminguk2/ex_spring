--board.sql

drop table board;

create table board(
   bno number primary key,  -- 글번호
   title varchar2(200) not null, --글제목
   content varchar2(500),   -- 글내용
   writer varchar2(50) not null,  -- 작성자
   regdate date default sysdate,  -- 작성일자
   viewcnt number default 0    --조회수
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




