package com.example.apicadastro.exceptions;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.http.HttpStatus;

@Data
@EqualsAndHashCode(callSuper = true)
public class UsuarioException extends RuntimeException  {

    private HttpStatus code;
    private String message;

    public UsuarioException(HttpStatus code, String message) {
        super(message);
        this.code = code;
        this.message = message;
    }
}
