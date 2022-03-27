import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import package0.dao.StudentDao;
import package0.entity.Student;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class Package0Test {
    private SqlSession sqlSession = null;
    @Before
    public void doBefore() throws IOException {
        String mybatisConfigPath = "mybatis-config.xml";

        InputStream is = Resources.getResourceAsStream(mybatisConfigPath);

        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        sqlSession = sqlSessionFactory.openSession(true);
        System.out.println("------------------------------------------------start test------------------------------------");
    }

    @After
    public void doAfter(){
        sqlSession.close();
        System.out.println("------------------------------------------------end   test------------------------------------");

    }

    @Test
    public void testSelectAllStudents() throws IOException {
        StudentDao studentDao = sqlSession.getMapper(StudentDao.class);

        List<Student> studentList = studentDao.selectAllStudents();
        for (Student student : studentList){
            System.out.println(student);
        }
    }

    @Test
    public void testSelectStudentsByStudent(){
        StudentDao studentDao = sqlSession.getMapper(StudentDao.class);
        Student student = new Student(1, "男", 1, "理解");
        List<Student> studentList = studentDao.selectStudentsByStudent(student);

        for (Student stu : studentList){
            System.out.println(stu);
        }
    }

    @Test
    public void testSelectStudentsByGenderAndClassId(){
        StudentDao studentDao = sqlSession.getMapper(StudentDao.class);

        List<Student> studentList = studentDao.selectStudentsByGenderAndClassId("男", 1);

        for (Student stu : studentList){
            System.out.println(stu);
        }
    }

    @Test
    public void testInsertStudent(){
        StudentDao studentDao = sqlSession.getMapper(StudentDao.class);

        Student student = new Student(17, "男", 4, "洪金宝");
        studentDao.insertStudent(student);
    }

    @Test
    public void testUpdateStudent(){
        StudentDao studentDao = sqlSession.getMapper(StudentDao.class);

        studentDao.updateStudent(17, "成龙");
    }
}
