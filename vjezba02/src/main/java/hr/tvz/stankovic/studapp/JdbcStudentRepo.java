package hr.tvz.stankovic.studapp;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Primary;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Primary
@Repository
public class JdbcStudentRepo implements StudentRepository {

    private JdbcTemplate jdbc;
    private SimpleJdbcInsert studentInserter;

    public JdbcStudentRepo(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
        this.studentInserter = new SimpleJdbcInsert(jdbc)
                .withTableName("students");
    }

    @Override
    public List<Student> findAll() {
        return this.jdbc.query("select * from students;", this::mapRowToStudent);
    }

    public Optional<Student> findStudentByJMBAG(String jmbag) {
        return this.jdbc.query("select * from students where jmbag=?", this::mapRowToStudent, jmbag).stream().findAny();

    }

    public Optional<Student> save(StudentCommand student) {
        Student stud = new Student(student);
        Map values = new HashMap();
        values.put("jmbag", stud.getJmbag());
        values.put("name", stud.getName());
        values.put("surname", stud.getSurname());
        values.put("ectsCount", stud.getEctsCount());
        values.put("dateOfBirth", stud.getDateOfBirth());
        int numberOfAfflicted = this.studentInserter.execute(values);
        stud = numberOfAfflicted == 0 ? stud : null;
        return Optional.of(stud);
    }

    public boolean deleteByJmbag(String jmbag) {
        try {
            this.jdbc.update("delete * from students where jmbag=?", jmbag);
        } catch (DataAccessException e) {
            return false;
        }
        return true;
    }

    private Student mapRowToStudent(ResultSet rs, int rowNum) throws SQLException {
        Student student = new Student(
                rs.getString("jmbag"),
                rs.getString("name"),
                rs.getString("surname"),
                rs.getDate("dateOfBirth").toLocalDate(),
                rs.getInt("ectsCount")
                );
        return student;
    }

    public Optional<Student> findStudentByName(String name) {
        return this.jdbc.query("select * from students where name like ?%", this::mapRowToStudent, name).stream().findAny();
    }
}
