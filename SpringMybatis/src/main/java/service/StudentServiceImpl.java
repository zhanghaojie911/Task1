package service;

import dao.StudentMapper;
import model.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;
import java.util.Map;

/**
 * Created by msi-pc on 2018/5/10.
 */
public class StudentServiceImpl implements StudentService {
    ApplicationContext applicationContext = new ClassPathXmlApplicationContext("Springmybatis-config.xml");
    StudentMapper studentMapper = applicationContext.getBean(StudentMapper.class);


    public int add(Student student) {
        studentMapper.addStudent(student);
        int a = student.getId();
        return a;
    }

    public Boolean delete(int id) {
        return studentMapper.deleteStudent(id);
    }

    public Boolean update(Student student) {
        return studentMapper.updateStudent(student);
    }

    public Student selectById(int id) {
        Student student = studentMapper.selectStudentById(id);
        return student;
    }

    public List<Student> listAll() {
        List<Student> list = studentMapper.listAllStudent();
        return list;
    }

    public List<Student> lisetByName(Map map) {
        List<Student> list = studentMapper.listStudentByName(map);
        return list;
    }
    public StudentMapper getStudentMapper() {
        return studentMapper;
    }

    public void setStudentMapper(StudentMapper studentMapper) {
        this.studentMapper = studentMapper;
    }
}
