package java_prj;

public class VehicleTable {

	private String model_no;
	private String model;
	private String company;
	private double mileage,price;
	private int year,stock;

	public VehicleTable(){}
	
	public VehicleTable(String model_no,String model,String company,double mileage,int year,double price,int stock) {
		this.model_no =model_no;
	    this.model = model;
	    this.company= company;
	    this.mileage = mileage;
	    this.year = year;
	    this.price =price;
	    this.stock=stock;
	    }
	 
	public String getModel_no() {
		return this.model_no;
	   }
	 
	public void setModel_no(String model_no) {
	    this.model_no =model_no;
	   }
	 
	public String getModel() {
	    return this.model;
	   }
	 
	public void setModel(String model) {
	    this.model =model;
	   }
	   
	public String getCompany() {
	    return this.company;
	   }
	 
	public void setCompany(String company) {
	    this.company=company;
	   }
	   
	public int getYear() {
	    return this.year;
	   }
	 
	public void setYear(int year) {
	    this.year= year;
	   }
	 
	public double getMileage() {
		return this.mileage;
	   }
	 
    public void setMileage(double mileage) {
        this.mileage= mileage;
	   }
	 
    public double getPrice() {
        return this.price ;
	   }
	 
    public void setPrice(double price) {
        this.price=price;
	   }
	  
    public int getStock() {
        return this.stock;
	   }
	 
    public void setStock(int stock) {
        this.stock=stock;
	   }
	 
	 }