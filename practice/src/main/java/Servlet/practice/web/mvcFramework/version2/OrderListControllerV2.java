package Servlet.practice.web.mvcFramework.version2;

import Servlet.practice.domain.Order;
import Servlet.practice.domain.OrderRepository;
import Servlet.practice.web.mvcFramework.MyView;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

public class OrderListControllerV2 implements ControllerV2 {
    OrderRepository repository = OrderRepository.getInstance();
    @Override
    public MyView process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Order> orders = repository.findAll();

        request.setAttribute("orders",orders);

        String viewPath = "/WEB-INF/views/orders.jsp";
        return new MyView(viewPath);
    }
}
