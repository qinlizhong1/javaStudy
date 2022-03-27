package package3.dao;

import org.apache.ibatis.annotations.Param;
import package3.entity.Student;

import java.util.List;

public interface StudentDao {
    List<Student> selectAllStudents();
}
