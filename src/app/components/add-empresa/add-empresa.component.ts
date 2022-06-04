import { Component, OnInit } from '@angular/core';
import { EmpresaService } from 'src/app/services/empresa/empresa.service';
import 

@Component({
  selector: 'app-add-empresa',
  templateUrl: './add-empresa.component.html',
  styleUrls: ['./add-empresa.component.css']
})
export class AddEmpresaComponent implements OnInit {

  empresa = new Empresa();
  submitted = false;
  msgError = '';

  constructor( private empresaService: EmpresaService)  { }

  ngOnInit(): void {

    existsPK (val:string): void {
      this.empresaService.get(val)
        .subscribe(
          data => {
            console.log(data);
          },
          error => {
            console.log(error);
          });
    }
  
    saveEmpresa(): void {
      const data = {
        id: this.author.id,
        name: this.author.name,
        nationality: this.author.nationality
      };
  
      this.authorService.create(data)
        .subscribe(
          data => {
            this.submitted=true;
            console.log(data);
          },
          error => {
            this.msgError  = error.message +' \n '+ error.error.message;
            console.log(error);
          });
    }
  
    newEmpresa() {
      this.submitted = false;
      this.empresa.id = null;
      this.empresa.razonsocial = null;
      this.empresa.nit = null;
    }
  
  }

}
