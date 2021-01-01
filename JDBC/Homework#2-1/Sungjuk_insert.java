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
      System.out.println("추가하고자 하는 학생의 이름을 입력하세요. ");
      String name = sc.nextLine();
      
      System.out.println("추가하고자 하는 학생의 국어 점수를 입력하세요.");
      int kor = Integer.parseInt(sc.nextLine());
      
      System.out.println("추가하고자 하는 학생의 수학 점수를 입력하세요.");
      int mat = Integer.parseInt(sc.nextLine());
      
      System.out.println("추가하고자 하는 학생의 영어 점수를 입력하세요.");
      int eng = Integer.parseInt(sc.nextLine());
      
      System.out.println("추가하고자 하는 학생의 학교 코드를 입력하세요. ");
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
         
         if(result==0) System.out.println(" 입력 완료 ");
         else if(result==-1) System.out.println(" 입력 실패 ");
         else if(result== 2) System.out.println(" 해당 데이터가 없습니다. ");
         else System.out.println(" 데이터 처리에 이상 발생 확인 필요 ");
         
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