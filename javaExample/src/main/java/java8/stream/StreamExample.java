package java8.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class StreamTest {
    public List<Author> getAuthors() {
        List<Author> authors = new ArrayList<>();
        List<Book> books0 = new ArrayList<>();
        Book book00 = new Book("射雕", 18);
        Book book01 = new Book("碧血剑", 18.8);
        books0.add(book00);
        books0.add(book01);
        Author author0 = new Author("金庸", 70, books0);

        List<Book> books1 = new ArrayList<>();
        Book book10 = new Book("三重门", 8);
        Book book11 = new Book("毒", 8.8);
        books1.add(book10);
        books1.add(book11);
        Author author1 = new Author("韩寒", 30, books1);

        List<Book> books2 = new ArrayList<>();
        Book book20 = new Book("白银", 38);
        Book book21 = new Book("青铜", 38.8);
        books2.add(book20);
        books2.add(book21);
        Author author2 = new Author("王小波", 35, books2);

        authors.add(author0);
        authors.add(author1);
        authors.add(author2);
        authors.add(author0);
        return authors;
    }

    public void showAuthors() {
        List<Author> authors = getAuthors();
        for (Author author : authors) {
            System.out.println(author);
        }
    }

    /**
     * filter
     */
    public void test0() {
        System.out.println("-----------------------------------------------test0()-----------------------------------------------");
        List<Author> authors = getAuthors();
        authors.stream()
                .filter(s -> s.getAge() < 50).forEach(s -> System.out.println(s));
    }

    /**
     * limt
     */
    public void test1() {
        System.out.println("\n\n-----------------------------------------------test1()-----------------------------------------------");
        List<Author> authors = getAuthors();
        authors.stream()
                .limit(3).forEach(s -> System.out.println(s));
    }

    /**
     * skip
     */
    public void test2() {
        System.out.println("\n\n-----------------------------------------------test2()-----------------------------------------------");
        List<Author> authors = getAuthors();
        authors.stream()
                .skip(2).forEach(s -> System.out.println(s));
    }

    /**
     * distinct
     */
    public void test3() {
        System.out.println("\n\n-----------------------------------------------test3()-----------------------------------------------");
        List<Author> authors = getAuthors();
        authors.stream()
                .distinct().forEach(s -> System.out.println(s));
    }

    /**
     * sorted()，需要对应类实现Comparable接口
     */
    public void test4() {
        System.out.println("\n\n-----------------------------------------------test4()-----------------------------------------------");
        List<Author> authors = getAuthors();
        authors.stream()
                .sorted().forEach(s -> System.out.println(s));
    }

    /**
     * map
     */
    public void test5() {
        System.out.println("\n\n-----------------------------------------------test5()-----------------------------------------------");
        List<Author> authors = getAuthors();
        authors.stream()
                .map(s -> s.getName()).forEach(s -> System.out.println(s));
    }

    /**
     * flatmap
     */
    public void test6() {
        System.out.println("\n\n-----------------------------------------------test6()-----------------------------------------------");
        List<Author> authors = getAuthors();
        authors.stream()
                .flatMap(s -> s.getBooks().stream()).forEach(s -> System.out.println(s));
    }


    /**
     * findFirst
     */
    public void test8() {
        System.out.println("\n\n-----------------------------------------------test8()-----------------------------------------------");
        List<Author> authors = getAuthors();
        Author author = authors.stream()
                .findFirst().get();

        System.out.println(author);
    }

    /**
     * findAny
     */
    public void test9() {
        System.out.println("\n\n-----------------------------------------------test9()-----------------------------------------------");
        List<Author> authors = getAuthors();
        Author author = authors.stream()
                .findAny().get();

        System.out.println(author);
    }

    /**
     * allMatch
     */
    public void test10() {
        System.out.println("\n\n-----------------------------------------------test10()-----------------------------------------------");
        List<Author> authors = getAuthors();
        boolean res = authors.stream()
                .allMatch(author -> author.getAge() > 50);

        System.out.println(res);
    }

    /**
     * anyMatch
     */
    public void test11() {
        System.out.println("\n\n-----------------------------------------------test11()-----------------------------------------------");
        List<Author> authors = getAuthors();
        boolean res = authors.stream()
                .anyMatch(author -> author.getAge() > 50);

        System.out.println(res);
    }

    /**
     * count
     */
    public void test12() {
        System.out.println("\n\n-----------------------------------------------test12()-----------------------------------------------");
        List<Author> authors = getAuthors();
        long res = authors.stream()
                .count();

        System.out.println(res);
    }

    /**
     * max
     */
    public void test13() {
        System.out.println("\n\n-----------------------------------------------test13()-----------------------------------------------");
        List<Author> authors = getAuthors();
        Author author = authors.stream()
                .max((author1, author2) -> {return author1.compareTo(author2);}).get();

        System.out.println(author);
    }

    /**
     * min
     */
    public void test14() {
        System.out.println("\n\n-----------------------------------------------test14()-----------------------------------------------");
        List<Author> authors = getAuthors();
        Author author = authors.stream()
                .min((author1, author2) -> {return author1.compareTo(author2);}).get();

        System.out.println(author);
    }
}

public class StreamExample {
    public static void main(String[] args) {
        StreamTest streamTest = new StreamTest();
        streamTest.test0();
        streamTest.test1();
        streamTest.test2();
        streamTest.test3();
        streamTest.test4();
        streamTest.test5();
        streamTest.test6();
        streamTest.test8();
        streamTest.test9();
        streamTest.test10();
        streamTest.test11();
        streamTest.test12();
        streamTest.test13();
        streamTest.test14();
    }
}
