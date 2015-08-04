package com.readMdb;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ListDaxx extends BaseDao {
	ResultSet rs = null;

	/**
	 * 根据条件查询出档案信息
	 * 
	 * @param dainfo
	 * @return
	 */
	public List<DaBean> listDaxx(String dainfo) {
		List<DaBean> list = new ArrayList<DaBean>();
		super.open();
		String sql = "select e.real_id,d.date,d.daxx,e.dept,de.unique_department_id as uni_id,de.name as de_name from fu_ethics.datemp d left join fu_ethics.empinfo e on d.emp_id = e.id left join fu_base.employee ee on e.real_id = ee.unique_employee_id left join fu_base.department de on de.unique_department_id = ee.unique_department_id where e.real_id is not null and daxx like '%锦旗%' and (daxx like '%科%' or daxx like '%区%' or daxx like '%内%' or daxx like '%外%' or daxx like '%全体%'or daxx like '%康复%' or daxx like '%护理%' or daxx like '%特需%' or daxx like '%中西%')";
		rs = super.findSql(sql);
		DaBean dbean = null;
		try {
			while (rs.next()) {
				dbean = new DaBean();
				dbean.setEmp_id(rs.getString("uni_id"));
				dbean.setDate(rs.getString("date"));
				dbean.setDaxx(rs.getString("daxx"));
				list.add(dbean);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	/**
	 * 根据不同情况插入fu_ethics.redbag表中
	 */
	public int insertIntoTable(String emp_id, String money, String time,
			String daxx) {
		super.open();
		String sql = "insert into fu_ethics.redbag(emp_id,program_title,money,handle_time,remark) values ('"
				+ emp_id
				+ "','24','"
				+ money
				+ "','"
				+ time
				+ "','"
				+ daxx
				+ "')";
		int num = super.execSql(sql);
		return num;
	}

	/**
	 * 根据不同情况插入fu_ethics.jinbian表中
	 */
	// 还未完成
	public int insertIntoJb(String emp_id, String time, String daxx) {
		super.open();
		String sql = "insert into fu_ethics.jinbian_dept(receiver,type,add_time) values ('"
				+ emp_id + "','1','" + time + "')";
		int num = super.execSql(sql);
		return num;
	}
}
