<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<%! String name = "������"; %>
	<% String addr = "����� ���α�"; %>
	<br> �̸� : <%= name %>
	<br> �ּ� : <% out.println(addr); %>
	<br>
	<%-- <jsp:include page="age.jsp"> </jsp:include> --%>
	<br>
</body>
</html>