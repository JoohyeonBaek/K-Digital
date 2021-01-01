package ususunmoon;
import java.sql.*;

import tsunmoon.DBConnect;

import java.io.*;

public class sungjuk_05_multiresultset {	
	public static void main(String[] args) {
		Connection conn = new DBConnect().getConn();
		CallableStatement stmt = null;
		
		try {
			stmt = conn.prepareCall("{call student_multiresultset}");
			boolean isResultset = stmt.execute();
			ResultSet rs = stmt.getResultSet();
			while(rs.next()) {
				String name = rs.getString("name");
				int kor = rs.getInt("kor");
				int mat = rs.getInt("mat");
				int eng = rs.getInt("eng");
				if(name!=null) {
					System.out.println("�̸�: " + name);
				}
				isResultset = stmt.getMoreResults();
				if(!isResultset) {
					System.out.println("�ι�° ����� ResultSet�� �ƴմϴ�");
				}
				else 
					System.out.println("�ι��� ����� resultSet�Դϴ�");
				rs=stmt.getResultSet();
				while(rs.next()) {
					String name = rs.getString("name");
					int kor = rs.getInt("kor");
					int mat = rs.getInt("mat");
					int eng = rs.getInt("eng");
					if(name!=null) {
						System.out.println("�̸�: " + name);
				}
			}
		} catch(Exception e) {
			e.printStackTrace();
		}

	}

}
