import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ohwf } from 'src/app/models/ohwf';
import { OhwfserviceService } from 'src/app/service/rest-api/ohwfservice.service';

@Component({
  selector: 'app-ohwf-update',
  templateUrl: './ohwf-update.component.html',
  styleUrls: ['./ohwf-update.component.css']
})
export class OhwfUpdateComponent implements OnInit {

  ohwf_id: number;
  ohwf: ohwf;

  constructor(private route: ActivatedRoute, private router: Router,
    private ohWfService: OhwfserviceService) { }

  ngOnInit() {
    this.ohwf = new ohwf();

    this.ohwf_id = this.route.snapshot.params['ohwf_id'];

    this.ohWfService.getOhForm(this.ohwf_id)
      .subscribe(data => {
        console.log(data)
        this.ohwf = data;
      }, error => console.log(error));
  }


  onSubmit() {
    this.updateOhwf();
  }

  updateOhwf() {
    this.ohWfService.updateOhwf(this.ohwf_id, this.ohwf)
      .subscribe(data => {
        console.log(data);
        this.ohwf = new ohwf();
        this.gotoList();
      }, error => console.log(error));
  }



  gotoList() {
    this.router.navigate(['/only_header_wireframe']);
  }
}
