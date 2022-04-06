package package2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import package2.entity.Book;


/**
 * 实体类对象参数绑定
 * 前端提交的name属性必须与POJO里面的属性一致，这样SpringMVC才会自动帮我们绑定数据，否则会绑定失败！！！
 */
@Controller("bookController2")
public class BookController {
    @RequestMapping(value = "/p2", method = {RequestMethod.POST, RequestMethod.GET})
    public String getInfo(Book book) {
        System.out.println("[p2]获取到的数据为：ID--" + book.getId() + ",名称--" + book.getName() + ",出版社--" + book.getPublisher());
        //成功后跳转的页面
        return "success";
    }
}
