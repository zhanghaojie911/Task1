package service;

import model.Student;

import java.util.List;
import java.util.Map;

/**
 * Created by msi-pc on 2018/5/10.
 */
public interface StudentService {
    int add(Student student);
    Boolean delete(int id);
    Boolean update(Student student);
    Student selectById(int id);
    List<Student> listAll();
    List<Student> lisetByName(Map map);
}
