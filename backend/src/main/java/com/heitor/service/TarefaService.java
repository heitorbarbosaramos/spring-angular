package com.heitor.service;

import java.util.List;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.heitor.domain.Tarefa;
import com.heitor.repository.TarefaRepository;

@Service
public class TarefaService {

	private final TarefaRepository repo;
	
	@Autowired
	public TarefaService(TarefaRepository repo) {
		this.repo = repo;
	}
	
	public Tarefa save(Tarefa tarefa) {
		return repo.save(tarefa);
	}
	
	public Tarefa findById(Integer id) {
		Tarefa tarefa = repo.findById(id).orElseThrow(()-> new ObjectNotFoundException("Tarefa não encontrada: ", TarefaService.class.getName()));
		return tarefa;
	}
	
	public List<Tarefa> findAll(){
		return repo.findAll();
	}
}
