package ususunmoon;
import java.sql.*;

import tsunmoon.DBConnect;

import java.io.*;
public class t_image {

	public static void main(String[] args) {
		Connection conn = new DBConnect().getConn();
		try {
			PreparedStatement ps = conn.prepareStatement("insert into imagetable values(?,?)");
			ps.setString(1, "���̹���");
			FileInputStream fin = new FileInputStream("C://Users//qorwn//Desktop//����//��Ÿ�ڷ�/������_�������.jpg");
			// 2���� ������ => �޸� �ִ� ������ �״�� ����
			ps.setBinaryStream(2, fin, fin.available());
			int i = ps.executeUpdate();
			System.out.println(i + "���� �̹��� ����Ϸ�");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

}
