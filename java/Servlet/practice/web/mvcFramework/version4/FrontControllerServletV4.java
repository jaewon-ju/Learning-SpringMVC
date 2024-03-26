package Servlet.practice.web.mvcFramework.version4;

import Servlet.practice.web.mvcFramework.MyView;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "frontControllerServletV4", urlPatterns = "/front-controller/v4/*")
public class FrontControllerServletV4 extends HttpServlet {

    private Map<String, ControllerV4> controllerMap = new HashMap<>();
    // ControllerV3의 구현객체들을 저장하는 Map

    public FrontControllerServletV4() {
        controllerMap.put("/front-controller/v4/orders/new-form", new OrderFormControllerV4());
        controllerMap.put("/front-controller/v4/orders/save", new OrderSaveControllerV4());
        controllerMap.put("/front-controller/v4/orders", new OrderListControllerV4());

        // 프론트 컨트롤러가 생성될 때 Map에 구현객체들을 저장
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String requestURI = request.getRequestURI();
        ControllerV4 controllerV4 = controllerMap.get(requestURI);
        if(controllerV4 == null){
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        // 파라미터를 분석해서 컨트롤러에 넘겨줘야 함.
        Map<String, String> parameterMap = createParameterMap(request);

        // 모델을 새로 생성해서 컨트롤러에 넘겨줘야 함.
        Map<String, Object> model = new HashMap<>();

        String viewName = controllerV4.process(parameterMap, model);

        String viewPath = viewResolve(viewName);
        MyView myView = new MyView(viewPath);
        myView.render(model, request, response);
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
