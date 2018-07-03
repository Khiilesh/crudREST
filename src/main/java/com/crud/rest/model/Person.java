package com.crud.rest.model;

import java.time.LocalDateTime;
import java.util.Date;

public class Person {
	 
    private String name;
    private int age;
    private LocalDateTime dob;
    private String emailID;
 
    /**
	 * Default Constructor
	 */
    public Person() {
 
    }

    
	/**
	 * @param name
	 * @param age
	 * @param dob
	 * @param emailID
	 */
	public Person(String name, int age, LocalDateTime dob, String emailID) {
		super();
		this.name = name;
		this.age = age;
		this.dob = dob;
		this.emailID = emailID;
	}


	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}

	/**
	 * @param age the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}

	/**
	 * @return the dob
	 */
	public LocalDateTime getDob() {
		return dob;
	}

	/**
	 * @param dob the dob to set
	 */
	public void setDob(LocalDateTime dob) {
		this.dob = dob;
	}

	/**
	 * @return the emailID
	 */
	public String getEmailID() {
		return emailID;
	}

	/**
	 * @param emailID the emailID to set
	 */
	public void setEmailID(String emailID) {
		this.emailID = emailID;
	}
 
    
 
}
