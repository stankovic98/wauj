import { Component, OnInit, Input } from '@angular/core';
import { Student, StudentsService } from '../../services/students.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-student-detail',
  templateUrl: './student-detail.component.html',
  styleUrls: ['./student-detail.component.css']
})
export class StudentDetailComponent implements OnInit {

  student: Student;

  constructor(private activatedRoute: ActivatedRoute, private studentsService: StudentsService) { }

  ngOnInit() {
    this.activatedRoute.params.subscribe(params => {
      this.studentsService.getStudentByJmab(params.jmbag).then(student => {
        this.student = student;
      });
    });
  }

}
