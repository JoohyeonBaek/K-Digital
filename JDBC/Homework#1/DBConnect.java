package tsunmoon;
import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnect {
	private Connection conn;
	
	public DBConnect() {
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			String url = "jdbc:mariadb://127.0.0.1:3306/sungjuk_test";
			conn = DriverManager.getConnection(url,"root","*****");
			System.out.println("Maria DB �� ���������� ����Ǿ����ϴ�.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public Connection getConn() {
		return conn;
	}
}
