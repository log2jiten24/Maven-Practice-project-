package databaseconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.testng.annotations.Test;

public class Databaseconnection {
	
	
	@Test
	public void testDatabase () throws Exception {
		
		//Database Driver name 
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		System.out.println ("Driver loaded");
		//it will establish connection between the database 
		Connection con = DriverManager.getConnection("jdbc:mysql://locahost:3306/seleniumusers", "root" , "jeet47900");
		
		//give host as database name : mysql , localhost(its prsent in localhost) , 
		//as database name as seleniumusers - useranme and password 
		
		System.out.println ("Connected to my SQL Databse ");
		
		
		Statement st = con.createStatement();
		
		//it returns ResultSet Object
		ResultSet rs = st.executeQuery( "select * from seleniumusers" );
		
		while (rs.next()) {
			
			//give the parameter name as the column name 
			String firstname = rs.getString("firstname");
			//it will fetch all the rows of the firstname column details 
			System.out.println ("Database first column Record fetched :" + firstname);
			
		}
		
	}

}
