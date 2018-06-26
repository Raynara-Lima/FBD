package pojo;

import java.math.BigDecimal;


public class Compra {
	private int compraId;
	private int clienteId;
	private String dataCompra;
	private String dataEnt;
	private BigDecimal frete;
	
	
	
	public Compra(int compraId, int clienteId, String dataCompra, String dataEnt,
			BigDecimal frete) {
		super();
		this.compraId = compraId;
		this.clienteId = clienteId;
		this.dataCompra = dataCompra;
		this.dataEnt = dataEnt;
		this.frete = frete;
	}
	
	
	public Compra(int clienteId, String dataCompra) {
		super();
		this.clienteId = clienteId;
		this.dataCompra = dataCompra;

	}
	public Compra(int compraId, int clienteId) {
		super();
		this.clienteId = clienteId;
		this.compraId = compraId;

	}
	public Compra(int compraId, int clienteId, String dataCompra) {
		super();
		this.dataCompra = dataCompra;
		this.clienteId = clienteId;
		this.compraId = compraId;

	}
	@Override
	public String toString() {
		return "compraId=" + compraId + ", clienteId=" + clienteId
				+ ", dataCompra=" + dataCompra + ", dataEnt=" + dataEnt
				+  ", frete=" + frete + "]";
	}

	public int getCompraId() {
		return compraId;
	}
	public void setCompraId(int compraId) {
		this.compraId = compraId;
	}
	public int getClienteId() {
		return clienteId;
	}
	public void setClienteId(int clienteId) {
		this.clienteId = clienteId;
	}
	public String getDataCompra() {
		return dataCompra;
	}
	public void setDataCompra(String dataCompra) {
		this.dataCompra = dataCompra;
	}
	public String getDataEnt() {
		return dataEnt;
	}
	public void setDataEnt(String dataEnt) {
		this.dataEnt = dataEnt;
	}
	public BigDecimal getFrete() {
		return frete;
	}
	public void setFrete(BigDecimal frete) {
		this.frete = frete;
	}
	

	

}
