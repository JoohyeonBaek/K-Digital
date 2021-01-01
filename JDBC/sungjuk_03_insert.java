package ususunmoon;
import java.sql.*;
import java.util.*;

import tsunmoon.DBConnect;

/*
 * 문제
 * name, kor, mat, eng, schoolcode 입력받고
 * 입력할 데이터를 키보드에서 입력받고
 * student_insert procedure를 이용해서 데이터를 입력하고
 * result값을 확인해서 경우 마다 올바른 멘트가 출력되도록 출력
 */
public class sungjuk_03_insert {
	public static void main(String[] args) {
		Connection con = new DBConnect().getConn();
		CallableStatement stmt = null;
		Scanner sc = new Scanner(System.in);
		
		String name = sc.next();
		int kor = sc.nextInt();
		int mat = sc.nextInt();
		int eng = sc.nextInt();
		String schoolcode = sc.next();		
		
		try {
			String sql = "call student_insert(?,?,?,?,?,?)";
			stmt = con.prepareCall(sql);
			stmt.setString(1,name);
			stmt.setInt(2,kor);
			stmt.setInt(3,mat);
			stmt.setInt(4,eng);
			stmt.setString(5,schoolcode);
			stmt.registerOutParameter(6, java.sql.Types.INTEGER);
			int affectedrowcount = stmt.executeUpdate();
			if(affectedrowcount>0)
				System.out.println("데이터 삽입 성공");
			else
				System.out.println("데이터 삽입 실패");
			
			int result = stmt.getInt(6);
			if(result == 0)
				System.out.println("성공");
			else if(result == -1) 
				System.out.println("실패");			
			else 
				System.out.println("해당하는 데이터가 없습니다");			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(stmt!=null) stmt.close();
				if(con!=null) stmt.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
}
