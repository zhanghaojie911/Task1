package action;

import model.Student;
import org.apache.log4j.Logger;
import service.StudentService;
import service.StudentServiceImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by msi-pc on 2018/5/10.
 */
public class SpringMybatisAction {
    public static void main(String[] args) {
        Student student;
        StudentService studentService = new StudentServiceImpl();
        Logger logger = Logger.getLogger(SpringMybatisAction.class);
        Long start = System.currentTimeMillis();

        try {
            for (int i=6;i<100;i++){
                student = new Student(i,"陈独秀","男");
                logger.info(studentService.add(student));
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("插入失败,姓名有重复");
        }

        try {
            for (int i=50;i<100;i++){
                student = new Student(i,"jack","男");
                if (studentService.update(student)){logger.debug("更新成功");}
                else {logger.info("修改失败，第"+i+"条信息不存在");}
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("修改失败，姓名重复");
        }

        for (int i=70;i<100;i++){
            if (studentService.delete(i)){logger.debug("第"+i+"条信息删除成功");}
            else {logger.info("删除失败，第"+i+"条信息不存在，请查证后再删除");}
        }

        try {
            Map map = new HashMap();
            map.put("name","jack");
            List<Student>list = studentService.lisetByName(map);
            for (Student student1:list){logger.info(student1);}
        } catch (Exception e) {
            e.printStackTrace();
            logger.info("未找到指定信息");
        }
        long end=System.currentTimeMillis();
        long time = start-end;
        System.out.println("花费时间"+time+"毫秒");
        System.out.println("程序已运行结束");
    }
}
