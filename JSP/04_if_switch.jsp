<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<%!int day = 0;%>
	<%
	if (day == 0 | day == 7) {
	%>
	<p>오늘은 주말입니다.</p>
	<%
	} else {
	%>
	<p>오늘은 주말이 아닙니다.</p>
	<%
	}
	%>
	<%
	switch (day) {
	case 0:
		out.println("오늘은 Sunday");
		break;
	case 1:
		out.println("오늘은 Monday");
		break;
	case 2:
		out.println("오늘은 Tuesday");
		break;
	case 3:
		out.println("오늘은 Wendsday");
		break;
	case 4:
		out.println("오늘은 Thursday");
		break;
	case 5:
		out.println("오늘은 Friday");
		break;
	case 6:
		out.println("오늘은 Saturday");
		break;
	}
	%>
</body>
</html>