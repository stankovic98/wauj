import { Component, OnInit } from '@angular/core';
import { Lecturer, LecturerService } from '../../services/lecturer.service';

@Component({
  selector: 'app-lecturer',
  templateUrl: './lecturer.component.html',
  styleUrls: ['./lecturer.component.css']
})
export class LecturerComponent implements OnInit {
  // oprosite na nedovrsenom zadatku, prekasno sam poceo rjesavati.
  lectures: Lecturer[];
  constructor(private lecturerService: LecturerService) { }

  ngOnInit() {
    this.lecturerService.getLectures().then(lecuters => {
      this.lectures = lecuters;
    });
  }

  addLecturer() {
    //
  }

}
