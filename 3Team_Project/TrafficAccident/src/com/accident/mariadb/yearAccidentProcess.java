package com.accident.mariadb;

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


@WebServlet("/yearAccidentProcess")
public class yearAccidentProcess extends HttpServlet {
   private static final long serialVersionUID = 1L;
    public yearAccidentProcess() {
        super();
        // TODO Auto-generated constructor stub
    }
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
   }
   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      String yearin = request.getParameter("year");
      int year = Integer.parseInt(yearin);
      request.setCharacterEncoding("UTF-8");
      request.setAttribute("data2", yearin);
          
      
      AccidentDTO dto = new AccidentDTO();
      dto.setYear(year);
      

      AccidentDAO dao = new AccidentDAO();
      ArrayList<AccidentDTO> vec = new ArrayList<AccidentDTO>();
      vec = dao.selectAccident(year);
      request.setAttribute("data1", vec);
      
      ServletContext context = this.getServletContext();
      RequestDispatcher dispatcher = context.getRequestDispatcher("/success_yearAccidentProcess.jsp");
      dispatcher.forward(request, response);
      
      }
   }