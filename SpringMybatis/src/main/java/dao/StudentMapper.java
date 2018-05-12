package dao;

import model.Student;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

/**
 * Created by msi-pc on 2018/5/10.
 */
public interface StudentMapper {
    int addStudent(Student student);
    Boolean deleteStudent(int id);
    Boolean updateStudent(Student student);
    Student selectStudentById(int id);
    List<Student> listAllStudent();
    List<Student> listStudentByName(Map map);
}
