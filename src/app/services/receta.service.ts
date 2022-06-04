import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Receta } from '../model/receta';

const baseUrl = 'http://localhost:8080/api/v1/Receta';

@Injectable({
  providedIn: 'root'
})
export class RecetaService {

  constructor(private http: HttpClient) { }

  getAll(): Observable<Receta[]> {
    return this.http.get<Receta[]>(baseUrl);
  }

  get(id: String): Observable<Receta> {
    return this.http.get<Receta>(`${baseUrl}/${id}`);
  }

  create(data: any): Observable<any> {
    return this.http.post(baseUrl, data);
  }

  update(id: string, data: any): Observable<any> {
    return this.http.put(`${baseUrl}/${id}`, data);
  }

  delete(id: string): Observable<any> {
    return this.http.delete(`${baseUrl}/${id}`);
  }

  deleteAll(): Observable<any> {
    return this.http.delete(baseUrl);
  }

}