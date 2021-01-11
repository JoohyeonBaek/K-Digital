<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<ul>
		<li><p><b>Maths</b>
		<%= request.getParameter("maths") %>
		</p></li>
		<li><p><b>Physics</b>
		<%= request.getParameter("physics") %>
		</p></li>
		<li><p><b>Chemistry</b>
		<%= request.getParameter("chemistry") %>
		</p></li>
	</ul>
</body>
</html>