package usunmoon;
import java.sql.*;

public class Sungjuk_print {

	public static void main(String[] args) {
		Connection con = new DBConnect_20201231().getConn();
		CallableStatement stmt = null;
		
		try {
			stmt = con.prepareCall("{call call_all()}");
			ResultSet rs = stmt.executeQuery();
			System.out.println("bunho\tname\tkor\tmat\teng\ttotal\taverage\tgrade\tschoolcode");
			while(rs.next()) {
				int bunho = rs.getInt("bunho");
				String name = rs.getString("name");
				int kor = rs.getInt("kor");
				int mat = rs.getInt("mat");
				int eng = rs.getInt("eng");
				int total = rs.getInt("total");
				float average = rs.getFloat("average");
				String grade = rs.getString("grade");
				String schoolcode = rs.getString("SchoolCode");
								
				if(name!=null) {
					System.out.println(bunho + "\t" + name + "\t" + kor + "\t" + mat + "\t" + eng + "\t" + total + "\t" + average + "\t" + grade + "\t" + schoolcode);
				}
			}
		} catch (Exception e) {
				e.printStackTrace();
		} finally {
				try {
					stmt.close();
					con.close();
				} catch(SQLException e) {
					e.printStackTrace();
				}
		}

	}

}
