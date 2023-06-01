import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class ListService {

  constructor(private http: HttpClient) {

  }

  API = 'http://localhost:9091'
  public getAllData() {
    return this.http.get(this.API + '/getCommonTable');
  }

}
