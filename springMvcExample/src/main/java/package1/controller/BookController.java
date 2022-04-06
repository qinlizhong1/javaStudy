package package1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


/**
 * 简单类型参数绑定
 * Controller中的形参需要与前台提交的name属性一样才能完成绑定，如果不一致，使用注解@RequestParam绑定
 * 如果请求中不包含其中的某个形参，此时是不会报错的，默认使用该参数时要进行空校验。
 */
@Controller
public class BookController {
    @RequestMapping(value = "/p1", method = {RequestMethod.POST, RequestMethod.GET})
    public String getInfo(Integer id, @RequestParam("name") String names, String publisher) {
        System.out.println("获取到的数据为：ID--" + id + ",名称--" + names + ",出版社--" + publisher);
        //成功后跳转的页面
        return "success";
    }
}
