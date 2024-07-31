import java.util.*;
import java.sql.*;

//Nome do aluno: Gabriel Martins Alves da Silva - CB3021521

public class Produtos {
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
	
	public static int salvarProduto(Produto p) {
		int status = 0;
		try {
		Connection con = Produtos.getConnection();
		PreparedStatement ps = con.prepareStatement("insert into trabalhoPratico2(nome,unidadeCompra,descricao,qtdPrevistoMes,precoMaxComprado) values (?,?,?,?,?)");
		ps.setString(1,p.getNome());
		ps.setString(2,String.valueOf(p.getUnidadeCompra()));
		ps.setString(3,p.getDescricao());
		ps.setString(4,String.valueOf(p.getQtdPrevistoMes()));
		ps.setString(5,String.valueOf(p.getPrecoMaxComprado()));

		status = ps.executeUpdate();

		con.close();
		} catch(Exception ex) {ex.printStackTrace();}

		return status;
	}
	
	public static int updateProduto(Produto p) {
		int status = 0;
		try {
		Connection con = Produtos.getConnection();
		PreparedStatement ps = con.prepareStatement("update trabalhoPratico2 set nome=?,unidadeCompra=?,descricao=?,qtdPrevistoMes=?,precoMaxComprado=?where id=?");
		ps.setString(1,p.getNome());
		ps.setString(2,String.valueOf(p.getUnidadeCompra()));
		ps.setString(3,p.getDescricao());
		ps.setString(4,String.valueOf(p.getQtdPrevistoMes()));
		ps.setString(5,String.valueOf(p.getPrecoMaxComprado()));
		ps.setInt(6,p.getId());

		status = ps.executeUpdate();

		con.close();
		} catch(Exception ex) {ex.printStackTrace();}

		return status;
	}
	
	public static int deletarProduto(int id) {
		int status = 0;
		
		try {
		Connection con = Produtos.getConnection();
		PreparedStatement ps = con.prepareStatement("delete from trabalhoPratico2 where id=?");
		ps.setInt(1,id);
		status = ps.executeUpdate();

		con.close();
		} catch (Exception e) {e.printStackTrace();}

		return status;
	}
	
	public static Produto getProdutoByID(int id){
		Produto p = new Produto();

		try {
		Connection con = Produtos.getConnection();
		PreparedStatement ps = con.prepareStatement("select * from trabalhoPratico2 where id=?");
		ps.setInt(1,id);
		ResultSet rs = ps.executeQuery();
		
		if(rs.next()) {
		p.setId(rs.getInt(1));
		p.setNome(rs.getString(2));
		p.setUnidadeCompra(rs.getInt(3));
		p.setDescricao(rs.getString(4));
		p.setQtdPrevistoMes(rs.getDouble(5));
		p.setPrecoMaxComprado(rs.getDouble(6));
		}
		
		con.close();
		} catch (Exception ex) {ex.printStackTrace();}

		return p;
	}
	
	public static List<Produto> listarProdutos(){
		List<Produto> list = new ArrayList<Produto>();

		try {
		Connection con = Produtos.getConnection();
		PreparedStatement ps = con.prepareStatement("select * from trabalhoPratico2");
		ResultSet rs = ps.executeQuery();
				
		while(rs.next()) {
		Produto p = new Produto();
		
		p.setId(rs.getInt(1));
		p.setNome(rs.getString(2));
		p.setUnidadeCompra(rs.getInt(3));
		p.setDescricao(rs.getString(4));
		p.setQtdPrevistoMes(rs.getDouble(5));
		p.setPrecoMaxComprado(rs.getDouble(6));
		
		list.add(p);
		}
		
		con.close();
		} catch (Exception e) {e.printStackTrace();}

		return list;
	}

}
