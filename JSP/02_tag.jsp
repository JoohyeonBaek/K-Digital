<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<%!
		int a;
		int b;
		public int sum(int a, int b) {
			return a+b;
		}
	%>
	
	<%
		a = 10;
		b = 20;
		out.println(sum(a,b));
	%>
	<p> ǥ���� : ���ü��� ���� ���� �޽���� ������� ����ϴ� ���� ���� </p>
	<div> ����� = <%= sum(a,b) %></div>
	
	<% int g = 60; int k=40; int r = 20; %>
	��θ� ���� ��� ����� <%= g+k+r %> �Դϴ�.
</body>
</html>