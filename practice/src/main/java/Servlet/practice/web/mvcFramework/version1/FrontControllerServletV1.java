package Servlet.practice.web.mvcFramework.version1;

import Servlet.practice.web.mvcFramework.version1.ControllerV1;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * FrontController 버전1
 * 프론트 컨트롤러를 도입하여 공통 처리 기능을 가능하게 만들었다.
 * 프론트 컨트롤러를 제외한 나머지 컨트롤러는 서블릿을 사용하지 않아도 된다.
 */
@WebServlet(name = "frontControllerServletV1", urlPatterns = "/front-controller/v1/*")
public class FrontControllerServletV1 extends HttpServlet {

    private Map<String, ControllerV1> controllerMap = new HashMap<>();
    // ControllerV1의 구현객체들을 저장하는 Map

    public FrontControllerServletV1() {
        controllerMap.put("/front-controller/v1/orders/new-form", new OrderFormControllerV1());
        controllerMap.put("/front-controller/v1/orders/save", new OrderSaveControllerV1());
        controllerMap.put("/front-controller/v1/orders", new OrderListControllerV1());

        // 프론트 컨트롤러가 생성될 때 Map에 구현객체들을 저장
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String requestURI = request.getRequestURI();

        ControllerV1 controllerV1 = controllerMap.get(requestURI);
        if(controllerV1 == null){
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        controllerV1.process(request,response);
    }
}
