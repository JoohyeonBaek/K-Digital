<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Ŭ���̾�Ʈ�� ���� ���� ������</h1>
	
	<ul>
		<li><p>
				<b>����1 :</b>
				<%=request.getParameter("num1")%>
			</p></li>
		<li><p>
				<b>����2 :</b>
				<%=request.getParameter("num2")%>
		<li><p>
				<b>�� :</b>
				<%=Integer.parseInt(request.getParameter("num1")) + Integer.parseInt(request.getParameter("num2"))%>
	</ul>
</body>
</html>