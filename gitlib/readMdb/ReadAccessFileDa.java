package com.readMdb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class ReadAccessFileDa {
	/**
	 * 档案信息
	 * @return
	 * @throws Exception
	 */
	public List<DaBean> ConnectAccessFile() throws Exception {
		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		/**
		 * 直接连接access文件。
		 */
		Properties prop = new Properties();
		prop.put("charSet", "gb2312");
		prop.put("user", "");
		prop.put("password", "");
		String dbur1 = "jdbc:odbc:driver={Microsoft Access Driver (*.mdb)};DBQ=c://ydda.mdb";
		Connection conn = DriverManager.getConnection(dbur1, prop);
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("select * from 档案");
		List<DaBean> list = new ArrayList<DaBean>();
		DaBean dbean = null;
		while (rs.next()) {
			dbean = new DaBean();
			dbean.setId(rs.getString(1));
			dbean.setEmp_id(rs.getString(2));
			dbean.setDate(rs.getString(3));
			dbean.setDaxx(rs.getString(4));
			list.add(dbean);
		}
		rs.close();
		stmt.close();
		conn.close();
		return list;
	}
}
