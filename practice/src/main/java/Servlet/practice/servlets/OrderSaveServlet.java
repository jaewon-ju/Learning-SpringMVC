package Servlet.practice.servlets;

import Servlet.practice.domain.Order;
import Servlet.practice.domain.OrderRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "orderSaveServlet", urlPatterns = "/servlet/orders/save")
public class OrderSaveServlet extends HttpServlet {

    private OrderRepository orderRepository = OrderRepository.getInstance();
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String product = request.getParameter("product");
        int count = Integer.parseInt(request.getParameter("count"));

        Order order = new Order(product, count);
        orderRepository.save(order);
        response.setContentType("text/html");
        response.setCharacterEncoding("utf-8");
        PrintWriter w = response.getWriter();
        w.write("<html>\n" +
                "<head>\n" +
                " <meta charset=\"UTF-8\">\n" + "</head>\n" +
                "<body>\n" +
                "성공\n" +
                "<ul>\n" +
                "    <li>id=" + order.getId() + "</li>\n" +
                "    <li>product=" + order.getProduct() + "</li>\n" +
                " <li>count=" + order.getCount() + "</li>\n" + "</ul>\n" +
                "<a href=\"/index.html\">메인</a>\n" + "</body>\n" +
                "</html>");

        // HTML 중간에 자바 코드를 넣는 것도 가능하다.
        // 베이스가 자바 코드이기 때문에 가능하다.
    }
}
