package service;

import dao.StudentDao;
import dao.StudentDaoImpl;
import model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by msi-pc on 2018/5/7.
 */
@Service
public class StudentServiceImpl implements StudentService{
    @Autowired
    private StudentDao studentDao = new StudentDaoImpl();

    @Override
    public void add(Student student) {
        studentDao.addStudent(student);
    }

    @Override
    public int delete(int id) {
        return studentDao.deleteStudent(id);
    }

    @Override
    public int update(Student student) {
        return studentDao.updateStudent(student);
    }

    @Override
    public Student selectId(int id) {
        return studentDao.selectById(id);
    }

    @Override
    public List<Student> listAll() {
        return studentDao.listAllStudent();
    }
}
