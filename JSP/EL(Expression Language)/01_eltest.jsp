<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<%="${200+100} : "%>${200+100}<br>
	<%="${200-100} : "%>${200-100}<br>
	<%="${200/100} : "%>${200/100}<br>
	<%="${200>100} : "%>${200>100}<br>
	<%="${200==100} : "%>${200==100}<br>

	<%="${header.user-agent} : "%>
	��û�� ������ ������ ���� : ${hrader.user-agent}
	<br> ���޵� �޽����� ���� : ${param["message"]} Ŭ���̾�Ʈ���� ���޵Ǵ� q���� �־�� �� out ���� ��ü ��� :
	<%
	out.println(request.getParameter("q"));
	%><br> ǥ���� �±� ��� :
	<%=request.getParameter("q")%><br> EL ���(1) : ${param.q}
	<br> EL ���(2) : ${param["q"]}
	<br>

</body>
</html>