<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<!DOCTYPE html>

<!-- Forwarding : 넘겨주기만 함-->

<%
request.setCharacterEncoding("utf-8");
%>

<%
String name = "본인의 이름";
String bloodType = request.getParameter("bloodType");
%>

<jsp:forward page=`<%=bloodType + ".jsp"`%>>
	<jsp:param value="<%=name%>" name="name" />
</jsp:forward>