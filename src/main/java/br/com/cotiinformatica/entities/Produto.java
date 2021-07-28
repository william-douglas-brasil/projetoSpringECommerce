package br.com.cotiinformatica.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.ManyToMany;

@Entity
@Table
public class Produto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Integer idProduto;

	@Column(length = 150, nullable = false)
	private String nome;

	@Column(nullable = false)
	private Double preco;

	@Column(length = 250, nullable = false)
	private String descricao;

	@Column(length = 250, nullable = false)
	private String foto;

	/*
	 * Nome do atributo na classe Pedido onde foi mapeado a @JoinTable
	 */
	@ManyToMany(mappedBy = "produtos")
	private List<Pedido> pedidos;

	public Produto() {
		// TODO Auto-generated constructor stub
	}

	public Produto(Integer idProduto, String nome, 
   Double preco, String descricao, String foto) {
		super();
		this.idProduto = idProduto;
		this.nome = nome;
		this.preco = preco;
		this.descricao = descricao;
		this.foto = foto;
	}

	public Integer getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(Integer idProduto) {
		this.idProduto = idProduto;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public List<Pedido> getPedidos() {
		return pedidos;
	}

	public void setPedidos(List<Pedido> pedidos) {
		this.pedidos = pedidos;
	}

	public String getFoto() {
		return foto;
	}


	public void setFoto(String foto) {
		this.foto = foto;
	}

	@Override
	public String toString() {
		return "Produto [idProduto=" + idProduto + ", nome=" + nome + ", preco=" + preco + ", descricao=" + descricao
		+ ", foto=" + foto + "]";
	}
}
