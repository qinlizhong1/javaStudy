package package6.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 转发
 */
@Controller
public class ForwardController {
    @RequestMapping(value = "/f")
    public String doDirect(){
        System.out.println("------------------------------------------ForwardController中------------------------------------------");
        return "forward:/forward";
    }
}
