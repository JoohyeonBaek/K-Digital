package usunmoon;
import java.sql.Connection;
import java.sql.CallableStatement;
import java.util.Scanner;
import tsunmoon.DBConnect;


public class Sungjuk_insert {
   public static void main(String[] args) {
	  Connection conn = new DBConnect().getConn();
      CallableStatement stmt = null;
      
      Scanner sc = new Scanner(System.in);
      System.out.println("�߰��ϰ��� �ϴ� �л��� �̸��� �Է��ϼ���. ");
      String name = sc.nextLine();
      
      System.out.println("�߰��ϰ��� �ϴ� �л��� ���� ������ �Է��ϼ���.");
      int kor = Integer.parseInt(sc.nextLine());
      
      System.out.println("�߰��ϰ��� �ϴ� �л��� ���� ������ �Է��ϼ���.");
      int mat = Integer.parseInt(sc.nextLine());
      
      System.out.println("�߰��ϰ��� �ϴ� �л��� ���� ������ �Է��ϼ���.");
      int eng = Integer.parseInt(sc.nextLine());
      
      System.out.println("�߰��ϰ��� �ϴ� �л��� �б� �ڵ带 �Է��ϼ���. ");
      String schoolcode = sc.nextLine();
      
      try {
         stmt = conn.prepareCall("{call student_insert(?,?,?,?,?,?)}");
         stmt.setString(1, name);
         stmt.setInt(2, kor);
         stmt.setInt(3, mat);
         stmt.setInt(4, eng);
         stmt.setString(5, schoolcode);
         stmt.registerOutParameter(6, java.sql.Types.INTEGER);
         stmt.execute();
         
         int result=stmt.getInt(6);
         
         if(result==0) System.out.println(" �Է� �Ϸ� ");
         else if(result==-1) System.out.println(" �Է� ���� ");
         else if(result== 2) System.out.println(" �ش� �����Ͱ� �����ϴ�. ");
         else System.out.println(" ������ ó���� �̻� �߻� Ȯ�� �ʿ� ");
         
      }catch(Exception e) {
         e.printStackTrace();
      }finally {
         try {
            stmt.close();
            conn.close();
         }catch(Exception e){
            e.printStackTrace();
         }
      }
   }

}