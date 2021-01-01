package usunmoon;
import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnect_20201231 {
	private Connection conn;
	
	public DBConnect_20201231() {
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			String url = "jdbc:mariadb://127.0.0.1:3306/sungjuk_test";
			conn = DriverManager.getConnection(url,"root","*****");
			System.out.println("Maria DB 가 정상적으로 연결되었습니다.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public Connection getConn() {
		return conn;
	}
}
