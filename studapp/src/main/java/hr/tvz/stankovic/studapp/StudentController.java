package hr.tvz.stankovic.studapp;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("student")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping()
    public List<StudentDTO> getAllStudents() {
        return studentService.findAll();
    }

    @GetMapping(params = "JMBAG")
    public StudentDTO getStudentByJMBAG(@RequestParam final String JMBAG){
        return studentService.findStudentByJMBAG(JMBAG); }
}
