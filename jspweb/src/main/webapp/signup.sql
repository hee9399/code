-- 08-24 수업 
# 데이터베이스 생성 : JSPWEB
drop database if exists JSPWEB;
create database JSPWEB;
use JSPWEB;

# member테이블 생성
drop table if exists member;
create table member(
	mno int auto_increment ,			-- 식별번호 (회원번호)
	mid varchar(50) not null unique ,	-- 아이디 , 공백불가능 , 중복불가능
    mpwd varchar(20) not null ,			-- 비밀번호 , 공백불가능
	memall varchar(50) not null unique ,		-- 이메일 , 공백불가능
    mimg longtext ,		-- 회원 프로필 이미지 사진 이름 , 공백 가능
    primary key(mno)
);

select*from member;

# 회원가입 
insert into member( mid , mpwd , memall , mimg ) values( 'qweqwe' , 'a1234' , 'qwe@qwe.com' , 'default.jpg' );
	-- insert into member( mid , mpwd , memall , mimg ) values( ? , ?' , ? , ? )

# 2. 아이디중복검사. [  ]
select*from member where mid = 'qweqwe';
 -- select*from member where mid = ?











