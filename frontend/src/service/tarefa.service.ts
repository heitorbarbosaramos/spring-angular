import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Tarefa } from 'src/app/model/Tarefa';
import { Observable } from 'rxjs'

@Injectable({
  providedIn: 'root'
})
export class TarefaService {

  BASE_URL = 'http://localhost:8080/api/tarefa';

  constructor(private http : HttpClient) { }

  salvar(tarefa : Tarefa) : Observable<Tarefa>{
    return this.http.post<Tarefa>(this.BASE_URL, tarefa)
  }

  listar() : Observable<Tarefa[]>{
    return this.http.get<Tarefa[]>(this.BASE_URL);
  }
}
