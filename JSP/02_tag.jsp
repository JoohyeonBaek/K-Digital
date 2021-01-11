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
	<p> 표현식 : 가시성도 좋고 변수 메쏘드의 결과값을 출력하는 것이 가능 </p>
	<div> 결과는 = <%= sum(a,b) %></div>
	
	<% int g = 60; int k=40; int r = 20; %>
	모두를 더한 계산 결과는 <%= g+k+r %> 입니다.
</body>
</html>