package usunmoon;

import java.sql.*;
import tsunmoon.DBConnect;


import java.util.Scanner;

public class Sungjuk_update {
   public void update() {

      Connection conn = new DBConnect().getConn();
      CallableStatement stmt = null;
      Scanner sc = new Scanner(System.in);

      try {
         String sql = "{call student_update(?,?,?,?,?,?)}";
         stmt = conn.prepareCall(sql);
         System.out.println("수정할 번호 입력");
         int bunho = sc.nextInt();
         stmt.setInt(1, bunho);
         System.out.println("바꿀 이름 입력");
         String name = sc.next();
         stmt.setString(2, name);
         System.out.println("바꿀 국어 성적 입력");
         int kor = sc.nextInt();
         stmt.setInt(3, kor);
         System.out.println("바꿀 영어 성적 입력");
         int eng = sc.nextInt();
         stmt.setInt(4, eng);
         System.out.println("바꿀 수학 성적 입력");
         int mat = sc.nextInt();
         stmt.setInt(5, mat);

         stmt.registerOutParameter(6, java.sql.Types.INTEGER);
         int affectedrowcount = stmt.executeUpdate();
         if (affectedrowcount > 0)
            System.out.println("데이터 수정 성공");
         else
            System.out.println("데이터 수정 실패");
         int result = stmt.getInt(6);
         if (result == 0)
            System.out.println("성공");
         else if (result == -1)
            System.out.println("실패");
         else if (result == 2)
            System.out.println("해당하는 데이터가 없음");

      } catch (Exception e) {
         e.printStackTrace();
      } finally {
         try {
            if (stmt != null)
               stmt.close();
            if (conn != null)
               stmt.close();
         } catch (Exception e) {
            e.printStackTrace();
         }
      }

   }

}