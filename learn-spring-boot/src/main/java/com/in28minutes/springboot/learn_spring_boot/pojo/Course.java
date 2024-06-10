package com.in28minutes.springboot.learn_spring_boot.pojo;

public class Course {
	private int id;
	private String CourseName;
	private String author;

	public Course(int id, String courseName, String author) {
		super();
		this.id = id;
		CourseName = courseName;
		this.author = author;
	}

	public int getId() {
		return id;
	}

	public String getCourseName() {
		return CourseName;
	}

	public String getAuthor() {
		return author;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setCourseName(String courseName) {
		CourseName = courseName;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	@Override
	public String toString() {
		return "Course [id=" + id + ", CourseName=" + CourseName + ", author=" + author + "]";
	}

}
