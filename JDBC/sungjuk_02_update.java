package ususunmoon;
import java.sql.*;

import tsunmoon.DBConnect;

public class sungjuk_02_update {
	public static void main(String[] args) {
		Connection conn = new DBConnect().getConn();
		int no = 1;
		String name = "����ȣ";
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
			pstmt.registerOutParameter(6,java.sql.Types.INTEGER);	// return���� ������ Ÿ�� ����
			int affectedrowcount = pstmt.executeUpdate();
			if(affectedrowcount>0)
				System.out.println("������ ���� ����");
			else
				System.out.println("������ ���� ����");
			
			int result = pstmt.getInt(6);	// stored procedure���� ������ �� Ȯ�� (result)
			if(result==0)
				System.out.println("����");
			else if(result == -1)
				System.out.println("����");
			else if(result == 2)
				System.out.println("�ش��ϴ� �����Ͱ� �����ϴ�");
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
