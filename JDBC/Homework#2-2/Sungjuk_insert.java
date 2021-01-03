package usunmoon;
import java.sql.*;
import java.util.*;
import tsunmoon.DBConnect;

public class Sungjuk_insert{
   public void insert() {
      Connection conn = new DBConnect().getConn();
      CallableStatement stmt = null;
      
      Scanner in = new Scanner(System.in);
      System.out.println("�߰��ϰ��� �ϴ� �л��� �̸��� �Է��ϼ���. ");
      String name = in.nextLine();
      System.out.println("�߰��ϰ��� �ϴ� �л��� ���� ������ �Է��ϼ���. ");
      int kor = Integer.parseInt(in.nextLine());
      System.out.println("�߰��ϰ��� �ϴ� �л��� ���� ������ �Է��ϼ���. ");
      int mat = Integer.parseInt(in.nextLine());
      System.out.println("�߰��ϰ��� �ϴ� �л��� ���� ������ �Է��ϼ���. ");
      int eng = Integer.parseInt(in.nextLine());
      System.out.println("�߰��ϰ��� �ϴ� �л��� �б� �ڵ带 �Է��ϼ���. ");
      String schoolcode = in.nextLine();
      try {
         String sql = "call student_insert(?,?,?,?,?,?)";
         stmt = conn.prepareCall(sql);
         stmt.setString(1, name);
         stmt.setInt(2, kor);
         stmt.setInt(3, mat);
         stmt.setInt(4, eng);
         stmt.setString(5, schoolcode);
         stmt.registerOutParameter(6, java.sql.Types.INTEGER);
         stmt.execute();
         
         int result = stmt.getInt(6);
         
         if(result ==0) System.out.println("����");
         else if(result == -1) System.out.println("����");
         else if(result == 2) System.out.println("�ش��ϴ� �����Ͱ� ����");
         else System.out.println("������ ó���� �̻� �߻� Ȯ���غ��ÿ�.");
         
      }catch(Exception e) {
         e.printStackTrace();
      }finally {
         try {
            conn.close();
            stmt.close();
         }catch(Exception e){
            e.printStackTrace();
         }
      }
   }
}