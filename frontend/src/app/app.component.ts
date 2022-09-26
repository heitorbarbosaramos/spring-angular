import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl } from '@angular/forms'
import { TarefaService } from 'src/service/tarefa.service';
import { Tarefa } from './model/Tarefa';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {

  constructor(private service: TarefaService) { }


  listTarefa: Tarefa[] = [];

  ngOnInit(): void {
    this.listarTarefas();
  }

  listarTarefas() {
    return this.service.listar().subscribe(t => this.listTarefa = t);
  }

  form: FormGroup = new FormGroup({
    descricao: new FormControl('')
  })

  salvar() {
    console.log(this.form.value)
    const tarefa: Tarefa = { ...this.form.value };
    this.service.salvar(tarefa).subscribe(t => {
      this.listTarefa.push(tarefa);
      this.form.reset()
    }
    );
  }

  finalizarTarefa(tarefa: Tarefa) {
    tarefa.realizado = !tarefa.realizado;
    this.service.update(tarefa).subscribe(
      t => {
        console.log("ATUALIZADO ", t);
        this.listarTarefas();
      })
  }

  delete(id: number) {
    this.service.delete(id).subscribe({
      next: (response) => this.listarTarefas()
    }
    )
  }
}
