import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import package0.dao.StudentDao;
import package0.entity.Student;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class Package0Test {
    @Test
    public void testSelectAllStudents() throws IOException {
        String mybatisConfigPath = "mybatis-config.xml";

        InputStream is = Resources.getResourceAsStream(mybatisConfigPath);

        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);

        StudentDao studentDao = sqlSession.getMapper(StudentDao.class);

        List<Student> studentList = studentDao.selectAllStudents();
        for (Student student : studentList){
            System.out.println(student);
        }
    }
}
