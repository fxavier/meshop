package mz.com.xavier.meshop.resource;

import mz.com.xavier.meshop.model.Categoria;
import mz.com.xavier.meshop.repository.CategoriaRepository;
import mz.com.xavier.meshop.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/categorias")
public class CategoriaResource {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private CategoriaService categoriaService;


    @GetMapping
    @PreAuthorize("hasAuthority('ROLE_LISTAR_CATEGORIAS') and #oauth2.hasScop('read')")
    public List<Categoria> todas() {
        return categoriaRepository.findAll();
    }

    @GetMapping("/{codigo}")
    public Categoria findOne(@PathVariable Long codigo) {
        return categoriaService.findById(codigo);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @PreAuthorize("hasAuthority('ROLE_CADASTRAR_CATEGORIAS') and #oauth2.hasScop('write')")
    public Categoria create(@Valid @RequestBody Categoria categoria) {
        return categoriaService.save(categoria);
    }

    @PutMapping("/{codigo}")
    public void update(@PathVariable Long codigo, @Valid @RequestBody Categoria categoria) {
        categoria.setCodigo(codigo);
        categoriaService.save(categoria);
    }

    @DeleteMapping("/{codigo}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long codigo) {
        categoriaService.deleteById(codigo);
    }
}
