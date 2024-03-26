package Servlet.practice.web.mvcFramework.version3;

import Servlet.practice.domain.Order;
import Servlet.practice.domain.OrderRepository;
import Servlet.practice.web.mvcFramework.ModelView;

import java.util.List;
import java.util.Map;

public class OrderListControllerV3 implements ControllerV3{

    OrderRepository orderRepository = OrderRepository.getInstance();
    @Override
    public ModelView process(Map<String, String> parameterMap) {
        List<Order> all = orderRepository.findAll();

        ModelView modelView = new ModelView("orders");
        modelView.getModel().put("orders",all);

        return modelView;
    }
}
