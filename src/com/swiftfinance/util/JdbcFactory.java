package com.swiftfinance.util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public final class JdbcFactory {

	private JdbcFactory(){
		
	}
	public static Connection getCon() throws SQLException{
		
		
		try {
			Context initContext = new InitialContext();
			Context envContext = (Context) initContext.lookup("java:/comp/env");
			DataSource ds = (DataSource) envContext.lookup("jdbc/mssql");
			Connection conn = ds.getConnection();
			return conn;
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			throw new SQLException(e);
		}

		/*
		 * String url =
		 * "jdbc:microsoft:sqlserver://DIGITELT146;DatabaseName=swiftfinance";
		 * Connection con = null; try {
		 * 
		 * Class.forName("com.microsoft.jdbc.sqlserver.SQLServerDriver"); con =
		 * DriverManager.getConnection(url, "sa", "sa"); return con;
		 * 
		 * } catch (ClassNotFoundException | SQLException e) { throw new SQLException();
		 * }
		 */
		 
		
		
		/*
		 * String url = "jdbc:oracle:thin:@localhost:1521:xe"; Connection con = null;
		 * try {
		 * 
		 * Class.forName("oracle.jdbc.OracleDriver"); con =
		 * DriverManager.getConnection(url, "vishal", "oracle"); return con;
		 * 
		 * } catch (ClassNotFoundException | SQLException e) { throw new SQLException();
		 * }
		 */
	}
}
