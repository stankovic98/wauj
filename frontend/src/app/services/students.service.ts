import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/Observable';
import 'rxjs/add/observable/of';
import { HttpClient, HttpHeaders } from '@angular/common/http';


@Injectable()
export class StudentsService {

  readonly url = 'http://localhost:8080';
  httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' })
  };

  students: Student[];

  constructor(private http: HttpClient) { }

  public getStudents(): Observable<Student[]> {
    return this.http.get<Student[]>(this.url+"/student").pipe();
  }

  public getStudentByJmab(jmbag: string): Promise<Student> {
    return this.http.get<Student>(this.url + "/student?JMBAG=" + jmbag).toPromise();
  }

  public addStudent(student: NewStudent) {
    return this.http.post<Student>(this.url + "/student", student).toPromise();
  }

  public deleteStudent(jmbag: string) {
    return this.http.delete(this.url + "/student/" + jmbag);
  }
}

export interface Student {
  jmbag: String;
  numberOfEcts: number;
  tuitionShouldBePaid: boolean;
}

export interface NewStudent {
  jmbag: String;
  name: String;
  surname: String;
  ectsCount: number;
  dateOfBirth: String;
}
