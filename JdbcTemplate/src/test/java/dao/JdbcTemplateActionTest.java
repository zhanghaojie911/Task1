package dao;

import model.Student;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.StudentService;
import service.StudentServiceImpl;


import java.util.List;

/**
 * Created by msi-pc on 2018/5/7.
 */
public class JdbcTemplateActionTest {
    Logger logger = Logger.getLogger(JdbcTemplateActionTest.class);
    ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationcontext.xml");
    StudentServiceImpl studentServiceImpl = (StudentServiceImpl)applicationContext.getAutowireCapableBeanFactory().getBean("studentServiceImpl");
    @Test
    public void addStudent() throws Exception {
        Student student = new Student();
        student.setId(6);
        student.setName("大耳朵图图");
        student.setGender("男");
        studentServiceImpl.add(student);
    }

    @Test
    public void deleteStudent() throws Exception {
        if(studentServiceImpl.delete(6)>0){
            logger.debug("删除成功");
        }else{logger.info("删除失败");}
    }

    @Test
    public void updateStudent() throws Exception {
        Student student =  new Student();
        student.setId(6);
        student.setName("jack");
        student.setGender("男");
        if (studentServiceImpl.update(student)>0){
            logger.debug("修改成功");
        }else{logger.info("修改失败,第"+student.getId()+"条不存在");}
    }

    @Test
    public void selectById() throws Exception {
        Student student = studentServiceImpl.selectId(6);
        logger.info(student);
    }

    @Test
    public void listAllStudent() throws Exception {
        List<Student> list = studentServiceImpl.listAll();
        for (Student student:list){
            logger.info(student);
        }
    }


}