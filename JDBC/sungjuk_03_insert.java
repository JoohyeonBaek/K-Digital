package ususunmoon;
import java.sql.*;
import java.util.*;

import tsunmoon.DBConnect;

/*
 * ����
 * name, kor, mat, eng, schoolcode �Է¹ް�
 * �Է��� �����͸� Ű���忡�� �Է¹ް�
 * student_insert procedure�� �̿��ؼ� �����͸� �Է��ϰ�
 * result���� Ȯ���ؼ� ��� ���� �ùٸ� ��Ʈ�� ��µǵ��� ���
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
				System.out.println("������ ���� ����");
			else
				System.out.println("������ ���� ����");
			
			int result = stmt.getInt(6);
			if(result == 0)
				System.out.println("����");
			else if(result == -1) 
				System.out.println("����");			
			else 
				System.out.println("�ش��ϴ� �����Ͱ� �����ϴ�");			
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
