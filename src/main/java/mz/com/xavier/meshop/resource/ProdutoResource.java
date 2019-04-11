package mz.com.xavier.meshop.resource;

import mz.com.xavier.meshop.model.Produto;
import mz.com.xavier.meshop.repository.ProdutoRepository;
import mz.com.xavier.meshop.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoResource {

    @Autowired
    private ProdutoRepository produtoRepository;
    @Autowired
    private ProdutoService produtoService;

    @GetMapping
    public List<Produto> todos() {
        return produtoRepository.findAll();
    }

    @GetMapping("/{codigo}")
    public Produto findByCodigo(@PathVariable Long codigo) {
        return produtoService.findById(codigo);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Produto create(@Valid @RequestBody Produto produto) {
        return produtoService.save(produto);
    }

    @PutMapping("/{codigo}")
    public Produto update(@PathVariable Long codigo, @Valid @RequestBody Produto produto) {
        produto.setCodigo(codigo);
        return produtoService.save(produto);
    }

    @DeleteMapping("/{codigo}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteByid(@PathVariable Long codigo) {
        produtoService.deleteById(codigo);
    }

}
