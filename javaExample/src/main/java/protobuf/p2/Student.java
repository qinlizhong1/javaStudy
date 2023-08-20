package protobuf.p2;

import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class Student {
    private Integer id;
    private String name;
    private Boolean boy;
    private List<String> listString;
    private Map<String, String> mapString;
    private List<Book> listBook;
    private Map<String, Book> mapBook;
}
