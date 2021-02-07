package com.emp.mariadb;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/deleteProcess")
public class deleteProcess extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public deleteProcess() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		int num = Integer.parseInt(request.getParameter("id"));
		EmpDTO dto = new EmpDTO();
		dto.setId(num);
		EmpDAO dao = new EmpDAO();
		boolean bool = dao.deleteEmp(dto);

		if (bool) {
			response.sendRedirect("./25_success.html");
		}
		doGet(request, response);		
	}

}
