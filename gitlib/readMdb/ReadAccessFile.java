package com.readMdb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class ReadAccessFile {
	/**
	 * 个人档案
	 * 
	 * @return
	 * @throws Exception
	 */
	public List<EmpBean> ConnectAccessFile() throws Exception {
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
		ResultSet rs = stmt.executeQuery("select * from 个人信息");
		List<EmpBean> list = new ArrayList<EmpBean>();
		EmpBean empbean = null;
		while (rs.next()) {
			empbean = new EmpBean();
			empbean.setId(rs.getString(1));
			empbean.setName_spell(rs.getString(2));
			empbean.setName(rs.getString(3));
			empbean.setSex(rs.getString(4));
			empbean.setBirth(rs.getString(5));
			empbean.setWork_time(rs.getString(6));
			empbean.setXueli(rs.getString(7));
			empbean.setJob(rs.getString(8));
			empbean.setDept(rs.getString(9));
			list.add(empbean);
		}
		rs.close();
		stmt.close();
		conn.close();
		return list;
	}
}
