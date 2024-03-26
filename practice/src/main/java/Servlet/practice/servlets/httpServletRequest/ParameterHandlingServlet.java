package Servlet.practice.servlets.httpServletRequest;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Enumeration;

@WebServlet(name="parameterHandlingServlet", urlPatterns = "/goods")
public class ParameterHandlingServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String product = request.getParameter("product");
        System.out.println("product = " + product);
        // 단일

        request.getParameterNames().asIterator().forEachRemaining(paramName -> System.out.println("paramName = " + paramName));
        // 모든 파라미터 이름 조회

        String[] products = request.getParameterValues("product");
        for(String productName : products) {
            System.out.println("product = " + productName);
        }
    }
}
