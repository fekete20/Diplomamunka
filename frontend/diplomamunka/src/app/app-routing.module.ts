import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { StudentComponent } from './student/student.component';
import { LoginComponent } from './login/login.component';
import { ForbiddenComponent } from './forbidden/forbidden.component';
import { ResultComponent } from './result/result.component';
import { ListComponent } from './list/list.component';
import { UploadCsvComponent } from './upload-csv/upload-csv.component';
import { UserRegistrationComponent } from './user-registration/user-registration.component';
import {StatisticsComponent} from "./statistics/statistics.component";

const routes: Routes = [
  {
    path: 'home', component: HomeComponent
  },
  {
    path: 'student', component: StudentComponent
  },
  {
    path: 'login', component: LoginComponent
  },
  {
    path: 'forbidden', component: ForbiddenComponent
  },
  {
    path: 'results', component: ResultComponent
  },
  {
    path: 'list', component: ListComponent
  },
  {
    path: 'uploadStudents', component: UploadCsvComponent
  },
  {
    path: 'registerUser', component: UserRegistrationComponent
  },
  {
    path: 'statistics', component: StatisticsComponent
  }

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
