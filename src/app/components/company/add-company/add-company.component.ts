import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { company } from "../../../models/company";
import { CompanyService } from '../../../service/rest-api/company.service';


@Component({
  selector: 'app-add-company',
  templateUrl: './add-company.component.html',
  styleUrls: ['./add-company.component.css']
})

export class AddCompanyComponent implements OnInit {

  constructor(private companyService: CompanyService,
    private router: Router) {}

  ngOnInit() {
  }
 
  
  company: company = new company();
  submitted = false;

  
  newCompany(): void {
    this.submitted = false;
    this.company = new company();
  }

  save() {
    this.companyService
    .addCompany(this.company).subscribe(data => {
      console.log(data)
      this.company = new company();
      this.gotoList();
    }, 
    error => console.log(error));
  }

  onSubmit() {
    this.submitted = true;
    this.save();    
  }

  gotoList() {
    this.router.navigate(['/company']);
  }

}
