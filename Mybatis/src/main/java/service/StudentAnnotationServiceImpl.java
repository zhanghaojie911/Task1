package service;

import dao.StudentAnnotationMapper;
import model.Student;
import org.apache.ibatis.session.SqlSession;
import util.SqlSessionUtil;

import java.util.List;
import java.util.Map;

/**
 * Created by msi-pc on 2018/5/9.
 */
public class StudentAnnotationServiceImpl implements StudentAnnotationService{

    private StudentAnnotationMapper studentAnnotationMapper;
    private SqlSession session;


    public int add(Student student) throws Exception {
        session = SqlSessionUtil.getSqlSession();
        studentAnnotationMapper = session.getMapper(StudentAnnotationMapper.class);
        studentAnnotationMapper.addStudent(student);
        int id = student.getId();
        session.close();
        return id;
    }

    public Boolean delete(int id) throws Exception {
        session = SqlSessionUtil.getSqlSession();
        studentAnnotationMapper = session.getMapper(StudentAnnotationMapper.class);
        Boolean b1 = studentAnnotationMapper.deleteStudent(id);
        session.close();
        return b1;
    }

    public Boolean update(Student student) throws Exception {
        session = SqlSessionUtil.getSqlSession();
        studentAnnotationMapper = session.getMapper(StudentAnnotationMapper.class);
        Boolean b2 = studentAnnotationMapper.updateStudent(student);
        session.close();
        return b2;
    }

    public Student selectById(int id) throws Exception {
        session = SqlSessionUtil.getSqlSession();
        studentAnnotationMapper = session.getMapper(StudentAnnotationMapper.class);
        Student student =  studentAnnotationMapper.selectStudentById(id);
        session.close();
        return student;
    }

    public List<Student> listByName( Map map) throws Exception {
        session = SqlSessionUtil.getSqlSession();
        studentAnnotationMapper = session.getMapper(StudentAnnotationMapper.class);
        List<Student> list1 = studentAnnotationMapper.listStudentByName(map);
        session.close();
        return list1;
    }

    public List<Student> listAll() throws Exception {
        session = SqlSessionUtil.getSqlSession();
        studentAnnotationMapper = session.getMapper(StudentAnnotationMapper.class);
        List<Student>list2 = studentAnnotationMapper.listStudentAll();
        session.close();
        return list2;
    }

    public StudentAnnotationMapper getStudentAnnotationMapper() {
        return studentAnnotationMapper;
    }

    public void setStudentAnnotationMapper(StudentAnnotationMapper studentAnnotationMapper) {
        this.studentAnnotationMapper = studentAnnotationMapper;
    }
}
