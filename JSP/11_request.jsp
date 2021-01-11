<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@ page import = "java.io.*, java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<table width = "100%" border="1" align="center">
	<tr bgcolor = "#949494">
	<th>헤더이름</th>
	<th>헤더값</th>
	</tr>
	<%
	Enumeration headerNames = request.getHeaderNames();
	while(headerNames.hasMoreElements()) {
		String paramName = (String)headerNames.nextElement();
	}
	%></table>
</body>
</html>