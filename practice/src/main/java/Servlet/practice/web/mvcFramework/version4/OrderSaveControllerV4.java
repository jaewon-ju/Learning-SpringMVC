package Servlet.practice.web.mvcFramework.version4;

import Servlet.practice.domain.Order;
import Servlet.practice.domain.OrderRepository;

import java.util.Map;

public class OrderSaveControllerV4 implements ControllerV4 {

    OrderRepository orderRepository = OrderRepository.getInstance();

    @Override
    public String process(Map<String, String> parameterMap, Map<String, Object> model) {
        String product = parameterMap.get("product");
        int count = Integer.parseInt(parameterMap.get("count"));

        Order order = new Order(product, count);

        orderRepository.save(order);

        model.put("order",order);

        return "save-result";
    }
}
