
import java.util.*;
import java.io.*;

public class C_08_Properties {

   public static void main(String[] args) throws Exception {
      Properties prop = new Properties();
      prop.setProperty("timeout", "30");
      prop.setProperty("language", "kr");
      prop.setProperty("size", "10");
      prop.setProperty("capacity", "10");
      Enumeration e = prop.propertyNames();
      while(e.hasMoreElements()) {
         String element = (String)e.nextElement();
         System.out.println(element + "=" +prop.getProperty(element));
      }
      prop.setProperty("size", "20");
      System.out.println("size" + prop.getProperty("size"));
      prop.store(new FileWriter("info.properties"), "test");
      
      Properties sysProp = System.getProperties();
      System.out.println("java.version :" + 
            sysProp.getProperty("java.version"));
      System.out.println("user.lauguage :" + 
            sysProp.getProperty("user.language"));
      sysProp.list(System.out);

   }

}