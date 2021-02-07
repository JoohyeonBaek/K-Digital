package com.emp.mariadb;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;

public class EmpDAO {
	private Connection conn;

	public static Connection getConnection() {
		Connection con = null;
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mariadb://localhost:3306/sunmoon", "root", "22gkrsus");
		} catch (Exception e) {
			System.out.println(e);
		}
		return con;
	}

	public static ArrayList<EmpDTO> getRecords(int start, int total) {
		ArrayList<EmpDTO> list = new ArrayList<EmpDTO>();
		try {
			Connection con = getConnection();
			PreparedStatement ps = con
					.prepareStatement("select EMPNO, ENAME, SAL  from emp limit " + (start - 1) + "," + total);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				EmpDTO e = new EmpDTO();
				e.setId(rs.getInt(1));
				System.out.println(rs.getInt(1));
				e.setName(rs.getString(2));
				e.setSalary(rs.getInt(3));
				list.add(e);
			}
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return list;
	}

	public boolean registerEmp(EmpDTO dto) throws ServletException {
		Connection conn = getConnection();
		String query = "insert into emp(EMPNO, ENAME, SAL) values (?, ?, ?) ";// 번호는 자동증가
		System.out.println(dto.getId());
		try { // Statement -> PreparedStatement -> CallableStatement
			PreparedStatement pstmt = conn.prepareStatement(query); // 반복사용할 수 있도록 하여 속도를 개선한 것
			pstmt.setInt(1, dto.getId()); // Mapping
			pstmt.setString(2, dto.getName());
			pstmt.setFloat(3, dto.getSalary());
			pstmt.executeUpdate();
			pstmt.close();
			conn.close();
		} catch (SQLException ex) {
			throw new ServletException("등록 실패!");
		}
		return true;
	}

	public boolean updateEmp(EmpDTO dto) throws ServletException {
		Connection conn = getConnection();
		String query = "update emp set ENAME = ?, SAL = ? where EMPNO = ?";		
		try {
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setString(1, dto.getName());
			pstmt.setInt(2, dto.getSalary());
			pstmt.setInt(3, dto.getId());
			pstmt.executeUpdate();
		} catch (SQLException ex) {
			throw new ServletException("업데이트 실패");
		} finally {
			this.close();
		}
		return true;
	}

	public boolean deleteEmp(EmpDTO dto) throws ServletException {
		Connection con = getConnection();
		String query = "delete from emp where EMPNO = ?";
		try {
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setInt(1, dto.getId());
			pstmt.executeUpdate();
		} catch (SQLException ex) {
			throw new ServletException("삭제 실패");
		} finally {
			this.close();
		}
		return true;
	}

	private void close() {
		try {
			if (conn != null && !conn.isClosed())
				conn.close();
		} catch (SQLException ex) {
			conn = null;
		}
	}

}
