package mz.com.xavier.meshop.repository;

import mz.com.xavier.meshop.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    Optional<Produto> findByNomeOrSku(String nome, String sku);

}
