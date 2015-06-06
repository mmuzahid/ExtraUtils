package com.my.models;

public class Role {

	public  String name;
	public Permission[] permissions = {new Permission("Add User"), new Permission("Edit User")};
	public Role(String name) {
		this.name = name;
	}
	
	public Role() {
	}


}
