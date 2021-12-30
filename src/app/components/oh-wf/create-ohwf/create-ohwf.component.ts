import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ohwf } from 'src/app/models/ohwf';
import { OhwfserviceService } from 'src/app/service/rest-api/ohwfservice.service';




@Component({
  selector: 'app-create-ohwf',
  templateUrl: './create-ohwf.component.html',
  styleUrls: ['./create-ohwf.component.css']
})
export class CreateOhwfComponent implements OnInit {

  //code starts here//

  constructor(private ohwfService: OhwfserviceService,
    private router: Router) { }

  ngOnInit() {
  }


  ohwf: ohwf = new ohwf();
  submitted = false;


  newOhForm(): void {
    this.ohwf = new ohwf();
  }

  save() {
    this.ohwfService
      .addOhForm(this.ohwf).subscribe(data => {
        console.log(data)
        this.ohwf = new ohwf();
        this.gotoList();
      },
        error => console.log(error));
  }

  onSubmit() {
    this.save();
  }

  gotoList() {
    this.router.navigate(['/only_header_wireframe']);
  }

}


