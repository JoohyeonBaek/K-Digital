<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<%
	int i = 0;
	while (true) {
		out.println(i + "번째 줄");
		i++;
	%>
	<br> ===========================
	<br />
	<%
	if (i > 5)
		break;
	}
	%>
</body>
</html>