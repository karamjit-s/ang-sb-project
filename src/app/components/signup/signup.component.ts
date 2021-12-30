import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { SignupService } from 'src/app/service/rest-api/signup.service';
import { SignUp } from '../../models/signUp';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {


  // Code Start here

  signUp: SignUp = new SignUp();
  submitted = false;

  constructor(private signupService: SignupService,
    private router: Router) { }

  ngOnInit() {
  }

  onSubmit() {
    this.submitted = true;
    this.save();
  }

  newEmployee(): void {
    this.submitted = false;
    this.signUp = new SignUp();
  }

  save() {
    this.signupService.createSignUp(this.signUp).subscribe(data => {
      console.log(data)
      this.signUp = new SignUp();
      this.gotoList();
    },
      error => console.log(error));
  }

  gotoList() {
    this.router.navigate(['/home']);
  }

  // end //

}






