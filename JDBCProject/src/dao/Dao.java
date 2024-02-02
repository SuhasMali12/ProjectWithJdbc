package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import entity.Student;

public class Dao {
	
public void m1()throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
	    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","root");
	    Statement stmt=con.createStatement();
		ResultSet rs=stmt.executeQuery("select * from Student");
		List<Student> list=new ArrayList<Student>();
		while(rs.next()) {
			String id=rs.getString(1);
			String sn=rs.getString(2);
			String sa=rs.getString(3);
			String sg=rs.getString(4);
			Student st=new Student();
			st.setStudent_id(id);
			st.setStudent_name(sn);
			st.setAge(sa);
			st.setGrade(sg);
			list.add(st);
			}
	
		for (Student student : list) {
			System.out.println(student);
			}
		    }
}

/*Certainly! Let's break down the provided Java code step by step:

Imports:
The code imports necessary classes from the Java standard library and any external libraries used in the project.

Class Declaration:
The `Dao` class is declared, which contains the main method for executing the program.

Main Method:
The `main` method is the entry point of the program. It performs the following tasks:- **Prints Messages (Step 1, Step 2, Step 3, Step 4, Step 5):** These are debug messages printed to the console to indicate the progress of the program.

Class.forName("com.mysql.cj.jdbc.Driver"): This loads the MySQL JDBC driver class. This line is required to ensure that the JDBC driver is properly loaded before using it to connect to the database.

Connection Establishment: It establishes a connection to the MySQL database named "student" running locally on port 3306, with the username "root" and password "root". The `getConnection()` method of the `DriverManager` class is used for this purpose.

Creating a Statement: It creates a `Statement` object (`stmt`) from the `Connection` object (`con`). The `Statement` object is used to execute SQL queries against the database.

Executing SQL Query: It executes the SQL query `"select * from Student"` using the `executeQuery()` method of the `Statement` object. This query retrieves all rows and columns from the "Student" table in the database.

Processing ResultSet: It iterates through the `ResultSet` object (`rs`) obtained from executing the query. For each row in the result set:- It retrieves values from each column using the `getString()` method, specifying the column index.
- It creates a new `Student` object and sets its properties using the retrieved values.
- It adds the `Student` object to the `list` collection.

Printing Student Details: Finally, it iterates through the `list` collection and prints the details of each student to the console.

Entity Class (`Student`):The `Student` class represents the entity structure for a student. It likely contains private fields for `student_id`, `student_name`, `age`, and `grade`, along with getter and setter methods for accessing and modifying these fields.

List of Students:The `List<Student> list` stores instances of the `Student` class, representing the data retrieved from the database.

Overall, this code establishes a connection to a MySQL database, retrieves student records from a table named "Student", processes the retrieved data, and prints it to the console. It demonstrates a basic usage of JDBC for database interaction in Java 
*/
