package com.idp.common.util;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Properties;

public class ExecuteDDL {

	private static String driver;
	private static String url;
	private static String user;
	private static String pass;
	private static Connection conn;
	private static Statement stmt;

	public static void initParam(String paramFile) throws Exception {
		Properties props = new Properties();
		InputStream resourceAsStream = ExecuteDDL.class.getClassLoader().getResourceAsStream(paramFile);
		props.load(resourceAsStream);
		driver = props.getProperty("jdbc.driver");
		url = props.getProperty("jdbc.url");
		user = props.getProperty("jdbc.username");
		pass = props.getProperty("jdbc.password");
	}

	public static void createTale(String sql) throws Exception {
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, pass);
			stmt = conn.createStatement();
			stmt.executeUpdate(sql);
		} finally {
			if (stmt != null) {
				stmt.close();
			}
			if (conn != null) {
				conn.close();
			}
		}
	}
}