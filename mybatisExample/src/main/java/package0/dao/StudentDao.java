package package0.dao;

import org.apache.ibatis.annotations.Param;
import package0.entity.Student;

import java.util.List;

public interface StudentDao {
    public List<Student> selectAllStudents();

    //入参是实体类对象，那么sql语句中#{}中名称要是Student类中对应的一样的名称
    public List<Student> selectStudentsByStudent(Student student);

    //@Param中的名称要和sql语句中#{}中名称相同
    public List<Student> selectStudentsByGenderAndClassId(@Param("gend") String gen, @Param("cid") Integer cid);

    public void insertStudent(Student student);

    public void updateStudent(@Param("id") Integer sid, @Param("sname") String sname);
}
