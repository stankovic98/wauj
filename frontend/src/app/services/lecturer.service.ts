import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable()
export class LecturerService {
  readonly lecturerUrl = 'http://localhost:8080/lecturer'
  constructor(private http: HttpClient) { }

  public getLectures() {
    return this.http.get<Lecturer[]>(this.lecturerUrl).toPromise();
  }

  public addLecturer(lecturer: Lecturer) {
    return this.http.post(this.lecturerUrl, lecturer).toPromise();
  }
}

export interface Lecturer {
  id: string;
  name: string;
  surname: string;
  email: string;
}
