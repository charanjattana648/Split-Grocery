package com.user.jattana.dao;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.user.jattana.model.Item;

@Component
public class ItemDaoImpl implements ItemDao{
	
	private final String PATH="C:\\Users\\charan\\Desktop\\studyData\\Projects 2020\\java\\Split-Grocery\\src\\main\\resources\\itemData.txt"; 

	public boolean addItem(Item item) {
		// TODO Auto-generated method stub
		System.out.println("entering for adding item...!!");
		return writeFile(item);
	}

	public List<Item> getAllItems() {
		List<Item> itemList=new ArrayList<Item>();
		BufferedReader reader;
		int lines = 0;
		try {
			reader = new BufferedReader(new FileReader(PATH));
			while (reader.readLine() != null) lines++;
			reader.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public List<Item> getThisMonthItems(int monthyear) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean deleteItem(int id) {
		// TODO Auto-generated method stub
		return false;
	}
	
	public boolean writeFile(Item item) {
		boolean isFileExist=false;
		try {
		      File myObj = new File(PATH);
		      if (myObj.createNewFile()) {
		        System.out.println("File created: " + myObj.getName());
		        return addDataToFile(item,isFileExist);
		      } else {
		    	isFileExist=true;
		        System.out.println("File already exists.");
		        return addDataToFile(item,isFileExist);
		      }
		    } catch (IOException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		      return false;
		    }		
	}
	
	public boolean addDataToFile(Item item,boolean isFileExist) {
		try {
		FileWriter myWriter = new FileWriter(PATH,true);
		if(isFileExist) {
	      myWriter.write("\n"+item.toString());
		}else {
			 myWriter.write(item.toString());
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

	public int numberOfItems() {
		BufferedReader reader;
		int lines = 0;
		try {
			reader = new BufferedReader(new FileReader(PATH));
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
