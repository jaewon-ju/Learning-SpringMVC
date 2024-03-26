package Servlet.practice.web.mvcFramework.version5;

import Servlet.practice.web.mvcFramework.ModelView;
import Servlet.practice.web.mvcFramework.version4.ControllerV4;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ControllerV4Adapter implements MyHandlerAdapter{
    @Override
    public boolean support(Object handler) {
        return (handler instanceof ControllerV4);
    }

    @Override
    public ModelView handle(HttpServletRequest request, HttpServletResponse response, Object handler) throws ServletException, IOException {
        ControllerV4 controllerV4 = (ControllerV4) handler;

        Map<String, String> parameterMap = new HashMap<>();
        Map<String, Object> model = new HashMap<>();

        request.getParameterNames().asIterator().forEachRemaining(paramName -> parameterMap.put(paramName, request.getParameter(paramName)));

        String viewName = controllerV4.process(parameterMap, model);
        ModelView modelView = new ModelView(viewName);
        modelView.setModel(model); // 반드시 모델을 세팅한 후에 넘겨줘야 한다.

        return modelView;
    }
}
