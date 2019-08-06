package java_prj;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;


public class AddDb 
{
	boolean result;
	public boolean AddDetails(String id,String Name,String Age,String Salary,String Designation,String Address)
	{
		Connection con=null;
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			final String User="root";
			final String Pass="password";
			final String DB_URL="jdbc:mysql://127.0.0.1:3306/login";
			con=DriverManager.getConnection(DB_URL,User,Pass);
			PreparedStatement ps=con.prepareStatement("INSERT into employeedetail values(?,?,?,?,?,?)");
			ps.setString(1, id);
			ps.setString(2, Name);
			ps.setString(3, Age);
			ps.setString(4, Salary);
			ps.setString(5, Designation);
			ps.setString(6, Address);
			int rs=ps.executeUpdate();			//for non-select use executeUpdate else executeQuery
			if(rs==0)							//returns 0 if error or anything else 1
				result=false;
			else
				result=true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return result;
	}

}
