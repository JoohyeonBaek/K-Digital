package com.accident.mariadb;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/allAccidentProcess")
public class allAccidentProcess extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public allAccidentProcess() {
        super();        
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		AccidentDAO dao = new AccidentDAO();
		ArrayList<AccidentDTO> vec = new ArrayList<AccidentDTO>();
		vec = dao.allAccident();
		request.setAttribute("data_allAccident", vec);
		
		ServletContext context = this.getServletContext();
		RequestDispatcher dispatcher = context.getRequestDispatcher("/success_AccidentProcess.jsp");
		dispatcher.forward(request, response);
		// doGet(request, response);
	}

}
