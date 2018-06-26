package dao;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import pojo.Carrinho;
import pojo.Produto;
import JDBC.ConnectionFactory;

public class carrinhoDAO {
private Connection connection;
	
	public carrinhoDAO(){
		
	}
	public boolean addCar(Carrinho car){
		String sql = "INSERT INTO carrinho (compraId, produtoId, qtd) VALUES (?, ?, ?)";
		this.connection = new ConnectionFactory().getConnection();
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			stmt.setInt(1, car.getCompraId());
			stmt.setInt(2, car.getProdutoId());
			stmt.setInt(3, car.getQtde());
		
			int rowsAffected = stmt.executeUpdate();
			stmt.close();
			if(rowsAffected > 0)
				return true;
			
			return false;
		}catch(SQLException e) {
			System.err.println(e.getMessage());
		}
		
		finally {
			try {
				this.connection.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}
	


	public ArrayList<Carrinho> listarCarrihos(){
		String sql = "SELECT * FROM carrinho";
		ArrayList<Carrinho> carrinho = new ArrayList<>();
		this.connection = new ConnectionFactory().getConnection();
		
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				int compraId = rs.getInt("compraId");
				int produtoId = rs.getInt("produtoId");
				int qtde = rs.getInt("qtde");

				Carrinho car = new Carrinho(compraId, produtoId, qtde);
				
				carrinho.add(car);
				
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
		
		return carrinho;
	}
	public boolean excluirProdutoCar(int id) {
		String sql = "DELETE FROM carrinho WHERE produtoid = ?";
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
	
	public boolean excluirCar(int id) {
		String sql = "DELETE FROM carrinho WHERE compraId = ?";
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
