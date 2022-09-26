package com.heitor.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.heitor.domain.Tarefa;
import com.heitor.service.TarefaService;

@Service
public class DBInstancia {
	
	private final TarefaService service;
	
	@Autowired
	public DBInstancia(TarefaService service) {
		this.service = service;
	}

	
	public void addTarefa() {
		Tarefa tarefa1 = new Tarefa(null, "Tarefa um", false, null, null);
		Tarefa tarefa2 = new Tarefa(null, "Tarefa um", false, null, null);
		Tarefa tarefa3 = new Tarefa(null, "Tarefa um", false, null, null);
		
		service.save(tarefa1);
		service.save(tarefa2);
		service.save(tarefa3);
		
		
	}

}
