package service;

import model.Student;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by msi-pc on 2018/5/7.
 */
@Service
public interface StudentService {
    void add(Student student);
    int delete(int id);
    int update(Student student);
    Student selectId(int id);
    List<Student> listAll();
}
