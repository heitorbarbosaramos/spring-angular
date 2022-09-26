package com.heitor.exceptions.resources;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MensagemErrorPadrao {
	
	private String statusHttp;
    private String mensagem;
    private String path;
    @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
    private LocalDateTime data;

}
