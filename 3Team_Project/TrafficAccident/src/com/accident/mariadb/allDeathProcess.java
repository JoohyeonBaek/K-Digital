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


@WebServlet("/allDeathProcess")
public class allDeathProcess extends HttpServlet {
   private static final long serialVersionUID = 1L;
    public allDeathProcess() {
        super();
    }

   protected void doGet(HttpServletRequest request, HttpServletResponse response) 
         throws ServletException, IOException {
      request.setCharacterEncoding("UTF-8");
      
      AccidentDAO dao = new AccidentDAO();
      ArrayList<AccidentDTO> vec = new ArrayList<AccidentDTO>();
      vec=dao.allDeath();
      request.setAttribute("data2",vec);
      
      ServletContext context=this.getServletContext();
      RequestDispatcher dispatcher = 
            context.getRequestDispatcher("/success_allDeathProcess.jsp");
      dispatcher.forward(request, response);
   }
}