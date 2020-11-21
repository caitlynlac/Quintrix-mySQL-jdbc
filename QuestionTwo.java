import org.testng.annotations.Test;
import java.sql.*;

public class QuestionTwo {
  
  @Test
  public void getAirplaneMovies() {
	  
	  
	  try {
		  
	  Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sakila", "root", "CaitMl2895!!");

      //Create statement
	  Statement myStmt = conn.createStatement();
	  
	  //Execute statement
	  ResultSet myRS = myStmt.executeQuery("SELECT title from film WHERE title LIKE '%AIRPLANE%'");
	  
	  //Display result:
	  while (myRS.next()) {
		  System.out.println(myRS.getNString("title"));
	  }
	  
	  conn.close();
	  	  
   }  
	  catch (Exception exc) {
		  exc.printStackTrace();
	  }
   }
}
