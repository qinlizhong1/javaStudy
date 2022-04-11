package jdbc;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

class DbOp{
    public void query() throws IOException, ClassNotFoundException, SQLException {
        InputStream is = DbOp.class.getClassLoader().getResourceAsStream("db.properties");
        Properties properties = new Properties();
        properties.load(is);

        Class.forName(properties.getProperty("mysql.driver"));
        Connection connection = DriverManager.getConnection(properties.getProperty("mysql.url"), properties.getProperty("mysql.username"), properties.getProperty("mysql.password"));

        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select *from student");

        while (resultSet.next()){
            String sid  = resultSet.getString(2);
            String sname  = resultSet.getString("sname");
            String classId = resultSet.getString("class_id");

            System.out.println("sid:" + sid + "\tsname:" + sname + "\tclass_id:" + classId);
        }
    }
}

public class Test0 {
    public static void main(String[] args) throws SQLException, IOException, ClassNotFoundException {
        DbOp dbOp = new DbOp();
        dbOp.query();
    }
}
