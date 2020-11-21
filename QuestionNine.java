import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.testng.annotations.Test;

public class QuestionNine {
  @Test
  public void updateTimeStamp() {
	  
	  try {
		  
	 //Connect	  
	  Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sakila", "root", "CaitMl2895!!");
    
	  //create statement 
	  Statement setUpdate = conn.createStatement();
	  Statement joinTables = conn.createStatement(); 
	  Statement setNewUpdate = conn.createStatement();
	  
	  //execute 1st timestamp update:
	  setUpdate.executeUpdate("SET SQL_SAFE_UPDATES = 0");
	  
	  //get result set:
	  ResultSet myRS = joinTables.executeQuery("INNER JOIN address ON address.address_id = store.address_id SET store.last_update = CURDATE() WHERE address.address = '110 Main'");
	  
	  //Execute 2nd timestamp update: 
	  setNewUpdate.executeUpdate("SET SQL_SAFE_UPDATES = 1");
	  
	  //Get new timestamp 
	  while (myRS.next()) {
		  System.out.println(myRS.getNString("last_update"));
		  
	  }
	  
	  conn.close();
	  	  
   }
	  catch (Exception exc) {
		  exc.printStackTrace();
	  }
	  
	  
  }
}
