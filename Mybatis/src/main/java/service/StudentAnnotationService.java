package service;

import model.Student;

import java.util.List;
import java.util.Map;

/**
 * Created by msi-pc on 2018/5/9.
 */
public interface StudentAnnotationService {
    int add(Student student)throws Exception;
    Boolean delete(int id)throws Exception;
    Boolean update(Student student)throws Exception;
    Student selectById(int id)throws Exception;
    List<Student> listByName( Map map)throws Exception;
    List<Student>listAll()throws  Exception;
}
