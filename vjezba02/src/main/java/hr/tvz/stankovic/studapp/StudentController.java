package hr.tvz.stankovic.studapp;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.Console;
import java.util.List;

@RestController
@RequestMapping("student")
@CrossOrigin(origins = "http://localhost:4200")
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
    public ResponseEntity<StudentDTO> getStudent(@RequestParam final String JMBAG){
        StudentDTO stud = studentService.findStudentByJMBAG(JMBAG);
        if (stud == null) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .build();
        } else {
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(stud);
        }
    }

    @RequestMapping("/name")
    @GetMapping(params = "name")
    public ResponseEntity<List<StudentDTO>> getStudentsByName(@RequestParam final String name) {
        List<StudentDTO> matchingStudents = studentService.findStudentsByName(name);
        if (matchingStudents.size() == 0) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .build();
        }
        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .body(matchingStudents);
    }

    @PostMapping
    public ResponseEntity<StudentDTO> save(@Valid @RequestBody final StudentCommand command){
        StudentDTO newStudent = studentService.save(command);
        if (newStudent == null) {
            return ResponseEntity
                    .status(HttpStatus.CONFLICT)
                    .build();
        } else {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(newStudent);
        }
    }

    @DeleteMapping("/{jmbag}")
    public ResponseEntity<Object> delete(@PathVariable String jmbag){
        if (studentService.deleteByJMBAG(jmbag)) {
            return ResponseEntity.status(HttpStatus.ACCEPTED).build();
        }
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
