package Servlet.practice.servlets.httpServletRequest;

import Servlet.practice.basic.JsonData;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletInputStream;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.util.StreamUtils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

@WebServlet(name = "messageBodyServlet", urlPatterns = "/goods-json")
public class MessageBodyServlet extends HttpServlet {

    private ObjectMapper objectMapper = new ObjectMapper();
    // SpringBoot가 제공하는 JSON을 객체로 변환하기 위한 클래스

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletInputStream inputStream = request.getInputStream();
        String wholeBody = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8);

        JsonData jsonData = objectMapper.readValue(wholeBody, JsonData.class);
        System.out.println("jsonData.getProduct() = " + jsonData.getProduct());
        System.out.println("jsonData.getCount() = " + jsonData.getCount());
    }
}
