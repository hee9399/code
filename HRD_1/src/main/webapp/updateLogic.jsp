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
	<%
		request.setCharacterEncoding("UTF-8");
		String custno= request.getParameter("custno");
		String custname=request.getParameter("custname");
		String phone=request.getParameter("phone");
		String address=request.getParameter("address");
		String joindate=request.getParameter("joindate");
		String grade=request.getParameter("grade");
		String city=request.getParameter("city");
		
		System.out.print("여기염");
	
		
		//Dao처리
		Dao dao = new Dao();
		dao.update(custno, custname, phone, address, joindate, grade, city);
		//페이지전환/전환[response.sendRedirect("이동할경로")]
		response.sendRedirect("update.jsp?custno="+custno);
	
	%>

</body>
</html>