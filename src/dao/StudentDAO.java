package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import model.Student;
import util.DBConnection;

public class StudentDAO {
    
    public void addStudent(Student s) {
        String sql = "INSERT INTO students(name,email,course,age) VALUES(?,?,?,?)";

        try(Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(sql,
        	Statement.RETURN_GENERATED_KEYS)) {

            ps.setString(1, s.getName());
            ps.setString(2, s.getEmail());
            ps.setString(3, s.getCourse());
            ps.setInt(4, s.getAge());
            ps.executeUpdate();
            
            ResultSet rs = ps.getGeneratedKeys();
            if(rs.next()) {
            	int generatedId = rs.getInt(1);
            	System.out.println("Student added successfully.");
            	System.out.println("Generated Student Id:" +generatedId);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void viewStudents() {
        String sql = "SELECT * FROM students";

        try(Connection con = DBConnection.getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql)) {

                while(rs.next()) {
                    System.out.println(
                        rs.getInt("id") + " | " +
                        rs.getString("name") + " | " +
                        rs.getString("email") + " | " +
                        rs.getString("course") + " | " +
                        rs.getInt("age")
                    );
                }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void updateStudent(int id, String newName) {
    	String sql = "UPDATE students SET name = ? where id = ?";
    	
    	try(Connection con = DBConnection.getConnection();
    		PreparedStatement ps = con.prepareStatement(sql)) {
    		ps.setString(1, newName);
    		ps.setInt(2, id);
    		ps.executeUpdate();
    		System.out.println("Student updated succesfully");
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    }
    
    public void deleteStudent(int id) {
    	String sql = "DELETE FROM students WHERE id = ?";
    	
    	try(Connection con = DBConnection.getConnection();
    		PreparedStatement ps = con.prepareStatement(sql)) {
    		ps.setInt(1, id);
    		ps.executeUpdate();
    		System.out.println("Student deleted succesfully");
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    }
}