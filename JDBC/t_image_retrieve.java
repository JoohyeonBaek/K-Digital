package ususunmoon;
import java.sql.*;

import tsunmoon.DBConnect;

import java.io.*;;

public class t_image_retrieve {
	
	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = new DBConnect().getConn();
			ps = conn.prepareStatement("select * from imagetable");
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				Blob b = rs.getBlob(2);
				byte barr[] = b.getBytes(1, (int) b.length());
				
				FileOutputStream fout = new FileOutputStream("C://Users//qorwn//Desktop//����//��Ÿ�ڷ�/����_�������.jpg");
				System.out.println("�̹��� ���� �ٿ�Ϸ�");
				fout.write(barr);
				fout.close();
				
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		
	}

}
