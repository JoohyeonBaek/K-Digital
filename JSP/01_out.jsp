<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<%! int i = 10; %>
	<%! int a,b,c; %>
	<% out.println("빅데이터 과정 <br>"); %>
	<% out.println("자바와 동일한데 패키지 처리만 달라짐 <br>"); %>
	<% System.out.println("어디에 출력되나?"); %>
	서버측 java server page 입니다.
	JSP의 시작입니다.
	변수 i에 들어 있는 값은 <%= i %> 입니다.
	<script type="text/javascript">
		console.log("브라우저에 출력");
	</script>
</body>
</html>