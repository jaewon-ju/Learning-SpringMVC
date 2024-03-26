package Servlet.practice.web.mvcFramework.version4;

import Servlet.practice.domain.Order;
import Servlet.practice.domain.OrderRepository;

import java.util.List;
import java.util.Map;

public class OrderListControllerV4 implements ControllerV4 {

    OrderRepository orderRepository = OrderRepository.getInstance();
    @Override
    public String process(Map<String, String> parameterMap, Map<String, Object> model) {
        List<Order> all = orderRepository.findAll();
        model.put("orders",all);

        return "orders";
    }
}
