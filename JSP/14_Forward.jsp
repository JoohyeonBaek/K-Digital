<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<!DOCTYPE html>

<!-- Forwarding : �Ѱ��ֱ⸸ ��-->

<%
request.setCharacterEncoding("utf-8");
%>

<%
String name = "������ �̸�";
String bloodType = request.getParameter("bloodType");
%>

<jsp:forward page=`<%=bloodType + ".jsp"`%>>
	<jsp:param value="<%=name%>" name="name" />
</jsp:forward>