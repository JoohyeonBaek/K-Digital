package tsunmoon;
import java.sql.*;

public class pet_Delete {

   public static void main(String[] args) {
      Connection conn = null;
      try {
    	  Class.forName("org.mariadb.jdbc.Driver");
          String url = "jdbc:mariadb://127.0.0.1:3306/tsunmoon";
          conn = DriverManager.getConnection(url,"root","22gkrsus");
          System.out.println("�����Ƶ�� ���Ӽ���");
           
      } catch(Exception e){
           e.printStackTrace();
      }
      
      PreparedStatement pstmt = null;
      ResultSet rs = null;
      
      try {
         String sql = "delete from pet where name=?";
         pstmt=conn.prepareStatement(sql);
         String name = "������";
         pstmt.setString(1,name);
         pstmt.executeUpdate();
         System.out.println("������ �����߽��ϴ�.");
      
      }catch(Exception e) {
         e.printStackTrace();
      }finally {
         try {
            if(rs!=null) rs.close();
            if(pstmt!=null) pstmt.close();
            if(conn!=null) conn.close();
         } catch(Exception e) {}
      }
   }

}