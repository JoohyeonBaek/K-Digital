<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("utf-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
String name = request.getParameter("name");
int mbti = Integer.parseInt(request.getParameter("answer"));
String[] mbtiData = { "청렴결백 논리주의자", "용감한 수호자", "선의의 옹호자", "용의주도한 전략가",
		"만능 재주꾼", "호기심 많은 예술가", "열정적인 중재자", "논리적인 사색가",
		"모험을 즐기는 사업가", "자유로운 영혼의 연예인", "재기발랄한 활동가", "논쟁을 즐기는 변론가",
		"엄격한 관리자", "사교적인 외교관", "정의로운 사회운동가", "대담한 통솔자"		
};

out.println("<h1 style=\"text-align: center\">" + name + " 님은" + "<br><br>" + mbtiData[mbti] + " !!</h1>"); 
%>


</body>
</html>