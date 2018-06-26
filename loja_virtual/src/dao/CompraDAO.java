package dao;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;

import pojo.Compra;
import pojo.Produto;

import JDBC.ConnectionFactory;

public class CompraDAO {
	private Connection connection;
	
	public CompraDAO(){
		
	}
	
	public boolean addCompra(Compra compra){
		String sql = "INSERT INTO compra (clienteId, dataCompra) VALUES (?, ?)";
		this.connection = new ConnectionFactory().getConnection();
		
		try{
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			
			
			stmt.setInt(1, compra.getClienteId());
			stmt.setString(2, compra.getDataCompra());
			int affectedRows = stmt.executeUpdate();
			stmt.close();
			
			if(affectedRows > 0){
				return true;
			}
			return false;
		}catch(SQLException e){
			System.err.println(e.getMessage());
		}finally{
			try{
				this.connection.close();
			} catch (SQLException e){
				e.printStackTrace();
			}
		}
		return false;
	}
	public ArrayList<Compra> listarCompras(){
		String sql = "SELECT * FROM compra";
		ArrayList<Compra> compras = new ArrayList<>();
		this.connection = new ConnectionFactory().getConnection();
		
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				int id = rs.getInt("compraId");
				int cli = rs.getInt("clienteId");
				String dataC = rs.getString("dataCompra");
				String dataE = rs.getString("dataEnt");
				BigDecimal frete = rs.getBigDecimal("frete");

				Compra compra = new Compra(id, cli, dataC, dataE, frete);
				
				compras.add(compra);
				
			}
			
			stmt.close();
		} catch(SQLException e) {
			System.err.println(e.getMessage());
		}
		
		finally {
			try {
				this.connection.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
		
		return compras;
	}
	
	public boolean finalizarCompra(String dataEnt, BigDecimal frete, int compraId) {
		String sql = "update compra set dataent = ?, frete = ? where compraid = ?";
this.connection = new ConnectionFactory().getConnection();

try{
	PreparedStatement stmt = connection.prepareStatement(sql);
	
	stmt.setString(1, dataEnt);
	stmt.setBigDecimal(2, frete);
	stmt.setInt(3, compraId);
	int affectedRows = stmt.executeUpdate();
	stmt.close();
	
	if(affectedRows > 0){
		return true;
	}
	return false;
}catch(SQLException e){
	System.err.println(e.getMessage());
}finally{
	try{
		this.connection.close();
	} catch (SQLException e){
		e.printStackTrace();
	}
}
return false;
	}
	public int getCompraById(int idCli) {
		String sql = "SELECT compraId FROM compra WHERE clienteId = ?";
		this.connection = new ConnectionFactory().getConnection();
		  int result = 0;
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			stmt.setInt(1, idCli);
			
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {
				  result = rs.getInt("compraId");
				  
				}
			
			stmt.close();
			
			
		}catch(SQLException e) {
			System.err.println(e.getMessage());
		}finally {
			try {
				this.connection.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	public boolean excluirCompra(int id) {
		String sql = "DELETE FROM compra WHERE compraId = ?";
		this.connection = new ConnectionFactory().getConnection();
		
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			//Setar valores
			stmt.setInt(1, id);
			
			int affectedRows = stmt.executeUpdate();
			stmt.close();
			
			if(affectedRows > 0) {
				return true;
			}
			return false;
		}catch(SQLException e) {
			System.err.println(e.getMessage());
		}finally {
			try {
				this.connection.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}
		
}
