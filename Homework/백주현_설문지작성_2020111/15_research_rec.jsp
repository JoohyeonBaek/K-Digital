<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>

<%
int sum = 0;
int[] answer = new int[5];
String[] answerStr = {"�ſ�׷���", "�׷���", "�����̴�", "�ƴϴ�", "�ſ�ƴϴ�"};

for(int i=0; i<5; i++) {
	String answerNum = Integer.toString(i+1);
	answer[i] = Integer.parseInt(request.getParameter("answer" + answerNum));
	out.println(i+1 + "�� ���� ���� �׸� : " + answerStr[answer[i]-1]);
	out.println("<br>");
	sum += answer[i];	
}
%>


������ <%= sum %> �Դϴ�.

</body>
</html>