import { Component, OnInit } from '@angular/core';
import { Student, StudentsService, NewStudent } from '../../services/students.service';
@Component({
  selector: 'app-student-list',
  templateUrl: './student-list.component.html',
  styleUrls: ['./student-list.component.css']
})
export class StudentListComponent implements OnInit {

  students: Student[];

  constructor(private studentService: StudentsService) { }

  ngOnInit() {
    this.studentService.getStudents().subscribe(students => {
      this.students = students;
    });
  }

  addStudent(jmbag, name, surname, ectsCount) {
    let newStudent: NewStudent = {
      jmbag,
      name,
      surname,
      ectsCount,
      dateOfBirth: '20.12.2002.'
    };
    console.log(newStudent);
    this.studentService.addStudent(newStudent);
  }

  deleteStudent(jmbag: string) {
    this.studentService.deleteStudent(jmbag);
  }
}
