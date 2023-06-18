package com.wonderwebdev.assignment3;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class UserService {
	private static UserService userService = null;
	private ArrayList<User> users;

	public UserService() {
		 Path path = Paths.get("data.txt");
	    try {
	        this.users = (ArrayList<User>) readDataFromFile(path);
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}

	
	// create User Array.
	public List<User> readDataFromFile(Path path) throws IOException {
		List<User> Users = new ArrayList<>();
	try {		
	
		//and reads the CSV file line by line, 
			List<String> data = Files.readAllLines(path);//Returns a list(interface) extending from a collection
			//parsing each line into the corresponding properties 
			//of a new User object. 
			data.stream()
			.forEach((String lineOfData) -> {
					try {
						String[] UserData = lineOfData.split(",");
						if (UserData.length == 3) {	
							String Username = UserData[0];
							String Password = UserData[1];
							String name = UserData[2];
							User user = new User(Username, Password, name);
							//store the created User objects in an ArrayList<User>.
							Users.add(user);
							
						}
						
						}
						
					catch (NumberFormatException e) {
						System.out.println("Program cannot read the file.");
						e.printStackTrace();
					}
			
			});


	}catch(

	IOException e)
	{
		System.out.println("Program cannot read the file.");
		e.printStackTrace();
	}
	return Users;
	}
//validating if the inputted username/password matches to User Array. 
	public User validateUser(String username, String password) {
		for (User user : users) {
			if(user.getUsername().equalsIgnoreCase(username)&& user.getPassword().equalsIgnoreCase(password)
			  && user.getPassword().equals(password)) {
				return user;
			}
		}
		
		return null;
	}
}
