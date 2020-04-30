package hr.tvz.stankovic.studapp;

import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Repository
public class StudentRepo implements StudentRepository {
    private List<Student> MOCKED_STUDENTS = new ArrayList<>(Arrays.asList(
            new Student("0256423323", "Ivo", "Ivianjkov", LocalDate.now().minusYears(27), 120), new Student("0256423324", "Lucija", "Lucičić", LocalDate.now().minusYears(25), 98)
    ));

    @Override
    public List<Student> findAll() {
        return this.MOCKED_STUDENTS;
    }

    @Override
    public Optional<Student> findStudentByJMBAG(String jmbag) {
        return this.MOCKED_STUDENTS.stream().filter(student -> student.getJmbag().equals(jmbag)).findAny();
    }

    @Override
    public Optional<Student> save(StudentCommand newStudent) {
        if (this.MOCKED_STUDENTS.stream().filter(student -> student.getJmbag().equals(newStudent.getJmbag())).findAny().orElse(null) == null) {
            this.MOCKED_STUDENTS.add(new Student(newStudent));
            return Optional.of(new Student(newStudent));
        } else {
            System.out.println(newStudent.getName());
            return Optional.empty();
        }
    }

    public boolean deleteByJmbag(String jmbag) {
        Student studToRemove = findStudentByJMBAG(jmbag).orElse(null);
        if (studToRemove == null) {
            return false;
        }
        MOCKED_STUDENTS.remove(studToRemove);
        return true;
    }

    public Optional<Student> findStudentByName(String name) {
        return null;
    }
}
