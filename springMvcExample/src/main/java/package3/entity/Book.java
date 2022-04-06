package package3.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
class Author {
    private String name;
    private String age;
}

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book {
    //书的ID
    private Integer id;
    //书名
    private String name;
    //出版社
    private String publisher;

    //图书作者(可以有多位)
    private List<Author> author;

    //图书类型
    private String[] bookType;
}
