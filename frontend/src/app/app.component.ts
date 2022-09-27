import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder ,FormControl, Validators } from '@angular/forms'
import { TarefaService } from 'src/service/tarefa.service';
import { Tarefa } from './model/Tarefa';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {

  constructor(private service: TarefaService, private formBuilder: FormBuilder) { }


  listTarefa: Tarefa[] = [];
  formulario!: FormGroup;
  
  ngOnInit(): void {

    this.listarTarefas();
    this.validaFormulario();
       
  }

  //https://www.alura.com.br/artigos/como-aplicar-validacao-formularios-reativos-angular
  validaFormulario(){
    this.formulario = this.formBuilder.group({
      descricao: new FormControl('', [Validators.required, Validators.minLength(5)])
    })
  }

  listarTarefas() {
    return this.service.listar().subscribe(t => this.listTarefa = t);
  }


  salvar() {
    console.log(this.formulario.value)
    const tarefa: Tarefa = { ...this.formulario.value };
    console.log(tarefa)
    this.service.salvar(tarefa).subscribe(t => {
      this.listTarefa.push(tarefa);
      this.formulario.reset();
    })
  }

  finalizarTarefa(tarefa : Tarefa){
    tarefa.realizado =!tarefa.realizado
    this.service.update(tarefa).subscribe(t=>{
      console.log("ATUALIZADO ", t)
      this.listarTarefas();
    })
  }

  delete(id: number){
    this.service.delete(id).subscribe({
      next:(response) => this.listarTarefas()
    })
  }
 

}
