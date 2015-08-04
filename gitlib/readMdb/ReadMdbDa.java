package com.readMdb;

import java.util.ArrayList;
import java.util.List;

public class ReadMdbDa {

	public static void main(String[] args) {
		List<DaBean> list = new ArrayList<DaBean>();
		ReadAccessFileDa raf = new ReadAccessFileDa();
		try {
			list = raf.ConnectAccessFile();
		} catch (Exception e) {
			e.printStackTrace();
		}
		InsertIntoMysqlDa iim = new InsertIntoMysqlDa();
		iim.insertInfos(list);
	}
}
