import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';

import { FormsModule } from '@angular/forms';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { ListFilterPipe } from './services/listerfilter.service';
import { NgSelectModule } from '@ng-select/ng-select';
import { LoginComponent } from './components/login/login.component';
import { HttpInterceptorService } from './services/http-interceptor.service';
import { LogoutComponent } from './components/logout/logout.component';
import { AddRecetaComponent } from './components/add-receta/add-receta.component';
import { ListRecetaComponent } from './components/list-receta/list-receta.component';
import { AddUsuarioComponent } from './components/add-usuario/add-usuario.component';

import { UpdateUsuarioComponent } from './components/update-usuario/update-usuario.component';

@NgModule({
  declarations: [
    AppComponent,
    ListFilterPipe, 
    LoginComponent, 
    LogoutComponent,
    AddRecetaComponent,
    ListRecetaComponent,
    AddUsuarioComponent,
    UpdateUsuarioComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    AppRoutingModule,
    HttpClientModule,
    NgbModule,
    NgSelectModule
  ],
  providers: [    {
    provide: HTTP_INTERCEPTORS,
    useClass: HttpInterceptorService,
    multi: true
  }],
  bootstrap: [AppComponent]
})
export class AppModule { }
