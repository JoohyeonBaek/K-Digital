package com.dbcp;

import java.sql.Connection;
import javax.naming.*;
import javax.sql.*;

public class DbcpBean {
		private Connection conn;
		public DbcpBean() {
			try {
				Context initContext = new InitialContext();
				Context envContext = (Context)initContext.lookup("java:/comp/env");
				DataSource ds = (DataSource)envContext.lookup("jdbc/mariaconn");
				conn = ds.getConnection();
				System.out.println("DbcpBean 작업성공!");
			} catch(Exception e) {
				e.printStackTrace();
				System.out.println("fail");
			}
		}
		
		public Connection getConn() { return conn; }
}
