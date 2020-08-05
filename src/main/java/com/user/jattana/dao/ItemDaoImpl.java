package com.user.jattana.dao;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.user.jattana.model.Item;
import com.user.jattana.model.Person;

@Component
public class ItemDaoImpl implements ItemDao{
	
	private final String PATH="C:\\Users\\charan\\Desktop\\studyData\\Projects 2020\\java\\Split-Grocery\\src\\main\\resources\\itemData.txt"; 

	@Autowired
	FileDao fileDao;
	public boolean addItem(Item item) {
		// TODO Auto-generated method stub
		System.out.println("entering for adding item...!!");
		return fileDao.addData(item.toString(), PATH, true);
		
	}

	public List<Item> getAllItems() {
		List<Item> itemList=new ArrayList<Item>();
		BufferedReader reader;
		int lines = 0;
		try {
			reader = fileDao.getData(PATH);
			String line="";
			while ((line=reader.readLine())!= null) { 
				//System.out.println(line);
			String itemData[]=line.split(", ");	
			Item item=new Item();
			for(String data: itemData){
				String item_data[]=data.split("=");
				if(item_data[0].equalsIgnoreCase("id"))
				{
					item.setId(Integer.parseInt(item_data[1]));
				}else if(item_data[0].equalsIgnoreCase("itemName"))
				{
					item.setItemName(item_data[1]);					
				}else if(item_data[0].equalsIgnoreCase("qty"))
				{
					item.setQty(Integer.parseInt(item_data[1]));
				}else if(item_data[0].equalsIgnoreCase("itemPrice"))
				{
					item.setItemPrice(Double.parseDouble(item_data[1]));
				}else if(item_data[0].equalsIgnoreCase("type"))
				{
					item.setType(item_data[1]);	
				}else if(item_data[0].equalsIgnoreCase("boughtBy"))
				{
					item.setBoughtBy(item_data[1]);	
				}else if(item_data[0].equalsIgnoreCase("date"))
				{
					DateTimeFormatter formatter = DateTimeFormatter. ofPattern( "yyyy-MM-dd" ); 
					LocalDate date = LocalDate. parse( item_data[1] , formatter);
					item.setDate(date);	
				}else if(item_data[0].equalsIgnoreCase("forWhom"))
				{
					if(item_data[1]!=null){
						item.setForWhom(item_data[1].split("/"));	
						}
					
					}
				}
			itemList.add(item);
			}
			reader.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return itemList;
	}

	public List<Item> getThisMonthItems(int monthyear) {
		return null;
	}

	public boolean deleteItem(int id) {
		return false;
	}

	public int numberOfItems() {
	
		return fileDao.size(PATH);
	}

	public int getLastId() {		
		return getAllItems().get(numberOfItems()-1).getId();
	}
	
	

}
