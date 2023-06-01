import { Component, OnInit } from '@angular/core';
import { AbstractControl, FormControl, FormGroup, ValidationErrors, ValidatorFn, Validators } from '@angular/forms';
import { UserRegistrationService } from '../_services/user-registration.service';

@Component({
  selector: 'app-user-registration',
  templateUrl: './user-registration.component.html',
  styleUrls: ['./user-registration.component.css']
})
export class UserRegistrationComponent implements OnInit {
  title = 'Register new user';

  userDetails = null as any;

  registerForm: FormGroup

  constructor(private userRegistrationService: UserRegistrationService) {
    this.registerForm = new FormGroup({
      userName : new FormControl(null,[Validators.required]),
      userPassword : new FormControl(null,[Validators.required]),
      confirmPassword : new FormControl(null)
    },
    {
      validators:matchpassword
    })

  }
  ngOnInit(): void {

  }

  register() {
    this.userRegistrationService.registerUser(this.registerForm.value).subscribe(
      (resp) =>{
        console.log('register response: ' + resp);
        this.registerForm.reset();
      },
      (err) => {
        console.log(err);
      }
    );
  }

  }

  export const matchpassword : ValidatorFn = (control: AbstractControl):ValidationErrors|null =>{

    let userPassword = control.get('userPassword');
    let confirmPassword = control.get('confirmPassword');
    if(userPassword && confirmPassword && userPassword?.value != confirmPassword?.value){
       return {
           passwordmatcherror : true }
    }
   return null;
  }
