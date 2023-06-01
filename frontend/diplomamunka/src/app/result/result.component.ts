import { Component } from '@angular/core';
import { NgForm } from '@angular/forms';
import { ResultService } from '../_services/result.service';

@Component({
  selector: 'app-result',
  templateUrl: './result.component.html',
  styleUrls: ['./result.component.css']
})
export class ResultComponent {

  resultDetails = null as any;

  resultToUpdate = {
    resultID: "",
    assignment_name: "",
    assignment_url: "",
    starter_code_url: "",
    github_username: "",
    roster_identifier: "",
    student_repository_name: "",
    student_repository_url: "",
    submission_timestamp: "",
    points_awarded: "",
    points_available: ""
  }

  constructor(private resultService: ResultService) {
    this.getResultDetails()
  }

  register(registerForm: NgForm) {
    this.resultService.registerResult(registerForm.value).subscribe(
      (resp) =>{
        console.log(resp);
        registerForm.reset();
        this.getResultDetails();
      },
      (err) => {
        console.log(err);
      }
    );
  }

  getResultDetails() {
    this.resultService.getResult().subscribe(
      (resp) => {
        console.log(resp);
        this.resultDetails = resp;
      },
      (err) => {
        console.log(err);
      }
    )
  }

  deleteResult(result: any) {
    this.resultService.deleteResult(result.resultID).subscribe(
      (resp) => {
        console.log(resp);
        this.getResultDetails();
      },
      (err) => {
        console.log(err);
      }
    )
  }

  edit(result: any) {
    this.resultToUpdate = result;
  }

  updateResult() {
    this.resultService.updateResult(this.resultToUpdate).subscribe(
      (resp) => {
        console.log(resp);
        this.getResultDetails();
      },
      (err) => {
        console.log(err);
      }
    )
  }



}

