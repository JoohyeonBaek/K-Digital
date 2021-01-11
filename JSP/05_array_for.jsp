<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<table>
		<%
			int godhealth = 1004;
			String[][] arr = {{"arcon","BigData","Development"}, {"one","two","three"}};
			for(String data[] : arr) {
				out.println(data.length + "<br>");
				for(String str : data) {
					%>
					<td><%= str %></td>
					<%
				}
					%>
					<tr></tr>
					<%
			}			
		%>
	</table>
</body>
</html>