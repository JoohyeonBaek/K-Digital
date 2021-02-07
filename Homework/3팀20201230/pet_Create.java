package tsunmoon;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.*;

class DBConnect {
   private Connection conn;
   
   public DBConnect() {
      try {
      Class.forName("org.mariadb.jdbc.Driver");
      String url = "jdbc:mariadb://127.0.0.1:3306/tsunmoon";
      conn = DriverManager.getConnection(url, "root", "22gkrsus");
      System.out.println("마리아 디비 접속 성공");
      }catch(Exception e){
         e.printStackTrace();
      }
   } 
   public Connection getConn() {
      return conn;
   }
}

class Pet{
   private String name;
   private String owner;
   private String species;
   private String sex;
   private String birth;
   private String death;
   public Pet() {}
   public Pet(String name, String owner, String species, String sex, String birth, String death) {
      this.name=name;
      this.owner=owner;
      this.species=species;
      this.sex=sex;
      this.birth=birth;
      this.death=death;
   }
   public String getName() {
      return name;
   }
   public void setName(String name) {
      this.name = name;
   }
   public String getOwner() {
      return owner;
   }
   public void setOwner(String owner) {
      this.owner = owner;
   }
   public String getSpecies() {
      return species;
   }
   public void setSpecies(String species) {
      this.species = species;
   }
   public String getSex() {
      return sex;
   }
   public void setSex(String sex) {
      this.sex = sex;
   }
   public String getBirth() {
      return birth;
   }
   public void setBirth(String birth) {
      this.birth = birth;
   }
   public String getDeath() {
      return death;
   }
   public void setDeath(String death) {
      this.death = death;
   }
   
}

public class pet_Create {

   public static void main(String[] args) {
      Connection conn = new DBConnect().getConn();
      PreparedStatement pstmt = null;
      
      BufferedReader typein = new BufferedReader(new InputStreamReader(System.in)); 
      
      try {
         String sql = "insert into pet(name, owner, species, sex, birth, death) values(?,?,?,?,?,?)";
         pstmt = conn.prepareStatement(sql);
         System.out.println("추가할 펫의 이름");
         String name = typein.readLine();
         pstmt.setString(1, name);
         
         System.out.println("추가할 펫의 주인");
         String owner = typein.readLine();
         pstmt.setString(2, owner);
         
         System.out.println("추가할 펫의 종");
         String species = typein.readLine();
         pstmt.setString(3, species);
         
         System.out.println("추가할 펫의 성별");
         String sex = typein.readLine();
         pstmt.setString(4, sex);
         
         System.out.println("추가할 펫의 Birth");
         String birth = typein.readLine();
         pstmt.setString(5, birth);
         
         System.out.println("추가할 펫의 Death");
         String death = typein.readLine();
         pstmt.setString(6, death);
         
         pstmt.executeUpdate();
         System.out.println("회원정보를 저장했습니다.");
         
       }catch(Exception e) {
          e.printStackTrace();
       }finally {
          try {
             if(conn!=null) conn.close();
             if(pstmt!=null) pstmt.close();

          }catch(Exception e) {}
       }

    }
 }