<%@page import="java.util.Map"%>
<%@page import="dao.Dao"%>
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
		int custno = Integer.parseInt(request.getParameter("custno"));
		Dao dao = new Dao();
		Map<String,String> map = dao.getMember(custno);
		
	%>
	<script type="text/javascript"> <!--가입은 js파일 따로 만들었는데 수정은 길지 않으니까 여기에 바로 만들-->
		function onUpdate() {document.updateForm.submit();alert('회원수정완료')}
	</script>
	
		<h3>홈쇼핑 회원 정보 수정</h3>
		<form name="updateForm" method="post" action="updateLogic.jsp">
			<table>
				<tr><td>회원번호(자동발생)</td> <td><input name="custno" type="text" value=<%=map.get("custno")%>></td></tr>
				<tr><td>회원성명</td> <td><input name="custname" type="text" value=<%=map.get("custname")%>></td></tr>
				<tr><td>회원전화</td> <td><input name="phone" type="text" value=<%=map.get("phone")%>></td></tr>
				<tr><td>회원주소</td> <td><input name="address" type="text" value=<%=map.get("address")%>></td></tr>
				<tr><td>가입일자</td> <td><input name="joindate" type="text" value=<%=map.get("joindate")%>></td></tr>
				<tr><td>고객등릅[A:VIP,B:일반,C:직원]</td> <td><input name="grade" value=<%=map.get("grade")%> type="text"></td></tr>
				<tr><td>도시코드</td> <td><input name="city" value=<%=map.get("city")%> type="text"></td></tr>
				<tr><td colspan="2">
					<center>
						<button type="button" onclick="onUpdate()">수정</button>
						<a href="list.jsp"><button type="button">조회</button></a>
					</center>
					</td>		
				</tr>
			</table>
		</form>		
	
	<%@include file="footer.jsp" %>                    
</body>
</html>