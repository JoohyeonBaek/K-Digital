package com.emp.mariadb;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/updateProcess")
public class updateProcess extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public updateProcess() {
        super();       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
	      
	      int num = Integer.parseInt(request.getParameter("id"));
	      String name = request.getParameter("name");
	      int sal = Integer.parseInt(request.getParameter("sal"));
	      
	      EmpDTO dto = new EmpDTO();
	      dto.setId(num);
	      dto.setName(name);
	      dto.setSalary(sal);
	      
	      EmpDAO dao = new EmpDAO();
	      boolean bool = dao.updateEmp(dto);
	      
	      if(bool) {
	         response.sendRedirect("./25_success.html");
	      }
		
	}

}
