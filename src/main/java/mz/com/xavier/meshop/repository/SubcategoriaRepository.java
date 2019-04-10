package mz.com.xavier.meshop.repository;

import mz.com.xavier.meshop.model.Subcategoria;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SubcategoriaRepository extends JpaRepository<Subcategoria, Long> {
    Optional<Subcategoria> findByNome(String nome);
    Optional<Subcategoria> findByCategoriaCodigo(Long codigoCategoria);

}
