package com.user.jattana.model;

import java.util.List;

public class Owes {
	
	private String owe_by;
	private String owe_to;
	private double owned_total_money;
	
	
	public String getOwe_by() {
		return owe_by;
	}
	public void setOwe_by(String owe_by) {
		this.owe_by = owe_by;
	}
	public String getOwe_to() {
		return owe_to;
	}
	public void setOwe_to(String owe_to) {
		this.owe_to = owe_to;
	}
	public double getOwned_total_money() {
		return owned_total_money;
	}
	public void setOwned_total_money(double owned_total_money) {
		this.owned_total_money = owned_total_money;
	}
	@Override
	public String toString() {
		return "Owes [owe_by=" + owe_by + ", owe_to=" + owe_to + ", owned_total_money=" + owned_total_money + "]";
	}
	
	public int checkObjectExists(List<Owes> owes_list,String owe_to,String owened_by)	
	{
		for(int i=0;i<owes_list.size();i++) {
		if(owes_list.get(i).getOwe_by().equalsIgnoreCase(owened_by) && owes_list.get(i).getOwe_to().equalsIgnoreCase(owe_to))
		{
			return i;
		}
		}
		return -1;
	}
	

}
