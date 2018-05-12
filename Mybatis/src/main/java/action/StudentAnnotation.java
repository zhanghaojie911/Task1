package action;

import model.Student;
import org.apache.log4j.Logger;
import service.StudentAnnotationService;
import service.StudentAnnotationServiceImpl;

/**
 * Created by msi-pc on 2018/5/9.
 */
public class StudentAnnotation {
    public static void main(String[] args) throws Exception {
        StudentAnnotationService studentAnnotationService = new StudentAnnotationServiceImpl();
        Logger logger = Logger.getLogger(StudentAnnotation.class);

        try {
            for (int i=6;i<100;i++){
                Student student = new Student();
                student.setId(i);
                student.setName("托马斯");
                student.setGender("男");
                logger.info(studentAnnotationService.add(student));
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("插入数据重复");
        }

        try {
            for (int i =50;i<100;i++){
                Student student = new Student(i,"阿姆斯特朗.托马斯","男");
                if (!studentAnnotationService.update(student)){logger.info("修改失败");}
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("数据有重复，请确认");
        }
    }
}
