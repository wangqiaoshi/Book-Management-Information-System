import java.sql.*;

public class JdbcFiles {
	public static java.sql.Connection conn = null;
	//Connection conn;
	Statement stmt;
	int inorupdatevalue = -1;
	
	public JdbcFiles()  throws Exception{

		   try{
			   if(conn==null||conn.isClosed()){
			   Class.forName("com.mysql.jdbc.Driver");
			   String url = "jdbc:mysql://210.30.108.66:3306/booksystem";
			   
			   //get a connection to the database for a user named booksystem
			   conn = DriverManager.getConnection(url, "booksystem", "booksystem");
			   }
			   //String drivername = "sun.jdbc.odbc.JdbcOdbcDriver";
		       //String dbURL = "jdbc:odbc:MyBookDB";
		       //Class.forName(drivername);
		       //conn=DriverManager.getConnection(dbURL, "sa", "sa");
		       stmt=conn.createStatement();
		}catch(ClassNotFoundException e){
		       throw new Exception("Database Driver Not Found" + e.getMessage());
		}catch(SQLException e){
		       throw new Exception("Database Not Connected" + e.getMessage());
		}
		}
		       public synchronized ResultSet executeQuery(String sql) throws Exception{
		       ResultSet rs = stmt.executeQuery(sql);
		       return rs;
		}
		       public synchronized int insert(String sql) throws Exception{
		       inorupdatevalue = stmt.executeUpdate(sql);
		       return inorupdatevalue;
		}
		       public synchronized int update(String sql)  throws Exception{
		       inorupdatevalue = stmt.executeUpdate(sql);
		       return inorupdatevalue;
		}
		       public synchronized int del(String sql) throws Exception{
		       inorupdatevalue = stmt.executeUpdate(sql);
		       return inorupdatevalue;
		}
		       public void close()  throws Exception{
		       conn.close();

		}
}
