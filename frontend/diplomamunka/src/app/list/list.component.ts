import { Component, OnInit } from '@angular/core';
import { ListService } from '../_services/list.service';

@Component({
  selector: 'app-list',
  templateUrl: './list.component.html',
  styleUrls: ['./list.component.css']
})
export class ListComponent implements OnInit {
  assignment_name : any
  neptun_code: any
  student_name: any

  listDetails = null as any;

  constructor(private listService: ListService) {
    this.getListDetails()
  }

  ngOnInit() {
    this.getListDetails()
  }

  // searching
  searchForAssignmentName() {
    if(this.assignment_name == "") {
      this.ngOnInit();
    } else {
        this.listDetails= this.listDetails.filter((res:any) =>{
        return res.assignment_name.toLocaleLowerCase().match(this.assignment_name.toLocaleLowerCase())
      })
    }
  }

  searchForNeptunCode() {
    if(this.neptun_code == "") {
      this.ngOnInit();
    } else {
      this.listDetails= this.listDetails.filter((res:any) =>{
        return res.neptun_code.toLocaleLowerCase().match(this.neptun_code.toLocaleLowerCase())
      })
    }
  }

  searchForStudentName() {
    if(this.student_name == "") {
      this.ngOnInit();
    } else {
      this.listDetails= this.listDetails.filter((res:any) =>{
        return res.student_name.toLocaleLowerCase().match(this.student_name.toLocaleLowerCase())
      })
    }
  }

  // sorting
  key: any='assignment_name';
  reverse: boolean = false;
  sort(key: any) {
    this.key = key;
    this.reverse = !this.reverse;
  }

  // pagination - if the page loads, the 1st page will be shown
  p: number = 1

  getListDetails() {
      this.listService.getAllData().subscribe(
        (resp) => {
          console.log(resp);
          this.listDetails = resp;
        },
        (err) => {
          console.log(err);
        }
      )
  }
}
