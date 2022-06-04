import { Component, OnInit } from '@angular/core';
import { Usuario } from 'src/app/model/usuario';
import { UsuarioService } from 'src/app/services/usuario.service';

@Component({
  selector: 'app-add-usuario',
  templateUrl: './add-usuario.component.html',
  styleUrls: ['./add-usuario.component.css']
})
export class AddUsuarioComponent implements OnInit {

  usuario = new Usuario();
  submitted = false;
  msgError = '';

  constructor(private usuarioService: UsuarioService) { }

  ngOnInit(): void {
  }

  existsPK (val:string): void {
    this.usuarioService.get(val)
      .subscribe(
        data => {
          console.log(data);
        },
        error => {
          console.log(error);
        });
  }

  saveUsuario(): void {
    const data = {
      id: this.usuario.id,
      nombre: this.usuario.nombre,
      apellido: this.usuario.apellido,
      municipio: this.usuario.municipio,
      correo: this.usuario.correo,
      cedula: this.usuario.cedula,
      login: this.usuario.login,
      password: this.usuario.password
      
    };

    this.usuarioService.create(data)
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

  newUsuario() {
    this.submitted = false;
    this.usuario.id = null;
    this.usuario.nombre = null;
    this.usuario.apellido = null;
    this.usuario.municipio = null;
    this.usuario.correo = null;
    this.usuario.cedula = null;
    this.usuario.login = null;
    this.usuario.password = null;
  }

}