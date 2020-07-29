package com.user.jattana.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.user.jattana.dao.ItemDao;
import com.user.jattana.model.Item;

@Component
public class ItemServiceImpl implements ItemService {

	@Autowired
	ItemDao itemDao;
	
	public boolean addItem(Item item) {
		return itemDao.addItem(item);
	}

	public List<Item> getAllItems() {
		return itemDao.getAllItems();
	}

	public List<Item> getThisMonthItems(int monthyear) {
		return itemDao.getThisMonthItems(monthyear);
	}

	public boolean deleteItem(int id) {
		return itemDao.deleteItem(id);
	}

}
