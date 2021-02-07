<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="java.lang.*,java.util.*, java.sql.*, 
     javax.sql.*, javax.naming.*,com.emp.mariadb.*, 
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
	ArrayList<EmpDTO> vec = new ArrayList<EmpDTO>();
	vec = (ArrayList<EmpDTO>)request.getAttribute("data1");
%>
<center>
	<h3>주소록</h3> 
	<a href = "http://localhost:8080/showemp/25_emp_test.html"> 메뉴로 돌아가기</a> 
<table border=1>
	<tr>
		<th>변호</th><th>이름</th><th>급여</th>
	</tr>
<%
	Iterator iterator = vec.iterator();
	while (iterator.hasNext()) {
		EmpDTO dto = (EmpDTO) iterator.next();
	%>

	<tr> 
		<td> <%=dto.getId() %></td>
		<td> <%=dto.getName() %></td>
		<td> <%=dto.getSalary() %></td>
	</tr>
	<%
    }
%>     
</table>



        
</center>
</body>
</html>