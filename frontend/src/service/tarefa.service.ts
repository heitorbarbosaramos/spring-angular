import { Injectable } from '@angular/core';
import { Tarefa } from 'src/app/model/Tarefa';
import { Observable } from 'rxjs'
import { HttpClient } from '@angular/common/http'

@Injectable({
  providedIn: 'root'
})

export class TarefaService {

  apiUrl  = 'http://localhost:8080/api/tarefa';

  constructor(private http : HttpClient) { }

  salvar(tarefa : Tarefa) : Observable<Tarefa>{
     return this.http.post<Tarefa>(this.apiUrl, tarefa);
  }
}
