package ususunmoon;
import java.sql.*;

import tsunmoon.DBConnect;

import java.io.*;

public class t_file {
	public static void main(String[] args) {
		try {
			Connection conn = new DBConnect().getConn();
			PreparedStatement ps = conn.prepareStatement("insert into filetable value(?,?)");
			
			File f = new File("C://Users//qorwn//Desktop//����//K-Digital//DB/test.txt");
			FileReader fr = new FileReader(f);
			
			ps.setInt(1, 100);
			ps.setCharacterStream(2,fr, (int)f.length());
			int i = ps.executeUpdate();
			System.out.println(i + "���� ����Ϸ�");
			
			conn.close();
			ps.close();
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			
		}

	}

}
