package br.com.acpgroup.desafioacp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.acpgroup.desafioacp.entity.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long>{

	boolean existsByCodigoProduto(String codigoProduto);

}
