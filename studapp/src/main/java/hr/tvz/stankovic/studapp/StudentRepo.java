package hr.tvz.stankovic.studapp;

import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Repository
public class StudentRepo implements StudentRepository {
    private final List<Student> MOCKED_STUDENTS = Arrays.asList(
            new Student("0256423323", "Ivo", "Ivianjkov", LocalDate.now().minusYears(27), 120), new Student("0256423324", "Lucija", "Lucičić", LocalDate.now().minusYears(25), 98)
    );

    @Override
    public List<Student> findAll() {
        return this.MOCKED_STUDENTS;
    }

    @Override
    public Optional<Student> findStudentByJMBAG(String jmbag) {
        return this.MOCKED_STUDENTS.stream().filter(student -> student.getJmbag().equals(jmbag)).findAny();
    }
}
