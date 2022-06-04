import { Component, OnInit } from '@angular/core';
import { Usuario } from 'src/app/model/usuario';
import { UsuarioService } from 'src/app/services/usuario.service';

@Component({
  selector: 'app-update-usuario',
  templateUrl: './update-usuario.component.html',
  styleUrls: ['./update-usuario.component.css']
})
export class UpdateUsuarioComponent implements OnInit {

  usuario = new Usuario();
  UsuarioFil: Usuario[];
  submitted = false;
  user = null;
  
  currentUsuario = null;
  msgError = '';

  constructor(private usuarioService: UsuarioService) { }

  ngOnInit(): void {
    this.user = sessionStorage.getItem("usuario")
    this.retrieveUsuario(this.user)
    console.log("lo mande a buscar", this.user)
  }
  
  retrieveUsuario(val:string): void {
    this.usuarioService.get(val)
      .subscribe(
        data => {
          this.currentUsuario = data;
          console.log(data);
        },
        error => {
          this.msgError =  error.message +' \n '+ error.error.message;
          console.log(error);
        });
  }

  updateUsuario(): void {
   this.usuarioService.update(this.currentUsuario.id, this.currentUsuario)
      .subscribe(
        data => {
          console.log(data);
        },
        error => {
          console.log(error);
        });
  }
}