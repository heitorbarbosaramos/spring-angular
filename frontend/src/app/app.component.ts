import { Component } from '@angular/core';
import { FormGroup, FormControl } from '@angular/forms'
import { TarefaService } from 'src/service/tarefa.service';
import { Tarefa } from './model/Tarefa';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  form: FormGroup = new FormGroup({
    descricao:  new FormControl('')
  })

  constructor(private service : TarefaService){}

  submit(){
    console.log(this.form.value)
    const tarefa : Tarefa = { ...this.form.value}
    this.service.salvar(tarefa).subscribe(salvarTarefa => console.log(salvarTarefa))
  }
}
