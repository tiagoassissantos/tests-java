package br.com.tiagosantos.carstore.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "BrandNotExists")
public class BrandNotExistsException extends RuntimeException {

}
