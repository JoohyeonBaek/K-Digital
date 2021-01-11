<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ page import = "java.io.*,java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<center>
		<%
		response.setIntHeader("Refresh", 5);

		Calendar calendar = new GregorianCalendar();
		String am_pm;

		int hour = calendar.get(Calendar.HOUR);
		int minute = calendar.get(Calendar.MINUTE);
		int second = calendar.get(Calendar.SECOND);

		if (calendar.get(Calendar.AM_PM) == 0)
			am_pm = "AM";
		else
			am_pm = "PM";
		String CT = hour + ":" + minute + ":" + second + " " + am_pm;
		out.println("현재시간: " + CT + "\n");
		%>
	</center>
</body>
</html>