package java_prj;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DbConnection {
	public Connection Connect() {
		try {
			String url = "jdbc:mysql://localhost:3306/test";
			String user = "root";
			String pw = "";
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection(url, user, pw);
			return conn;
		}
		catch(ClassNotFoundException |SQLException ex) {
			Logger.getLogger(DbConnection.class.getName()).log(Level.SEVERE,null,ex);
		}
	return null;
	}
}

