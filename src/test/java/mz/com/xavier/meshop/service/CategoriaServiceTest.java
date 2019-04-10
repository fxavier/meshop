package mz.com.xavier.meshop.service;

import mz.com.xavier.meshop.model.Categoria;
import mz.com.xavier.meshop.repository.CategoriaRepository;
import mz.com.xavier.meshop.service.exception.CategoriaExistsException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.*;

class CategoriaServiceTest {

    private CategoriaService categoriaService;

    @Mock
    private CategoriaRepository mockedCategoria;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        categoriaService = new CategoriaService(mockedCategoria);
    }

    @Test
    void save() {
        Categoria categoria = new Categoria();

        BDDMockito.given(mockedCategoria.save(any(Categoria.class))).willReturn(categoria);

        Categoria categoriaSalva = categoriaService.save(new Categoria());

        BDDMockito.then(mockedCategoria).should().save(any(Categoria.class));
        assertNotNull(categoriaSalva);
    }

    @Test
    void shouldDenyToCreateExistingCategory() {
        Categoria categoriaInDatabase = new Categoria();
        categoriaInDatabase.setCodigo(2L);
        categoriaInDatabase.setNome("Electronica");

        when(mockedCategoria.findByNome("Electronica")).thenReturn(Optional.of(categoriaInDatabase));

        Categoria categoria = new Categoria();
        categoria.setCodigo(5L);
        categoria.setNome("Electronica");

        assertThrows(CategoriaExistsException.class, () -> {
           categoriaService.save(categoria);
        });
    }
}