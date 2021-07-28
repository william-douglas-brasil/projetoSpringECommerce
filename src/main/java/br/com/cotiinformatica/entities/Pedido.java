package br.com.cotiinformatica.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table
public class Pedido {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Integer idPedido;

	@Column(nullable = false, unique = true)
	private String codigoPedido;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable = false)
	private Date dataPedido;

	@Column(nullable = false)
	private Double valor;

	@ManyToOne // muitos Pedidos para 1 Cliente
	// Chave estrangeira do relacionamento
	@JoinColumn(name = "idCliente", nullable = false)
	private Cliente cliente;

	@ManyToMany
	// mapeamento da tabela associativa do banco de dados
	// esta tabela ira conter chave estrangeira para pedido e para produto
	@JoinTable(
			// nome da tabela associativa
			name = "itempedido",
			// chave estrangeira com a tabela de Pedido
			joinColumns = @JoinColumn(name = "idPedido", nullable = false),
			// chave estrangeira com a tabela de Produto
			inverseJoinColumns = @JoinColumn(name = "idProduto", nullable = false))
	private List<Produto> produtos;

	public Pedido() {
		// TODO Auto-generated constructor stub
	}

	public Pedido(Integer idPedido, String codigoPedido, Date dataPedido, Double valor, Cliente cliente) {
		super();
		this.idPedido = idPedido;
		this.codigoPedido = codigoPedido;
		this.dataPedido = dataPedido;
		this.valor = valor;
		this.cliente = cliente;
	}

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

	public Date getDataPedido() {
		return dataPedido;
	}

	public void setDataPedido(Date dataPedido) {
		this.dataPedido = dataPedido;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

	@Override
	public String toString() {
		return "Pedido [idPedido=" + idPedido + ", codigoPedido=" + codigoPedido + ", dataPedido=" + dataPedido
				+ ", valor=" + valor + "]";
	}
}
