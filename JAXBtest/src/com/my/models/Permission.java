package com.my.models;

import javax.xml.bind.annotation.XmlType;

@XmlType(name = "UserPermission")
public class Permission extends java.security.Permission{

	public String name;
	public Permission() {
		super("");
	}
	public Permission(String name) {
		super(name);
		this.name = name;
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean implies(java.security.Permission permission) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getActions() {
		// TODO Auto-generated method stub
		return null;
	}

}
