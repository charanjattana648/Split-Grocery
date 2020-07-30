package com.user.jattana.dao;

import java.io.BufferedReader;

public interface FileDao {

	boolean addData(String data,String Path,boolean isAppend);
	
	BufferedReader getData(String Path);
	
	int size(String path);
	
}
