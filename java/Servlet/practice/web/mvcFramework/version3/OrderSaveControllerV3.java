package Servlet.practice.web.mvcFramework.version3;

import Servlet.practice.domain.Order;
import Servlet.practice.domain.OrderRepository;
import Servlet.practice.web.mvcFramework.ModelView;

import java.util.Map;

public class OrderSaveControllerV3 implements ControllerV3{

    OrderRepository orderRepository = OrderRepository.getInstance();

    @Override
    public ModelView process(Map<String, String> parameterMap) {
        String product = parameterMap.get("product");
        int count = Integer.parseInt(parameterMap.get("count"));

        Order order = new Order(product, count);

        orderRepository.save(order);

        ModelView modelView = new ModelView("save-result");
        modelView.getModel().put("order",order);

        return modelView;
    }
}
