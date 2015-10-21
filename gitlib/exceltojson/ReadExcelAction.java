package com.exceltojson;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class ReadExcelAction extends ActionSupport {
	private String path;
	private List<String[]> list = new ArrayList<String[]>();

	public String readExcel() {
		int rows = 0;// 总行数
		int cols = 0;// 总列数

		// path = "F:\\" + path;
		File file = new File(path);// 根据路劲获取文件
		try {
			Workbook bk = Workbook.getWorkbook(file); // 读取excel文件
			Sheet sheet = bk.getSheet(0); // 获取第一个工作表格
			rows = sheet.getRows();
			cols = sheet.getColumns();
			System.out.println("行：" + rows + ",列：" + cols);
			String[][] str = new String[rows][cols];// 定义一个二维数组
			
			for (int i = 0; i < str.length; i++) {// 读取单元格内容并存放到二维数组中
													// 默认从第一行第一列读取
				// 这里定义成数组或者里的javabean
				String[] strs = new String[cols];// 长度是cols的长度
				for (int j = 0; j < str[i].length; j++) {
					Cell cell = sheet.getCell(j, i);
					// 这里把读取的放到string数组中
					strs[j] = cell.getContents().replace(",", "").trim();
				}
				list.add(strs);
			}
			//转成json格式
			ListToJson ltj = new ListToJson();
			String exceljson = ltj.listToJson(list);
			//将转成json格式的字符串写入json文件中
			ToText tt=new ToText();
			tt.toText(exceljson);
		} catch (BiffException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return ActionSupport.SUCCESS;
	}
	
	// get&set
	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public List<String[]> getList() {
		return list;
	}

	public void setList(List<String[]> list) {
		this.list = list;
	}

}
