package com.accident.mariadb;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import com.dbcp.DbcpBean;

public class AccidentDAO {
	private Connection conn;

	public static Connection getConnection() {
		Connection conn;

		conn = new DbcpBean().getConn();
		return conn;
	}

	public ArrayList<AccidentDTO> allAccident() throws ServletException {
		Connection conn = getConnection();
		ArrayList<AccidentDTO> vec = new ArrayList<AccidentDTO>();
		String query = "select year, accident from trafficaccident";
		try {
			PreparedStatement pstmt = conn.prepareStatement(query);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				AccidentDTO at = new AccidentDTO();
				at.setYear(rs.getInt("year"));
				at.setAccident(rs.getInt("accident"));
				vec.add(at);
			}
			rs.close();
			pstmt.close();
		} catch (SQLException ex) {
			throw new ServletException("fail");
		} finally {
			this.close();
		}
		return vec;
	}

	public ArrayList<AccidentDTO> allDeath() throws ServletException {
		Connection conn = getConnection();
		ArrayList<AccidentDTO> vec = new ArrayList<AccidentDTO>();
		String query = "SELECT year,death FROM trafficaccident";
		try {
			PreparedStatement pstmt = conn.prepareStatement(query);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				AccidentDTO ad = new AccidentDTO();
				ad.setYear(rs.getInt("year"));
				ad.setDeath(rs.getInt("death"));
				vec.add(ad);
			}
			rs.close();
			pstmt.close();
		} catch (SQLException ex) {
			throw new ServletException("선택 실패");
		} finally {
			this.close();
		}
		return vec;
	}

	public static ArrayList<AccidentDTO> selectAccident(int year) {
	      ArrayList<AccidentDTO> list=new ArrayList<AccidentDTO>();
	      try{
	         Connection con=getConnection();
	         PreparedStatement ps=con.prepareStatement("select * from trafficaccident where year =" + year);
	         ResultSet rs=ps.executeQuery();
	         while(rs.next()){
	            AccidentDTO e=new AccidentDTO();
	            e.setYear(rs.getInt(1));
	            e.setAccident(rs.getInt(2));
	            e.setDeath(rs.getInt(3));
	            e.setInjury(rs.getInt(4));
	            list.add(e);
	         }
	      }catch(Exception e){System.out.println(e);}
	      return list;
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
