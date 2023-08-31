import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class StatisticsService {

  constructor(private http: HttpClient) { }

  API = 'http://localhost:9091';

  public getDownloadedTasksCountAndPoints() {
    return this.http.get(this.API + '/getDownloadedTasksCountAndPoints');
  }

  public getFullPointData() {
    return this.http.get(this.API + '/getFullPointData');
  }

  public getPercentageDownloaded() {
    return this.http.get(this.API + '/getPercentageDownloaded');
  }

  public getCountDownloaded() {
    return this.http.get(this.API + '/getCountDownloaded');
  }
}
