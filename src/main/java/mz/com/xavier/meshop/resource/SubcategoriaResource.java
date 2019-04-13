package mz.com.xavier.meshop.resource;

import mz.com.xavier.meshop.model.Subcategoria;
import mz.com.xavier.meshop.repository.SubcategoriaRepository;
import mz.com.xavier.meshop.service.SubcategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/subcategorias")
public class SubcategoriaResource {

    @Autowired
    private SubcategoriaRepository subcategoriaRepository;

    @Autowired
    private SubcategoriaService subcategoriaService;

    @GetMapping
    public List<Subcategoria> todas() {
        return subcategoriaRepository.findAll();
    }

    @GetMapping("/{codigo}")
    public Subcategoria findById(@PathVariable Long codigo) {
        return subcategoriaService.findById(codigo);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Subcategoria create(@Valid @RequestBody Subcategoria subcategoria) {
       return subcategoriaService.save(subcategoria);
    }

    @PutMapping("/{codigo}")
    public Subcategoria update(@PathVariable Long codigo, @Valid @RequestBody Subcategoria subcategoria) {
        subcategoria.setCodigo(codigo);
        return subcategoriaService.save(subcategoria);
    }

    @DeleteMapping("/{codigo}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long codigo) {
        subcategoriaService.deleteById(codigo);
    }

}
