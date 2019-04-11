package mz.com.xavier.meshop.service;

import mz.com.xavier.meshop.model.Produto;
import mz.com.xavier.meshop.repository.ProdutoRepository;
import mz.com.xavier.meshop.service.exception.ProdutoExistsException;
import mz.com.xavier.meshop.service.exception.ProdutoNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProdutoService {

    private ProdutoRepository produtoRepository;

    public ProdutoService(@Autowired ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    public Produto save(final Produto produto) {
        verifyIfExistsProduto(produto);
        return produtoRepository.save(produto);
    }

    public Produto findById(Long codigo) {
        verifyIfNotExists(codigo);
        return produtoRepository.getOne(codigo);
    }

    public void deleteById(Long codigo) {
        verifyIfNotExists(codigo);
        produtoRepository.deleteById(codigo);
    }

    private void verifyIfNotExists(Long codigo) throws ProdutoNotFoundException {
        Optional<Produto> foundProduto = produtoRepository.findById(codigo);
        if (foundProduto.isEmpty()) {
            throw new ProdutoNotFoundException();
        }
    }

    private void verifyIfExistsProduto(Produto produto) {
        Optional<Produto> foundProduto = produtoRepository.findByNomeOrSku(produto.getNome(), produto.getSku());
        if (foundProduto.isPresent() && (produto.isNovo() || isActualizandoParaProdutosDiferentes(produto, foundProduto) )) {
            throw new ProdutoExistsException();
        }
    }

    private boolean isActualizandoParaProdutosDiferentes(Produto produto, Optional<Produto> foundProduto) {
        return produto.exists() && !produto.equals(foundProduto);
    }


}
