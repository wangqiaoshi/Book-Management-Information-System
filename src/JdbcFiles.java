import java.sql.*;
public class JdbcFiles {
	Connection conn;
	Statement stmt;
	int inorupdatevalue=-1;
	
	public JdbcFiles()  throws Exception{

		   try{
			   String drivername="sun.jdbc.odbc.JdbcOdbcDriver";
		       String dbURL="jdbc:odbc:MyBookDB";
		       Class.forName(drivername);
		       conn=DriverManager.getConnection(dbURL,"sa","sa");
		       stmt=conn.createStatement();
		}catch(ClassNotFoundException e){
		       throw new Exception("Database Driver Not Found"+e.getMessage());
		}catch(SQLException e){
		       throw new Exception("Database Not Connected"+e.getMessage());
		}
		}
		       public synchronized ResultSet executeQuery(String sql) throws Exception{
		       ResultSet rs=stmt.executeQuery(sql);
		       return rs;
		}
		       public synchronized int insert(String sql) throws Exception{
		       inorupdatevalue=stmt.executeUpdate(sql);
		       return inorupdatevalue;
		}
		       public synchronized int update(String sql)  throws Exception{
		       inorupdatevalue=stmt.executeUpdate(sql);
		       return inorupdatevalue;
		}
		       public synchronized int del(String sql) throws Exception{
		       inorupdatevalue=stmt.executeUpdate(sql);
		       return inorupdatevalue;
		}
		       public void close()  throws Exception{
		       conn.close();

		}
}
