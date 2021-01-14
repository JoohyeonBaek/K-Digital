package com.sung.sunmoon;

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

   protected void doGet(HttpServletRequest request, HttpServletResponse response) 
         throws ServletException, IOException {      
      
   }
   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	   
	   request.setCharacterEncoding("utf-8");
	      
	      int bunho=Integer.parseInt(request.getParameter("bunho"));
	      String name=request.getParameter("name");
	      int kor=Integer.parseInt(request.getParameter("kor"));
	      int eng=Integer.parseInt(request.getParameter("eng"));
	      int mat=Integer.parseInt(request.getParameter("mat"));
	      
	      StudentDTO dto= new StudentDTO();
	      dto.setBunho(bunho);
	      dto.setName(name);
	      dto.setKor(kor);
	      dto.setEng(eng);
	      dto.setMat(mat);
	      
	      StudentDAO dao = new StudentDAO();
	      boolean bool =  dao.update_student(dto);	      
	      if(bool) {
	         response.sendRedirect("./success.html");
	      }
   }
}