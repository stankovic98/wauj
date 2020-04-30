package hr.tvz.stankovic.studapp;

import java.util.List;
import java.util.Optional;

public interface StudentRepository {
    List<Student> findAll();
    Optional<Student> findStudentByJMBAG(String jmbag);
    Optional<Student> save(StudentCommand student);
    boolean deleteByJmbag(String jmbag);
    public Optional<Student> findStudentByName(String name);
}
