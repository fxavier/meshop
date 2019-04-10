package mz.com.xavier.meshop.service;

import mz.com.xavier.meshop.model.Categoria;
import mz.com.xavier.meshop.repository.CategoriaRepository;
import mz.com.xavier.meshop.service.exception.CategoriaExistsException;
import mz.com.xavier.meshop.service.exception.CategoriaNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoriaService {

    private CategoriaRepository categoriaRepository;

    public CategoriaService(@Autowired CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    public Categoria save(final Categoria categoria) {
        verificaSeExistCategoria(categoria);

        return categoriaRepository.save(categoria);
    }

    public Categoria findById(Long codigo) {
        verifyIfNotExists(codigo);
       return categoriaRepository.getOne(codigo);
    }

    public void deleteById(Long codigo) {
        verifyIfNotExists(codigo);
        categoriaRepository.deleteById(codigo);
    }

    private void verifyIfNotExists(Long codigo) throws CategoriaNotFoundException {
        Optional<Categoria> foundCategoria = categoriaRepository.findById(codigo);
        if (foundCategoria.isEmpty()) {
            throw new CategoriaNotFoundException();
        }
    }

    private void verificaSeExistCategoria(Categoria categoria) throws CategoriaExistsException {
        Optional<Categoria> foundCategoria = categoriaRepository.findByNome(categoria.getNome());
        if(foundCategoria.isPresent() && (categoria.isNovo() || isActualizandoParaDiferenteCategoria(categoria, foundCategoria))) {
            throw new CategoriaExistsException();
        }
    }

    private boolean isActualizandoParaDiferenteCategoria(Categoria categoria, Optional<Categoria> foundCategoria) {
        return categoria.exists() && !categoria.equals(foundCategoria.get());
    }

}
