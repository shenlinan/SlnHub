package com.readMdb;

import java.util.List;

public class InsertIntoMysqlDa extends BaseDao {

	public void insertInfos(List<DaBean> list) {
		int count = 0;
		super.open();
		for (int i = 0; i < list.size(); i++) {
			String newDaxx = changeDaxx(list.get(i).getDaxx());
			String sql = "insert into fu_ethics.datemp values('"
					+ list.get(i).getId() + "','" + list.get(i).getEmp_id()
					+ "','" + list.get(i).getDate() + "','" + newDaxx + "')";
			System.out.println(sql + ";");
			super.execSql(sql);
			count += 1;
		}
		System.out.println("插入完成！共" + count + "条！");
		super.close();
	}

	public String changeDaxx(String daxx) {
		String daxxTemp = "";
		if (daxx.contains("1次")) {
			daxxTemp = daxx.replace("1次", "一次");
		} else if (daxx.contains("2次")) {
			daxxTemp = daxx.replace("2次", "二次");
		} else if (daxx.contains("3次")) {
			daxxTemp = daxx.replace("3次", "三次");
		} else if (daxx.contains("4次")) {
			daxxTemp = daxx.replace("4次", "四次");
		} else if (daxx.contains("5次")) {
			daxxTemp = daxx.replace("5次", "五次");
		} else if (daxx.contains("6次")) {
			daxxTemp = daxx.replace("6次", "六次");
		} else if (daxx.contains("7次")) {
			daxxTemp = daxx.replace("7次", "七次");
		} else if (daxx.contains("8次")) {
			daxxTemp = daxx.replace("8次", "八次");
		} else if (daxx.contains("9次")) {
			daxxTemp = daxx.replace("9次", "九次");
		} else if (daxx.contains("10次")) {
			daxxTemp = daxx.replace("10次", "十次");
		}else if (daxx.contains("1面")) {
			daxxTemp = daxx.replace("1面", "一面");
		} else if (daxx.contains("2面")) {
			daxxTemp = daxx.replace("2面", "二面");
		} else if (daxx.contains("3面")) {
			daxxTemp = daxx.replace("3面", "三面");
		} else if (daxx.contains("4面")) {
			daxxTemp = daxx.replace("4面", "四面");
		} else if (daxx.contains("1封")) {
			daxxTemp = daxx.replace("1封", "一封");
		} else if (daxx.contains("2封")) {
			daxxTemp = daxx.replace("2封", "二封");
		} else if (daxx.contains("3封")) {
			daxxTemp = daxx.replace("3封", "三封");
		} else if (daxx.contains("4封")) {
			daxxTemp = daxx.replace("4封", "四封");
		}else{
			daxxTemp = daxx;
		} 
		return daxxTemp;
	}
}
