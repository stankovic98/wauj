package hr.tvz.stankovic.studapp;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {
    private static final int YEARS_AFTER_WHICH_TUITION_SHOULD_BE_PAYED = 26;
    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }
    @Override
    public List<StudentDTO> findAll() {
        return studentRepository.findAll().stream().map(this::mapStudentToDTO).collect(Collectors.toList());
    }

    @Override
    public StudentDTO findStudentByJMBAG(final String JMBAG) {
        return studentRepository.findStudentByJMBAG(JMBAG).map(this::mapStudentToDTO).orElse(null);
    }

    @Override
    public StudentDTO save(StudentCommand student) {
        return studentRepository.save(student).map(this::mapStudentToDTO).orElse(null);
    }

    public List<StudentDTO> findStudentsByName(final String name) {
        return studentRepository.findStudentByName(name).stream().map(this::mapStudentToDTO).collect(Collectors.toList());
    }

    public boolean deleteByJMBAG(String jmbag) {
        return studentRepository.deleteByJmbag(jmbag);
    }

    private StudentDTO mapStudentToDTO(final Student student){
        return new StudentDTO(student.getJmbag(), student.getEctsCount(), shouldTuitionBePayed(student.getDateOfBirth()));
    }

    private boolean shouldTuitionBePayed(LocalDate dateOfBirth){
        return dateOfBirth.plusYears(YEARS_AFTER_WHICH_TUITION_SHOULD_BE_PAYED).isBefore(LocalDate.now());
    }
}
