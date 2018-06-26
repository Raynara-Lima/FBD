package pojo;

import java.math.BigDecimal;

public class Produto {
	private int produtoid;
	private String descricao;
	private int cat;
	private BigDecimal precoCusto;
	private BigDecimal precoVenda;
	private int qtde;
	
	public int getQtde() {
		return qtde;
	}
	public void setQtde(int qtde) {
		this.qtde = qtde;
	}
	public Produto(int produtoid, String descricao, int cat, BigDecimal precoCusto, BigDecimal precoVenda, int qtde){
		super();
		this.produtoid = produtoid;
		this.descricao = descricao;
		this.cat = cat;
		this.precoCusto = precoCusto;
		this.precoVenda = precoVenda;
		this.qtde = qtde;
	}
	public Produto(String descricao, int cat, BigDecimal precoCusto, BigDecimal precoVenda, int qtde){
		super();
		this.descricao = descricao;
		this.cat = cat;
		this.precoCusto = precoCusto;
		this.precoVenda = precoVenda;
		this.qtde = qtde;
	}
	
	
	

	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public int getProdutoid() {
		return produtoid;
	}
	public void setProdutoid(int produtoid) {
		this.produtoid = produtoid;
	}
	public int getCat() {
		return cat;
	}
	public void setCat(int cat) {
		this.cat = cat;
	}
	public BigDecimal getPrecoCusto() {
		return precoCusto;
	}
	public void setPrecoCusto(BigDecimal precoCusto) {
		this.precoCusto = precoCusto;
	}
	public BigDecimal getPrecoVenda() {
		return precoVenda;
	}
	public void setPrecoVenda(BigDecimal precoVenda) {
		this.precoVenda = precoVenda;
	}
	
	public String toString() {
		return "Produto: id=" + produtoid + ", descrição=" + descricao + ", preçoCusto=" + precoCusto + ", preçoVenda=" + precoVenda +  " qtd" + qtde;
	}
	
	
}
