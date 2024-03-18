package Servlet.practice.servlets.HttpServletResponse;

import Servlet.practice.basic.JsonData;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "httpResponseServlet", urlPatterns = "/response")
public class HttpResponseServlet extends HttpServlet {

    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter writer = response.getWriter();

        /*
        writer.println("Response with simple Text");
        */

        /*
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        // SetContentType 지정 필수

        writer.println("<html>");
        writer.println("<body>");
        writer.println(" <div>Response with HTML</div>");
        writer.println("</body>");
        writer.println("</html>");
        */

        response.setHeader("content-type", "application/json");
        // json은 utf-8 형식을 사용하도록 정의되어 있어서 characterEncoding을 지정할 필요 없다.

        JsonData jsonData = new JsonData();
        jsonData.setProduct("Speaker");
        jsonData.setCount(1);

        String result = objectMapper.writeValueAsString(jsonData);

        response.getWriter().write(result);
    }
}
