import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class EmployerService {

  baseUrl = "http://localhost:8080/api/employers"

  constructor(private httpClient:HttpClient) { }


  getEmployers():Observable<any> {
    //const headers = new HttpHeaders().set('Content-type', 'application/json;charset=utf-8');
    return this.httpClient.get(this.baseUrl)
  }
}
