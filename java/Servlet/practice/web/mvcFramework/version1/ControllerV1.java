package Servlet.practice.web.mvcFramework.version1;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public interface ControllerV1 {
    void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
    // ControllerV1 타입의 구현객체는 항상 process를 구현해야 함
    // process는 비즈니스 로직이다.
}
