package usunmoon;

import java.sql.CallableStatement;
import java.sql.Connection;

import tsunmoon.DBConnect;

public class Sungjuk_delete {
   private int bunho;
   Connection conn = new DBConnect().getConn();
   CallableStatement stmt = null;
   
   public void delete(int bunho) {
      this.bunho = bunho;
   
   try {
      String sql = "{call student_delete(?,?)}";
      stmt = conn.prepareCall(sql);
      
      stmt.setInt(1, bunho);
      
      stmt.registerOutParameter(2, java.sql.Types.INTEGER);
      int affectedrowcount = stmt.executeUpdate();
      stmt.execute();
      int result = stmt.getInt(2);
      if(affectedrowcount>0)
         System.out.println(bunho+"�� ������ ���� ����");
      else
         System.out.println("������ ���� ����");
      
   }catch(Exception e) {
      e.printStackTrace();
   }finally {
      try {
         conn.close();
         stmt.close();
      }catch(Exception e) {
         e.printStackTrace();
      }
   }

   }
}