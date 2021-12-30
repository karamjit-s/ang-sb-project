import { Injectable } from "@angular/core";
import { Observable, BehaviorSubject } from "rxjs";
import { HttpClient, HttpErrorResponse, HttpHeaders } from "@angular/common/http";
import { map } from 'rxjs/operators';
import { Student } from '../../models/student';
import { Project } from "src/app/models/project";

@Injectable({
    providedIn: 'root',
})

export class Header_line_Service {
    
    private API_URL = "http://localhost:8080/api/header_line_t";

    dataChange: BehaviorSubject<Student[]> = new BehaviorSubject<Student[]>([]);
    
    readonly httpOptions = {
        headers: new HttpHeaders({
            'Content-Type': 'application/json'
        })
    };
    private extractData(res: Response) {
        let body = res;
        return body || {};
    }

    constructor(private http: HttpClient) { }

    get data(): Student[] {
        return this.dataChange.value;
    }
    /*====GET ALL DATA=======*/
    getAll(): any {
        return this.http.get<Student[]>(this.API_URL).subscribe(data => {
            this.dataChange.next(data);
        },
            (error: HttpErrorResponse) => {
                console.log(error.name + ' ' + error.message);
            });
    }
    /*=======GET DATA with ID*/
    getById(id: number): Observable<any> {
        return this.http.get(`${this.API_URL}/${id}`);
    }

    /*=========CREATE DATA=========*/
    create(student: Object): Observable<Object> {
        return this.http.post(`${this.API_URL}`, student);
    }

    /*==========UPDATE DATA=============*/
    update(id: number, value: any): Observable<Object> {
        return this.http.put(`${this.API_URL}/${id}`, value);
    }

    /*===========DELETE DATA=============*/
    delete(id: number): Observable<any> {
        return this.http.delete(`${this.API_URL}/${id}`, {
            responseType: "text"
        });
    }//=====LINE CODE WILL INJECT HERE========

    /*==========================LINE PART SERVICE METHODS=================================*/
    lineDataChange: BehaviorSubject<Project[]> = new BehaviorSubject<
    Project[]
    >([]);

    get line_data(): Project[] {
        return this.lineDataChange.value;
    }

    getLinesByHeaderId(headerId: number): any {
        return this.http.get<Project[]>(this.API_URL + "/" + headerId + "/project")
            .subscribe(data => {
                this.lineDataChange.next(data);
            }, (error: HttpErrorResponse) => {
                console.log(error.name + " " + error.message);
            });
    }

    getLineByHeaderIdAndLineId(headerId: number, lineId: number): Observable<any> {
        return this.http
            .get<Project[]>(this.API_URL + "/" + headerId + "/project/" + lineId);
    }

    createLineByHeaderId(headerId: number, rn_hl_test3_line_t: Object): Observable<any> {
        return this.http.post(this.API_URL + '/' + headerId + '/project', rn_hl_test3_line_t);
    }

    updateLineByHeaderIdAndLineId(headerId: number, lineId: number, rn_hl_test3_line_t: any): Observable<any> {
        return this.http.put(this.API_URL + '/' + headerId + '/project/' + lineId, rn_hl_test3_line_t);
    }

    deleteLineByHeaderIdAndLineId(headerId: number, lineId: number): Observable<any> {
        return this.http.delete(this.API_URL + '/' + headerId + '/project/' + lineId, { responseType: "text" });
    }

}