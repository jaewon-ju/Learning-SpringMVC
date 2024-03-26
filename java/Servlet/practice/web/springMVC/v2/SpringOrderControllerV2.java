package Servlet.practice.web.springMVC.v2;

import Servlet.practice.domain.Order;
import Servlet.practice.domain.OrderRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/springmvc/v2/orders")
public class SpringOrderControllerV2 {

    OrderRepository orderRepository = OrderRepository.getInstance();

    @RequestMapping("/new-form")
    public ModelAndView newForm() {
        return new ModelAndView("new-form");
    }

    @RequestMapping("/save")
    public ModelAndView save(HttpServletRequest request, HttpServletResponse response) {
        String product = request.getParameter("product");
        int count = Integer.parseInt(request.getParameter("count"));

        Order order = new Order(product, count);
        orderRepository.save(order);

        ModelAndView mv = new ModelAndView("save-result");
        //mv.getModel().put("order",order);
        mv.addObject("order",order);

        return mv;
    }

    @RequestMapping
    public ModelAndView orders() {
        List<Order> all = orderRepository.findAll();

        ModelAndView mv = new ModelAndView("orders");
        mv.addObject("orders",all);
        //mv.getModel().put("orders",all);

        return mv;
    }
}
