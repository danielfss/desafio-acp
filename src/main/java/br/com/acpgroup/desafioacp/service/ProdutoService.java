package br.com.acpgroup.desafioacp.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.acpgroup.desafioacp.entity.Produto;
import br.com.acpgroup.desafioacp.repository.ProdutoRepository;

@Service
public class ProdutoService {

//	@Autowired
//	ProdutoRepository produtoRepository;
	
	final ProdutoRepository produtoRepository;
	
	/**
	 * Injeção de dependências via construtor
	 * @param produtoRepository
	 */
	public ProdutoService(ProdutoRepository produtoRepository) {
		this.produtoRepository = produtoRepository;
	}

	/**
	 * Método responsável por cadastrar/atualizar um produto.
	 * @param usuarioModel
	 * @return
	 */
	@Transactional
	public Produto insere(Produto produto) {
		return produtoRepository.save(produto);
	}

	public boolean existeProduto(String codigoProduto) {
		return produtoRepository.existsByCodigoProduto(codigoProduto);
	}

	public List<Produto> findAll() {
		return produtoRepository.findAll();
	}
	
	public Page<Produto> findAll(Pageable pageable) {
		return produtoRepository.findAll(pageable);
	}

	public Optional<Produto> findById(Long id) {
		return produtoRepository.findById(id);
	}

	@Transactional
	public void delete(Produto produto) {
		produtoRepository.delete(produto);
	}
}
