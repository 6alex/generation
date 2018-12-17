package com.idp.common.util;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import com.alibaba.druid.util.JdbcUtils;

public class ExecuteSql {

	private static String driver;
	private static String url;
	private static String user;
	private static String pass;
	private static Connection conn;
	private static Statement stmt;
	static {
		try {
			initParam("dbconfig.properties");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void initParam(String paramFile) throws Exception {
		Properties props = new Properties();
		InputStream resourceAsStream = ExecuteSql.class.getClassLoader().getResourceAsStream(paramFile);
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

	public static List<Map<String, Object>> query(String sql, List<Object> parameters) throws SQLException {
		return JdbcUtils.executeQuery(conn, sql, parameters);
	}

	public static int update(String sql, List<Object> parameters) throws SQLException {
		return JdbcUtils.executeUpdate(conn, sql, parameters);
	}

	public static void insert(String tableName, Map<String, Object> data) throws SQLException {
		JdbcUtils.insertToTable(conn, tableName, data);
	}

}