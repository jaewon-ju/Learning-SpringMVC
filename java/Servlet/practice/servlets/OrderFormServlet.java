package Servlet.practice.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;


@WebServlet(name = "orderFormServlet", urlPatterns = "/servlet/orderss/new-form")
public class OrderFormServlet extends HttpServlet {
        @Override
        protected void service(HttpServletRequest request, HttpServletResponse
        response)
             throws ServletException, IOException {
    response.setContentType("text/html");
    response.setCharacterEncoding("utf-8");

    PrintWriter w = response.getWriter();
    w.write("<!DOCTYPE html>\n" +
            "<html>\n" +
            "<head>\n" +
            "    <meta charset=\"UTF-8\">\n" +
            "    <title>Title</title>\n" +
            "</head>\n" +
            "<body>\n" +
            "<form action=\"/servlet/members/save\" method=\"post\">\n" +
            "    username: <input type=\"text\" name=\"product\" />\n" +
            "    age:      <input type=\"text\" name=\"count\" />\n" +
            " <button type=\"submit\">전송</button>\n" + "</form>\n" +
            "</body>\n" +
            "</html>\n");
    }
}