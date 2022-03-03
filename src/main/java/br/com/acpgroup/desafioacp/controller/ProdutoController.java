package br.com.acpgroup.desafioacp.controller;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.acpgroup.desafioacp.dto.ProdutoDto;
import br.com.acpgroup.desafioacp.entity.Produto;
import br.com.acpgroup.desafioacp.enums.Categoria;
import br.com.acpgroup.desafioacp.enums.StatusProduto;
import br.com.acpgroup.desafioacp.service.ProdutoService;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/produtos")
public class ProdutoController {

	final ProdutoService produtoService;

	/**
	 * INJEÇÃO DE DEPENDÊNCIAS VIA CONSTRUTOR
	 * 
	 * @param produtoService
	 */
	public ProdutoController(ProdutoService produtoService) {
		this.produtoService = produtoService;
	}

	/**
	 * Lista todos os registros de produtos
	 * 
	 * @return
	 */
	@GetMapping
	public ResponseEntity<List<Produto>> listaTodosProdutos() {
		return ResponseEntity.status(HttpStatus.OK).body(produtoService.findAll());
	}

//	@GetMapping
//	public ResponseEntity<Page<Produto>> listaTodosProdutos(@PageableDefault(page = 0, size = 10, sort = "id",
//	direction = Sort.Direction.ASC) Pageable pageable) {
//		return ResponseEntity.status(HttpStatus.OK).body(produtoService.findAll(pageable));
//	}
	
	/**
	 * traz os detalhes de um único produto
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping("/{id}")
	public ResponseEntity<Object> buscaPorId(@PathVariable(value = "id") Long id) {
		Optional<Produto> produtoOptional = produtoService.findById(id);
		if (!produtoOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Produto não encontrado");
		}
		return ResponseEntity.status(HttpStatus.OK).body(produtoOptional.get());
	}

	@PostMapping
	public ResponseEntity<Object> insereProduto(@RequestBody @Valid ProdutoDto produtoDto, Categoria categoria, StatusProduto status) {
		if (produtoService.existeProduto(produtoDto.getCodigoProduto())) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body("Esse código do produto já está em uso.");
		}
		// Produto produto = new Produto();
		var produto = new Produto();
		BeanUtils.copyProperties(produtoDto, produto);
		produto.getCategoria().getCode();
		produto.setCategoria(categoria);
		produto.getStatus().getCode();
		produto.setStatus(status);
		return ResponseEntity.status(HttpStatus.CREATED).body(produtoService.insere(produto));
	}

	@PutMapping("/{id}")
	public ResponseEntity<Object> alteraProduto(@PathVariable(value = "id") Long id,
			@RequestBody @Valid ProdutoDto produtoDto) {
		Optional<Produto> produtoOptional = produtoService.findById(id);
		if (!produtoOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Produto não encontrado.");
		}
		var produto = new Produto();
		BeanUtils.copyProperties(produtoDto, produto);
		produto.setId(produtoOptional.get().getId());
		return ResponseEntity.status(HttpStatus.OK).body(produtoService.insere(produto));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deletaProduto(@PathVariable(value = "id") Long id) {
		Optional<Produto> produtoOptional = produtoService.findById(id);
		if (!produtoOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Produto não encontrado.");
		}
		produtoService.delete(produtoOptional.get());
		return ResponseEntity.status(HttpStatus.OK).body("Produto deletado com sucesso.");
	}
}
