package ususunmoon;
import java.sql.*;

import tsunmoon.DBConnect;

public class sungjuk_02_update {
	public static void main(String[] args) {
		Connection conn = new DBConnect().getConn();
		int no = 1;
		String name = "김종호";
		int kor = 100;
		int mat = 100;
		int eng = 100;
		
		CallableStatement pstmt = null;
		try {
			String sql = "call student_update(?,?,?,?,?,?)";
			pstmt = conn.prepareCall(sql);
			pstmt.setInt(1, no);
			pstmt.setString(2, name);
			pstmt.setInt(3, kor);
			pstmt.setInt(4, mat);
			pstmt.setInt(5, eng);
			pstmt.registerOutParameter(6,java.sql.Types.INTEGER);	// return받을 데이터 타입 지정
			int affectedrowcount = pstmt.executeUpdate();
			if(affectedrowcount>0)
				System.out.println("데이터 수정 성공");
			else
				System.out.println("데이터 수정 실패");
			
			int result = pstmt.getInt(6);	// stored procedure에서 리턴한 값 확인 (result)
			if(result==0)
				System.out.println("성공");
			else if(result == -1)
				System.out.println("실패");
			else if(result == 2)
				System.out.println("해당하는 데이터가 없습니다");
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt!=null) pstmt.close();
				if(conn!=null) pstmt.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}

	}

}
