package package2.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
}
