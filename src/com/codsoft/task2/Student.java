package com.codsoft.task2;

import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class Student {
	
	
	private int rollNo;
	private String name;
	private Map<String, Float> marks;

	public Student() {
		super();
	}

	public Student(int rollNo, String name, Map<String, Float> marks) {
		super();
		this.rollNo = rollNo;
		this.name = name;
		this.marks = marks;
	}

	public int getRollNo() {
		return rollNo;
	}

	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Map<String, Float> getMarks() {
		return marks;
	}

	public void setMarks(Map<String, Float> marks) {
		this.marks = marks;
	}

}
