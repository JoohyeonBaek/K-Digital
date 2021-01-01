package usunmoon;
import java.sql.*;

import java.util.Scanner;
public class Sungjuk_select {

   public static void main(String[] args) {
      Connection conn = new DBConnect_20201231().getConn();
      Scanner sc = new Scanner(System.in);
      CallableStatement stmt = null;
      System.out.println("검색할 번호와 이름을 입력하세요");
      
      try {
         stmt = conn.prepareCall("call student_select(?,?)");
         stmt.setInt(1,sc.nextInt());
         stmt.setString(2, sc.next());
         ResultSet rs = stmt.executeQuery();
            while(rs.next()) {
               String name = rs.getString("name");
               int kor = rs.getInt("kor");
               int mat = rs.getInt("mat");
               int eng = rs.getInt("eng");
                                     
               if(name!=null) {
            	  System.out.println("name\tkor\tmat\teng");
                  System.out.println(name + "\t" + kor + "\t" + mat + "\t" + eng);
               }
            }
         } catch(Exception e) {
         e.printStackTrace();
      }finally {
         try {
            stmt.close();
            conn.close();
         }catch(SQLException e) {
            e.printStackTrace();
         }
      }
      
   }
   
}