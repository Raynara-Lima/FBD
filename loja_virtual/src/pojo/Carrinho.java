package pojo;



public class Carrinho {

	private int compraId;
	private int produtoId;
	private int qtde;
	
	public Carrinho(int compraId, int produtoId, int qtde){
		this.compraId = compraId;
		this.produtoId = produtoId;
		this.qtde = qtde;
	}
	
	public int getProdutoId() {
		return produtoId;
	}
	public void setProdutoId(int produtoId) {
		this.produtoId = produtoId;
	}
	public int getCompraId() {
		return compraId;
	}
	public void setCompraId(int compraId) {
		this.compraId = compraId;
	}
	public int getQtde() {
		return qtde;
	}
	public void setQtde(int qtde) {
		this.qtde = qtde;
	}
	public String toString(){
		return "compraID: " + compraId + "produtoId: " + produtoId + "qtd: " + qtde;
	}
	
}
