package java_prj;
import java.sql.*;

public class LoginAuth 
{
	boolean result;
	public boolean Authenticate(String user,String pass,int isadmin)
	{
		Connection con=null;
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			final String User="root";
			final String Pass="";
			final String DB_URL="jdbc:mysql://127.0.0.1:3306/test";
			con=DriverManager.getConnection(DB_URL,User,Pass);
			PreparedStatement ps=con.prepareStatement("Select * from login_details where username=? and password=? and isadmin=?");
			ps.setString(1, user);
			ps.setString(2, pass);
			ps.setLong(3, isadmin);
			ResultSet rs=ps.executeQuery();
			result=rs.next();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return result;
	}
}
