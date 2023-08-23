-- 08-22 수업 
# 데이터베이스 생성 : JSPWEB
drop database if exists JSPWEB;
create database JSPWEB;
use JSPWEB;

# 테이블 생성 visitlog
drop table if exists visitlog;
create table visitlog(
	vno int auto_increment ,		-- 식별번호 ( 방문록번호 ) , 자동번호 부여 
    vwriter varchar(30) , 			-- ( 방문록작성자 ) , 공백불가능 
    vpwd varchar(10) not null, 		-- ( 방문록비밀번호 ) , 공백불가능 
    vcontent text not null ,		-- ( 방문록내용 )
    vdate datetime default now(),	-- ( 방문록 작성일/시간 ) , 생략시 자동날짜/시간 등록 
    primary key(vno) 
);
# 1. 저장 insert / 레코드 추가 
insert into visitlog( vwriter , vpwd , vcontent) values('정희락' , '1234' , '안녕하세요');
	-- 이클립스 자바에서 입력할시 = insert into visitlog( vwriter , vpwd , vcontent) values(? , ? , '?);

# 2. 호출 select / 모든 레코드 검색 / 정렬(최신글부터 출력)
select*from visitlog order by vdate desc;

# 3. 수정 [ 삭제할 식별자 필수 ] 
/* vno 3 이면 vcontent필드의 값을 수정 */
update visitlog set vcontent = '내용수정했다' where vno = 3;
update visitlog set vcontent = '내용수정했다' where vno = 3 and vpwd = '123123';
# update visitlog set vcontent = ? where vno = ? and vpwd = ?

# 4. 삭제 [ 삭제할 식별자 필수 ] 
delete from visitlog; /*모든 레코드 삭제*/
-- vno 3인 레코드 삭제
delete from visitlog where vno = 3;
delete from visitlog where vno = 3 and vpwd = 'asd';
# delete from visitlog where vno = ? and vpwd = ?






