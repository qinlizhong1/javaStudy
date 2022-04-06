package package6.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Forward {
    @RequestMapping("/forward")
    @ResponseBody
    public String doSomething(){
        System.out.println("------------------------------------------Forward中------------------------------------------");

        return "forward转发过来的";
    }
}
