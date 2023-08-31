import {Component, OnInit} from '@angular/core';
import { StatisticsService} from "../_services/statistics.service";

@Component({
  selector: 'app-statistics',
  templateUrl: './statistics.component.html',
  styleUrls: ['./statistics.component.css']
})
export class StatisticsComponent implements OnInit {

  resultData: any
  fullPointData: any
  percentageDownloaded: any
  countDownloaded: any
  constructor(private statisticsService: StatisticsService) {
    this.getContent()
  }

  ngOnInit(): void {
    this.getContent()
  }


  getContent() {
    this.statisticsService.getDownloadedTasksCountAndPoints().subscribe(
      (resp) => {
        console.log(resp);
        this.resultData = resp;
      },

      (err) => {
        console.log(err);
      }
    )
    this.statisticsService.getFullPointData().subscribe(
      (resp) => {
        console.log(resp);
        this.fullPointData = resp;
      },

      (err) => {
        console.log(err);
      }
    )
    this.statisticsService.getPercentageDownloaded().subscribe(
      (resp) => {
        console.log(resp);
        this.percentageDownloaded = resp;
      },

      (err) => {
        console.log(err);
      }
    )
    this.statisticsService.getCountDownloaded().subscribe(
      (resp) => {
        console.log(resp);
        this.countDownloaded = resp;
      },

      (err) => {
        console.log(err);
      }
    )
  }

}
