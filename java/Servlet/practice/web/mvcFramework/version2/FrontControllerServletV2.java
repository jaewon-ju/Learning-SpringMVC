package Servlet.practice.web.mvcFramework.version2;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "frontControllerServletV2", urlPatterns = "/front-controller/v2/*")
public class FrontControllerServletV2 extends HttpServlet {

    private Map<String, ControllerV2> controllerMap = new HashMap<>();
    // ControllerV2의 구현객체들을 저장하는 Map

    public FrontControllerServletV2() {
        controllerMap.put("/front-controller/V2/orders/new-form", new OrderFormControllerV2());
        controllerMap.put("/front-controller/V2/orders/save", new OrderSaveControllerV2());
        controllerMap.put("/front-controller/V2/orders", new OrderListControllerV2());

        // 프론트 컨트롤러가 생성될 때 Map에 구현객체들을 저장
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String requestURI = request.getRequestURI();

        ControllerV2 controllerV2 = controllerMap.get(requestURI);
        if(controllerV2 == null){
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        MyView myView = controllerV2.process(request, response);
        myView.render(request,response);
    }
}
