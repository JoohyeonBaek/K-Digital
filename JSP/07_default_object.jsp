<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>�ڹ����α׷��ֿ��� ����Ʈ ���� ����ϴ� ��ü</title>
</head>
<body>
	<%
 	float f = 2.5f;
	int i = Math.round(f);
	java.util.Date date = new java.util.Date();
	%>
	
	�ݿø� : <%= i %> <br>
	���� ��¥ : <%= date.toString() %>
	�ð� : <%= date.getHours() %>
</body>
</html>