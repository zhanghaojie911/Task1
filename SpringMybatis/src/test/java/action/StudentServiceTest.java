package action;

import dao.StudentMapper;
import model.Student;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import service.StudentService;
import service.StudentServiceImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by msi-pc on 2018/5/10.
 */
//生成spring容器
@RunWith(SpringJUnit4ClassRunner.class)
//加载配置文件
@ContextConfiguration(locations = {"classpath:Springmybatis-config.xml"})

public class StudentServiceTest {
    private Logger logger = Logger.getLogger(StudentServiceTest.class);

    StudentService studentService = new StudentServiceImpl();

    @Test
    public void add() throws Exception {
        Student student = new Student(6,"图图","男");
        studentService.add(student);
    }

    @Test
    public void delete() throws Exception {
        studentService.delete(6);
    }

    @Test
    public void update() throws Exception {
        Student student = new Student("jack","男",6);
        studentService.update(student);
    }

    @Test
    public void selectById() throws Exception {
        Student student = studentService.selectById(6);
        logger.info(student);
    }

    @Test
    public void listAll() throws Exception {
        List<Student> list = studentService.listAll();
        for (Student student:list){logger.info(student);}
    }

    @Test
    public void listByName() throws Exception {
        Map<String,Object>map = new HashMap<String, Object>();
        map.put("name","王");
        List<Student>list = studentService.lisetByName(map);
        for (Student student:list){logger.info(student);}
    }

}