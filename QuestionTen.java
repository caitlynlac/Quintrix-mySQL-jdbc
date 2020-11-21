import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.testng.annotations.Test;

public class QuestionTen {
  @Test
  public void deleteNewStore() {
	  
	  
	  try {
		  
	  Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sakila", "root", "CaitMl2895!!");

      //Initiate query statements:
	  Statement startTrans = conn.createStatement();
	  Statement setUpdate1 = conn.createStatement();
	  Statement query = conn.createStatement();
	  Statement setUpdate2 = conn.createStatement();
	  Statement rollBack = conn.createStatement();
	  
	  //Set update1 + start transaction:
	  startTrans.executeUpdate("START TRANSACTION");
	  setUpdate1.executeUpdate("SET SQL_SAFE_UPDATES = 0");
	  
	  //Execute query:
	  query.executeQuery("DELETE s.* FROM store AS s INNER JOIN address AS a ON a.address_id = s.address_id WHERE a.address = '110 Main'");
	  
	  //Set update 2:
	  setUpdate2.executeUpdate("SET SQL_SAFE_UPDATES = 1");
	  
	  //Execute rollBack:
	  rollBack.executeQuery("ROLLBACK");
	  
	  //close connection
	  conn.close(); 	  
   }  
	  catch (Exception exc) {
		  exc.printStackTrace();
	  }
	  
	  
	  
	  
	  
	  
	  
  }
}
