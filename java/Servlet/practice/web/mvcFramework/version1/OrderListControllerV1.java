package Servlet.practice.web.mvcFramework.version1;

import Servlet.practice.domain.Order;
import Servlet.practice.domain.OrderRepository;
import Servlet.practice.web.mvcFramework.version1.ControllerV1;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

public class OrderListControllerV1 implements ControllerV1 {
    OrderRepository repository = OrderRepository.getInstance();
    @Override
    public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Order> orders = repository.findAll();

        request.setAttribute("orders",orders);

        String viewPath = "/WEB-INF/views/orders.jsp";
        RequestDispatcher dispatcher = request.getRequestDispatcher(viewPath);
        dispatcher.forward(request,response);
    }
}
