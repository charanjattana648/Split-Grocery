package com.user.jattana.controller;

import java.util.ArrayList;
import java.util.List;

import com.user.jattana.model.Item;
import com.user.jattana.model.Owes;


public class CalculateSplitGrocPrice {
	
	Owes owes=new Owes();
	
	
	public List<Owes> getSplitedGroceryPrice(List<Item> itemslist)
	{	
		List<Owes> owes_list=new ArrayList<Owes>();
		for(Item item: itemslist) {
		double item_amount=0;
			item_amount=(item.getQty()*item.getItemPrice())/(item.getForWhom().length);
			for(String name:item.getForWhom()) {
				 getOwesList(owes_list,item,item_amount,name);	
				}
		}
		return owes_list;
	}
	
	public void getOwesList(List<Owes> owes_list,Item item,double item_amount,String name)
	{
		
		double splited_amount=0;
		Owes o=new Owes();
		o.setOwe_to(item.getBoughtBy());
		o.setOwe_by(name);
		int index=owes.checkObjectExists(owes_list, item.getBoughtBy(), name);
		//System.out.println("index "+index);
		if(index<0)
		{
			o.setOwned_total_money(item_amount);
			owes_list.add(o);
		}else {
			double money=owes_list.get(index).getOwned_total_money();
			//System.out.println(money +" -----  "+item_amount);
			splited_amount=money+item_amount;
			//System.out.println(money +" ---****--  "+item_amount);
			o.setOwned_total_money(splited_amount);
			owes_list.set(index, o);
		}	
	}
	
	public List<Owes> getUpdatedOwesList(List<Owes> owes_list) {
		List<Owes> owesList=new ArrayList<>();
		Owes o;
		int i,j,l=owes_list.size();
		double amt=0;
		for(i=0;i<l;i++) {
			for(j=i+1;j<l;j++) {
			if(owes_list.get(i).getOwe_by().equals(owes_list.get(j).getOwe_to()) && 
					owes_list.get(i).getOwe_to().equals(owes_list.get(j).getOwe_by()))
			{
				System.out.println(" i : "+i);
				//System.out.println("====>>>>>>>>>> : "+owes_list.get(i));
				if(owes_list.get(i).getOwned_total_money()>owes_list.get(j).getOwned_total_money())
				{
					System.out.println("entering here.....1");
					int index=is_OwesToExists(owesList,owes_list.get(i).getOwe_to(),owes_list.get(i).getOwe_by());
					if(index==-1)
					{System.out.println("entering here.....2");
						o=new Owes();
						o.setOwe_by(owes_list.get(i).getOwe_by());
						o.setOwe_to(owes_list.get(i).getOwe_to());
						amt=owes_list.get(i).getOwned_total_money()-owes_list.get(j).getOwned_total_money();
						System.out.println("amt :=> "+amt);
						o.setOwned_total_money(amt);
						owesList.add(o);
					}else {
						o=new Owes();
						o.setOwe_by(owes_list.get(i).getOwe_by());
						o.setOwe_to(owes_list.get(i).getOwe_to());
						amt=owes_list.get(i).getOwned_total_money()-owes_list.get(j).getOwned_total_money();
						System.out.println("amt :=> "+amt);
						o.setOwned_total_money(amt);
						owesList.set(index,o);
					}
				}else {
					int index=is_OwesToExists(owesList,owes_list.get(i).getOwe_to(),owes_list.get(i).getOwe_by());
					if(index==-1)				
					{
						System.out.println("entering here.....11");
						o=new Owes();
						o.setOwe_by(owes_list.get(i).getOwe_by());
						o.setOwe_to(owes_list.get(i).getOwe_to());
						amt=owes_list.get(j).getOwned_total_money()-owes_list.get(i).getOwned_total_money();
						o.setOwned_total_money(amt);
						owesList.add(o);
					}}}		
					 
		}		
	}
		System.out.println("===================================>>>>>>>>>>>>>>>>>>");
		for(Owes o1:get_OwesList(owes_list,owesList))
		{			
			System.out.println(o1);
			//System.out.println("===================================>>>>>>>>>>>>>>>>>>");
		}
		System.out.println("===================================>>>>>>>>>>>>>>>>>>");
		return  owesList;
}
	public List<Owes> get_OwesList(List<Owes> owes_list,List<Owes> updated_owesList) {
		boolean isOwesExists;
		for(Owes old_owes:owes_list)
		{
			isOwesExists=false;
			for(Owes updated_owes:updated_owesList)
			{
				if(updated_owes.getOwe_by().equalsIgnoreCase(old_owes.getOwe_by()) && 
					updated_owes.getOwe_to().equalsIgnoreCase(old_owes.getOwe_to()) ||
					(updated_owes.getOwe_by().equalsIgnoreCase(old_owes.getOwe_to()) && 
					updated_owes.getOwe_to().equalsIgnoreCase(old_owes.getOwe_by()))){					
					isOwesExists=true;
				}
			}
			if(!isOwesExists)
			{
				updated_owesList.add(old_owes);
			}
		}
		return updated_owesList;		
	}
	
	public int is_OwesToExists(List<Owes> owesList,String owe_to,String owe_by)
	{
		int i,l=owesList.size();
		for(i=0;i<l;i++)
		{
			if(owesList.get(i).getOwe_to().equalsIgnoreCase(owe_to) && owesList.get(i).getOwe_to().equalsIgnoreCase(owe_by))
			{
				return i;
			}
		}
		return -1;
	}
}