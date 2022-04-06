package package4.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {
    //书的ID
    private Integer id;
    //书名
    private String name;
    //出版社
    private String publisher;
    //添加Map集合
    private Map<String, Author> authorMap;
}