package mz.com.xavier.meshop.service.exception;

import org.springframework.http.HttpStatus;

public class SubcategoriaException extends BusnessException {
    public SubcategoriaException() {
        super("subcategoria-3", HttpStatus.BAD_REQUEST);
    }
}
