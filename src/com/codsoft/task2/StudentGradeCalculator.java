package com.codsoft.task2;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class StudentGradeCalculator {

	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		
		Student s = new Student();
		Map<String, Float> marks = new HashMap<>();
		StudentGradeCalculator sgc = new StudentGradeCalculator();
		
		System.out.println("\t\t\t\tWelcome Students\n\n");
		
		System.out.print("Enter your name : ");
		s.setName(scan.nextLine());
		
		System.out.print("Enter your roll no : ");
		s.setRollNo(scan.nextInt());
		
		System.out.print("Enter Marks for English : ");
		marks.put("English", sgc.validateMarks(scan.nextFloat()));
		
		System.out.print("Enter Marks for Hindi : ");
		marks.put("Hindi", sgc.validateMarks(scan.nextFloat()));
		
		System.out.print("Enter Marks for Marathi : ");
		marks.put("Marathi", sgc.validateMarks(scan.nextFloat()));
		
		System.out.print("Enter Marks for Maths : ");
		marks.put("Maths", sgc.validateMarks(scan.nextFloat()));
		
		System.out.print("Enter Marks for Science : ");
		marks.put("Science", sgc.validateMarks(scan.nextFloat()));
		
		s.setMarks(marks);
		
		System.out.println("\n\nTotal Marks obtained : " +sgc.calculateTotalMarks(s));
		System.out.println("Average Marks obtained : " +sgc.calculateAverage(s));
		System.out.println("Grade obtained : " +sgc.calculateGrade(s));
	}

	
	public float validateMarks(Float mark) {
		try {
			if((mark < 0)  ||  (mark > 100))
				throw new IllegalArgumentException("Invalid Marks. Please recheck.");
		}
		catch(IllegalArgumentException e) {
			System.err.println(e.getMessage());
			System.out.println("Please re-enter marks : ");
			validateMarks(scan.nextFloat());
		}
		return mark;
	}
	
	public float calculateTotalMarks(Student s) {
		float totalMarks = 0f;
		for(Float marks : s.getMarks().values()) {
			totalMarks += marks;
		}
		return totalMarks;
	}
	
	
	public float calculateAverage(Student s) {
		return calculateTotalMarks(s) / s.getMarks().size();
	}
	
	
	public String calculateGrade(Student s) {
		float avg = calculateAverage(s);
		
		if(avg >= 75)
			return "Distinction";
		
		else if(avg < 75 && avg >= 60)
			return "Grade A"; 
		
		else if(avg < 60 && avg >= 50)
			return "Grade B"; 
		
		else if(avg < 50 && avg >= 35)
			return "Grade C"; 
		
		else 
			return "Fail"; 
	}
	
}
