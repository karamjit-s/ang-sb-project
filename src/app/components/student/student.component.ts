import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { student } from '../../models/student';
import { StudentServiceService } from '../../service/rest-api/student-service.service';

@Component({
  selector: 'app-student',
  templateUrl: './student.component.html',
  styleUrls: ['./student.component.css']
})
export class StudentComponent implements OnInit {

  student: Observable<student[]>;
    

  constructor(private studentService: StudentServiceService,
    private router: Router) {}


    
ngOnInit()
{
  this.reloadData();
}

reloadData() {
  this.student = this.studentService.getStudentList();
}

deleteStudent(id: number) {
  this.studentService.deleteStudent(id)
    .subscribe(
      data => {
        console.log(data);
        this.reloadData();
      },
      error => console.log(error));
}

studentDetails(cid: number){
  this.router.navigate(['details', cid]);
}

updateStudent(cid: number){
  this.router.navigate(['update', cid]);
}


}
