<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="java.lang.*,java.util.*, java.sql.*, 
     javax.sql.*, javax.naming.*,com.sung.sunmoon.*, 
	 java.io.UnsupportedEncodingException, java.text.SimpleDateFormat" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/paginationjs/2.1.4/pagination.min.js"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/paginationjs/2.1.4/pagination.css"/>
</head>

<body>		
		
<%
				ArrayList<StudentDTO> vec = new ArrayList<StudentDTO>();
					vec = (ArrayList<StudentDTO>)request.getAttribute("data1");
				%>
<center>
	<h3>Student</h3> 
	<a href = "http://localhost:8080/showemp/sungjukmenu.html"> �޴��� ���ư���</a> 
<table border=1>
	<tr>
		<th>��ȣ</th><th>�̸�</th><th>����</th><th>����</th><th>����</th><th>��</th><th>���</th><th>���</th><th>�б��ڵ�</th>
	</tr>
<%
Iterator iterator = vec.iterator();
	while (iterator.hasNext()) {
		StudentDTO dto = (StudentDTO) iterator.next();
%>

	<tr> 
		<td> <%=dto.getBunho() %></td>
		<td> <%=dto.getName() %></td>
		<td> <%=dto.getKor() %></td>
		<td> <%=dto.getMat() %></td>
		<td> <%=dto.getEng() %></td>
		<td> <%=dto.getTotal() %></td>
		<td> <%=dto.getAvg() %></td>
		<td> <%=dto.getGrade() %></td>
		<td> <%=dto.getSchoolCode() %></td>
		
	</tr>
	<%
    }
%>     
</table>



        
</center>
</body>
</html>