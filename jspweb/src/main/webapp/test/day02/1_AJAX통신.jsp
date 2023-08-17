<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h3> AJAX [ JS ---- 자바[서블릿] 통신 ] </h3>
	<h6> 1.[응답:문자타입] JS 에서 servlet[ 자바웹클래스 ] 에게 통신하고 데이터 반환 받기 </h6>
	<button onclick="예제1()"> 예제1 </button>
	
	<h6> 1.[응답:문자타입/한글인코딩] JS 에서 servlet[ 자바웹클래스 ] 에게 통신하고 데이터 반환 받기 </h6>
	<button onclick="예제2()"> 예제2 </button>
	
	<h6> 1.[응답:JSON타입/한글인코딩] JS 에서 servlet[ 자바웹클래스 ] 에게 통신하고 데이터 반환 받기 </h6>
	<button onclick="예제3()"> 예제3 </button>
	
	<script  src="http://code.jquery.com/jquery-latest.min.js"></script>

	<script src="1_AJAX통신.js" type="text/javascript"></script>

</body>
</html>