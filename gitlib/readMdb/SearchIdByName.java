package com.readMdb;

import java.util.ArrayList;
import java.util.List;

public class SearchIdByName {

	public static void main(String[] args) {
		List<EmpBean> list = new ArrayList<EmpBean>();
		ListEmps le = new ListEmps();
		list = le.listEmps();
		int errCount = 0;
		System.out.println("共" + list.size() + "条------------");
		for (int i = 0; i < list.size(); i++) {
			if (le.listByName(list.get(i).getName()) == 1) {
				if (le.listeeByName(list.get(i).getName()) == 1) {
					int num = le.updIntoEmp(list.get(i).getName(), le
							.listInfoByName(list.get(i).getName()).getId());
					if (num != 1) {
						System.out.println(list.get(i).getName());
						errCount += 1;
					}
				}
			}
			System.out.println("已经处理到第" + (i + 1) + "条--------------");
		}
		System.out.println("插入失败：" + errCount);
	}
}
