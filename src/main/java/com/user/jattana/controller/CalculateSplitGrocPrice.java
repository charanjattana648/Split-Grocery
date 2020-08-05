package com.user.jattana.controller;

import java.util.ArrayList;
import java.util.List;

import com.user.jattana.model.Item;
import com.user.jattana.model.Owes;


public class CalculateSplitGrocPrice {
	
	Owes owes=new Owes();
	List<Owes> owes_list=new ArrayList<Owes>();
	
	public List<Owes> getSplitedGroceryPrice(List<Item> itemslist)
	{	
		for(Item item: itemslist) {
		double item_amount=0;
//		if(item.getType().equalsIgnoreCase("shared_among"))
//		{
			item_amount=(item.getQty()*item.getItemPrice())/(item.getForWhom().length);
			for(String name:item.getForWhom()) {
				 getOwesList(item,item_amount,name);	
				}
	/*	}else if(item.getType().equalsIgnoreCase("totally_for"))
		{
			item_amount=(item.getQty()*item.getItemPrice())/item.getForWhom().length;
			System.out.println("-------->>."+item);
			for(String name:item.getForWhom()) {
				
				 getOwesList(item,item_amount,name);	
				}
			}	*/
		}
		return owes_list;
	}
	
	public void getOwesList(Item item,double item_amount,String name)
	{
		double splited_amount=0;
		Owes o=new Owes();
		o.setOwe_to(item.getBoughtBy());
		o.setOwe_by(name);
		int index=owes.checkObjectExists(owes_list, item.getBoughtBy(), name);
		System.out.println("index "+index);
		if(index<0)
		{
			o.setOwned_total_money(item_amount);
			owes_list.add(o);
		}else {
			double money=owes_list.get(index).getOwned_total_money();
			System.out.println(money +" -----  "+item_amount);
			splited_amount=money+item_amount;
			System.out.println(money +" ---****--  "+item_amount);
			o.setOwned_total_money(splited_amount);
			owes_list.set(index, o);
		}	
	}

}
