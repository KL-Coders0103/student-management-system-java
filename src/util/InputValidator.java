package util;

import exception.InvalidInputException;

public class InputValidator {
	public static void validateStudent(String name, String email, int age) 
		throws InvalidInputException {
			if (name == null || name.trim().isEmpty()) {
				throw new InvalidInputException("Name cannot be empty");
			}
			
			if(!email.contains("@")) {
				throw new InvalidInputException("Invalid email format");
			}
			
			if(age<=0 || age>100) {
				throw new InvalidInputException("Invalid age");
			}
	}
}