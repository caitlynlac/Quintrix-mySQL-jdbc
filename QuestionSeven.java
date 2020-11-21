import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import org.testng.annotations.Test;
import java.sql.*;


public class QuestionSeven {
  @Test
  public void getInvetoryId() {
	  
	  Connection conn = null;
	  Statement myStmt = null;
	  ResultSet myRS = null;
	  
	  
	  try {
		  
		  conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sakila", "root", "CaitMl2895!!");

	      //Create call statement 
		  myStmt = conn.createStatement();
		 
		  //Execute statement
		  myRS = myStmt.executeQuery("SELECT inventory_id FROM inventory INNER JOIN film ON inventory.film_id = film.film_id WHERE title = ALIEN CENTER AND store_id = 2");
		  
		  //Process Results
		  System.out.println(myRS.getNString("inventory_id"));
		  	  
	   }  
		  catch (Exception exc) {
			  exc.printStackTrace();
		  }
	   }
	  
  }

