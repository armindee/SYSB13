package JDBCPackage;
import java.sql.*;
public class SQLServerJDBCTest {
public static void main(String[ ] args) throws SQLException {
try {
DriverManager.registerDriver(new sun.jdbc.odbc.JdbcOdbcDriver());
//Class.forName("sun.jdbc.odbc.JdbcOdbcDriver"); // också ok
} catch(Exception e) {
System.out.println("Kan inte hitta database driver class: " + e);
} 
Connection con = DriverManager.getConnection
("JDBC:ODBC:MyServer;database=erdis;", "markus", "pwd");
Statement stmt = con.createStatement ();
//visa studenter som läser kurser
String sqlStr = "select s.spnr,s.sname,l.kkod,l.betyg ";
sqlStr += " from student s , laser l";
sqlStr += " where s.spnr = l.spnr ";
ResultSet rset = stmt.executeQuery (sqlStr); // returnerar resultset
while (rset.next ()) {
System.out.println (rset.getString (1) + " " + 
rset.getString (2) + " " + 
rset.getString (3) + " " + 
rset.getInt(4) );
}
//Skapa en testtabel
stmt.execute ("create table testtable(x varchar(10));"); 
} // main
} // SQLServerJDBCTest