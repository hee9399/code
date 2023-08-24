# 데이터베이스 생성 : JSPWEB
drop database if exists JSPWEB;
create database JSPWEB;
use JSPWEB;

# 테이블 설계  accountbook
drop database if exists accountbook;
create table accountbook(
	ano int auto_increment , -- 식별번호
    awriter text not null  ,    -- 내용용물작성 
    amoney varchar(50) , -- 금액 
    adate varchar(20) ,
	primary key(ano)
);
# 1. 저장 insert / 레코드 추가 
insert into accountbook( awriter , amoney , adate ) values( '적금' , '2000' , '1111-22-11' );
# 자바에서 
# insert into accountbook( awriter , amoney , adate ) values( ? , ? , ? );

# 호출 
select * from accountbook order by adate desc;

# 수정 
update accountbook set awriter = '출금' , amoney = '2000' where ano = 1;
-- update accountbook set awriter = ? , amoney = ? where ano = ?

# 삭제 
delete from accountbook where ano = 1;