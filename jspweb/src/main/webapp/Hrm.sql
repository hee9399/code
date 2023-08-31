drop database if exists jspweb;
create database jspweb;
use jspweb; 

SELECT * FROM jspweb.hrm;

drop table if exists  hrm;

create table hrm(
	hnumber int not null unique , -- 직원번호 
	hname varchar(10) not null , -- 직원이름 
    hphone varchar(20) not null , -- 전화번호 
    hrank varchar(5) not null , -- 직급 
    himg longtext , -- 회원 사진 
    hdate varchar(20) not null  -- 등록일 , 현재등록일(자동)

);
select*from hrm;

# 입력값 출력 
insert into hrm( hnumber , hname , hphone , hrank , himg , hdate ) values( '1' , '정희락' , '01011112222' , '사원'  , 'sdf.jsp' , '2023-08-30');
 -- insert into hrm( hnumber , hname , hphone , hrank , himg , hdate ) values( ? , ? , ? , ?  , ? , ? )
 
 select * from hrm order by hnumber asc;
	