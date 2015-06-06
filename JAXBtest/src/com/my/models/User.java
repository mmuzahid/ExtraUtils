package com.my.models;

import java.util.Date;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlRootElement;

//@XmlRootElement(name = "app__user")
public class User extends com.my.supermodels.GenericUser{

	@XmlID
	@XmlElement(name = "user_id")
	public String id = "" + new Date().getTime();
	//@XmlElement(name="xl:role")
	public Role role = new Role("Admin");
	public String name = "Jack Fruit";

	
	public User() {
		this.id = "" + new Date().getTime();
	}
	public User(long id) {
		this.id = "" + id;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", role=" + role + ", name=" + name + "]";
	}

	
}
