package com.weslley.workshopmongo.resources.exception;

import com.weslley.workshopmongo.services.exception.ObjectNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

/**
 * Manipulador de excecoes na camada de recource, @ControllerAdvice -> Tratar possiveis erros nas requisicoes
 *
 */
@ControllerAdvice
public class ResourceExceptionHandler {

    /**
     * Tratar erro do objetoNotFoundException
     * Identificar excecao e realizar o tratamento -> @ExceptionHandler(ObjectNotFoundException.class)
     * @return status, err
     */
    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundException e, HttpServletRequest request) {

        HttpStatus status = HttpStatus.NOT_FOUND;

        // System.currentTimeMillis() -> estado tual do sistema
        var err = new StandardError(
                System.currentTimeMillis(),
                status.value(),
                "Não encontrado",
                e.getMessage(),
                request.getRequestURI()
                );

        // Controlar status manualmente
        return ResponseEntity.status(status).body(err);
    }
}
