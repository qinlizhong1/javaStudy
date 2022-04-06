package package6.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Rediirect {
    @RequestMapping("/redirect")
    @ResponseBody
    public String doSomething(){
        System.out.println("------------------------------------------Redirect中------------------------------------------");

        return "redirect重定向过来的";
    }
}
