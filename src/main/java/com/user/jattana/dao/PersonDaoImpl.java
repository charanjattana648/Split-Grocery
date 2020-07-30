package com.user.jattana.dao;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.user.jattana.model.Item;
import com.user.jattana.model.Person;

@Component
public class PersonDaoImpl implements PersonDao {

	private final String PATH="C:\\Users\\charan\\Desktop\\studyData\\Projects 2020\\java\\Split-Grocery\\src\\main\\resources\\personData.txt"; 

	@Autowired
	FileDao fileDao;
	
	public boolean addPerson(Person person) {
		return fileDao.addData(person.toString(), PATH, true);
	}

	public List<Person> getAllPerson() {
		
		List<Person> personList=new ArrayList<Person>();
		BufferedReader reader;
		int lines = 0;
		try {
			reader = fileDao.getData(PATH);
			String line="";
			while ((line=reader.readLine())!= null) { 
				System.out.println(line);
			String itemData[]=line.split(", ");	
			Person person=new Person();
			for(String data: itemData){
				String item_data[]=data.split("=");
				if(item_data[0].equalsIgnoreCase("firstName"))
				{
					person.setFirstName(item_data[1]);
				}else if(item_data[0].equalsIgnoreCase("lastName"))
				{
					person.setLastName(item_data[1]);					
				}
				
			}personList.add(person);
			}
			reader.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return personList;		
	
	}

	public boolean deletePerson(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	public int numberOfPersons() {
		// TODO Auto-generated method stub
		return fileDao.size(PATH);
	}

}
