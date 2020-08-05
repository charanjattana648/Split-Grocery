package com.user.jattana.dao;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.springframework.stereotype.Component;

@Component
public class FileDaoImpl implements FileDao {

	public boolean addData(String data, String path, boolean isAppend) {
		// TODO Auto-generated method stub
		boolean isFileExist=false;
		try {
		      File myObj = new File(path);
		      if (myObj.createNewFile()) {
		        System.out.println("File created: " + myObj.getName());
		        return addDataToFile(data,path,isAppend,isFileExist);
		      } else {
		    	isFileExist=true;
		        System.out.println("File already exists.");
		        return addDataToFile(data,path,isAppend,isFileExist);
		      }
		    } catch (IOException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		      return false;
		    }	
	}
	
	public boolean addDataToFile(String data, String path, boolean isAppend,boolean isFileExist)
	{
		try {
			FileWriter myWriter = new FileWriter(path,isAppend);
			if(isFileExist && size(path)>0) {
		      myWriter.write("\n"+data);
			}else {
				 myWriter.write(data);
			}
		      myWriter.close();
		      System.out.println("Successfully wrote to the file.");
		      return true;
		    } catch (IOException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		      return false;
		    }
	}

	public BufferedReader getData(String Path) {
		// TODO Auto-generated method stub
		try {
			return new BufferedReader(new FileReader(Path));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		};
		return null;
	}

	public int size(String path) {
		BufferedReader reader;
		int lines = 0;
		try {
			reader = new BufferedReader(new FileReader(path));
			while (reader.readLine() != null) lines++;
			reader.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return lines;
	}

}
