# Student Management System

A console-based Student Management System built using Core Java, JDBC, and MySQL.

## Tech Stack
- Java 17 (LTS)
- JDBC
- MySQL
- Eclipse IDE

## Features
- Add Student
- View Students
- Update Student
- Delete Student
- Input Validation
- Custom Exception Handling

## Concepts Used
- OOP (Encapsulation, Abstraction)
- DAO Design Pattern
- Exception Handling
- Input Validation
- SDLC

## Database Schema
```sql
CREATE TABLE students (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100),
    email VARCHAR(100),
    course VARCHAR(50),
    age INT
);
```

How to Run
- Clone the repository
- Import project in Eclipse as Java Project
- Add MySQL Connector/J to build path
- Update DB credentials in DBConnection.java
- Run MainApp.java

---

Author
Lovesh Bodhani
