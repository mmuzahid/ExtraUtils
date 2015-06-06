package com.my.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

//@XmlRootElement(name = "users")
@XmlAccessorType(XmlAccessType.FIELD)
public class UserList {
	@XmlElement(name = "user")
	private List<User> users;

	public UserList() {
		users = new ArrayList<User>();
	}
	public void add(User user) {
		users.add(user);
	}
	public List<User> getUsers() {
		return users;
	}

	public static UserList createOrUpadate(UserList userList) {
		if (userList == null) {
			userList = new UserList();
			//add dummy
			userList.add(new User());
			userList.add(new User());
			userList.add(new User());	
		}
		
		for (User user : userList.getUsers()) {
			user.id = ""  + new Date().getTime();
		}
		return userList;
	}
	
	@Override
	public String toString() {
		return "users=" + users + "";
	}
	
}
