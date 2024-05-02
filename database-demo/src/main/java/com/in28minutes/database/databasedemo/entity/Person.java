package com.in28minutes.database.databasedemo.entity;

public class Person {
	private int id;
	private String name;
	private String location;
	private String birthDate;
	public Person() {}
	public Person(int id, String name, String location, String birthDate) {
		super();
		this.id = id;
		this.name = name;
		this.location = location;
		this.birthDate = birthDate;
	}
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getLocation() {
		return location;
	}
	public String getBirthDate() {
		return birthDate;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}
	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", location=" + location + ", birthDate=" + birthDate + "]";
	}
	

}
