package com.user.jattana.service;

import java.util.List;

import com.user.jattana.model.Item;

public interface ItemService {
	
	boolean addItem(Item item);
	
	List<Item> getAllItems();
	
	List<Item> getThisMonthItems(int monthyear);
	
	boolean deleteItem(int id);

}
