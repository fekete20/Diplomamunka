import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class UserRegistrationService {

  constructor(private http: HttpClient) { }

  API = 'http://localhost:9091';

  public registerUser(userData: any) {
    return this.http.post(this.API + '/registerNewUser', userData);

  }

}
