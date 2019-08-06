package java_prj;

public class EmployeeTable {
	private int id;
	private String name;
	private String dob;
	private String doj;
	private String designation;
	private float salary;
	private String mobile;
	private String address;
	private String uname;
	private String pw;
	
	public EmployeeTable()
	{
		
	}
	
	public EmployeeTable(int id,String name,String dob,String doj,String designation,float salary,String mobile,String address,String uname,String pw)
	{
		this.id = id;
		this.name = name;
		this.dob = dob;
		this.doj = doj;
		this.designation = designation;
		this.salary = salary;
		this.mobile = mobile;
		this.address = address;
		this.uname = uname;
		this.pw = pw;
	}
	
	public int getId()
	{
		return this.id;
	}
	
	public void setId(int id)
	{
		this.id = id;
	}
	
	public String getName()
	{
		return this.name;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public String getDob()
	{
		return this.dob;
	}
	
	public void setDob(String dob)
	{
		this.dob = dob;
	}
	
	public String getDoj()
	{
		return this.doj;
	}
	
	public void setDoj(String doj)
	{
		this.doj = doj;
	}
	
	public String getDesignation()
	{
		return this.designation;
	}
	
	public void setDesignation(String designation)
	{
		this.designation = designation;
	}
	
	public float getSalary()
	{
		return this.salary;
	}
	
	public void setSalary(float salary)
	{
		this.salary = salary;
	}
	
	public String getMobile()
	{
		return this.mobile;
	}
	
	public void setMobile(String mobile)
	{
		this.mobile = mobile;
	}
	
	public String getAddress()
	{
		return this.address;
	}
	
	public void setAddress(String address)
	{
		this.address = address;
	}
	
	public String getUname()
	{
		return this.uname;
	}
	
	public void setUname(String uname)
	{
		this.uname = uname;
	}
	
	public String getPw()
	{
		return this.pw;
	}
	
	public void setPw(String pw)
	{
		this.pw = pw;
	}
}