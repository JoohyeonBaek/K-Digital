<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<%! String name = "나라사랑"; %>
	<% String addr = "서울시 종로구"; %>
	<br> 이름 : <%= name %>
	<br> 주소 : <% out.println(addr); %>
	<br>
	<%-- <jsp:include page="age.jsp"> </jsp:include> --%>
	<br>
</body>
</html>