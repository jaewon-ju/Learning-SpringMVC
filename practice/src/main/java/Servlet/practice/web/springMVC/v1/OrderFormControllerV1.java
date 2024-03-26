package Servlet.practice.web.springMVC.v1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

// @Controller 어노테이션을 사용하면 해당 클래스를 스프링 빈으로 등록할 수 있다.
// 스프링에서 핸들러로 인식한다.
@Controller
public class OrderFormControllerV1 {
    @RequestMapping("/springmvc/v1/orders/new-form")
    public ModelAndView process() {
        return new ModelAndView("new-form");
    }
}
