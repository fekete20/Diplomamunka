import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class ResultService {

  constructor(private http: HttpClient) { }

  API = 'http://localhost:9091';

  public registerResult(resultData: any) {
    return this.http.post(this.API + '/registerResult', resultData);
  }

  public getResult() {
    return this.http.get(this.API + '/getResults');
  }

  public deleteResult(id: any) {
    return this.http.delete(this.API + '/deleteResult?id=' + id);
  }

  public updateResult(result: any) {
    return this.http.put(this.API + '/updateResult', result);
  }

  public csvResultsToDB() {
    return this.http.get(this.API + '/resultsToDB')
  }
}
