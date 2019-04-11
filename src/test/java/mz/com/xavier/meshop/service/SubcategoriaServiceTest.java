package mz.com.xavier.meshop.service;

import mz.com.xavier.meshop.model.Categoria;
import mz.com.xavier.meshop.model.Subcategoria;
import mz.com.xavier.meshop.repository.SubcategoriaRepository;
import mz.com.xavier.meshop.service.exception.SubcategoriaException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.ArgumentMatchers.anyLong;

import static org.junit.jupiter.api.Assertions.*;


class SubcategoriaServiceTest {

    private SubcategoriaService service;

    @Mock
    private SubcategoriaRepository mockedSubcategoria;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        service = new SubcategoriaService(mockedSubcategoria);
    }

    @Test
    void save() {
      Subcategoria subcategoria = new Subcategoria();
        BDDMockito.given(mockedSubcategoria.save(any(Subcategoria.class))).willReturn(subcategoria);

        Subcategoria savedSubcategoria = service.save(subcategoria);

        BDDMockito.then(mockedSubcategoria).should().save(any(Subcategoria.class));
        assertNotNull(savedSubcategoria);
    }

    @Test
    void shouldDenyCreateexistingSubcategoria() {
        Subcategoria subcategoriaInDatabase = new Subcategoria();
        subcategoriaInDatabase.setCodigo(5L);
        subcategoriaInDatabase.setCategoria(new Categoria());
        subcategoriaInDatabase.setNome("Computador");

        when(mockedSubcategoria.findByNome("Computador")).thenReturn(Optional.of(subcategoriaInDatabase));

        Subcategoria newSubcategoria = new Subcategoria();
        newSubcategoria.setCodigo(10L);
        newSubcategoria.setCategoria(new Categoria());
        newSubcategoria.setNome("Computador");

        assertThrows(SubcategoriaException.class, () -> {
            service.save(newSubcategoria);
        });
    }

    @Test
    void findById() {
      /*  //given
        Subcategoria subcategoriaInDatabase = new Subcategoria();
        subcategoriaInDatabase.setCodigo(1L);
        subcategoriaInDatabase.setNome("Computer");
        subcategoriaInDatabase.setCategoria(new Categoria());
        given(mockedSubcategoria.findById(1L)).willReturn(Optional.of(subcategoriaInDatabase));


        //when
        Subcategoria foundSubcategoria = service.findById(1L);

        //then
      //  then(mockedSubcategoria).should().findById(anyLong());
        assertThat(foundSubcategoria).isNotNull();
    */
    }

    @Test
    void deleteById() {
    }
}