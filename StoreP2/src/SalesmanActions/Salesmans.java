package SalesmanActions;

import java.util.*;
import java.sql.*;

//Nome do aluno: Gabriel Martins Alves da Silva - CB3021521

public class Salesmans {
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
	
	public static int salvarSalesman(Salesman s) {
		int status = 0;
		try {
		Connection con = Salesmans.getConnection();
		PreparedStatement ps = con.prepareStatement("insert into salesman(salesman_name,city,comission) values (?,?,?)");
		ps.setString(1,s.getNomeSalesman());
		ps.setString(2,s.getCidadeSalesman());
		ps.setString(3,String.valueOf(s.getComissaoSalesman()));

		status = ps.executeUpdate();

		con.close();
		} catch(Exception ex) {ex.printStackTrace();}

		return status;
	}
	
	public static int updateSalesman(Salesman s) {
		int status = 0;
		try {
		Connection con = Salesmans.getConnection();
		PreparedStatement ps = con.prepareStatement("update salesman set salesman_name=?,city=?,comission=?where id=?");
		ps.setString(1,s.getNomeSalesman());
		ps.setString(2,s.getCidadeSalesman());
		ps.setString(3,String.valueOf(s.getComissaoSalesman()));
		ps.setInt(4, s.getId());

		status = ps.executeUpdate();

		con.close();
		} catch(Exception ex) {ex.printStackTrace();}

		return status;
	}
	
	public static int deletarSalesman(int id) {
		int status = 0;
		
		try {
		Connection con = Salesmans.getConnection();
		PreparedStatement ps = con.prepareStatement("delete from salesman where id=?");
		ps.setInt(1,id);
		status = ps.executeUpdate();

		con.close();
		} catch (Exception e) {e.printStackTrace();}

		return status;
	}
	
	public static Salesman getSalesmanByID(int id){
		Salesman s = new Salesman();

		try {
		Connection con = Salesmans.getConnection();
		PreparedStatement ps = con.prepareStatement("select * from salesman where id=?");
		ps.setInt(1,id);
		ResultSet rs = ps.executeQuery();
		
		if(rs.next()) {
		s.setId(rs.getInt(1));
		s.setNomeSalesman(rs.getString(2));
		s.setCidadeSalesman(rs.getString(3));
		s.setComissaoSalesman(rs.getDouble(4));
		}
		
		con.close();
		} catch (Exception ex) {ex.printStackTrace();}

		return s;
	}
	
	public static List<Salesman> listarSalesmans(){
		List<Salesman> list = new ArrayList<Salesman>();

		try {
		Connection con = Salesmans.getConnection();
		PreparedStatement ps = con.prepareStatement("select * from salesman");
		ResultSet rs = ps.executeQuery();
				
		while(rs.next()) {
		Salesman s = new Salesman();
		
		s.setId(rs.getInt(1));
		s.setNomeSalesman(rs.getString(2));
		s.setCidadeSalesman(rs.getString(3));
		s.setComissaoSalesman(rs.getDouble(4));
		
		list.add(s);
		}
		
		con.close();
		} catch (Exception e) {e.printStackTrace();}

		return list;
	}

}
