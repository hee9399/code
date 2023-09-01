-- 08-24 수업 
# 데이터베이스 생성 : JSPWEB
drop database if exists jspweb; 
create database jspweb;
use jspweb;


# 회원제 테이블 생성
drop table if exists member;
create table member(  
   mno int auto_increment ,         -- 식별번호 (회원번호)
   mid varchar(50) not null unique ,   -- 아이디 , 공백불가능 , 중복불가능
	mpwd varchar(20) not null ,         -- 비밀번호 , 공백불가능
   memall varchar(50) not null unique ,      -- 이메일 , 공백불가능
    mimg longtext ,      -- 회원 프로필 이미지 사진 이름 , 공백 가능
    primary key(mno)
);

# 회원제 게시판 테이블 board
drop table if exists bcategory;
create table bcategory(
   bcno int auto_increment ,       -- 식별 번호 
    bcname varchar(30) not null ,    -- 제목  
    primary key(bcno) 
);

# 샘플 [ 공지사항 , 자유게시판 , 노하우 ]
insert into bcategory value(1 , '공지사항');
insert into bcategory value(2 , '자유게시판');
insert into bcategory value(3 , '노하우');

#  게시판 카테고리 테이블  bcategory foreign key(bcategory)
drop table if exists board;
create table board(
   bno int auto_increment ,       -- 식별 번호 
    btitle varchar(30) not null ,    -- 제목  
   bcontent longtext ,          -- 내용 
    bfile longtext ,             -- 첨부파일 
    bdate datetime default now() ,   -- 날짜 
    bview int default 0 ,          -- 조회수
    mno int ,
    bcno int ,
    primary key(bno) , -- 식별번호 pk
    foreign key( mno ) references member(mno) on delete cascade , -- 회원탈퇴시 게시물도 같이 삭제 [ 제약조건 ] 
    foreign key( bcno ) references bcategory( bcno ) on delete cascade on update cascade -- 카테고리 삭제시 게시물도 삭제 , 카테고립전호 변경시 fk도 같이 변경한다 [ 제약조건 ] 
);

# -------------------------- 게시판 ----------------------------------------------
# 1. 글 등록   # 1번 회원이 2번카테고리(자유게시판)에 제목,내용,첨부파일(없는상태) 등록 
-- insert into board( btitle , bcontent , bfile , mno , bcno )values( '제목' , '내용' , null , 1 , 2 );
-- insert into board( btitle , bcontent , bfile , mno , bcno )values( ? , ? , ? , ? , ? )

# 2. 모든 글 출력 [ 게시물번호 , 제목 , 파일 , 작성일 , 조회수 , 작성자아이디 , 카테고리명 ]
select*from board;
select  bno , btitle , bfile , bdate , bview from board; 
	# 게시물 테이블과 회원 테이블 조인[ 테이블 합치기 / pk - fk ]
    # 게시물 테이블내 작성자번화 회원테이블의 작성자번호와 같으면 
# 
select * from board b natural join member m;
# b는 board의 별칭  b.bno - b테이블의 bno
select  b.bno , b.btitle , b.bfile , b.bdate , b.bview from board b natural join member m; 
select  b.bno , b.btitle , b.bfile , b.bdate , b.bview , m.mid from board b natural join member m; 
	# 게시물 테이블 , 회원테이블의 아이디/프로필 , 게시물카테고리테이블 , 
    # b.* - b테이블의 모든 코드/정보를 가져온다 
select b.* , m.mid , m.mimg , bc.bcname
	from board b 
		natural join bcategory bc 
			natural join member m order by b.bdate desc; # 자연조인 


# -------------------------- 회원제  ------------------------------------------------------------

select*from member;


# 회원가입 
insert into member( mid , mpwd , memall , mimg ) values( 'qweqwe' , 'a1234' , 'qwe@qwe.com' , 'default.jpg' );
   -- insert into member( mid , mpwd , memall , mimg ) values( ? , ?' , ? , ? )

# 2. 아이디중복검사. [  ]
select*from member where mid = 'qweqwe';
 -- select*from member where mid = ?
 
 # 3. 로그인 [ 아이디와 비밀번호가 일치한 레코드 존재여부 ]
select * from member where mid = 'qweqwe' and mpwd = 'qweqwe' ; # 레코드가 검색되면 로그인성공 / 없으면 로그인 실패 
# select * from member where mid = ? and mpwd = ? ;

 # 4. 회원정보 호출 [ 아이디를 이용해서 패스워드 제외하고 모든 회원정보 호출 ]
select mno , mid , memall , mimg from member where mid = 'hee9399';
   -- select mno , mid , memall , mimg from member where mid = ?

 # 5. 회원탈퇴 [ 누구(mno) 를 탈퇴할껀지 , 검증(탈퇴할 회원의 패스워드) ] 
-- delete from member where mno = 1 and mpwd = qweqwe; -- 1번 회원의 패스워드가 'qweqwe' 이면 레코드 삭제 
# delete from member where mno = ? and mpwd = ?

# 6. 프로필 수정 [ 누구(mno) 를 수정할껀지 , 수정할 내용(사진명) ]
 -- update member set mimg = 'asdasd.jpg' where mno = 1; -- 1번 회원의 이미지명을 변경한다 
-- update member set mimg = ? where mno = ?

















