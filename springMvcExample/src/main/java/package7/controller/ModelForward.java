package package7.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ModelForward {
    @ResponseBody
    @RequestMapping("modelForward")
    public String getModelAttribute(Model model){
        System.out.println("key:" + model.getAttribute("username"));
        System.out.println("key:" + model.getAttribute("password"));
        return "ModelForward";
    }
}
