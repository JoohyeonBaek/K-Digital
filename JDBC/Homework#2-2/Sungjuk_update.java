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
         System.out.println("������ ��ȣ �Է�");
         int bunho = sc.nextInt();
         stmt.setInt(1, bunho);
         System.out.println("�ٲ� �̸� �Է�");
         String name = sc.next();
         stmt.setString(2, name);
         System.out.println("�ٲ� ���� ���� �Է�");
         int kor = sc.nextInt();
         stmt.setInt(3, kor);
         System.out.println("�ٲ� ���� ���� �Է�");
         int eng = sc.nextInt();
         stmt.setInt(4, eng);
         System.out.println("�ٲ� ���� ���� �Է�");
         int mat = sc.nextInt();
         stmt.setInt(5, mat);

         stmt.registerOutParameter(6, java.sql.Types.INTEGER);
         int affectedrowcount = stmt.executeUpdate();
         if (affectedrowcount > 0)
            System.out.println("������ ���� ����");
         else
            System.out.println("������ ���� ����");
         int result = stmt.getInt(6);
         if (result == 0)
            System.out.println("����");
         else if (result == -1)
            System.out.println("����");
         else if (result == 2)
            System.out.println("�ش��ϴ� �����Ͱ� ����");

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