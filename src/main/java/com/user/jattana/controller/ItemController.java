package com.user.jattana.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.user.jattana.dao.ItemDao;
import com.user.jattana.dao.PersonDao;
import com.user.jattana.model.Item;
import com.user.jattana.model.Person;
import com.user.jattana.service.ItemService;

@Controller
public class ItemController {
	
	//@Autowired
	
//	
	
	  @Autowired 
	  ItemService itemService;
	  
	  @Autowired 
	  PersonDao personDao;
	 
	
	List<Item> itemList=new ArrayList<Item>();
	
	
	@RequestMapping("/items")
	public ModelAndView showItemView(HttpServletRequest req,HttpServletResponse res,Model model)
	{
		ModelAndView mv=new ModelAndView("home");

		mv.addObject("person", personDao.getAllPerson());
		mv.addObject("items", itemService.getAllItems());
		return mv;
	}
	
	@RequestMapping("/addItem")
	public ModelAndView showAddedItem(HttpServletRequest req,Model model,@ModelAttribute("item") Item new_item)
	{
		ModelAndView mv=new ModelAndView("home");
		Item item=new_item;
		item.setId(itemService.numberOfItems()+1);
		item.setDate(java.time.LocalDate.now());
		itemList.add(item);
		itemService.addItem(item);

		mv.addObject("person", personDao.getAllPerson());
		mv.addObject("items", itemService.getAllItems());
		return mv;
	}
	
	@RequestMapping("/addPerson")
	public ModelAndView showAddedPerson(HttpServletRequest req,Model model,@ModelAttribute("person") Person new_person) {
		ModelAndView mv=new ModelAndView("home");
		Person person=new_person;	
		personDao.addPerson(new_person);
		mv.addObject("person", personDao.getAllPerson());
		mv.addObject("items", itemService.getAllItems());
		return mv;
	}
	
	

}
