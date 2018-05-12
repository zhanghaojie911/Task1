package dao;

import model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by msi-pc on 2018/5/7.
 */
@Component
public class StudentDaoImpl implements StudentDao {
    @Autowired
//    @Qualifier("jdbcTemplate")
    private JdbcTemplate jdbcTemplate;
    @Override
    public void addStudent(Student student) {
        String sql = "INSERT INTO people(id,name,gender) values(?,?,?)";
        jdbcTemplate.update(sql,new Object[]{student.getId(),student.getName(),student.getGender()});
    }

    @Override
    public int deleteStudent(int id) {
        String sql = "DELETE FROM people WHERE id = ?";
        return   jdbcTemplate.update(sql,id);
    }

    @Override
    public int updateStudent(Student student) {
        String sql = "UPDATE people SET id=?,name=?,gender=? WHERE id =?";
        return jdbcTemplate.update(sql,student.getId(),student.getName(),student.getGender(),student.getId());
}

    @Override
    public Student selectById(int id) {
       String sql = "SELECT * FROM people WHERE id = ?";
       Student student;
       RowMapper<Student> rowMapper = new BeanPropertyRowMapper<Student>(Student.class);
       student = jdbcTemplate.queryForObject(sql,rowMapper,id);
       return student;
     }

    @Override
    public List<Student> listAllStudent() {
       String sql = "SELECT * FROM people";
       final List<Student> studentList = new ArrayList<Student>();
     /*    final List<Student> studentList;
     RowMapper<Student> rowMapper = new BeanPropertyRowMapper<Student>(Student.class);
       studentList = jdbcTemplate.query(sql,rowMapper);
       return studentList;   */
        jdbcTemplate.query(sql, new RowCallbackHandler() {
            @Override
            public void processRow(ResultSet resultSet) throws SQLException {
                Student student = new Student();
                student.setId(resultSet.getInt("id"));
                student.setName(resultSet.getString("name"));
                student.setGender(resultSet.getString("gender"));
                studentList.add(student);
            }
        });
        return studentList;
    }
}
