<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>자바프로그래밍에서 임포트 없이 사용하는 객체</title>
</head>
<body>
	<%
 	float f = 2.5f;
	int i = Math.round(f);
	java.util.Date date = new java.util.Date();
	%>
	
	반올림 : <%= i %> <br>
	현재 날짜 : <%= date.toString() %>
	시간 : <%= date.getHours() %>
</body>
</html>