package mz.com.xavier.meshop.service.exception;

import org.springframework.http.HttpStatus;

public class ProdutoExistsException extends BusnessException {
    public ProdutoExistsException() {
        super("produto-6", HttpStatus.BAD_REQUEST);
    }
}
