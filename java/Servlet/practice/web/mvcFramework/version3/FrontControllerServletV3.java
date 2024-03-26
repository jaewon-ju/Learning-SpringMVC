package Servlet.practice.web.mvcFramework.version3;

import Servlet.practice.web.mvcFramework.ModelView;
import Servlet.practice.web.mvcFramework.MyView;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "frontControllerServletV3", urlPatterns = "/front-controller/v3/*")
public class FrontControllerServletV3 extends HttpServlet {

    private Map<String, ControllerV3> controllerMap = new HashMap<>();
    // ControllerV3의 구현객체들을 저장하는 Map

    public FrontControllerServletV3() {
        controllerMap.put("/front-controller/v3/orders/new-form", new OrderFormControllerV3());
        controllerMap.put("/front-controller/v3/orders/save", new OrderSaveControllerV3());
        controllerMap.put("/front-controller/v3/orders", new OrderListControllerV3());

        // 프론트 컨트롤러가 생성될 때 Map에 구현객체들을 저장
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String requestURI = request.getRequestURI();
        ControllerV3 controllerV3 = controllerMap.get(requestURI);
        if(controllerV3 == null){
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        // 파라미터를 분석해서 컨트롤러에 넘겨줘야 함.
        Map<String, String> parameterMap = createParameterMap(request);

        ModelView modelView = controllerV3.process(parameterMap);

        String viewPath = viewResolve(modelView.getViewName());
        MyView myView = new MyView(viewPath);
        myView.render(modelView.getModel(), request, response);
    }

    private String viewResolve(String viewName) {
        return "/WEB-INF/views/" + viewName + ".jsp";
    }

    private Map<String, String> createParameterMap(HttpServletRequest request) {
        Map<String, String> parameterMap = new HashMap<>();

        request.getParameterNames().asIterator().forEachRemaining(paramName -> parameterMap.put(paramName, request.getParameter(paramName)));
        return parameterMap;
    }
}
