package tsunmoon;
import java.sql.*;

public class pet_Update {

   public static void main(String[] args) {
      Connection conn = null;
      try {
         Class.forName("org.mariadb.jdbc.Driver");
         String url = "jdbc:mariadb://127.0.0.1:3306/tsunmoon";
         conn = DriverManager.getConnection(url,"root","22gkrsus");
         System.out.println("마리아 db 접속 성공!!");
      }catch(Exception e){
         e.printStackTrace();
      }
      
      String nameto ="두부";
      String name = "유리";
      
      PreparedStatement pstmt = null;
      try {
         String sql = "UPDATE pet set name=? WHERE name=?";
         pstmt = conn.prepareStatement(sql);
         
         pstmt.setString(1, nameto);
         pstmt.setString(2, name);
         pstmt.executeUpdate();
         System.out.println("pet정보를 업데이트했습니다.");
      }catch (Exception e) {
         e.printStackTrace();
      }finally {
         try {
            if (pstmt!=null) pstmt.close();
            if(conn!=null) conn.close();
         }catch(Exception e) {}
      }

   }

}