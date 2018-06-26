package pojo;

public class Cliente {
	private int clienteId;
	private String nome;
	private String email;
	private String endereco;
	private String cidade;
	private String cep;
	private String telefone;
	
	public Cliente(int clienteId, String nome, String email, String endereco, String cidade, String cep, String telefone){
		super();
		this.clienteId = clienteId;
		this.nome = nome;
		this.email = email;
		this.endereco = endereco;
		this.cidade = cidade;
		this.cep = cep;
		this.telefone = telefone;
	}
	
	public Cliente( String nome, String email, String endereco, String cidade, String cep, String telefone){
		super();
		this.nome = nome;
		this.email = email;
		this.endereco = endereco;
		this.cidade = cidade;
		this.cep = cep;
		this.telefone = telefone;
	}
	
	public String toString() {
		return "Cliente: id=" + clienteId + ", nome=" + nome + ", endereco= " + endereco + ", cidade= " + cidade + ", cep= " + cep + ", telefone = " + telefone;
	}
	public int getClienteId() {
		return clienteId;
	}
	public void setClienteId(int clienteId) {
		this.clienteId = clienteId;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
}
