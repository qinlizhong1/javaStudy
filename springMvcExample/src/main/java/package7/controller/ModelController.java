package package7.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ModelController {
    @RequestMapping("/model")
    public String requestAttrModel(Model model) {
        model.addAttribute("username", "覃立中");
        model.addAttribute("password", "123456");
        return "/modelForward";
    }

}
