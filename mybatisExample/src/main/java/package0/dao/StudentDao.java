package package0.dao;

import package0.entity.Student;

import java.util.List;

public interface StudentDao {
    List<Student> selectAllStudents();
}
