package com.sung.sunmoon;

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


@WebServlet("/selectProcess")
public class selectProcess extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public selectProcess() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		
		request.setCharacterEncoding("UTF-8");		
		
		
			
			StudentDAO dao = new StudentDAO();
			ArrayList<StudentDTO> vec = new ArrayList<StudentDTO>();
			vec = dao.getRecords(1,3);
			System.out.println("ok");
			request.setAttribute("data1", vec);
			
			ServletContext context = this.getServletContext();
			RequestDispatcher dispatcher = context.getRequestDispatcher("/showsungjuk.jsp");
			dispatcher.forward(request, response);// ¿Ãµø 
			
		
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
