package package4.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import package4.entity.Author;
import package4.entity.Book;

import java.util.Map;
import java.util.Set;

/**
 * Map集合绑定
 */
//@Controller：表示一个Controller实例，该实例由Spring容器管理
@Controller("bookController4")
public class BookController {
    //配置请求的地址
    @RequestMapping(value = "/p4", method = RequestMethod.POST)
    public String getInfo(Book book) {
        System.out.println("获取到的数据为：ID--" + book.getId()
                + ",名称--" + book.getName()
                + ",出版社--" + book.getPublisher());

        //遍历Map集合
        Map<String, Author> authorMap = book.getAuthorMap();
        Set<Map.Entry<String, Author>> entries = authorMap.entrySet();
        for (Map.Entry<String, Author> entry : entries) {
            System.out.println("键key："+entry.getKey()+"--作者名称："
                    +entry.getValue().getName()+"--作者年龄："+entry.getValue().getAge());
        }

        //成功后跳转的页面
        return "success";
    }
}