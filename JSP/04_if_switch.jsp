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
	<p>������ �ָ��Դϴ�.</p>
	<%
	} else {
	%>
	<p>������ �ָ��� �ƴմϴ�.</p>
	<%
	}
	%>
	<%
	switch (day) {
	case 0:
		out.println("������ Sunday");
		break;
	case 1:
		out.println("������ Monday");
		break;
	case 2:
		out.println("������ Tuesday");
		break;
	case 3:
		out.println("������ Wendsday");
		break;
	case 4:
		out.println("������ Thursday");
		break;
	case 5:
		out.println("������ Friday");
		break;
	case 6:
		out.println("������ Saturday");
		break;
	}
	%>
</body>
</html>