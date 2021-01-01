package tsunmoon;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
public class pet_Read {

   public static void main(String[] args) {
      Connection conn = null;
      try {
         Class.forName("org.mariadb.jdbc.Driver");
         String url="jdbc:mariadb://127.0.0.1:3306/tsunmoon";
         conn=DriverManager.getConnection(url, "root", "22gkrsus");
         System.out.println("maria DB 접속 성공!");   
      }catch(Exception e) {
         e.printStackTrace();
      }
      PreparedStatement pstmt = null;      
      ResultSet rs=null;
      try {
         
         String sql="SELECT name, owner, species, sex, birth, death From pet";
         pstmt = conn.prepareStatement(sql);
         System.out.println("이름  주인  종   성별      생일        죽음");
         rs=pstmt.executeQuery();
         while(rs.next()) {
            String name = rs.getString("name");
            String owner = rs.getString("owner");
            String species = rs.getString("species");
            String sex = rs.getString("sex");
            String birth = rs.getString("birth");
            String death = rs.getString("death");
            System.out.println(name + "  " + owner + "  " + species + "  " + sex + "  " + birth + "  " + death);
         }
      }catch(Exception e) {
         e.printStackTrace();
      }finally{
         try {
            if(rs!=null)rs.close();
            if(pstmt!=null)pstmt.close();
            if(conn!=null)conn.close();
         }catch(Exception e) {}
      }
      
   }

}