package mz.com.xavier.meshop.service.exception;

import org.springframework.http.HttpStatus;

public class CategoriaExistsException extends BusnessException {
    public CategoriaExistsException() {
        super("categoria-2", HttpStatus.BAD_REQUEST);
    }
}
