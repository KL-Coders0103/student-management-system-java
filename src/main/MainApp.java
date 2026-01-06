package main;

import java.util.Scanner;

import dao.StudentDAO;
import exception.InvalidInputException;
import model.Student;
import util.InputValidator;

public class MainApp {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
        StudentDAO dao = new StudentDAO();
        
        while(true) {
        	System.out.println("Student Management System");
        	System.out.println("1. Add Student");
        	System.out.println("2. View Students");
        	System.out.println("3. Update Student");
        	System.out.println("4. Delete Student");
        	System.out.println("5. Exit");
        	System.out.println("Enter Your choice");
        	int ch = sc.nextInt();
        	sc.nextLine();
        	
        	switch(ch) {
        	
        	case 1-> {
        		try {
	        		System.out.println("Enter Name:");
	        		String name = sc.nextLine();
	        		System.out.println("Enter Email");
	        		String email = sc.nextLine();
	        		System.out.println("Enter course");
	        		String course = sc.nextLine();
	        		System.out.println("Enter age");
	        		int age = sc.nextInt();
	        		InputValidator.validateStudent(name, email, age);
	        		dao.addStudent(new Student(name,email,course,age));
        		} catch (InvalidInputException e) {
        			System.out.println("Input Error:" +e.getMessage());
        			sc.nextLine();
        		} catch (Exception e) {
        			System.out.println("Something Went wrong");
        			sc.nextLine();
        		}
        	}
        	case 2-> dao.viewStudents();
        	
        	case 3-> {
        		System.out.println("Enter Student Id to update:");
        		int id = sc.nextInt();
        		sc.nextLine();
        		System.out.println("Enter New Name:");
        		String newName = sc.nextLine();
        		dao.updateStudent(id, newName);
        	}
        	
        	case 4-> {
        		System.out.println("Enter Student Id to delete:");
        		int id = sc.nextInt();
        		dao.deleteStudent(id);
        	}
        	
        	case 5-> {
        		System.out.println("Existing Bye");
        		sc.close();
        		System.exit(0);
        	}
        	
        	default -> System.out.println("Invalid choice");
        	}
        }
    }
}
