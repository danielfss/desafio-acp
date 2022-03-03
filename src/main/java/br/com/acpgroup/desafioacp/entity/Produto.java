package br.com.acpgroup.desafioacp.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import br.com.acpgroup.desafioacp.enums.Categoria;
import br.com.acpgroup.desafioacp.enums.StatusProduto;

@Entity
@Table(name = "TB_PRODUTOS")
public class Produto implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Long id;

	@Column(nullable = false, length = 70)
	private String nome;

	@Column(nullable = false)
	private double preco;

	@Column(nullable = false, unique = true, length = 50)
	private String codigoProduto;

	@Column(nullable = false)
	private Integer categoria;

	@Column(nullable = false)
	private Integer status;

	public Produto() {
	}

	public Produto(Long id, String nome, double preco, String codigoProduto, Categoria categoria, StatusProduto status) {
		this.id = id;
		this.nome = nome;
		this.preco = preco;
		this.codigoProduto = codigoProduto;
		setCategoria(categoria);
		setStatus(status);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public String getCodigoProduto() {
		return codigoProduto;
	}

	public void setCodigoProduto(String codigoProduto) {
		this.codigoProduto = codigoProduto;
	}

	public Categoria getCategoria() {
		return Categoria.valueOf(categoria);
	}

	public void setCategoria(Categoria categoria) {
		if (categoria != null) {
			this.categoria = categoria.getCode();
		}
	}

	public StatusProduto getStatus() {
		return StatusProduto.valueOf(status);
	}

	public void setStatus(StatusProduto status) {
		if (status != null) {
			this.status = status.getCode();
		}
	}

}
