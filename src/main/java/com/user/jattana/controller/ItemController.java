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

import com.user.jattana.model.Item;
import com.user.jattana.model.Person;

@Controller
public class ItemController {
	
	//@Autowired
	
//	
//	@Autowired
//	Person person;
	
	List<Item> itemList=new ArrayList<Item>();
	
	
	@RequestMapping("/items")
	public ModelAndView showItemView(HttpServletRequest req,HttpServletResponse res,Model model)
	{
		ModelAndView mv=new ModelAndView("home");
		return mv;
	}
	
	@RequestMapping("/addItem")
	public ModelAndView showAddedItem(HttpServletRequest req,Model model,@ModelAttribute("item") Item new_item)
	{
		ModelAndView mv=new ModelAndView("home");
		Item item=new_item;
		item.setId(itemList.size()+1);
		item.setDate(java.time.LocalDate.now());
		itemList.add(item);
		mv.addObject("items", itemList);
		return mv;
	}
	
	

}
