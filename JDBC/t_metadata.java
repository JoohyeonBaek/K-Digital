package ususunmoon;
import java.sql.*;

import tsunmoon.DBConnect;

import java.io.*;

public class t_metadata {

	public static void main(String[] args) {
		try {
			Connection conn = new DBConnect().getConn();
			DatabaseMetaData dbmd = conn.getMetaData();		// 데이터 베이스 정보 확인 (메타데이타)
			
			System.out.println("드라이버 이름: " + dbmd.getDriverName());
			System.out.println("드라이버 버전" + dbmd.getDriverVersion());
			System.out.println("사용자" + dbmd.getUserName());
		} catch(Exception e) {
			e.printStackTrace();
		}

	}

}
