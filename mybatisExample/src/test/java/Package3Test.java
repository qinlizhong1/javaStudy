import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import package3.dao.StudentDao;
import package3.entity.Student;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class Package3Test {
    private SqlSessionFactory sqlSessionFactory = null;
    @Before
    public void doBefore() throws IOException {
        String mybatisConfigPath = "mybatis-config.xml";

        InputStream is = Resources.getResourceAsStream(mybatisConfigPath);

        sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);

        System.out.println("------------------------------------------------start test------------------------------------");
    }

    @Test
    public void testSelectAllStudents() throws IOException {
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        StudentDao studentDao = sqlSession.getMapper(StudentDao.class);
        System.out.println("第一次查询---->");
        List<Student> studentList1 = studentDao.selectAllStudents();
        for (Student student : studentList1){
            System.out.println(student);
        }

        System.out.println("第二次查询---->");
        List<Student> studentList2 = studentDao.selectAllStudents();
        for (Student student : studentList2){
            System.out.println(student);
        }
    }

    /**
     * 测试commit操作使一级缓存失效
     * 需要将二级缓存禁用，测试该用例才能达到测试意图
     * @throws IOException
     */
    @Test
    public void testSelectAllStudents1() throws IOException {
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        StudentDao studentDao = sqlSession.getMapper(StudentDao.class);
        System.out.println("第一次查询---->");
        List<Student> studentList1 = studentDao.selectAllStudents();
        for (Student student : studentList1){
            System.out.println(student);
        }

        //执行了insert、update、delete的sql语句，又或者只执行了commit操作，都会导致一级缓存失效。
        //添加、修改，删除操作不管有没有成功，只要你执行了增删改的SQL，缓存都会清空，即使没有通过commit方法提交
        sqlSession.commit();

        System.out.println("第二次查询---->");
        List<Student> studentList2 = studentDao.selectAllStudents();
        for (Student student : studentList2){
            System.out.println(student);
        }
    }

    //二级缓存测试
    @Test
    public void testSelectAllStudents2() throws IOException {
        SqlSession sqlSession1 = sqlSessionFactory.openSession();
        StudentDao studentDao1 = sqlSession1.getMapper(StudentDao.class);
        System.out.println("第一次查询---->");
        List<Student> studentList1 = studentDao1.selectAllStudents();
        for (Student student : studentList1) {
            System.out.println(student);
        }

        //二级缓存在sqlSession关闭或者提交才会生效！这里选择关闭
        sqlSession1.close();

        SqlSession sqlSession2 = sqlSessionFactory.openSession();
        StudentDao studentDao2 = sqlSession2.getMapper(StudentDao.class);
        System.out.println("第二次查询---->");
        List<Student> studentList2 = studentDao2.selectAllStudents();
        for (Student student : studentList2) {
            System.out.println(student);
        }
    }

}
