package pojo;

public class Categoria {
	private int catId;
	private String nome;
	
	public Categoria(int catId, String nome){
		super();
		this.setCatId(catId);
		this.nome = nome;
	}
	public Categoria(String nome){
		super();
		this.nome = nome;
	}
	
	public String toString() {
		return "CatId: id=" + catId + ", nome=" + nome + "]";
	}
	public int getCatId() {
		return catId;
	}
	public void setCatId(int catId) {
		this.catId = catId;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
}
