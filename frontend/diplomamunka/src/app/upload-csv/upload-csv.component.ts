import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import {ResultService} from "../_services/result.service";

@Component({
  selector: 'app-upload-csv',
  templateUrl: './upload-csv.component.html',
  styleUrls: ['./upload-csv.component.css']
})
export class UploadCsvComponent implements OnInit {

   selectedFile: File | null | undefined;

  constructor(private http: HttpClient, private resultService: ResultService) { }

  ngOnInit() {}

  onFileSelected(event: any) {
    this.selectedFile = event.target.files[0];
  }

  csvResultsToDB() {
    this.resultService.csvResultsToDB().subscribe(
      (resp) =>
      {
        console.log(resp)
      },
      (err) => {
        console.log(err)
      }
    )
  }

  uploadResultFile() {
    if (!this.selectedFile) {
      console.error('No file selected.');
      return;
    }

    const uploadData = new FormData();
    uploadData.append('file', this.selectedFile, this.selectedFile.name);

    this.http.post('http://localhost:9091/uploadResultData', uploadData)
      .subscribe(res => {
        console.log(res);
        alert('Sikeresen adatbázisba írva.')
      }, err => {
        console.error(err);
      });

  }

  uploadFile() {
    if (!this.selectedFile) {
      console.error('No file selected.');
      return;
    }

    const uploadData = new FormData();
    uploadData.append('file', this.selectedFile, this.selectedFile.name);

    this.http.post('http://localhost:9091/uploadStudentData', uploadData)
      .subscribe(res => {
        console.log(res);
        alert('Sikeresen adatbázisba írva.')
      }, err => {
        console.error(err);
      });
  }
}
