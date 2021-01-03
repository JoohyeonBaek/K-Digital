package usunmoon;

import java.sql.*;
import tsunmoon.DBConnect;


public class Sungjuk_select {   
   private String name;
   public void select(String name) {
      
      this.name = name;
      Connection conn = new DBConnect().getConn();
      CallableStatement stmt = null;
      try {
         stmt = conn.prepareCall("call student_select(?)");
         stmt.setString(1, name);
         ResultSet rs = stmt.executeQuery();
         while (rs.next()) {
            name = rs.getString("name");
            int kor = rs.getInt("kor");
            int mat = rs.getInt("mat");
            int eng = rs.getInt("eng");
            if (name != null) {
               System.out.println("이름 : "+name + "  " +"국어 : "+ kor + "  "+"수학 : " +
            mat + "  "+"영어 : " + eng);
            }
         }
      } catch (Exception e) {
         e.printStackTrace();
      } finally {
         try {
            stmt.close();
            conn.close();
         } catch (SQLException e) {
            e.printStackTrace();
         }
      }
   }

}