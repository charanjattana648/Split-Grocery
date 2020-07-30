package com.user.jattana.dao;

import java.util.List;

import com.user.jattana.model.Item;

public interface ItemDao {
	
	boolean addItem(Item item);
	
	List<Item> getAllItems();
	
	List<Item> getThisMonthItems(int monthyear);
	
	boolean deleteItem(int id);
	
	int numberOfItems();
	
	int getLastId();

}
