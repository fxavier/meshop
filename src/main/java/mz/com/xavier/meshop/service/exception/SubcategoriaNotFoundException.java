package mz.com.xavier.meshop.service.exception;

import org.springframework.http.HttpStatus;

public class SubcategoriaNotFoundException extends BusnessException {
    public SubcategoriaNotFoundException() {
        super("subcategoria-4", HttpStatus.BAD_REQUEST);
    }
}
