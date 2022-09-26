package com.heitor.resources;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.heitor.domain.Tarefa;
import com.heitor.service.TarefaService;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/tarefa")
public class TarefaResources {

	private final TarefaService service;
	
	public TarefaResources(TarefaService service) {
		this.service = service;
	}
	
	@PostMapping
	public ResponseEntity<Void> save(@RequestBody @Valid Tarefa tarefa){
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(service.save(tarefa).getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Tarefa> findById(@PathVariable(name = "id") Integer id){
		return ResponseEntity.ok(service.findById(id));
	}
	
	@GetMapping
	public ResponseEntity<List<Tarefa>> findAll(){
		return ResponseEntity.ok(service.findAll());
	}
}
