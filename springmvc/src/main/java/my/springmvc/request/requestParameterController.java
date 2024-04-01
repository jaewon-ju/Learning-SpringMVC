package my.springmvc.request;

import lombok.extern.slf4j.Slf4j;
import my.springmvc.Order;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Controller
public class requestParameterController {
    @ResponseBody
    @RequestMapping("/test-requestParameter")
    public String process(@ModelAttribute Order order){
        return "ok";
    }
}
