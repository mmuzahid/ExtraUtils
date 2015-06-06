package com.my.supermodels;

import javax.xml.bind.annotation.XmlType;

public class GenericUser {
	enum Gender{MALE, FEMALE, OTHERS}
	public Gender sex = Gender.MALE;
}
