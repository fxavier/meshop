package mz.com.xavier.meshop.service.exception;

import org.springframework.http.HttpStatus;

public class ProdutoNotFoundException extends BusnessException {
    public ProdutoNotFoundException() {
        super("produto-7", HttpStatus.BAD_REQUEST);
    }
}
