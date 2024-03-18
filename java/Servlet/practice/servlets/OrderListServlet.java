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
import java.util.List;

@WebServlet(name = "orderListServlet", urlPatterns = "/servlet/orders")
public class OrderListServlet extends HttpServlet {
    private OrderRepository orderRepository = OrderRepository.getInstance();

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");

        List<Order> orders = orderRepository.findAll();

        PrintWriter w = response.getWriter();
        w.write("<html>");
        w.write("<head>");
        w.write("    <meta charset=\"UTF-8\">");
        w.write("    <title>Title</title>");
        w.write("</head>");
        w.write("<body>");
        w.write("<a href=\"/index.html\">메인</a>");
        w.write("<table>");
        w.write("   <thead>");
        w.write("<th>id</th>");
        w.write("<th>product</th>");
        w.write("<th>count</th>");
        w.write("   </thead>");
        w.write("   <tbody>");
        for (Order order : orders) {
            w.write("<tr>");
            w.write("<td>"+order.getId()+"</td>");
            w.write("<td>"+order.getProduct()+"</td>");
            w.write("<td>"+order.getCount()+"</td>");
            w.write("</tr>");
        }
        w.write("   </tbody>");
        w.write("   </table>");
        w.write("   </body>");
        w.write("   </html>");
    }
}
