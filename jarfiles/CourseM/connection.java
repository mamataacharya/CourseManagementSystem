
package CourseM;
import java.sql.*;
public class connection{
	
		
		public Connection connection(){
			Connection con = null;
			try {
			String url = "jdbc:mysql://localhost:3306/CourseManagement";
			String username = "root";
			String password = "mamata123@";
		
		     con= DriverManager.getConnection(url, username,password);
		        
		
		 
			}catch (Exception exp){
	            System.out.println(exp);
	        }
			return con;
	    }
	

	}


