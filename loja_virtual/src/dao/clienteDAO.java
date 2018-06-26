package dao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Connection;

import pojo.Cliente;
import JDBC.ConnectionFactory;
public class clienteDAO {
	private Connection connection;
	
	public clienteDAO(){
		
	}
	
	public boolean addCli(Cliente cli){
		String sql = "INSERT INTO cliente (nome, email, endereco, cidade, cep, telefone) VALUES (?, ?, ?, ?, ?, ?)";
		this.connection = new ConnectionFactory().getConnection();
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			stmt.setString(1, cli.getNome());
			stmt.setString(2, cli.getEmail());
			stmt.setString(3, cli.getEndereco());
			stmt.setString(4, cli.getCidade());
			stmt.setString(5, cli.getCep());
			stmt.setString(6, cli.getTelefone());
			
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
	


	public ArrayList<Cliente> listarClientes(){
		String sql = "SELECT * FROM cliente";
		ArrayList<Cliente> clientes = new ArrayList<>();
		this.connection = new ConnectionFactory().getConnection();
		
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				int id = rs.getInt("clienteId");
				String nome = rs.getString("nome");
				String email = rs.getString("email");
				String endereco = rs.getString("endereco");
				String cidade = rs.getString("cidade");
				String cep = rs.getString("cep");
				String telefone = rs.getString("telefone");
				Cliente cli = new Cliente(id, nome, email, endereco, cidade, cep, telefone);
				
				clientes.add(cli);
				
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
		
		return clientes;
	}
	public boolean excluirCliente(int id) {
		String sql = "DELETE FROM cliente WHERE clienteId = ?";
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
	
	public Cliente getCliById(int id) {
		String sql = "SELECT * FROM cliente WHERE clienteId = ?";
		this.connection = new ConnectionFactory().getConnection();
		
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			stmt.setInt(1, id);
			
			ResultSet rs = stmt.executeQuery();
			rs.next();
			
			Cliente cliente = new Cliente(id, rs.getString("nome"), rs.getString("email"), rs.getString("endereco"), rs.getString("cidade"), rs.getString("cep"), rs.getString("telefone"));
			stmt.close();
			
			return cliente;
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
