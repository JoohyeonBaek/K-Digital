package ususunmoon;
import java.sql.*;

import tsunmoon.DBConnect;

import java.io.*;

public class t_metadata {

	public static void main(String[] args) {
		try {
			Connection conn = new DBConnect().getConn();
			DatabaseMetaData dbmd = conn.getMetaData();		// ������ ���̽� ���� Ȯ�� (��Ÿ����Ÿ)
			
			System.out.println("����̹� �̸�: " + dbmd.getDriverName());
			System.out.println("����̹� ����" + dbmd.getDriverVersion());
			System.out.println("�����" + dbmd.getUserName());
		} catch(Exception e) {
			e.printStackTrace();
		}

	}

}
