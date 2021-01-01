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
					System.out.println("이름: " + name);
				}
				isResultset = stmt.getMoreResults();
				if(!isResultset) {
					System.out.println("두번째 결과는 ResultSet이 아닙니다");
				}
				else 
					System.out.println("두번쨰 결과가 resultSet입니다");
				rs=stmt.getResultSet();
				while(rs.next()) {
					String name = rs.getString("name");
					int kor = rs.getInt("kor");
					int mat = rs.getInt("mat");
					int eng = rs.getInt("eng");
					if(name!=null) {
						System.out.println("이름: " + name);
				}
			}
		} catch(Exception e) {
			e.printStackTrace();
		}

	}

}
