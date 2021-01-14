package com.sung.sunmoon;

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
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	response.getWriter().append("Served at: ").append(request.getContextPath());
        request.setCharacterEncoding("UTF-8");
        
        int delete_bunho =Integer.parseInt(request.getParameter("bunho"));
        
        StudentDTO dto = new StudentDTO();
        dto.setBunho(delete_bunho);
        
        StudentDAO dao = new StudentDAO();
        boolean bool = dao.delete_student(dto); 
        
        if(bool) {
           response.sendRedirect("./success.html");
        }
	}

   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      
      
   
   }

}