<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ page import="java.lang.*,java.util.*,java.sql.*,
   javax.sql.*,javax.naming.*,com.test.mariadb.*,
   java.io.UnsupportedEncodingException,java.text.SimpleDateFormat"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>MariaDB Member data</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

</head>
<body>
	<%
	ArrayList<MemberDTO_1> vec1 = new ArrayList<MemberDTO_1>();
	vec1 = (ArrayList<MemberDTO_1>) request.getAttribute("data2");
	%>
	<center>
		<h3>멤버 테이블</h3>
		<table class="table table-striped">
			<tr style="text-align: center;">
				<th>번호</th>
				<th>이름</th>
				<th>주소</th>
			</tr>
			<%
			Iterator iterator1 = vec1.iterator();
			while (iterator1.hasNext()) {
				MemberDTO_1 dto1 = (MemberDTO_1) iterator1.next();
			%>
			<tr style="text-align: center;">
				<td><%=dto1.getNum()%></td>
				<td><%=dto1.getName()%></td>
				<td><%=dto1.getAddr()%></td>
			</tr>
			<%
			}
			%>

		</table>
	</center>

</body>
</html>