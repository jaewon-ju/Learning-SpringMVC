package Servlet.practice.web.servletMVC;

import Servlet.practice.domain.Order;
import Servlet.practice.domain.OrderRepository;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "mvcOrderListServlet", urlPatterns = "/servlet-mvc/orders")
public class MvcOrderListServlet extends HttpServlet {
    private OrderRepository orderRepository = OrderRepository.getInstance();

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // ------ 파라미터 분석 ------
        List<Order> orders = orderRepository.findAll();
        // -----------------------


        // ------ Model에 저장 ------
        request.setAttribute("orders",orders);
        // -----------------------

        // ----- View에 제어권 넘김 -----
        String viewPath = "/WEB-INF/views/orders.jsp";
        RequestDispatcher dispatcher = request.getRequestDispatcher(viewPath);
        dispatcher.forward(request, response);
        // ------------------------
    }
}
