package com.exceltojson;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

public class ToText {
	public void toText(String str) throws IOException {
		File file = new File("F://json.json");
		if (!file.exists()) {
			file.createNewFile();
		}
		@SuppressWarnings("resource")
		PrintWriter pw = new PrintWriter(file);
		pw.write(str);
		pw.flush();
	}
}
