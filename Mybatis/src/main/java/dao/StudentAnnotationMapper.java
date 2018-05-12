package dao;

import model.Student;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;
import java.util.Map;

/**
 * Created by msi-pc on 2018/5/9.
 * 添加数据返回ID，删除或更新数据返回True/False
 */
public interface StudentAnnotationMapper {
    @Insert("INSERT INTO people (id,name,gender) values(#{id},#{name},#{gender})")
        int addStudent(Student student);

    @Delete("DELETE FROM people WHERE id =#{id}")
        Boolean deleteStudent(int id);

    @Update("UPDATE people SET name=#{name},gender=#{gender} WHERE id=#{id}")
        Boolean updateStudent(Student student);

    @Select("SELECT * FROM people WHERE id = #{id}")
        Student selectStudentById(int id);

    @Select("SELECT * FROM people WHERE NAME LIKE CONCAT('%',#{name},'%')")
        List<Student>listStudentByName(Map map);

    @Select("SELECT * FROM people")
        List<Student>listStudentAll();
}
