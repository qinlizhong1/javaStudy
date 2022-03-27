package fastjson;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONField;
import com.google.gson.JsonObject;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
class Book{
    private String bookName;
    private double bookPrice;
}

@Data
@NoArgsConstructor
@AllArgsConstructor
class Author implements Comparable{
    @JSONField(ordinal = 2)
    private String name;

    @JSONField(ordinal = 1)
    private int age;

    @JSONField(serialize = false)//sex不参与序列化
    private String sex;

    @JSONField(ordinal = 3, name = "Books")
    private List<Book> books;

    @JSONField(ordinal = 4, name = "SchoolS")
    private Map<String, String> schools;

    @Override
    public int compareTo(Object o) {
        if (o instanceof Author){
            Author author = (Author)o;
            if (this.age > author.getAge()){
                return 1;
            }else if(this.age < author.getAge()){
                return -1;
            }else {
                return 0;
            }
        }
        return -1;
    }
}

class JsonFieldTest{
    public Author getAuthor() {
        List<Book> books = new ArrayList<>();
        Book book0 = new Book("射雕", 18);
        Book book1 = new Book("碧血剑", 18.8);
        books.add(book0);
        books.add(book1);

        Map<String, String> schools = new HashMap<>();
        schools.put("小学", "一完小");
        schools.put("初中", "十一中");
        schools.put("高中", "一中");

        Author author = new Author("金庸", 70, "男", books, schools);

        return author;
    }

    public void test0(){
        System.out.println("----------------------------------------------------------------test0()----------------------------------------------------------------");
        Author author = getAuthor();
        System.out.println(author);

        //序列化
        String strJson = JSON.toJSONString(author);
        System.out.println("\n序列化结果：");
        System.out.println(strJson);

        //再反序列化
        Author author1 = JSON.parseObject(strJson, Author.class);
        System.out.println("反序列化结果：");
        System.out.println(author1);
    }

    public void test1(){
        System.out.println("\n\n----------------------------------------------------------------test1()----------------------------------------------------------------");
    }

    public void test2(){
        System.out.println("\n\n----------------------------------------------------------------test2()----------------------------------------------------------------");
    }

    public void test3(){
        System.out.println("\n\n----------------------------------------------------------------test3()----------------------------------------------------------------");
    }

    public void test4(){
        System.out.println("\n\n----------------------------------------------------------------test4()----------------------------------------------------------------");
    }
}

public class JsonFieldExample {
    public static void main(String[] args) {
        JsonFieldTest jsonFieldTest = new JsonFieldTest();
        jsonFieldTest.test0();
        jsonFieldTest.test1();
    }
}
