package java8.functional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

class FunctionalTest{
    public Author getAuthor() {
        List<Book> books = new ArrayList<>();
        Book book0 = new Book("射雕", 18);
        Book book1 = new Book("碧血剑", 18.8);
        books.add(book0);
        books.add(book1);
        Author author = new Author("金庸", 70, books);

        return author;
    }

    /**
     * get()方法：如果在这个Optional中包含值，则返回实际值value，否则会抛出NoSuchElementException异常
     */
    public void test0() {
        System.out.println("-------------------------------------------------------test0()-------------------------------------------------------");
        Optional<Author> optionalAuthor = Optional.ofNullable(getAuthor());
        Author author = optionalAuthor.get();
        System.out.println(author);
    }

    /**
     * isPresent()方法：如果值存在则方法会返回true，否则返回 false
     */
    public void test1() {
        System.out.println("\n-------------------------------------------------------test1()-------------------------------------------------------");
        Optional<Author> optionalAuthor = Optional.ofNullable(getAuthor());
        System.out.println(optionalAuthor.isPresent());

        Optional<Author> optionalNull = Optional.ofNullable(null);
        System.out.println(optionalNull.isPresent());
    }

    /**
     * ifPresent()方法：如果存在值，则使用该值调用指定的使用者(Consumer)，否则不执行任何操作。
     */
    public void test2() {
        System.out.println("\n-------------------------------------------------------test2()-------------------------------------------------------");
        Optional<Author> optionalAuthor = Optional.ofNullable(getAuthor());

        optionalAuthor.ifPresent(author -> System.out.println(author));

    }

    /**
     * filter()方法：如果值存在，并且这个值匹配给定的 predicate，返回一个Optional用以描述这个值，否则返回一个空的Optional
     */
    public void test3() {
        System.out.println("\n-------------------------------------------------------test3()-------------------------------------------------------");
        Optional<Author> optionalAuthor = Optional.ofNullable(getAuthor());

        Author author1 = optionalAuthor.filter(author -> author.getAge() > 50).get();
        System.out.println(author1);

    }

    /**
     *map()方法：如果有值，则对其执行调用映射函数得到返回值。如果返回值不为 null，则创建包含映射返回值的Optional作为map方法返回值，否则返回空Optional。
     */
    public void test4() {
        System.out.println("\n-------------------------------------------------------test4()-------------------------------------------------------");
        Optional<Author> optionalAuthor = Optional.ofNullable(getAuthor());

        System.out.println(optionalAuthor.map(author -> author.getName()).get());
    }

    /**
     *orElse()方法：如果存在该值，返回值， 否则返回 other。
     */
    public void test6() {
        System.out.println("\n-------------------------------------------------------test6()-------------------------------------------------------");
        Optional<Author> optionalAuthor = Optional.ofNullable(getAuthor());

        String name = optionalAuthor.map(author -> author.getName()).orElse("默认值");
        System.out.println(name);
    }
}

public class FunctionalExample {
    public static void main(String[] args) {
        FunctionalTest functionalTest = new FunctionalTest();
        functionalTest.test0();
        functionalTest.test1();
        functionalTest.test2();
        functionalTest.test3();
        functionalTest.test4();
        functionalTest.test6();
    }
}
