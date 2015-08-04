package com.readMdb;

import java.util.ArrayList;
import java.util.List;

public class ReadMdb {

	public static void main(String[] args) {
		List<EmpBean> list = new ArrayList<EmpBean>();
		ReadAccessFile raf = new ReadAccessFile();
		try {
			list = raf.ConnectAccessFile();
		} catch (Exception e) {
			e.printStackTrace();
		}
		InsertIntoMysql iim = new InsertIntoMysql();
		iim.insertInfos(list);
	}
}
