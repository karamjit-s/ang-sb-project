import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { EmployeeListComponent } from './components/employee/employee-list/employee-list.component';
import { UpdateEmployeeComponent } from './components/update-employee/update-employee.component';
import { HomeComponent } from './components/home/home.component';
import { CompanyListComponent } from './components/company/company-list/company-list.component';
import { AddCompanyComponent } from './components/company/add-company/add-company.component';
import { ListComponent } from './components/header-line/list-header-line/list_header_line.component';
import { AddMenuComponent } from './components/add-menu/add-menu.component';
import { StudentComponent } from './components/student/student.component';
import { SignupComponent } from './components/signup/signup.component';
import { LoginComponent } from './components/login/login.component';
import { CreateOhwfComponent } from './components/oh-wf/create-ohwf/create-ohwf.component';
import { CreateEmployeeComponent } from './components/employee/create-employee/create-employee.component';
import { EmployeeDetailsComponent } from './components/employee/employee-details/employee-details.component';
import { OhWfComponent } from './components/oh-wf/list-ohwf/oh-wf.component';
import { OhwfUpdateComponent } from './components/oh-wf/ohwf-update/ohwf-update.component';
import { AddElementComponent } from './components/testcdk/add-element/add-element.component';
import { MainTestCdkComponent } from './components/testcdk/main-test-cdk/main-test-cdk.component';

// import { TestcdkComponent } from './components/testcdk/testcdk.component';


const routes: Routes = [

  { path: '', redirectTo: 'employee', pathMatch: 'full' },
  { path: 'employees', component: EmployeeListComponent },
  { path: 'add', component: CreateEmployeeComponent },
  { path: 'update/:eid', component: UpdateEmployeeComponent },
  { path: 'details/:eid', component: EmployeeDetailsComponent },
  { path: 'home', component: HomeComponent },
  { path: 'company', component: CompanyListComponent },
  { path: 'add_company', component: AddCompanyComponent },
  // { path: '', redirectTo: 'company', pathMatch: 'full' },
  { path: '', redirectTo: 'home', pathMatch: 'full' },
  { path: 'header_line', component: ListComponent },
  // { path: 'add_header_line_record', component: AddComponent },
  { path: 'add_menu', component: AddMenuComponent },
  { path: 'student_list', component: StudentComponent },
  { path: 'signup', component: SignupComponent },
  { path: 'login', component: LoginComponent },

  { path: 'only_header_wireframe', component: OhWfComponent },
  { path: 'add_ohwf_record', component: CreateOhwfComponent },
  { path: 'update_ohwf/:ohwf_id', component: OhwfUpdateComponent },
  { path: 'update_ohwf_back', component: OhWfComponent },
  { path: 'test_cdk', component: MainTestCdkComponent },
  { path: 'add_element_into_test_cdk', component: AddElementComponent }

  
  
];


@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }







