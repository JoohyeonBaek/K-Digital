package ususunmoon;
import java.sql.*;
import java.util.*;

import tsunmoon.DBConnect;
public class sungjuk_04_delete {
	public static void main(String[] args) {
		Connection con = new DBConnect().getConn();
		CallableStatement stmt = null;
		Scanner sc = new Scanner(System.in);
		String name = sc.nextLine();
		
		try {
			String sql = "call student_delete(?,?)";
			stmt = con.prepareCall(sql);
			stmt.setString(1, name);
			stmt.registerOutParameter(2, java.sql.Types.INTEGER);
			int affectedrowcount = stmt.executeUpdate();
//			if(affectedrowcount>0)
//				System.out.println("������ ���� ����");
//			else
//				System.out.println("������ ���� ����");
			
			int result = stmt.getInt(2);
			if(result==0) 
				System.out.println("����");			
			else
				System.out.println("����");
		} catch(Exception e) {
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
