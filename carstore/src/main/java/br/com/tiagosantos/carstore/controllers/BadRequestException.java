package br.com.tiagosantos.carstore.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "ParamNotValid")
public class BadRequestException extends RuntimeException {

}
