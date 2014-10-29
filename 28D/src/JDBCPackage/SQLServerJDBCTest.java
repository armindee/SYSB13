package JDBCPackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
 
public class SQLServerJDBCTest {
	 
 
	 public static void main(String args[]) 
     {  
     try  
     { 
 
          Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); 
          String connectionUrl = "jdbc:sqlserver://ZENBOOK\\MSSQLSERVER;" + 
                                  "database=Hospital;" + 
                                  "user=Markus;" + 
                                  "password=1234Erdogan"; 
          
          Connection con = DriverManager.getConnection(connectionUrl); 
          System.out.println("Connected."); 
 
     }  
     catch(Exception e)  
     { 
    	 e.printStackTrace();
          System.out.println(e.getMessage()); 
          System.exit(0);  
     } 
  } 
 
}