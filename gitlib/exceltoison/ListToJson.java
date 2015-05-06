package com.exceltojson;

import java.util.List;

import com.google.gson.Gson;

public class ListToJson {
	public String listToJson(List<String[]> list) {
		Gson gson = new Gson();
		return gson.toJson(list);
	}
}
