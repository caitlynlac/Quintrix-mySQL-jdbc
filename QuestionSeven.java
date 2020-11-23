import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

import org.testng.annotations.Test;



public class QuestionSeven {
  @Test
  public void getInvetoryId() {
	  
	  try {
		    Properties props = new Properties(); 
		    props.put("user", "root");         
		    props.put("password", "CaitMl2895!!");
		    props.put("useUnicode", "true");
		    props.put("characterEncoding", "UTF-8");
		    props.put("useServerPrepStmts", "false");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sakila", props);

	      //Create call statement 
		 Statement myStmt = conn.createStatement();
		 
		  //Execute statement
		 ResultSet myRS = myStmt.executeQuery("SELECT inventory_id FROM inventory INNER JOIN film ON inventory.film_id = film.film_id WHERE title = 'ALIEN CENTER' AND store_id = '2'");
		 myRS.next();
		  //Process Results
		  System.out.println(myRS.getString("inventory_id"));
		  	  
	   }  
		  catch (Exception exc) {
			  exc.printStackTrace();
		  }
	   }
	  
  }

