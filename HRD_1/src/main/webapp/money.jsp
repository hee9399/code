<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
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
	
	
		<h3>회원매출조회</h3>
		<table border="1">
			<tr>
				<th>회원번호</th>
				<th>회원성명</th>
				<th>고객등급</th>
				<th>매출</th>
			</tr>
			
			<%
				Dao dao = new Dao();
				List<Map<String,String>> list = dao.getMoney();
				for(int i =0; i<list.size();i++){
					Map<String,String> map = list.get(i);
			%>	

			<tr>
				<th><%=map.get("custno") %></th>
				<th><%=map.get("custname") %></th>
				<th><%=map.get("grade") %></th>
				<th><%=map.get("sum") %></th>
			</tr>
			
			<%
					}
			%>
		</table>

	
	<%@include file="footer.jsp" %>
</body>
</html>