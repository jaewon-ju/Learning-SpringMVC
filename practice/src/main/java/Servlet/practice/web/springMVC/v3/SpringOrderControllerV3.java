package Servlet.practice.web.springMVC.v3;

import Servlet.practice.domain.Order;
import Servlet.practice.domain.OrderRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/springmvc/v3/orders")
public class SpringOrderControllerV3 {

    OrderRepository orderRepository = OrderRepository.getInstance();

    @GetMapping("/new-form")
    public String newForm() {
        return "new-form";
    }

    @PostMapping("/save")
    public String save(@RequestParam("product") String product, @RequestParam("count") int count, Model model) {
        Order order = new Order(product, count);
        orderRepository.save(order);

        model.addAttribute("order",order);

        return "save-result";
    }

    @GetMapping
    public String orders(Model model) {
        List<Order> all = orderRepository.findAll();

        model.addAttribute("orders",all);

        return "orders";
    }
}
