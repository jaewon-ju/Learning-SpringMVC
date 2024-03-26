package Servlet.practice.web.mvcFramework.version2;

import Servlet.practice.domain.Order;
import Servlet.practice.domain.OrderRepository;
import Servlet.practice.web.mvcFramework.MyView;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class OrderSaveControllerV2 implements ControllerV2 {

    OrderRepository orderRepository = OrderRepository.getInstance();

    @Override
    public MyView process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String product = request.getParameter("product");
        int count = Integer.parseInt(request.getParameter("count"));

        Order order = new Order(product, count);
        orderRepository.save(order);

        request.setAttribute("order",order);

        String viewPath = "/WEB-INF/views/save-result.jsp";
        return new MyView(viewPath);
    }
}
