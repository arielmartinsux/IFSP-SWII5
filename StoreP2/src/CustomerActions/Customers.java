package CustomerActions;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class Customers {
	public static Connection getConnection() {
		
		Connection con = null;
		
		try {
		String dbDriver = "com.mysql.cj.jdbc.Driver";
		String dbURL = "jdbc:mysql://localhost:3306/";
		// Database name to access
		String dbName = "tp01?useTimezone=true&serverTimezone=America/Sao_Paulo";
		String dbUsername = "acesso";
		String dbPassword = "santosfutebolclube";
		Class.forName(dbDriver);

		con = DriverManager.getConnection(dbURL + dbName, dbUsername, dbPassword);
		} catch(Exception e) {System.out.println(e);}
		
		return con;
	}
	
	public static int salvarCostumer(Customer c) {
		int status = 0;
		try {
		Connection con = Customers.getConnection();
		PreparedStatement ps = con.prepareStatement("insert into customer(cust_name,city,grade,salesman_id) values (?,?,?,?)");
		ps.setString(1,c.getNomeCustomer());
		ps.setString(2,c.getCidadeCustomer());
		ps.setString(3,String.valueOf(c.getGradeCustomer()));
		ps.setString(4,String.valueOf(c.getSalesmanId()));
		
		status = ps.executeUpdate();

		con.close();
		} catch(Exception ex) {ex.printStackTrace();}

		return status;
	}
	
	public static int updateCustomer(Customer c) {
		int status = 0;
		try {
		Connection con = Customers.getConnection();
		PreparedStatement ps = con.prepareStatement("update customer set cust_name=?,city=?,grade=?,salesman_id=?where id=?");
		ps.setString(1,c.getNomeCustomer());
		ps.setString(2,c.getCidadeCustomer());
		ps.setString(3,String.valueOf(c.getGradeCustomer()));
		ps.setString(4,String.valueOf(c.getSalesmanId()));
		ps.setString(5, String.valueOf(c.getSalesmanId()));

		status = ps.executeUpdate();

		con.close();
		} catch(Exception ex) {ex.printStackTrace();}

		return status;
	}
	
	public static int deletarCustomer(int id) {
		int status = 0;
		
		try {
		Connection con = Customers.getConnection();
		PreparedStatement ps = con.prepareStatement("delete from customer where id=?");
		ps.setInt(1,id);
		status = ps.executeUpdate();

		con.close();
		} catch (Exception e) {e.printStackTrace();}

		return status;
	}
	
	public static Customer getCustomerByID(int id){
		Customer c = new Customer();

		try {
		Connection con = Customers.getConnection();
		PreparedStatement ps = con.prepareStatement("select * from customer where id=?");
		ps.setInt(1,id);
		ResultSet rs = ps.executeQuery();
		
		if(rs.next()) {
		c.setId(rs.getInt(1));
		c.setCidadeCustomer(rs.getString(2));
		c.setGradeCustomer(rs.getInt(3));
		c.setSalesmanId(rs.getInt(4));
		}
		
		con.close();
		} catch (Exception ex) {ex.printStackTrace();}

		return c;
	}
	
	public static List<Customer> listarCustomers(){
		List<Customer> list = new ArrayList<Customer>();

		try {
		Connection con = Customers.getConnection();
		PreparedStatement ps = con.prepareStatement("select * from customer");
		ResultSet rs = ps.executeQuery();
				
		while(rs.next()) {
		Customer c = new Customer();
		
		c.setId(rs.getInt(1));
		c.setCidadeCustomer(rs.getString(2));
		c.setGradeCustomer(rs.getInt(3));
		c.setSalesmanId(rs.getInt(4));
		
		list.add(c);
		}
		
		con.close();
		} catch (Exception e) {e.printStackTrace();}

		return list;
	}

}

