import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './components/login/login.component';
import { LogoutComponent } from './components/logout/logout.component';
import { AddRecetaComponent } from './components/add-receta/add-receta.component';
import { ListRecetaComponent } from './components/list-receta/list-receta.component';
import { AddUsuarioComponent } from './components/add-usuario/add-usuario.component';
import { UpdateUsuarioComponent } from './components/update-usuario/update-usuario.component';

const routes: Routes = [
  { path: 'login', component: LoginComponent },
  { path: '', redirectTo: 'login', pathMatch: 'full'},
  { path: 'logout', component: LoginComponent },
  { path: 'addReceta', component: AddRecetaComponent },
  { path: 'listReceta', component: ListRecetaComponent },
  { path: 'addUsuario', component: AddUsuarioComponent },
  { path: 'updateUsuario', component: UpdateUsuarioComponent }


];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
