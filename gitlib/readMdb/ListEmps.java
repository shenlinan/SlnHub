package com.readMdb;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ListEmps extends BaseDao {
	ResultSet rs = null;

	/**
	 * 查询empinfo
	 * 
	 * @return
	 */
	public List<EmpBean> listEmps() {
		super.open();
		String sql = "select * from fu_ethics.empinfo";
		rs = super.findSql(sql);
		List<EmpBean> list = new ArrayList<EmpBean>();
		EmpBean emp = null;
		try {
			while (rs.next()) {
				emp = new EmpBean();
				emp.setId(rs.getString("id"));
				emp.setName(rs.getString("name"));
				list.add(emp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	/**
	 * 查询empinfo表,查看人员名称是否重复
	 */
	public int listByName(String name) {
		super.open();
		String sql = "select count(*) as count from fu_ethics.empinfo where name = '"
				+ name + "'";
		rs = super.findSql(sql);
		int count = 0;
		try {
			while (rs.next()) {
				count = rs.getInt("count");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}

	/**
	 * 查询employee表,查看人员名称是否重复
	 */
	public int listeeByName(String name) {
		super.open();
		String sql = "select count(*) as count from fu_base.employee where real_name = '"
				+ name + "'";
		rs = super.findSql(sql);
		int count = 0;
		try {
			while (rs.next()) {
				count = rs.getInt("count");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}

	/**
	 * 查询employee表,id
	 */
	public EmpBean listInfoByName(String name) {
		super.open();
		String sql = "select * from fu_base.employee where real_name = '"
				+ name + "'";
		rs = super.findSql(sql);
		EmpBean emp = new EmpBean();
		try {
			while (rs.next()) {
				emp.setId(rs.getString("unique_employee_id"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return emp;
	}

	/**
	 * empinfo表插入unique_id
	 */
	public int updIntoEmp(String name, String id) {
		super.open();
		String sql = "update fu_ethics.empinfo set real_id = '" + id
				+ "' where name = '" + name + "'";
		int count = super.execSql(sql);
		return count;
	}
}
