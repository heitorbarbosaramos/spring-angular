package com.heitor.domain;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Tarefa {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@NotNull(message = "Campo não pode ser vazio")
	private String descricao;
	@NotNull(message = "Campo não pode ser vazio")
	private Boolean realizado;
	@NotNull(message = "Campo não pode ser vazio")
	private LocalDateTime tarefaCriada;
	private LocalDateTime tarefaConcluida;
	
	@PrePersist
	public void brforeSave() {
		setTarefaCriada(LocalDateTime.now());
	}

}
