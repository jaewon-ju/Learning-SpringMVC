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

@WebServlet(name = "mvcOrderSaveServlet", urlPatterns = "/servlet-mvc/orders/save")
public class MvcOrderSaveServlet extends HttpServlet {
    private OrderRepository orderRepository = OrderRepository.getInstance();

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String product = request.getParameter("product");
        int count = Integer.parseInt(request.getParameter("count"));

        Order order = new Order(product,count);
        orderRepository.save(order);

        // Model에 데이터 보관
        // key, value 형태로 보관한다
        request.setAttribute("order",order);

        String viewPath = "/WEB-INF/views/save-result.jsp";
        RequestDispatcher dispatcher = request.getRequestDispatcher(viewPath);
        dispatcher.forward(request, response);
    }
}
