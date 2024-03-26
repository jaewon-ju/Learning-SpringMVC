package Servlet.practice.web.springMVC.v1;

import Servlet.practice.domain.Order;
import Servlet.practice.domain.OrderRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class OrderSaveControllerV1 {

    OrderRepository orderRepository = OrderRepository.getInstance();
    @RequestMapping("/springmvc/v1/orders/save")
    public ModelAndView process(HttpServletRequest request, HttpServletResponse response) {
        String product = request.getParameter("product");
        int count = Integer.parseInt(request.getParameter("count"));

        Order order = new Order(product, count);
        orderRepository.save(order);

        ModelAndView mv = new ModelAndView("save-result");
        //mv.getModel().put("order",order);
        mv.addObject("order",order);

        return mv;
    }
}
