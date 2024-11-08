package br.com.fiap.on_data_cp2.controller;

import br.com.fiap.on_data_cp2.controller.dto.ErroDetalhesDTO;
import br.com.fiap.on_data_cp2.exception.DataFuturaException;
import br.com.fiap.on_data_cp2.exception.DentistaDuplicadoException;
import br.com.fiap.on_data_cp2.exception.NaoEncontradoException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(DataFuturaException.class)
    public ResponseEntity<ErroDetalhesDTO> handleDataPassadaException(DataFuturaException ex, WebRequest request) {
        ErroDetalhesDTO erroDetalhes = new ErroDetalhesDTO(LocalDateTime.now(), ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(erroDetalhes, HttpStatus.NOT_FOUND);
    }


    @ExceptionHandler(DentistaDuplicadoException.class)
    public ResponseEntity<ErroDetalhesDTO> handleDentistaDuplicadoException(DentistaDuplicadoException ex, WebRequest request) {
        ErroDetalhesDTO erroDetalhes = new ErroDetalhesDTO(LocalDateTime.now(), ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(erroDetalhes, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(NaoEncontradoException.class)
    public ResponseEntity<ErroDetalhesDTO> handleNaoEncontradoException(NaoEncontradoException ex, WebRequest request) {
        ErroDetalhesDTO erroDetalhes = new ErroDetalhesDTO(LocalDateTime.now(), ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(erroDetalhes, HttpStatus.NOT_FOUND);
    }
}
