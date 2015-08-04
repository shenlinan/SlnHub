package com.readMdb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BaseDao {
	String url = "jdbc:mysql://127.0.0.1:3306/fu_ethics?useUnicode=true&characterEncoding=utf8&zeroDateTimeBehavior=convertToNull&transformedBitIsBoolean=true";
	String user = "";
	String password = "";
	Connection conn = null;
	PreparedStatement pst = null;
	ResultSet rs = null;
	static {
		/** 加载驱动 */
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	/** 建立连接 */
	public void open() {
		try {
			conn = DriverManager.getConnection(url, user, password);
//			System.out.println("连接成功...");
		} catch (SQLException e) {
//			System.out.println("连接失败...");
			e.printStackTrace();
		}
	}

	/** 查询 */
	public ResultSet findSql(String sql) {
		try {
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}

	/** 增删改 */
	public int execSql(String sql) {
		int count = 0;
		try {
			pst = conn.prepareStatement(sql);
			count = pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}

	/** 关闭资源 */
	public void close() {
		try {
			if (rs != null) {
				rs.close();
			}
			if (pst != null) {
				pst.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
