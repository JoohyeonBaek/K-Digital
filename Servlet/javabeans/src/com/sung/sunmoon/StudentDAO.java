package com.sung.sunmoon;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import com.dbcp.*;

public class StudentDAO {
	private Connection conn;

	public static Connection getConnection() {
		Connection conn;

		conn = new DbcpBean().getConn();
		return conn;
	}

	public static ArrayList<StudentDTO> getRecords(int start, int total) {
		ArrayList<StudentDTO> list = new ArrayList<StudentDTO>();
		Connection conn = getConnection();
		CallableStatement stmt = null;
		String query = "call call_all";
		try {
			stmt = conn.prepareCall(query);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				StudentDTO dto = new StudentDTO();
				dto.setBunho(rs.getInt(1));
				dto.setName(rs.getString(2));
				dto.setKor(rs.getInt(3));
				dto.setMat(rs.getInt(4));
				dto.setEng(rs.getInt(5));
				dto.setTotal(rs.getInt(6));
				dto.setAvg(rs.getFloat(7));
				dto.setGrade(rs.getString(8));
				dto.setSchoolCode(rs.getString(9));
				list.add(dto);
			}
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;

	}

	public boolean insert_student(StudentDTO dto) throws ServletException {
		Connection conn = getConnection();
		CallableStatement stmt = null;
		String query = "call student_insert(?,?,?,?,?,?)";
		try {
			stmt = conn.prepareCall(query);
			stmt.setString(1, dto.getName());
			stmt.setInt(2, dto.getKor());
			stmt.setInt(3, dto.getEng());
			stmt.setInt(4, dto.getMat());
			stmt.setString(5, dto.getSchoolCode());
			stmt.registerOutParameter(6, java.sql.Types.INTEGER);
			stmt.execute();

			int result = stmt.getInt(6);
			if (result == 0)
				System.out.println("성공!");
			else if (result == -1)
				System.out.println("등록 실패");
			else
				System.out.println("정상적인 접근이 아닙니다.");

			stmt.close();
		} catch (SQLException ex) {
			throw new ServletException("a");
		} finally {
			try {
				conn.close();
			} catch (SQLException ex) {
				throw new ServletException("a");
			}
		}
		return true;
	}

	public boolean update_student(StudentDTO dto) throws ServletException {
		Connection conn = getConnection();
		CallableStatement stmt = null;
		String sql = "call student_update(?,?,?,?,?,?)";
		try {

			stmt = conn.prepareCall(sql);

			stmt.setInt(1, dto.getBunho());
			stmt.setString(2, dto.getName());
			stmt.setInt(3, dto.getKor());
			stmt.setInt(4, dto.getMat());
			stmt.setInt(5, dto.getEng());
			stmt.registerOutParameter(6, java.sql.Types.INTEGER);

			stmt.executeUpdate();
			System.out.println("?");
			stmt.execute();
			stmt.close();

		} catch (SQLException ex) {
			throw new ServletException("수정 실패   ");
		} finally {
			this.close();
		}
		return true;
	}

	public boolean delete_student(StudentDTO dto) throws ServletException {
		Connection conn = getConnection();
		CallableStatement stmt = null;
		String query = "call student_delete(?,?)";
		try {
			stmt = conn.prepareCall(query);
			stmt.setInt(1, dto.getBunho());
			stmt.registerOutParameter(2, java.sql.Types.INTEGER);
			stmt.executeUpdate();
			stmt.execute();
			stmt.close();
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
