package ususunmoon;
import java.sql.*;
import java.util.*;

import tsunmoon.DBConnect;

public class sungjuk_01_callcall {	
	public static void main(String[] args) {
		Connection con = new DBConnect().getConn();
		CallableStatement stmt = null;
		try {
			stmt = con.prepareCall("{call call_all()}");
//			stmt = con.prepareCall("{call student_select(?)}");
//			stmt.setString(1,"고려인");
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				String name = rs.getString("sname");
				int kor = rs.getInt("kor");
				int mat = rs.getInt("mat");
				int eng = rs.getInt("eng");
//				if(name!=null) {
//					System.out.println("이름 : " + name + " 국어 : " + kor + "수학 : " + mat + "영어 : " + eng);
//				}
				SungjukDto sungjuk = new SungjukDto();
				sungjuk.setName(name);
				sungjuk.setKor(kor);
				sungjuk.setMat(mat);
				sungjuk.setEng(eng);
				
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
	



