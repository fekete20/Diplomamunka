import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';
import { StudentComponent } from './student/student.component';
import { LoginComponent } from './login/login.component';
import { HeaderComponent } from './header/header.component';
import { ForbiddenComponent } from './forbidden/forbidden.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HTTP_INTERCEPTORS, HttpClientModule } from '@angular/common/http'
import { RouterModule } from '@angular/router';
import { AuthGuard } from './_auth/auth.guard';
import { AuthInterceptor } from './_auth/auth.interceptor';
import { UserService } from './_services/user.service';
import { ResultComponent } from './result/result.component';
import { ListComponent } from './list/list.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatTableModule } from '@angular/material/table';
import { MatPaginatorModule } from '@angular/material/paginator';
import { Ng2SearchPipeModule } from 'ng2-search-filter';
import { NgxPaginationModule } from 'ngx-pagination';
import { Ng2OrderModule } from 'ng2-order-pipe';
import { UploadCsvComponent } from './upload-csv/upload-csv.component';
import { UserRegistrationComponent } from './user-registration/user-registration.component';
import { StatisticsComponent } from './statistics/statistics.component';
import {MatExpansionModule} from "@angular/material/expansion";


@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    StudentComponent,
    LoginComponent,
    HeaderComponent,
    ForbiddenComponent,
    ResultComponent,
    ListComponent,
    UploadCsvComponent,
    UserRegistrationComponent,
    StatisticsComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    RouterModule,
    ReactiveFormsModule,
    BrowserAnimationsModule,
    MatTableModule,
    MatPaginatorModule,
    Ng2SearchPipeModule,
    NgxPaginationModule,
    Ng2OrderModule,
    MatExpansionModule
  ],
  providers: [
    AuthGuard,
    {
      provide: HTTP_INTERCEPTORS,
      useClass: AuthInterceptor,
      multi: true
    },
    UserService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
