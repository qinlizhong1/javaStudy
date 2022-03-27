package package1.dao;

import org.apache.ibatis.annotations.Param;
import package1.entity.Student;

import java.util.List;

public interface StudentDao {
    //哪个条件为null就不加入查询条件
    public List<Student> selectStudentByGenderAndClassId(@Param("gender") String gender, @Param("classId") Integer classId);

    //哪个要设置的字段不为null就设置该字段，否则该字段不设置
    public void updateSelect(@Param("sid") Integer sid, @Param("gender") String gender, @Param("classId") Integer classId, @Param("sname") String sname);

    //in查询
    public List<Student> selectStudentInSid(@Param("sids") List<Integer> sids);
}
