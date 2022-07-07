package factory;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

class Student implements Cloneable{
    private String name;
    private Integer classId;

    //是否需要额外多选课程
    private Boolean needExtraCourse = false;

    //所学课程，需要通过rpc调用查询课程系统,耗时100ms
    private List<String> course = new ArrayList<>();

    public Student(String name, Integer classId) throws InterruptedException {
        this.name = name;
        this.classId = classId;

        //超时模拟rpc调用获取课程信息初始化course
        Thread.sleep(100);
        course.add("语文");
        course.add("数学");
        course.add("英语");
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setClassId(Integer classId) {
        this.classId = classId;
    }

    public void setNeedExtraCourse(Boolean needExtraCourse) {
        this.needExtraCourse = needExtraCourse;
    }

    public void setCourse(List<String> course) {
        this.course = course;
    }

    public String getName() {
        return name;
    }

    public Integer getClassId() {
        return classId;
    }

    public Boolean getNeedExtraCourse() {
        return needExtraCourse;
    }

    public List<String> getCourse() {
        return course;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", classId=" + classId +
                ", needExtraCourse=" + needExtraCourse +
                ", course=" + course +
                '}';
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        Object object = super.clone();
        Student student = (Student)object;

        List<String> newCourse = new ArrayList<>();
        Iterator<String>  it = student.course.iterator();

        while (it.hasNext()) {
            newCourse.add(it.next());
        }

        student.course  = newCourse;

        return object;
    }
}

class PrototypeTest{
    //普通方式创建对象
    public void test1() throws InterruptedException {
        long start =  new Date().getTime();
        Student student1 = new Student("张三",  1);
        Student student2 = new Student("李四",  2);
        Student student3 = new Student("王五",  3);
        Student student4 = new Student("赵六",  4);
        long end =  new Date().getTime();
        System.out.println("创建对象共花费了时间:" + (end -start) + " ms");
    }

    //浅拷贝原型模式创建对象
    public void test2() throws InterruptedException, CloneNotSupportedException {
        long start =  new Date().getTime();
        Student student1 = new Student("张三",  1);

        Student student2 = (Student) student1.clone();
        student2.setName("李四");

        Student student3 = (Student) student1.clone();
        student3.setName("王五");

        Student student4 = (Student) student1.clone();
        student4.setName("赵六 ");

        System.out.println("student1--->" + student1);
        System.out.println("student2--->" + student2);
        System.out.println("student3--->" + student3);
        System.out.println("student4--->" + student4);

        long end =  new Date().getTime();
        System.out.println("创建对象共花费了时间:" + (end -start) + " ms");


        //赵六选修了课程美术
        student4.setNeedExtraCourse(true);
        student4.getCourse().add("美术 ");
        System.out.println("\n赵六选修美术课后：");
        System.out.println("student1--->" + student1);
        System.out.println("student2--->" + student2);
        System.out.println("student3--->" + student3);
        System.out.println("student4--->" + student4);
    }


}

public class PrototypeExample {
    public static void main(String[] args) throws InterruptedException, CloneNotSupportedException {
        long start =  new Date().getTime();
        Student student1 = new Student("张三",  1);

        Student student2 = (Student) student1.clone();
        student2.setName("李四");

        Student student3 = (Student) student1.clone();
        student3.setName("王五");

        Student student4 = (Student) student1.clone();
        student4.setName("赵六 ");

        System.out.println("student1--->" + student1);
        System.out.println("student2--->" + student2);
        System.out.println("student3--->" + student3);
        System.out.println("student4--->" + student4);

        long end =  new Date().getTime();
        System.out.println("创建对象共花费了时间:" + (end -start) + " ms");


        //赵六选修了课程美术
        student4.setNeedExtraCourse(true);
        student4.getCourse().add("美术 ");
        System.out.println("\n赵六选修美术课后：");
        System.out.println("student1--->" + student1);
        System.out.println("student2--->" + student2);
        System.out.println("student3--->" + student3);
        System.out.println("student4--->" + student4);
    }
}
