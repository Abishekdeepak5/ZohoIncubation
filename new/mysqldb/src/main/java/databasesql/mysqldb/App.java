package databasesql.mysqldb;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
/**
 * Hello world!
 *
 */
public class App 
{
	 private static final String URL = "jdbc:mysql://localhost:3306/webdb";
	 private static final String USER = "root";
	 private static final String PASSWORD = "admin";
    public static void main( String[] args )
    {
    	System.out.println("Hello");
    	try(Connection connection=DriverManager.getConnection(URL, USER, PASSWORD)){
    	}catch(Exception e) {
    		System.out.println(e.getMessage());
    	}
        
        System.out.println( "Hello Wo" );
    }
}



