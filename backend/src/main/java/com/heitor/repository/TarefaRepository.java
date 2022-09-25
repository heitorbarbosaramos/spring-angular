package com.heitor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.heitor.domain.Tarefa;

@Repository
public interface TarefaRepository extends JpaRepository<Tarefa, Integer> {

}
