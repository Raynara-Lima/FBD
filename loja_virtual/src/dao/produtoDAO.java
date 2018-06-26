package dao;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;

import JDBC.ConnectionFactory;

import pojo.Produto;


public class produtoDAO {

	private Connection connection;
	
	public produtoDAO(){
		
	}
	public boolean addPro(Produto pro){
		String sql = "INSERT INTO produto (descricao, cat, precoCusto, precoVenda, qtde) VALUES (?, ?, ?, ?, ?)";
		this.connection = new ConnectionFactory().getConnection();
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			stmt.setString(1, pro.getDescricao());
			stmt.setInt(2, pro.getCat());
			stmt.setBigDecimal(3, pro.getPrecoCusto());
			stmt.setBigDecimal(4, pro.getPrecoVenda());
			stmt.setInt(5, pro.getQtde());
		
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
	


	public ArrayList<Produto> listarProdutos(){
		String sql = "SELECT * FROM produto";
		ArrayList<Produto> produtos = new ArrayList<>();
		this.connection = new ConnectionFactory().getConnection();
		
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				int id = rs.getInt("produtoid");
				String descricao = rs.getString("descricao");
				int cat = rs.getInt("cat");
				BigDecimal precoC = rs.getBigDecimal("precoCusto");
				BigDecimal precoV = rs.getBigDecimal("precoVenda");
				int qtde = rs.getInt("qtde");

				Produto pro = new Produto(id, descricao, cat, precoC, precoV, qtde);
				
				produtos.add(pro);
				
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
		
		return produtos;
	}
	public boolean excluirProduto(int id) {
		String sql = "DELETE FROM produto WHERE produtoid = ?";
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
	
	
	public Produto getProdutoId(int id) {
		String sql = "SELECT * FROM produto WHERE produtoid = ?";
		
		this.connection = new ConnectionFactory().getConnection();
		
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setInt(1, id);
			
			ResultSet rs = stmt.executeQuery();
			rs.next();
			
			Produto pro = new Produto(id, rs.getString("descricao"), rs.getInt("cat"), rs.getBigDecimal("precoCusto"), rs.getBigDecimal("precoVenda"), rs.getInt("qtde"));
			
			stmt.close();
			
			return pro;
		}catch(SQLException e) {
			System.err.println(e.getMessage());
		}finally {
			try {
				this.connection.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	

}