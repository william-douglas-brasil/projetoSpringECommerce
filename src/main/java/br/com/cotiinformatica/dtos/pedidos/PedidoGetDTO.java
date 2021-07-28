package br.com.cotiinformatica.dtos.pedidos;

import java.util.List;

import br.com.cotiinformatica.dtos.clientes.ClienteGetDTO;
import br.com.cotiinformatica.dtos.produtos.ProdutoGetDTO;

public class PedidoGetDTO {

	private Integer idPedido;
	private String codigoPedido;
	private String dataPedido;
	private Double valor;

	private ClienteGetDTO cliente;
	private List<ProdutoGetDTO> produtos;

	public Integer getIdPedido() {
		return idPedido;
	}

	public void setIdPedido(Integer idPedido) {
		this.idPedido = idPedido;
	}

	public String getCodigoPedido() {
		return codigoPedido;
	}

	public void setCodigoPedido(String codigoPedido) {
		this.codigoPedido = codigoPedido;
	}

	public String getDataPedido() {
		return dataPedido;
	}

	public void setDataPedido(String dataPedido) {
		this.dataPedido = dataPedido;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public ClienteGetDTO getCliente() {
		return cliente;
	}

	public void setCliente(ClienteGetDTO cliente) {
		this.cliente = cliente;
	}

	public List<ProdutoGetDTO> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<ProdutoGetDTO> produtos) {
		this.produtos = produtos;
	}
}

