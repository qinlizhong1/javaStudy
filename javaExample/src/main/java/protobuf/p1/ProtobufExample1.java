package protobuf.p1;

public class ProtobufExample1 {
    public static void main(String[] args) {
        Stu.Student student = Stu.Student.newBuilder()
                .setName("han mei")
                .setAge(38)
                .build();
        System.out.println(student);
    }
}
