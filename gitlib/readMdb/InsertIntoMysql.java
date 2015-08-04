package com.readMdb;

import java.util.List;

public class InsertIntoMysql extends BaseDao {

	public void insertInfos(List<EmpBean> list) {
		super.open();
		for (int i = 0; i < list.size(); i++) {
			if(list.get(i).getName()!=null){
				String sql = "insert into fu_ethics.empInfo values('"
						+ list.get(i).getId() + "','"
						+ list.get(i).getName_spell() + "','"
						+ list.get(i).getName().replace(" ", "") + "','"
						+ list.get(i).getSex() + "','"
						+ list.get(i).getBirth() + "','"
						+ list.get(i).getWork_time() + "','"
						+ list.get(i).getXueli() + "','"
						+ list.get(i).getJob() + "','"
						+ list.get(i).getDept() + "')";
//				System.out.println(sql + ";");
				super.execSql(sql);
			}else{
				String sql = "insert into fu_ethics.empInfo values('"
						+ list.get(i).getId() + "','"
						+ list.get(i).getName_spell() + "','"
						+ list.get(i).getName() + "','"
						+ list.get(i).getSex() + "','"
						+ list.get(i).getBirth() + "','"
						+ list.get(i).getWork_time() + "','"
						+ list.get(i).getXueli() + "','"
						+ list.get(i).getJob() + "','"
						+ list.get(i).getDept() + "')";
//				System.out.println(sql + ";");
				super.execSql(sql);
			}
		}
		System.out.println("插入完成！");
		super.close();
	}

}
