package service;

import model.Student;
import org.junit.Test;

import org.apache.log4j.Logger;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MybatisAnnotationActionTest {

    private StudentAnnotationService studentAnnotationService = new StudentAnnotationServiceImpl();
    private Logger logger = Logger.getLogger(MybatisAnnotationActionTest.class);

    @Test
    public void add() throws Exception {
        Student student = new Student();
        student.setId(6);
        student.setName("大耳朵图图");
        student.setGender("男");
        logger.info(studentAnnotationService.add(student));
    }

    @Test
    public void delete() throws Exception {
        if (!studentAnnotationService.delete(6)){
            logger.info("删除失败，数据不存在");
        }
    }

    @Test
    public void update() throws Exception {
        Student student =new Student();
        student.setId(6);
        student.setName("jack");
        student.setGender("男");
        if (!studentAnnotationService.update(student)){logger.info("修改失败,数据不存在");}
    }

    @Test
    public void selectById() throws Exception {
       logger.info(studentAnnotationService.selectById(1));
    }

    @Test
    public void listByName() throws Exception {
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("name","王");
        List<Student>list = studentAnnotationService.listByName(map);
        logger.info(list);
    }

    @Test
    public void listAll() throws Exception {
        List<Student>list = studentAnnotationService.listAll();
        for(Student student:list){
            logger.info(student);
        }

    }

}