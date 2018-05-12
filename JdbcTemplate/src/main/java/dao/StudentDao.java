package dao;

import model.Student;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by msi-pc on 2018/5/7.
 */
@Component
public interface StudentDao {
    void addStudent(Student student);
    int deleteStudent(int id);
    int updateStudent(Student student);
    Student selectById(int id);
    List<Student> listAllStudent();
}
