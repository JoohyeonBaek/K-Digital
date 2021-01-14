package com.sung.sunmoon;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/insertProcess")
public class insertProcess extends HttpServlet {
   private static final long serialVersionUID = 1L;

    public insertProcess() {
        super();
    }

   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      response.getWriter().append("Served at: ").append(request.getContextPath());
   }

   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      request.setCharacterEncoding("utf-8");
      
      String name = request.getParameter("name");
      int kor = Integer.parseInt(request.getParameter("kor"));
      int eng = Integer.parseInt(request.getParameter("eng"));
      int mat = Integer.parseInt(request.getParameter("mat"));
      String schoolcode = request.getParameter("schoolcode");
      
      StudentDTO dto = new StudentDTO();
      dto.setName(name);
      dto.setKor(kor);
      dto.setEng(eng);
      dto.setMat(mat);
      dto.setSchoolCode(schoolcode);
      
      StudentDAO dao = new StudentDAO();
      boolean bool = dao.insert_student(dto);
      
      if(bool) {
         response.sendRedirect("./success.html");
      }
   }
}