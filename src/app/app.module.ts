import { BrowserModule } from '@angular/platform-browser';
import { CUSTOM_ELEMENTS_SCHEMA,NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { EmployeeListComponent } from './components/employee/employee-list/employee-list.component';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { HttpInterBasicAuthService } from './service/http/http-inter-basic-auth.service';

import { UpdateEmployeeComponent } from './components/update-employee/update-employee.component';
import { HomeComponent } from './components/home/home.component';
import { AddCompanyComponent } from './components/company/add-company/add-company.component';
import { CompanyListComponent } from './components/company/company-list/company-list.component';
import { MatToolbarModule } from '@angular/material/toolbar';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { NgxBootstrapIconsModule, allIcons } from 'ngx-bootstrap-icons';
import { MatSliderModule } from '@angular/material/slider';
import { MatIconModule } from '@angular/material/icon';
import { MatCardModule } from '@angular/material/card';
import { MatButtonModule } from '@angular/material/button';
import { MatMenuModule } from '@angular/material/menu';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { CommonModule } from "@angular/common";
import { MatExpansionModule } from '@angular/material/expansion';
import { MatFormFieldModule } from "@angular/material/form-field";
import { MatInputModule } from "@angular/material/input";
import { MatCheckboxModule } from "@angular/material/checkbox";
import { MatSlideToggleModule } from "@angular/material/slide-toggle";
import { MatTableModule } from "@angular/material/table";
import { MatPaginatorModule } from '@angular/material/paginator';
import { MatSortModule } from '@angular/material/sort';
import { MatAutocompleteModule } from "@angular/material/autocomplete";
import { MatTabsModule } from "@angular/material/tabs";
import { MatRadioModule } from "@angular/material/radio";
import { MatDatepickerModule } from "@angular/material/datepicker";
import { MatNativeDateModule } from "@angular/material/core";
import { MatSelectModule } from "@angular/material/select";
import { SharedModule } from './shared/shared.module';
// import { NavbarComponent } from './navbar/navbar.component';
// import { TopNavComponent } from './navbar/top-nav/top-nav.component';
// import { SideNavComponent } from './navbar/side-nav/side-nav.component';
import { MatListModule } from '@angular/material/list';
import { MatSidenavModule } from '@angular/material/sidenav';
import { AddMenuComponent } from './components/add-menu/add-menu.component';
import { StudentComponent } from './components/student/student.component';
import { SignupComponent } from './components/signup/signup.component';
import { LoginComponent } from './components/login/login.component';
import { MatStepperModule } from '@angular/material/stepper';
import { MDBBootstrapModule} from 'angular-bootstrap-md';
import { CreateOhwfComponent } from './components/oh-wf/create-ohwf/create-ohwf.component';
import { CreateEmployeeComponent } from './components/employee/create-employee/create-employee.component';
import { EmployeeDetailsComponent } from './components/employee/employee-details/employee-details.component';
import { OhWfComponent } from './components/oh-wf/list-ohwf/oh-wf.component';
import { OhwfUpdateComponent } from './components/oh-wf/ohwf-update/ohwf-update.component';
import { CreateHeaderLineComponent } from './components/header-line/create-header-line/create-header-line.component';
import { BasicAuthenticationService } from './service/http/basic-authentication.service';
// import { TestcdkComponent } from './components/testcdk/testcdk.component';
import { DragDropModule } from '@angular/cdk/drag-drop';
import { AddElementComponent } from './components/testcdk/add-element/add-element.component';
// import { TestcdkComponent } from './components/testcdk/list-test-cdk/testcdk.component';
import { MainTestCdkComponent } from './components/testcdk/main-test-cdk/main-test-cdk.component';
import { NavbarComponent } from './components/navbar/navbar.component';
import { SideNavComponent } from './components/navbar/side-nav/side-nav.component';
import { TopNavComponent } from './components/navbar/top-nav/top-nav.component';



@NgModule({

  imports: [
   
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    NgbModule,
    NgxBootstrapIconsModule.pick(allIcons),
    BrowserAnimationsModule,
    SharedModule,
    CommonModule,
    HttpClientModule,
    MatMenuModule,
    MatTabsModule,
    MatAutocompleteModule,
    MatSlideToggleModule,
    MatTableModule,
    MatPaginatorModule,
    MatSortModule,
    MatToolbarModule,
    MatFormFieldModule,
    MatInputModule,
    MatButtonModule,
    MatCardModule,
    MatCheckboxModule,
    MatRadioModule,
    MatDatepickerModule,
    MatNativeDateModule,
    MatFormFieldModule,
    MatSelectModule,
    MatSliderModule,
    MatIconModule,
    MatExpansionModule,
    MatListModule,
    MatTabsModule,
    MatSidenavModule,
    MatStepperModule,
    FormsModule,
    DragDropModule,

    [MDBBootstrapModule.forRoot()],
   

  ],

  declarations: [
    AppComponent,
    CreateEmployeeComponent,
    EmployeeDetailsComponent,
    EmployeeListComponent,
    UpdateEmployeeComponent,
    HomeComponent,
    AddCompanyComponent,
    CompanyListComponent,
    NavbarComponent,
    TopNavComponent,
    SideNavComponent,
    AddMenuComponent,
    StudentComponent,
    SignupComponent,
    LoginComponent,
    OhWfComponent,
    CreateOhwfComponent,
    OhwfUpdateComponent,
    CreateHeaderLineComponent,
    // TestcdkComponent,
    AddElementComponent,
    MainTestCdkComponent,
 
    
    // For MDB Angular Free

    
    
    
    //  ListComponent,
    //  AddComponent,
    //  Header_lineComponent,
    //  Header_lineModule


  ],
  providers: [
    BasicAuthenticationService,

    {provide: HTTP_INTERCEPTORS, useClass: HttpInterBasicAuthService, multi: true}
  ],
  bootstrap: [AppComponent],

  schemas: [
    CUSTOM_ELEMENTS_SCHEMA
  ],
})

  
 

export class AppModule {




}
