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
  
  constructor(private service : TarefaService){}

  form : FormGroup = new FormGroup({
    descricao : new FormControl('')
  })

  salvar(){
    console.log(this.form.value)
    const tarefa : Tarefa = {...this.form.value };
    this.service.salvar(tarefa).subscribe(
      this.form.reset
    );
  }
}
