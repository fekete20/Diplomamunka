import { Component } from '@angular/core';
import { StudentService } from '../_services/student.service';
import {
  AbstractControl,
  FormControl,
  FormGroup,
  ValidationErrors,
  ValidatorFn,
  Validators
} from '@angular/forms';

@Component({
  selector: 'app-student',
  templateUrl: './student.component.html',
  styleUrls: ['./student.component.css']
})
export class StudentComponent {

  studentDetails = null as any;

  registerForm: FormGroup

  studentToUpdate = {
    neptun_code: "",
    student_name: "",
    github_username: ""
  }

  constructor(private studentService: StudentService) {
    this.getStudentsDetails()
    this.registerForm = new FormGroup({
      neptun_code : new FormControl(null,[Validators.required]),
      student_name : new FormControl(null),
      github_username : new FormControl(null)
    }, {
      validators: neptuncodeerror
  })
  }

  register() {
    this.studentService.registerStudent(this.registerForm.value).subscribe(
      (resp) =>{
        console.log('register response: ' + resp);
        this.registerForm.reset();
        this.getStudentsDetails();
      },
      (err) => {
        console.log(err);
      }
    );
  }

  getStudentsDetails() {
    this.studentService.getStudent().subscribe(
      (resp) => {
        console.log(resp);
        this.studentDetails = resp;
      },
      (err) => {
        console.log(err);
      }
    )
  }

  deleteStudent(student: any) {
    this.studentService.deleteStudent(student.neptun_code).subscribe(
      (resp) => {
        console.log(resp);
        this.getStudentsDetails();
      },
      (err) => {
        console.log(err);
      }
    )
  }

  edit(student: any) {
    this.studentToUpdate = student;
  }

  updateStudent(/*student: any*/) {
    this.studentService.updateStudent(this.studentToUpdate).subscribe(
      (resp) => {
        console.log(resp);
        this.getStudentsDetails();
      },
      (err) => {
        console.log(err);
      }
    )
  }

}

export const neptuncodeerror : ValidatorFn = (control: AbstractControl):ValidationErrors|null =>{

  let neptun_code = control.get('neptun_code');
  console.log(neptun_code?.value)
  if(neptun_code && neptun_code?.value === null || !(neptun_code?.value.match("([0-9]|[A-Z]|[a-z]){6}"))){
    return {
      neptuncodeerror : true }
  }
  return null;
}
