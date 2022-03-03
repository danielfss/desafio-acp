package br.com.acpgroup.desafioacp.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import br.com.acpgroup.desafioacp.enums.Categoria;
import br.com.acpgroup.desafioacp.enums.StatusProduto;

public class ProdutoDto {

	@NotBlank(message = "Preencha o campo de nome do produto.")
	private String nome;

	private Double preco;

	@NotBlank(message = "Preencha o campo de código.")
	@Size(min = 8, max = 50)
	private String codigoProduto;

//	@NotBlank(message = "O campo não pode estar vazio.")
	private Integer categoria;

//	@NotBlank(message = "O campo não pode estar vazio.")
	private Integer status;

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
