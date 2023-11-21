<%@page import="dao.Dao"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@include file="header.jsp" %>
	<%
		Dao dao =new Dao();
		int custno=dao.lastNo();
	
	%>
	
	<center>
		<h3>홈쇼핑 회원등록</h3>
		<form name="joinForm" method="post" action="joinLogic.jsp">

			<table>
				
				<tr><td>회원번호(자동발생)</td> <td><input name="custno" type="text" value=<%=custno%>></td></tr>
				<tr><td>회원성명</td> <td><input name="custname" type="text"></td></tr>
				<tr><td>회원전화</td> <td><input name="phone" type="text"></td></tr>
				<tr><td>회원주소</td> <td><input name="address" type="text"></td></tr>
				<tr><td>가입일자</td> <td><input name="joindate" type="text"></td></tr>
				<tr><td>고객등릅[A:VIP,B:일반,C:직원]</td> <td><input name="grade"  type="text"></td></tr>
				<tr><td>도시코드</td> <td><input name="city" type="text"></td></tr>
				<tr><td colspan="2">
					<center>
						<button type="button" onclick="onJoin()">등록</button>
						<button type="button">조회</button>
					</center>
					</td>		
				</tr>
			</table>
		</form>		
	</center>
	
	<%@include file="footer.jsp" %>
	
	<script type="text/javascript" src="join.js"></script>
</body>
</html>