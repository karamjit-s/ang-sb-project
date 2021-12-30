import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { add_element_cdk } from 'src/app/models/add_element_cdk';
import { TestCdkServiceService } from 'src/app/service/rest-api/test-cdk-service.service';

@Component({
  selector: 'app-add-element',
  templateUrl: './add-element.component.html',
  styleUrls: ['./add-element.component.css']
})
export class AddElementComponent implements OnInit {

  

// Code Start here
// add_element_cdk: Employee = new Employee();

add_element_cdk: add_element_cdk =  new add_element_cdk();
submitted = false;

constructor(private testCdkServiceService: TestCdkServiceService,
  private router: Router) { }

ngOnInit() {
}

onSubmit() {
  this.submitted = true;
  this.save();
}

// newEmployee(): void {
//   this.submitted = false;
//   this.signUp = new SignUp();
// }

save() {
  this.testCdkServiceService.addElement(this.add_element_cdk).subscribe(data => {
    console.log(data)
    this.add_element_cdk = new add_element_cdk();
    this.gotoList();
  },
    error => console.log(error));
}

gotoList() {
  this.router.navigate(['/test_cdk']);
}

// end //

}
