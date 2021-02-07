package com.emp.mariadb;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/EmpProcess")
public class EmpProcess extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public EmpProcess() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		String str = request.getParameter("action");
		request.setCharacterEncoding("UTF-8");
		
		if (str.equals("insert")){
			System.out.println("입력요청");
			
			int id = Integer.parseInt( request.getParameter("id"), 10);
			String name  = request.getParameter("name");
			int salary = Integer.parseInt( request.getParameter("salary") );

			EmpDTO dto = new EmpDTO();
			dto.setId(id);
			dto.setName(name);
			dto.setSalary(salary);			
			EmpDAO dao = new EmpDAO();
			boolean bool = dao.registerEmp(dto);
			PrintWriter out = response.getWriter();
			if(bool) {
				response.sendRedirect("./25_success.html");
			}
			else {
				out.println("입력에 실패하였습니다. ");
			}
		}
		else if (str.equals("select")) {
			
			EmpDAO dao = new EmpDAO();
			ArrayList<EmpDTO> vec = new ArrayList<EmpDTO>();
			vec = dao.getRecords(1,5);
			request.setAttribute("data1", vec);
			
			ServletContext context = this.getServletContext();
			RequestDispatcher dispatcher = context.getRequestDispatcher("/25_showemp.jsp");
			dispatcher.forward(request, response);// 이동 
		}
		
		else if (str.equals("update")) {
			
		}
		
		else if (str.equals("delete")){
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
		
		else {
			response.sendRedirect("EmpMenu.html");
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
