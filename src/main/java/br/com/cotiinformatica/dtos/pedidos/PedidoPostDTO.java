package br.com.cotiinformatica.dtos.pedidos;

public class PedidoPostDTO {

	private String dataPedido;
	private String valor;
	private String idCliente;
	private Integer[] idProduto;

	public String getDataPedido() {
		return dataPedido;
	}

	public void setDataPedido(String dataPedido) {
		this.dataPedido = dataPedido;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public String getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(String idCliente) {
		this.idCliente = idCliente;
	}

	public Integer[] getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(Integer[] idProduto) {
		this.idProduto = idProduto;
	}
}

