package com.readMdb;

import java.util.ArrayList;
import java.util.List;

public class AddNewDaxx {

	public static void main(String[] args) {
		StringManage sm = new StringManage();
		String money = "";
		int errCount = 0;
		List<DaBean> list = new ArrayList<DaBean>();
		ListDaxx lda = new ListDaxx();
		list = lda.listDaxx("收红包");
		for (int i = 0; i < list.size(); i++) {
			// System.out.println(list.get(i).getDaxx());
			// if (sm.hasDigit(list.get(i).getDaxx())) {
			// money = sm.getNumbers(list.get(i).getDaxx());
			// } else {
			// money = "0";
			// }
			int num = lda.insertIntoJb(list.get(i).getEmp_id(), list.get(i)
					.getDate(), list.get(i).getDaxx());
			if (num != 1) {
				errCount += 1;
			}
			System.out.println("正在执行第" + (i + 1) + "个...");
		}
		System.out.println("插入完成，失败次数为：" + errCount);
	}
}
