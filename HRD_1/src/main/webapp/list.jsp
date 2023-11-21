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
	
	
		<h3>회원목록 조회/수정</h3>
		<table border="1">
			<tr>
				<th>회원번호</th>
				<th>회원성명</th>
				<th>전화번호</th>
				<th>주소</th>
				<th>가입일자</th>
				<th>고객등급</th>
				<th>거주지역</th>
			</tr>
			<%
				Dao dao= new Dao();
				List<Map<String,String>> list= dao.list();

			
				for(int i=0; i<list.size();i++){
					Map<String,String> map= list.get(i);
					//1. 날짜 시간 중에 날짜만 추출 [공백기준으로 분해 후 앞부분 추출]
					String data=map.get("joindate").split(" ")[0]; //띄어쓰기 기준
					//2.등급에 따른 출력
					String price=map.get("grade").equals("A")? "VIP" : 
								map.get("grade").equals("B")? "일반": "직원";
			%><!-- 자바끝 -->	
				
			<tr>
				<td>
					<a href="update.jsp?custno=<%=map.get("custno") %>">
						<%= map.get("custno") %></td>
					</a>					
				<td><%= map.get("custname") %></td>
				<td><%= map.get("phone") %></td>
				<td><%= map.get("address") %></td>
				<td><%= data %></td>
				<td><%= price %></td>
				<td><%= map.get("city") %></td>
			
			</tr>
		<%
		}
		%>	
		
		</table>
	
	
	<%@include file="footer.jsp" %>

</body>
</html>