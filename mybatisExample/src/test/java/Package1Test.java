import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import package1.dao.StudentDao;
import package1.entity.Student;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class Package1Test {
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
    public void doAfter() {
        sqlSession.close();
        System.out.println("------------------------------------------------end   test------------------------------------");

    }

    @Test
    public void testSelectStudentByGenderAndClassId() throws IOException {
        StudentDao studentDao = sqlSession.getMapper(StudentDao.class);

        List<Student> studentList = studentDao.selectStudentByGenderAndClassId(null, null);
        for (Student student : studentList) {
            System.out.println(student);
        }
        System.out.println("\n");

        studentList = studentDao.selectStudentByGenderAndClassId("男", null);
        for (Student student : studentList) {
            System.out.println(student);
        }
        System.out.println("\n");

        studentList = studentDao.selectStudentByGenderAndClassId(null, 1);
        for (Student student : studentList) {
            System.out.println(student);
        }
        System.out.println("\n");

        studentList = studentDao.selectStudentByGenderAndClassId("女", 1);
        for (Student student : studentList) {
            System.out.println(student);
        }
    }

    @Test
    public void testUpdateStudent() throws IOException {
        StudentDao studentDao = sqlSession.getMapper(StudentDao.class);
        studentDao.updateSelect(17, "女",null, "曾子丹");
    }

    @Test
    public void testSelectStudentInSid() throws IOException {
        StudentDao studentDao = sqlSession.getMapper(StudentDao.class);
        List<Integer> sids = new ArrayList<>();
        sids.add(1);
        sids.add(3);
        sids.add(5);

        List<Student> studentList = studentDao.selectStudentInSid(sids);
        for (Student student : studentList) {
            System.out.println(student);
        }
    }
}
