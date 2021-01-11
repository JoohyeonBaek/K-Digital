<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ page import="java.io.*,java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<center>
		<h2>모든 선택 받기</h2>
		<table width="100%" border="1" aligen="center">
			<tr bgcolor="#949494">
				<th>전송 파라미터 이름</th>
				<th>값</th>
			</tr>
			<%
			Enumeration paramNames = request.getParameterNames();
			while (paramNames.hasMoreElements()) {
				String paramName = (String) paramNames.nextElement();
				out.print("<tr><td>" + paramName + "</td>\n");
				String paramValue = request.getHeader(paramName);
				out.println("<td>" + paramValue + "</td></tr>\n");
			}
			%>
		</table>
	</center>
</body>
</html>
F
