package ususunmoon;
import java.sql.*;

import tsunmoon.DBConnect;

import java.io.*;
public class t_image {

	public static void main(String[] args) {
		Connection conn = new DBConnect().getConn();
		try {
			PreparedStatement ps = conn.prepareStatement("insert into imagetable values(?,?)");
			ps.setString(1, "곰이미지");
			FileInputStream fin = new FileInputStream("C://Users//qorwn//Desktop//주현//기타자료/백주현_증명사진.jpg");
			// 2진수 데이터 => 메모리 있는 내용을 그대로 저장
			ps.setBinaryStream(2, fin, fin.available());
			int i = ps.executeUpdate();
			System.out.println(i + "행의 이미지 저장완료");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

}
