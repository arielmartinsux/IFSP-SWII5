package OrderActions;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class Orders {
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

	
	public static int salvarOrder(Order o) {
		int status = 0;
		try {
		Connection con = Orders.getConnection();
		PreparedStatement ps = con.prepareStatement("insert into orders(ord_no,purch_amt,ord_date,customer_id,salesman_id) values (?,?,CURDATE(),?,?)");
		ps.setString(1,String.valueOf(o.getOrdNo()));
		ps.setString(2,String.valueOf(o.getPurchAmt()));
		ps.setString(3,String.valueOf(o.getCustomerId()));
		ps.setString(4,String.valueOf(o.getSalesmanId()));
		
		status = ps.executeUpdate();

		con.close();
		} catch(Exception ex) {ex.printStackTrace();}

		return status;
	}
	
	
	public static int deletarOrder(int id) {
		int status = 0;
		
		try {
		Connection con = Orders.getConnection();
		PreparedStatement ps = con.prepareStatement("delete from order where order_no=?");
		ps.setInt(1,id);
		status = ps.executeUpdate();

		con.close();
		} catch (Exception e) {e.printStackTrace();}

		return status;
	}
	
	public static Order getOrderByID(int id){
		Order o = new Order();

		try {
		Connection con = Orders.getConnection();
		PreparedStatement ps = con.prepareStatement("select * from order where order_no=?");
		ps.setInt(1,id);
		ResultSet rs = ps.executeQuery();
		
		if(rs.next()) {
		o.setOrdNo(rs.getInt(1));
		o.setPurchAmt(rs.getDouble(2));
		o.setDate(rs.getDate(3));
		o.setSalesmanId(rs.getInt(4));
		}
		
		con.close();
		} catch (Exception ex) {ex.printStackTrace();}

		return o;
	}
	
	public static List<Order> listarOrders(){
		List<Order> list = new ArrayList<Order>();

		try {
		Connection con = Orders.getConnection();
		PreparedStatement ps = con.prepareStatement("select * from order");
		ResultSet rs = ps.executeQuery();
				
		while(rs.next()) {
		Order o = new Order();
		
		o.setOrdNo(rs.getInt(1));
		o.setPurchAmt(rs.getDouble(2));
		o.setDate(rs.getDate(3));
		o.setCustomerId(rs.getInt(4));
		o.setSalesmanId(rs.getInt(5));
		
		list.add(o);
		}
		
		con.close();
		} catch (Exception e) {e.printStackTrace();}

		return list;
	}

}

