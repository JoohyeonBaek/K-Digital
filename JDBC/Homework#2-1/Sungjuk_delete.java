package usunmoon;
import java.sql.Connection;
import java.sql.CallableStatement;
import java.util.Scanner;


public class Sungjuk_delete {

   public static void main(String[] args) {
      Connection conn = new DBConnect_20201231().getConn();
      CallableStatement stmt = null;
      
      Scanner sc = new Scanner(System.in);
      
      try {
         String sql = "call student_delete(?,?)";
         stmt = conn.prepareCall(sql);
         System.out.println("������ ��ȣ �Է�");
         int bunho = sc.nextInt();
         stmt.setInt(1, bunho);
         
         stmt.registerOutParameter(2, java.sql.Types.INTEGER);
         int affectedrowcount = stmt.executeUpdate();
         stmt.execute();
         int result = stmt.getInt(2);
         if(affectedrowcount>0)
            System.out.println(bunho+"�� ������ ���� ����");
         else
            System.out.println("������ ���� ����");
         if (result ==0)
            System.out.println("����");
         else if (result ==-1)
            System.out.println("����");
         
      }catch(Exception e) {
         e.printStackTrace();
      }finally {
         try {
            conn.close();
            stmt.close();
         }catch(Exception e) {            e.printStackTrace();
         }
      }
   }
}