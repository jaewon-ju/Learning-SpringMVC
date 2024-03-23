package Servlet.practice.web.mvcFramework.version1;

import Servlet.practice.domain.Order;
import Servlet.practice.domain.OrderRepository;
import Servlet.practice.web.mvcFramework.version1.ControllerV1;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class OrderSaveControllerV1 implements ControllerV1 {

    OrderRepository orderRepository = OrderRepository.getInstance();

    @Override
    public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String product = request.getParameter("product");
        int count = Integer.parseInt(request.getParameter("count"));

        Order order = new Order(product, count);
        orderRepository.save(order);

        request.setAttribute("order",order);

        String viewPath = "/WEB-INF/views/save-result.jsp";
        RequestDispatcher dispatcher = request.getRequestDispatcher(viewPath);
        dispatcher.forward(request,response);
    }
}
