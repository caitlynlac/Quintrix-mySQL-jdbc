import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.*;
import org.testng.annotations.Test;

public class QuestionEight {
	
  @Test
  public void newStoreTransaction() {
	  
	  try {
		  
	 //Connect	  
	  Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sakila", "root", "CaitMl2895!!");
    
	  //create statement 
	  Statement staffUpdate = conn.createStatement();
	  Statement addressUpdate = conn.createStatement();
	  Statement storeUpdate = conn.createStatement();
	  
	  //insert data and execute statement
	  staffUpdate.executeUpdate("INSERT INTO staff(staff_id, first_name, last_name, address_id, store_id, active, username)  " + "VALUES ('3','Beyonce', 'Knowles', '3', '4', '2', 'QueenB')");
	  addressUpdate.executeUpdate("INSERT INTO address(address, district, city_id, phonel, location) " + "VALUES ('100 Hollywood', 'Celeb', '400', '7777777777', 'HOLLYWOOD')");
	  storeUpdate.executeUpdate("INSERT INTO store(store_id, manager_staff_id, address_id) " + "VALUES ('100 Hollywood', 'Celeb', '400', '7777777777', 'HOLLYWOOD')");
	  
	  //Close out:
	  conn.close();
	  	  
   }  
	  catch (Exception exc) {
		  exc.printStackTrace();
	  }
   }
	  
  }

