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
	<% out.println("������ ���� <br>"); %>
	<% out.println("�ڹٿ� �����ѵ� ��Ű�� ó���� �޶��� <br>"); %>
	<% System.out.println("��� ��µǳ�?"); %>
	������ java server page �Դϴ�.
	JSP�� �����Դϴ�.
	���� i�� ��� �ִ� ���� <%= i %> �Դϴ�.
	<script type="text/javascript">
		console.log("�������� ���");
	</script>
</body>
</html>