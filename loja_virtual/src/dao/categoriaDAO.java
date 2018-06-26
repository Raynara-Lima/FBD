package dao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Connection;
import JDBC.ConnectionFactory;
import pojo.Categoria;



public class categoriaDAO {

	private Connection connection;
	public categoriaDAO(){
	
}
	public boolean addCat(Categoria cat){
		String sql = "INSERT INTO categoria (nome) VALUES (?)";
		this.connection = new ConnectionFactory().getConnection();
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			stmt.setString(1, cat.getNome());
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
	


	public ArrayList<Categoria> listarCategorias(){
		String sql = "SELECT * FROM categoria";
		ArrayList<Categoria> categorias = new ArrayList<>();
		this.connection = new ConnectionFactory().getConnection();
		
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				int id = rs.getInt("catId");
				String nome = rs.getString("nome");
			
				Categoria cat = new Categoria(id, nome);
				
				categorias.add(cat);
				
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
		
		return categorias;
	}
	public boolean excluirCategoria(int id) {
		String sql = "DELETE FROM categoria WHERE catid = ?";
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
