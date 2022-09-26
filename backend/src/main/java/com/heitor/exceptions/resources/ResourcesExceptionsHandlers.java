package com.heitor.exceptions.resources;

import java.time.LocalDateTime;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import lombok.extern.slf4j.Slf4j;

@ControllerAdvice
@Slf4j
public class ResourcesExceptionsHandlers {
	
	@ExceptionHandler(org.hibernate.ObjectNotFoundException.class)
    public ResponseEntity<MensagemErrorPadrao> objectNotFoundExceptions(org.hibernate.ObjectNotFoundException e, HttpServletRequest request){

        HttpStatus status = HttpStatus.NOT_FOUND;

        MensagemErrorPadrao padrao = new MensagemErrorPadrao();
        padrao.setStatusHttp(status.toString());
        padrao.setMensagem(e.getMessage());
        padrao.setPath(request.getRequestURI());
        padrao.setData(LocalDateTime.now());

        log.error(e.getMessage());
        e.getStackTrace();

        return ResponseEntity.status(status).body(padrao);
    }

}
