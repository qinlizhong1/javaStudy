package java8.stream;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

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
public class Author implements Comparable{
    private String name;
    private int age;
    private List<Book> books;

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
