package hr.tvz.stankovic.studapp;

import java.util.List;

public interface StudentService {
    List<StudentDTO> findAll();
    StudentDTO findStudentByJMBAG(String jmbag);
}
