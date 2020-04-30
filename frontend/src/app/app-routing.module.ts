import { NgModule } from "@angular/core";
import { Routes, RouterModule } from "@angular/router";
import { StudentListComponent } from "./components/student-list/student-list.component";
import { HomeComponent } from './components/home/home.component';
import { StudentDetailComponent } from './components/student-detail/student-detail.component';

const routes: Routes = [
  {
    path: "",
    component: HomeComponent
  },
  {
    path: "students",
    component: StudentListComponent
  },
  {
    path: "students/:jmbag",
    component: StudentDetailComponent
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {}
