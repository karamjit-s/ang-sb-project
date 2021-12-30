import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Observable } from "rxjs";
import { company } from "../../../models/company";
import { CompanyService } from '../../../service/rest-api/company.service';

@Component({
  selector: 'app-company-list',
  templateUrl: './company-list.component.html',
  styleUrls: ['./company-list.component.css']
})
export class CompanyListComponent  implements OnInit {
    
    company: Observable<company[]>;
    

    constructor(private companyService: CompanyService,
      private router: Router) {}


      
  ngOnInit()
  {
    this.reloadData();
  }
  
  reloadData() {
    this.company = this.companyService.getCompanyList();
  }

  deleteCompany(id: number) {
    this.companyService.deleteCompany(id)
      .subscribe(
        data => {
          console.log(data);
          this.reloadData();
        },
        error => console.log(error));
  }

  companyDetails(cid: number){
    this.router.navigate(['details', cid]);
  }

  updateCompany(cid: number){
    this.router.navigate(['update', cid]);
  }


}
