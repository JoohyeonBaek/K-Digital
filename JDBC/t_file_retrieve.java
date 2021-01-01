package ususunmoon;
import java.sql.*;

import tsunmoon.DBConnect;

import java.io.*;

public class t_file_retrieve {

	public static void main(String[] args) {
		try {
			Connection conn = new DBConnect().getConn();
			PreparedStatement ps = conn.prepareStatement("select * from filetable");
			ResultSet rs = ps.executeQuery();
			rs.next();
			Clob c = rs.getClob(2);
			Reader r = c.getCharacterStream();
			FileWriter fw = new FileWriter("C://Users//qorwn//Desktop//주현//K-Digital//DB/test2.txt");
			int i;
			while((i=r.read()) != -1) {
				fw.write((char)i);
			}
				
				fw.close();
				conn.close();
				System.out.println("파일 다운로드 성공");
		} catch(Exception e) {
				e.printStackTrace();
		}
	}

}


