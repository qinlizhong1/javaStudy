package package3.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import package3.entity.Book;

/**
 * 实体类中有集合如list集合
 * 实体类中有数组
 */
@Controller("bookController3")
public class BookController {
    //配置请求的地址
    @RequestMapping(value = "/p3", method = RequestMethod.POST)
    public String getInfo(Book book) {
        System.out.println("获取到的数据为：ID--" + book.getId()
                + ",名称--" + book.getName()
                + ",出版社--" + book.getPublisher()
                + "\n作者信息--" + book.getAuthor());
        for (String bookType : book.getBookType()) {
            System.out.println(bookType);
        }

        return "success";
    }
}
