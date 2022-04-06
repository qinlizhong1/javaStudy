package package6.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 重定向
 */
@Controller
public class RedirectController {
    @RequestMapping(value = "/r")
    public String doDirect(){
        System.out.println("------------------------------------------RedirectController中------------------------------------------");
        return "redirect:/redirect";
    }
}
