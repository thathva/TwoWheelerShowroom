package java_prj;
import javafx.application.*;
import javafx.scene.*;
import javafx.stage.*;
import javafx.scene.layout.*;
//import javafx.scene.node.*;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.geometry.*;
import javafx.event.*;
import java.sql.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class MainScreen extends Application 
{
	
	public ObservableList<VehicleTable> getVehicleList()
	{
	ObservableList<VehicleTable> data1 = FXCollections.observableArrayList();
	DbConnection d = new DbConnection();
	Connection conn = d.Connect();
	try {
	ResultSet rs = conn.createStatement().executeQuery("select * from vehicles");
	while (rs.next()) {
	data1.add(new VehicleTable(rs.getString(1),rs.getString(2),rs.getString(3),rs.getDouble(4),rs.getInt(5),rs.getDouble(6),rs.getInt(7)));
	}
	
	} catch (SQLException e) {
	e.printStackTrace();
	}
	return data1;
	}
	
	public ObservableList<EmployeeTable> getEmployeeList()
	{
		ObservableList<EmployeeTable> data = FXCollections.observableArrayList();
		DbConnection d = new DbConnection();
		Connection conn = d.Connect();
		try {
			ResultSet rs = conn.createStatement().executeQuery("Select *from data");
			while (rs.next()) {
				data.add(new EmployeeTable(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getFloat(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10)));
			}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return data;
	}
	
		@SuppressWarnings("unchecked")
		@Override
	public void start(Stage stage) 
	{
		//layouts
		VBox root=new VBox(10);
		VBox dashboard=new VBox();
		VBox employeedashboard=new VBox(10);
		VBox addbox=new VBox(10);
		VBox eaddbox=new VBox(10);
		VBox deletebox=new VBox(10);
		VBox edeletebox=new VBox(10);
		VBox updatebox=new VBox(10);
		VBox eupdatebox=new VBox(10);
		VBox displaybox=new VBox(10);
		VBox edisplaybox=new VBox(10);
		VBox inventory=new VBox(10);
		VBox billing=new VBox(10);
		
		//scenes
		Scene LoginScene=new Scene(root,300,300);
		Scene AdminDashboard=new Scene(dashboard,300,300);
		Scene EmployeeDashboard=new Scene(employeedashboard,300,300);
		Scene addScene=new Scene(addbox,400,400);
		Scene eaddScene=new Scene(eaddbox,400,400);
		Scene updatescene=new Scene(updatebox,300,300);
		Scene eupdatescene=new Scene(eupdatebox,300,300);
		Scene deletescene=new Scene(deletebox,300,300);
		Scene edeletescene=new Scene(edeletebox,300,300);
		Scene viewscene=new Scene(displaybox,300,300);
		Scene eviewscene=new Scene(edisplaybox,300,300);
		Scene inventoryscene=new Scene(inventory,300,300);
		Scene BillingScene=new Scene(billing,300,300);
		
		
		//Login
		Label User=new Label("Username");
		TextField Username=new TextField();
		Username.setMaxWidth(200);
		Label Pass=new Label("Password");
		PasswordField Password=new PasswordField();
		Password.setMaxWidth(200);
		CheckBox AdminCheck=new CheckBox("Login as Admin");
		Button LoginButton=new Button("Login");
		LoginButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e)
			{
				if(AdminCheck.isSelected())
				{
					String user=Username.getText();
					String password=Password.getText();
					LoginAuth la=new LoginAuth();
					boolean res=la.Authenticate(user, password, 1);
					if(res)
					{	
						stage.setScene(AdminDashboard);
					}
					else
					{
						Alert alert=new Alert(AlertType.WARNING);
						alert.setContentText("Invalid Credentials");
						alert.show();
					}
				}
				else
				{
					String user=Username.getText();
					String password=Password.getText();
					LoginAuth la=new LoginAuth();
					boolean res=la.Authenticate(user, password, 0);
					if(res)
					{	
						stage.setScene(EmployeeDashboard);
					}
					else
					{
						Alert alert=new Alert(AlertType.WARNING);
						alert.setContentText("Invalid Credentials");
						alert.show();
					}
				 }
			}
		});
		
		//Menu for Admin
		MenuBar mb=new MenuBar();
		Menu Employee=new Menu("Employee");
		Menu Data=new Menu("Options");
		MenuItem Logout=new MenuItem("Log Out");
		MenuItem Add=new MenuItem("Add");
		MenuItem Update=new MenuItem("Update");
		MenuItem Delete=new MenuItem("Delete");
		MenuItem Inventory=new MenuItem("Inventory");
		Employee.getItems().addAll(Add,Update,Delete);
		Data.getItems().addAll(Inventory,Logout);
		mb.getMenus().addAll(Employee,Data);
		
		//Menu for Employee
		MenuBar menubar=new MenuBar();
		
		//INVENTORY
		Menu VInventory=new Menu("Inventory");
		MenuItem eadd=new MenuItem("Add");
		MenuItem eupdate=new MenuItem("Update");
		MenuItem edelete=new MenuItem("Delete");
		VInventory.getItems().addAll(eadd,eupdate,edelete);
		menubar.getMenus().add(VInventory);
		
		//Billing
		Menu EOptions=new Menu("Options");
		MenuItem Billing=new MenuItem("Billing");
					
		//Logout
		MenuItem ELogout=new MenuItem("Log out");
		EOptions.getItems().addAll(Billing,ELogout);
		menubar.getMenus().add(EOptions);
		
		Button submit=new Button("Add");
		
		Label modelnumLabel=new Label("Model no:");
    	TextField modelnumtext=new TextField();
    	modelnumtext.setMaxWidth(300);
    	
    	Label modelLabel=new Label("Model:");
    	TextField modeltext=new TextField();
    	modeltext.setMaxWidth(300);
    	
    	Label companyLabel=new Label("Company:");
    	TextField companytext=new TextField();
    	companytext.setMaxWidth(300);
    	
    	Label mileageLabel=new Label("Mileage:");
    	TextField mileagetext=new TextField();
    	mileagetext.setMaxWidth(300);
    	
    	Label yearLabel=new Label("Year:");
    	TextField yeartext=new TextField();
    	yeartext.setMaxWidth(300);
    	
    	Label priceLabel=new Label("Price :");
    	TextField pricetext=new TextField();
    	pricetext.setMaxWidth(300);
    	
    	Label stockLabel=new Label("Stock:");
        TextField stocktext=new TextField();
        stocktext.setMaxWidth(300);
		
		Label IDlabel = new Label("ID: ");
		TextField IDtext = new TextField();
		
		Label namelabel = new Label("Name: ");
		TextField nametext = new TextField();
		
		Label doblabel = new Label("DOB: ");
		TextField dobtext = new TextField();
		
		Label dojlabel = new Label("DOJ: ");
		TextField dojtext = new TextField();
		
		Label desiglabel = new Label("Designation: ");
		TextField desigtext = new TextField();
		
		Label salarylabel = new Label("Salary: ");
		TextField salarytext = new TextField();
		
		Label mobilelabel = new Label("Mobile: ");
		TextField mobiletext = new TextField();
		
		Label addresslabel = new Label("Address: ");
		TextField addresstext = new TextField();
		
		Label unamelabel = new Label("Username: ");
		TextField unametext = new TextField();
		
		Label pwlabel = new Label("Password: ");
		PasswordField pwtext = new PasswordField();
		
		Label lVno = new Label("Model no:");
		TextField VNo=new TextField();
		VNo.setMaxWidth(200);
		
		Label lVPrice = new Label("Price:");
		TextField VPrice=new TextField();
		VPrice.setMaxWidth(200);
		
		Button billingbutton=new Button("Generate Bill");
		
		//Table for employee details
		
		TableView<EmployeeTable> table1 = new TableView<EmployeeTable>();
		TableColumn<EmployeeTable, Integer> idcol = new TableColumn<EmployeeTable,Integer>("ID");
		TableColumn<EmployeeTable, String> namecol = new TableColumn<EmployeeTable,String>("Name");
		TableColumn<EmployeeTable, String> dobcol = new TableColumn<EmployeeTable,String>("DOB");
		TableColumn<EmployeeTable, String> dojcol = new TableColumn<EmployeeTable,String>("DOJ");
		TableColumn<EmployeeTable, String> desigcol = new TableColumn<EmployeeTable,String>("Designation");
		TableColumn<EmployeeTable, Float> salarycol = new TableColumn<EmployeeTable,Float>("Salary");
		TableColumn<EmployeeTable, String> mobilecol = new TableColumn<EmployeeTable,String>("Mobile");
		TableColumn<EmployeeTable, String> addresscol = new TableColumn<EmployeeTable,String>("Address");
		TableColumn<EmployeeTable, String> unamecol = new TableColumn<EmployeeTable,String>("Username");
		TableColumn<EmployeeTable, String> pwcol = new TableColumn<EmployeeTable,String>("Password");
		
		idcol.setCellValueFactory(new PropertyValueFactory<>("id"));
		namecol.setCellValueFactory(new PropertyValueFactory<>("name"));
		dobcol.setCellValueFactory(new PropertyValueFactory<>("dob"));
		dojcol.setCellValueFactory(new PropertyValueFactory<>("doj"));
		desigcol.setCellValueFactory(new PropertyValueFactory<>("designation"));
		salarycol.setCellValueFactory(new PropertyValueFactory<>("salary"));
		mobilecol.setCellValueFactory(new PropertyValueFactory<>("mobile"));
		addresscol.setCellValueFactory(new PropertyValueFactory<>("address"));
		unamecol.setCellValueFactory(new PropertyValueFactory<>("uname"));
		pwcol.setCellValueFactory(new PropertyValueFactory<>("pw"));
		
		ObservableList<EmployeeTable> list1 = getEmployeeList();
		table1.setItems(list1);
		table1.getColumns().addAll(idcol,namecol,dobcol,dojcol,desigcol,salarycol,mobilecol,addresscol,unamecol,pwcol);
		
		//Table for Vehicle details
		
		TableView<VehicleTable> table = new TableView<VehicleTable>();
	    TableColumn<VehicleTable, String> model_no = new TableColumn<VehicleTable, String>("Model No.");
	    TableColumn<VehicleTable, String> model = new TableColumn<VehicleTable, String>("Model");
	    TableColumn<VehicleTable, String> company= new TableColumn<VehicleTable, String>("Company");
	    TableColumn<VehicleTable, Double> mileage= new TableColumn<VehicleTable, Double>("Mileage");
	    TableColumn<VehicleTable, Integer> year= new TableColumn<VehicleTable, Integer>("Year Of Manufacture");
	    TableColumn<VehicleTable, Double> price= new TableColumn<VehicleTable, Double>("Price");
	    TableColumn<VehicleTable, Integer> stock= new TableColumn<VehicleTable, Integer>("Stock Available");
	     
	     
	    model_no.setCellValueFactory(new PropertyValueFactory<>("model_no"));
	    model.setCellValueFactory(new PropertyValueFactory<>("model"));
	    company.setCellValueFactory(new PropertyValueFactory<>("company"));
	    mileage.setCellValueFactory(new PropertyValueFactory<>("mileage"));
	    year.setCellValueFactory(new PropertyValueFactory<>("year"));
	    price.setCellValueFactory(new PropertyValueFactory<>("price"));
	    stock.setCellValueFactory(new PropertyValueFactory<>("stock"));
	    
	    ObservableList<VehicleTable> list = getVehicleList();
	    table.setItems(list);
	    table.getColumns().addAll(model_no,model,company,mileage,year,price,stock);
	     
		//Event Handlers for Admin dashboard
	    
		Add.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e)
			{
				stage.setScene(addScene);
				
				DbConnection db = new DbConnection();
				Connection conn = db.Connect();
				submit.setOnAction(new EventHandler<ActionEvent>() {
					public void handle(ActionEvent e)
					{
				try {
					String query = " insert into data(id,name,dob,doj,designation,salary,mobile,address,uname,pw)"
	    	    	        + " values (?,?,?,?,?,?,?,?,?,?)";
					PreparedStatement preparedStmt = conn.prepareStatement(query);
	    	        preparedStmt.setInt (1,Integer.parseInt(IDtext.getText()));
	    	        preparedStmt.setString (2,nametext.getText());
	    	        preparedStmt.setString (3,dobtext.getText());
	    	        preparedStmt.setString (4,dojtext.getText());
	    	        preparedStmt.setString (5,desigtext.getText());
	    	        preparedStmt.setFloat (6,Float.parseFloat(salarytext.getText()));
	    	        preparedStmt.setString (7,mobiletext.getText());
	    	        preparedStmt.setString (8,addresstext.getText());
	    	        preparedStmt.setString (9,unametext.getText());
	    	        preparedStmt.setString (10,pwtext.getText());
	    	        preparedStmt.execute();
 	    	       
	    	        Label display=new Label("ENTRY SUCCESSFUL!!!");
	    	        Alert alert=new Alert(AlertType.CONFIRMATION);
					alert.setTitle("Test");
					alert.setContentText("ENTRY SUCCESSFUL!!!");
					alert.show();
					dashboard.getChildren().add(display);
					stage.setScene(viewscene);
					ObservableList<EmployeeTable> list = getEmployeeList();
	    	        table1.setItems(list);
					displaybox.getChildren().addAll(mb,table1);
	    	        conn.close();
				}
				catch (Exception e1)
	    	      {
	    	        System.err.println("Got an exception! ");
	    	        System.err.println(e1.getMessage());
	    	      }
				
				
			}});
				addbox.getChildren().addAll(IDlabel,IDtext,namelabel,nametext,doblabel,dobtext,dojlabel,dojtext,desiglabel,desigtext,salarylabel,salarytext);
				addbox.getChildren().addAll(mobilelabel,mobiletext,addresslabel,addresstext,unamelabel,unametext,pwlabel,pwtext,submit);
			}});
		
		Update.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e)
			{
				stage.setScene(updatescene); 
    	    	Label enumLabel=new Label("Employee id:");
    	    	TextField enumtext=new TextField();
    	    	enumtext.setMaxWidth(300);
    	    	Button show_button=new Button("SHOW");
    	    	
	    		show_button.setOnAction(new EventHandler<ActionEvent>() {
	    	    @Override
	    	    public void handle(ActionEvent event) {
	    	    	try{
	    	    	
	    	    	DbConnection db = new DbConnection();
	    	    	Connection conn = db.Connect();
	    	    	Statement stmt;
	    	    	stmt=conn.createStatement();
	    	    	
	    	    	String query = "select * from data where id= "+Integer.parseInt(enumtext.getText());
                    ResultSet rs=stmt.executeQuery(query);
                    while(rs.next()){
                    	Label salaryLabel=new Label("Salary :");
            	    	TextField salarytext=new TextField(rs.getString(6));
            	    	salarytext.setMaxWidth(300);
            	    	
            	    	Label desigLabel=new Label("Designation:");
                        TextField desigtext=new TextField(rs.getString(5));
                        desigtext.setMaxWidth(300);
                       
                        Label mobileLabel=new Label("Mobile:");
                        TextField mobiletext=new TextField(rs.getString(7));
                        mobiletext.setMaxWidth(300);
                        Label addLabel=new Label("Address:");
                        TextField addtext=new TextField(rs.getString(8));
                        addtext.setMaxWidth(300);
                        Label unameLabel=new Label("Username:");
                        TextField unametext=new TextField(rs.getString(9));
                        unametext.setMaxWidth(300);
                        Label pwLabel=new Label("Password:");
                        TextField pwtext=new TextField(rs.getString(10));
                        pwtext.setMaxWidth(300);
                        Button update_submit=new Button("UPDATE");
                        update_submit.setOnAction(new EventHandler<ActionEvent>() {
        	    	    @Override
        	    	    public void handle(ActionEvent event) {
        	    	    	try{
        	    	    	String query = " update data set salary = ?, designation = ?, mobile=?, address=?, uname=?, pw=? where id = ?";// + modelnumtext.getText();
        	    	    	PreparedStatement preparedStmt = conn.prepareStatement(query);
        	    	        preparedStmt.setFloat (1,Float.parseFloat(salarytext.getText()));
        	    	        preparedStmt.setString (2,desigtext.getText());
        	    	        preparedStmt.setString(3,mobiletext.getText());
        	    	        preparedStmt.setString(4,addtext.getText());
        	    	        preparedStmt.setString(5,unametext.getText());
        	    	        preparedStmt.setString(6,pwtext.getText());
        	    	        preparedStmt.setInt(7,Integer.parseInt(enumtext.getText()));
        	    	        
                            preparedStmt.execute();
        	    	       
        	    	        Label display=new Label("ENTRY SUCCESSFUL!!!");
        	    	        updatebox.getChildren().add(display);
        	    	         
                            stage.setScene(viewscene); 
        	    	        ObservableList<EmployeeTable> list = getEmployeeList();
        	    	        table1.setItems(list);
        	    	        displaybox.getChildren().addAll(mb,table1);
        	    	        conn.close();
        	    	    	}
        	    	    	
        	    	    	catch (SQLException e) {
        	    	    		e.printStackTrace();
        	    	    		}
        	    	    	
        	    	    	updatebox.getChildren().addAll(salaryLabel,salarytext,desigLabel,desigtext,mobileLabel,mobiletext);
	        	    		updatebox.getChildren().addAll(addLabel,addresstext,unameLabel,unametext,pwLabel,pwtext,update_submit);
        	    	    }});
        	    		
                       }
                        
        	    	}
	    	    	
        	    	 catch (Exception e)
    	    	      {
    	    	        System.err.println("Got an exception! ");
    	    	        System.err.println(e.getMessage());
    	    	      }
    	    	    
	    	    }});
        	    	
	    		updatebox.getChildren().addAll(enumLabel,enumtext,show_button);
      	    	
      	    }
                    
			});
		

	    Delete.setOnAction(new EventHandler<ActionEvent>() {
	    	    @Override
	    	    
	    	    public void handle(ActionEvent event) {
	    	    
	    	    	stage.setScene(deletescene); 
	    	    	Label enumLabel=new Label("Employee id:");
	    	    	TextField enumtext=new TextField();
	    	    	enumtext.setMaxWidth(300);
	    	    	Button delete_button=new Button("DELETE");
		    		delete_button.setOnAction(new EventHandler<ActionEvent>() {
		    	    @Override
		    	    public void handle(ActionEvent event) {
		    	    	try{
		    	    		
		    	    	DbConnection db = new DbConnection();
		    	    	Connection conn = db.Connect();
		    	    	String query = "delete from data where id= ?";
		    	        PreparedStatement preparedStmt = conn.prepareStatement(query);
		    	        preparedStmt.setString(1, enumtext.getText());
	                    preparedStmt.execute();
	                    stage.setScene(viewscene);
		    	        ObservableList<EmployeeTable> list = getEmployeeList();
		    	        table1.setItems(list);
		    	        displaybox.getChildren().addAll(mb,table1);
		    	        conn.close();
		    	      }
		    	    	
		    	      catch (Exception e)
		    	      {
		    	        System.err.println("Got an exception! ");
		    	        System.err.println(e.getMessage());
		    	      }
	    	    	
	    	    	}});
		    		
		    		deletebox.getChildren().addAll(enumLabel,enumtext,delete_button);
	    	    
	    	    }});
		    		
		
		Inventory.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e)
			{
				stage.setScene(inventoryscene);
				ObservableList<VehicleTable> list = getVehicleList();
			    table.setItems(list);
			    inventory.getChildren().addAll(mb,table);
				
			}
		});
		
		Logout.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e)
			{
				stage.setScene(LoginScene);
			}
		});
		
		ELogout.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e)
			{
				stage.setScene(LoginScene);
			}
		});
		
		
		Billing.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e)
			{
				stage.setScene(BillingScene);
			}
		});
		
		billingbutton.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e)
			{
				String no=VNo.getText();
				String price=VPrice.getText();
				double tax=Double.parseDouble(VPrice.getText()) * 0.18;
				double amount=Double.parseDouble(VPrice.getText()) + tax;
				Alert alert=new Alert(AlertType.INFORMATION);
				alert.setContentText("VNo: "+no+"\n"+"Price: "+price+"\n"+"Total Amount: "+amount);
				alert.show();
			}
		});
		
		
		//Event handlers for Employee dashboard
		
		eadd.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e)
			{
				stage.setScene(eaddScene);  
				Button insert_submit=new Button("SUBMIT");
				
    	    	insert_submit.setOnAction(new EventHandler<ActionEvent>() {
    	    	    @Override
    	    	    public void handle(ActionEvent event) {
    	    	    	try{
    	    	    		
    	    	    	DbConnection db = new DbConnection();
    	    	    	Connection conn = db.Connect();
    	    	    	String query = " insert into vehicles(model_no,model,company,mileage,year,price,stock)"
    	    	    	        + " values (?, ?, ?, ?,?,?, ?)";
    	    	    	PreparedStatement preparedStmt = conn.prepareStatement(query);
    	    	        preparedStmt.setString (1,modelnumtext.getText());
    	    	        preparedStmt.setString (2,modeltext.getText());
    	    	        preparedStmt.setString(3,companytext.getText());
    	    	        preparedStmt.setDouble(4,Double.parseDouble(mileagetext.getText()));
    	    	        preparedStmt.setInt(5,Integer.parseInt(yeartext.getText()));
    	    	        preparedStmt.setDouble(6,Double.parseDouble(pricetext.getText()));
    	    	        preparedStmt.setInt(7,Integer.parseInt(stocktext.getText()));
                        
    	    	        preparedStmt.execute();
    	    	       
    	    	        Label display=new Label("ENTRY SUCCESSFUL!!!");
    	    	        Alert alert=new Alert(AlertType.CONFIRMATION);
						alert.setTitle("Test");
						alert.setContentText("ENTRY SUCCESSFUL!!!");
						alert.show();
    	    	        eaddbox.getChildren().add(display);
    	    	        stage.setScene(eviewscene); 
    	    	        ObservableList<VehicleTable> list = getVehicleList();
    	    	        table.setItems(list);
    	    	        edisplaybox.getChildren().addAll(menubar,table);
    	    	    	}
    	    	    	
    	    	    	catch (SQLException e) {
    	    	    		e.printStackTrace();
    	    	    		}
    	    	    
    	    	    }});
                 
    	    	eaddbox.getChildren().addAll(modelnumLabel,modelnumtext,modelLabel,modeltext,companyLabel,companytext,mileageLabel,mileagetext,yearLabel,yeartext);
    	    	eaddbox.getChildren().addAll(priceLabel,pricetext,stockLabel,stocktext,insert_submit);
                 }
			
		});
		
		
		edelete.setOnAction(new EventHandler<ActionEvent>() {
    	    @Override
    	    
    	    public void handle(ActionEvent event) {
    	    
    	    	stage.setScene(edeletescene); 
    	    	Label modelnumLabel=new Label("Model no:");
    	    	TextField modelnumtext=new TextField();
    	    	modelnumtext.setMaxWidth(300);
    	    	Button delete_button=new Button("DELETE");
	    		delete_button.setOnAction(new EventHandler<ActionEvent>() {
	    	    @Override
	    	    public void handle(ActionEvent event) {
	    	    	try{
	    	    	
	    	    	DbConnection db = new DbConnection();
	    	    	Connection conn = db.Connect();
	    	    	String query = "delete from vehicles where model_no= ?";
	    	        PreparedStatement preparedStmt = conn.prepareStatement(query);
	    	        preparedStmt.setString(1, modelnumtext.getText());
                    preparedStmt.execute();
                    stage.setScene(eviewscene); 
	    	        ObservableList<VehicleTable> list = getVehicleList();
	    	        table.setItems(list);
	    	        edisplaybox.getChildren().addAll(menubar,table);
	    	        conn.close();
	    	      }
	    	    	
	    	      catch (Exception e)
	    	      {
	    	        System.err.println("Got an exception! ");
	    	        System.err.println(e.getMessage());
	    	      }
    	    	
    	    	}});
	    		
	    		edeletebox.getChildren().addAll(modelnumLabel,modelnumtext,delete_button);
    	    
    	    }});
	    		
    
 
		eupdate.setOnAction(new EventHandler<ActionEvent>() {
    	    @Override
    	    
    	    public void handle(ActionEvent event) {
    	    
    	    	stage.setScene(eupdatescene); 
    	    	Label modelnumLabel=new Label("Model no:");
    	    	TextField modelnumtext=new TextField();
    	    	modelnumtext.setMaxWidth(300);
    	    	Button show_button=new Button("SHOW");
    	    	
	    		show_button.setOnAction(new EventHandler<ActionEvent>() {
	    	    @Override
	    	    public void handle(ActionEvent event) {
	    	    	try{
	    	    		Statement stmt;
		    	    	DbConnection db = new DbConnection();
		    	    	Connection conn = db.Connect();
		    	    	stmt=conn.createStatement();
	    	    	
		    	    	String query = "select * from vehicles where model_no= "+modelnumtext.getText();
		    	    	ResultSet rs=stmt.executeQuery(query);
		    	    	while(rs.next()){
	            	    	
            	    	Label priceLabel=new Label("Price :");
            	    	TextField pricetext=new TextField(rs.getString(6));
            	    	pricetext.setMaxWidth(300);
            	    	
            	    	Label stockLabel=new Label("Stock:");
                        TextField stocktext=new TextField(rs.getString(7));
                        stocktext.setMaxWidth(300);
                        Button update_submit=new Button("UPDATE");
                        update_submit.setOnAction(new EventHandler<ActionEvent>() {
	    	    	    @Override
	    	    	    public void handle(ActionEvent event) {
	    	    	    	try{
	    	    	    		
	    		    	    	DbConnection db = new DbConnection();
	    		    	    	Connection conn = db.Connect();
		    	    	    	String query = " update vehicles set price = ?, stock = ? where model_no = ?";
		    	    	    	PreparedStatement preparedStmt = conn.prepareStatement(query);
		    	    	        preparedStmt.setString (3,modelnumtext.getText());
		    	    	        preparedStmt.setDouble(1,Double.parseDouble(pricetext.getText()));
		    	    	        preparedStmt.setInt(2,Integer.parseInt(stocktext.getText()));
		                        
		    	    	        preparedStmt.execute();
		    	    	       
		    	    	        Label display=new Label("ENTRY SUCCESSFUL!!!");
		    	    	        eupdatebox.getChildren().add(display);
		    	    	         
		                        stage.setScene(eviewscene); 
		    	    	        ObservableList<VehicleTable> list = getVehicleList();
		    	    	        table.setItems(list);
		    	    	        conn.close();
		    	    	        edisplaybox.getChildren().addAll(menubar,table);
		    	    	    	}
	    	    	    	
	    	    	    	catch (SQLException e) {
	    	    	    		e.printStackTrace();
	    	    	    		}
	    	    	    	
	    	    	    }});
                        
	    	    		eupdatebox.getChildren().addAll(priceLabel,pricetext,stockLabel,stocktext,update_submit);
	                    }
		    	    	
	               }
	    	    	
	    	    	 catch (Exception e)
		    	      {
		    	        System.err.println("Got an exception! ");
		    	        System.err.println(e.getMessage());
		    	      }
	    	    	
		    	    }});
	    	    	eupdatebox.getChildren().addAll(modelnumLabel,modelnumtext,show_button);
	  	    	
	  	    	}});
		
		//adding controls
		root.getChildren().addAll(User,Username,Pass,Password,AdminCheck,LoginButton);
		root.setAlignment(Pos.CENTER);
		dashboard.getChildren().addAll(mb,table1);
		dashboard.setAlignment(Pos.CENTER);
		addbox.setAlignment(Pos.CENTER);
	    employeedashboard.getChildren().addAll(menubar,table);
	    employeedashboard.setAlignment(Pos.CENTER);
		billing.getChildren().addAll(lVno,VNo,lVPrice,VPrice,billingbutton);
		billing.setAlignment(Pos.CENTER);
		
		//stage
		stage.setTitle("Two Wheeler Showroom Management System");
		stage.setScene(LoginScene);
		stage.show();
		}

		public static void main(String args[]) 
		{
			launch(args);
		}
}