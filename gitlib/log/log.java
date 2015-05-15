package com.log;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

public class log {
	private String path = "/home/";
	private String filename = "";

	// 获取当前时间
	public String getNowTime() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sdf.format(new Date());
	}

	// 获取当前日期
	public String getNowDate() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return sdf.format(new Date());
	}

	// 初始化
	public void init() {
		File f = new File(path);
		if (!f.exists()) {
			f.mkdirs();
		}
		String date = this.getNowDate();
		this.filename = path + "log_" + date + ".log";
		File ff = new File(filename);
		if (!ff.exists()) {
			try {
				ff.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	// 记录
	public void record(String msg) {
		init();
		//
		String temp = "";
		try {
			File file = new File(filename);
			if (file.exists()) {
				FileInputStream fis = new FileInputStream(file);
				InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
				BufferedReader br = new BufferedReader(isr);
				StringBuffer sb = new StringBuffer();
				temp = br.readLine();
				while (temp != null) {
					sb = sb.append(temp);
					sb = sb.append(System.getProperty("line.separator"));// 换行
					temp = br.readLine();
				}
				sb = sb.append(this.getNowTime());
				sb = sb.append(" : ");
				sb = sb.append(msg);
				sb = sb.append(System.getProperty("line.separator"));// 换行
				br.close();
				//
				FileOutputStream fos = new FileOutputStream(file);
				BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(
						fos, "UTF-8"));
				bw.write(sb.toString());
				bw.flush();
				bw.close();
				isr.close();
				fis.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
