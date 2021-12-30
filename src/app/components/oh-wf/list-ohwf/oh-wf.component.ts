import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { ohwf } from 'src/app/models/ohwf';
import { OhwfserviceService } from 'src/app/service/rest-api/ohwfservice.service';
import { wf_fp_service } from 'src/app/service/rest-api/wf_fp_service.service';


@Component({
  selector: 'app-oh-wf',
  templateUrl: './oh-wf.component.html',
  styleUrls: ['./oh-wf.component.css']
})
export class OhWfComponent implements OnInit {

  //code start here //


  ohwf: Observable<ohwf[]>;

  constructor(private ohWfService: OhwfserviceService,
    private router: Router) { }

  wfs: wf_fp_service;

  ngOnInit() {
    this.reloadData();
  }

  reloadData() {
    this.ohwf = this.ohWfService.getOhFormList();
  }

  deleteOhwf(ohwf_id: number) {
    this.ohWfService.deleteOhwf(ohwf_id)
      .subscribe(
        data => {
          console.log(data);
          this.reloadData();
        },
        error => console.log(error));
  }


  updateOhwf(ohwf_id: number) {
    this.router.navigate(['update_ohwf', ohwf_id]);
  }


  //build wireframe //
  build_wf(ohwf_id: number) {
    this.ohwf = this.wfs.build_wf(ohwf_id)

    this.reloadData();

  }

  //code end here //


}
