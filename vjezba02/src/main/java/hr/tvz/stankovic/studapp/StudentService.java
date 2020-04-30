package hr.tvz.stankovic.studapp;

import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface StudentService {
    List<StudentDTO> findAll();
    StudentDTO findStudentByJMBAG(String jmbag);
    List<StudentDTO> findStudentsByName(String name);
    StudentDTO save(StudentCommand student);
    boolean deleteByJMBAG(String jmbag);
}
