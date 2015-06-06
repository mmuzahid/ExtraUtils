package com.my;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import javax.xml.bind.DataBindingException;
import javax.xml.bind.JAXB;

import com.my.models.User;
import com.my.models.UserList;

public class TestJaxb {

	public static void main(String[] args) throws IOException, FileNotFoundException {
		System.out.println("Starting JAXB test...");
		
		String xml = "res/jaxbData.xml";
		File file = new File(xml);
		
		UserList userList = getUserList(file);
		
		userList = UserList.createOrUpadate(userList);
		
		saveUserList(file, userList);
		
		System.out.println(userList);
		System.out.println("Ending JAXB test ...");
		System.exit(0);
	}

	private static void saveUserList(File file, UserList userList) throws IOException {
		OutputStream os = new FileOutputStream(file);
		JAXB.marshal(userList, os);
		os.close();
	}

	private static UserList getUserList(File file) throws IOException {
		UserList userList = null;
		InputStream is = new FileInputStream(file);
		try {
			userList = JAXB.unmarshal(is,UserList.class);
		}catch(DataBindingException dbe) {}
		is.close();
					
		return userList;
	}
}
