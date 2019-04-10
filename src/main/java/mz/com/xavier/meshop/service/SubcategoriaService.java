package mz.com.xavier.meshop.service;

import mz.com.xavier.meshop.model.Subcategoria;
import mz.com.xavier.meshop.repository.SubcategoriaRepository;
import mz.com.xavier.meshop.service.exception.SubcategoriaException;
import mz.com.xavier.meshop.service.exception.SubcategoriaNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SubcategoriaService {

    private SubcategoriaRepository subcategoriaRepository;

    public SubcategoriaService(@Autowired SubcategoriaRepository subcategoriaRepository) {
        this.subcategoriaRepository = subcategoriaRepository;
    }

    public Subcategoria save(final Subcategoria subcategoria) {
        verifyIfExists(subcategoria);
        return subcategoriaRepository.save(subcategoria);
    }

    public Subcategoria findById(Long codigo) {
        verifyIfNotExists(codigo);
        return subcategoriaRepository.getOne(codigo);
    }

    public void deleteById(Long codigo) {
        verifyIfNotExists(codigo);
        subcategoriaRepository.deleteById(codigo);
    }

    private void verifyIfNotExists(Long codigo) throws SubcategoriaNotFoundException {
        Optional<Subcategoria> foundSubcategoria = subcategoriaRepository.findById(codigo);
        if (foundSubcategoria.isEmpty()) {
            throw new SubcategoriaNotFoundException();
        }
    }

    private void verifyIfExists(Subcategoria subcategoria) throws SubcategoriaException{
        Optional<Subcategoria> foundSubcategoria = subcategoriaRepository.findByNome(subcategoria.getNome());
        if (foundSubcategoria.isPresent() && (subcategoria.isNovo()) || isActualizandoParaDiferenteSubcat(subcategoria, foundSubcategoria)) {
            throw new SubcategoriaException();
        }
    }

    private boolean isActualizandoParaDiferenteSubcat(Subcategoria subcategoria, Optional<Subcategoria> foundSubcategoria) {
        return subcategoria.exists() && !subcategoria.equals(foundSubcategoria.get());
    }
}
