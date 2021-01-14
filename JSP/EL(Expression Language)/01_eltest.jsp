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
	요청을 보내온 브라우저 정보 : ${hrader.user-agent}
	<br> 전달된 메시지의 내용 : ${param["message"]} 클라이언트에서 전달되는 q값이 있어야 함 out 내장 객체 사용 :
	<%
	out.println(request.getParameter("q"));
	%><br> 표현식 태그 사용 :
	<%=request.getParameter("q")%><br> EL 사용(1) : ${param.q}
	<br> EL 사용(2) : ${param["q"]}
	<br>

</body>
</html>