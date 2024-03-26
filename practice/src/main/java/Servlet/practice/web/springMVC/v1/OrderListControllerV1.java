package Servlet.practice.web.springMVC.v1;

import Servlet.practice.domain.Order;
import Servlet.practice.domain.OrderRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

@Controller
public class OrderListControllerV1 {

    OrderRepository orderRepository = OrderRepository.getInstance();
    @RequestMapping("/springmvc/v1/orders")
    public ModelAndView process() {
        List<Order> all = orderRepository.findAll();

        ModelAndView mv = new ModelAndView("orders");
        mv.addObject("orders",all);
        //mv.getModel().put("orders",all);

        return mv;
    }
}
