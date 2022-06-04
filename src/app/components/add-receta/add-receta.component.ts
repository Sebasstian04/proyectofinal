import { Component, OnInit } from '@angular/core';
import { Receta } from 'src/app/model/receta';
import { RecetaService } from 'src/app/services/receta.service';

@Component({
  selector: 'app-add-receta',
  templateUrl: './add-receta.component.html',
  styleUrls: ['./add-receta.component.css']
})
export class AddRecetaComponent implements OnInit {

  receta = new Receta();
  submitted = false;
  msgError = '';

  constructor(private recetaService: RecetaService) { }

  ngOnInit(): void {
  }

  existsPK (val:string): void {
    this.recetaService.get(val)
      .subscribe(
        data => {
          console.log(data);
        },
        error => {
          console.log(error);
        });
  }

  saveReceta(): void {
    const data = {
      id: this.receta.id,
      nombre: this.receta.nombre,
      cantidad: this.receta.cantidad,
      ingredientes: this.receta.ingredientes,
      descripcion: this.receta.descripcion
    };

    this.recetaService.create(data)
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

  newReceta() {
    this.submitted = false;
    this.receta.id = null;
    this.receta.nombre = null;
    this.receta.cantidad = null;
    this.receta.ingredientes = null;
    this.receta.descripcion = null;
  }

}