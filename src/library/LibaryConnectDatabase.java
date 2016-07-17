package library;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class LibaryConnectDatabase {
	private Connection cnn = null;
	public Connection getConnectMySQL(){
			
			try {
				Class.forName("com.mysql.jdbc.Driver");
				cnn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bnews?useUnicode=true&characterEncoding=UTF-8","root","");
			} catch (Exception e) {
				
			}
			return cnn;
		}
	public void closeDB(){
		if(cnn!=null){
			try {
				cnn.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
	}
	
}
