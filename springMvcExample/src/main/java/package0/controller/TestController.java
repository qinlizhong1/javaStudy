package package0.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller

public class TestController {
    @RequestMapping("/p0")
    public String hello(){
        System.out.println("--------执行了hello------");
        return "success";
    }
}
