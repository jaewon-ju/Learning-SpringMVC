package Servlet.practice.web.mvcFramework.version5;

import Servlet.practice.web.mvcFramework.version3.ControllerV3;
import Servlet.practice.web.mvcFramework.ModelView;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ControllerV3Adapter implements MyHandlerAdapter{
    // V3 전용 어댑터
    @Override
    public boolean support(Object handler) {
        return (handler instanceof ControllerV3);
        // 컨트롤러가 version3 이어야만 지원한다.
    }

    @Override
    public ModelView handle(HttpServletRequest request, HttpServletResponse response, Object handler) throws ServletException, IOException {
        ControllerV3 controllerV3 = (ControllerV3) handler;

        // 파라미터를 분석해서 컨트롤러에 넘겨줘야 함.
        Map<String, String> parameterMap = createParameterMap(request);

        ModelView modelView = controllerV3.process(parameterMap);
        return modelView;
    }

    private Map<String, String> createParameterMap(HttpServletRequest request) {
        Map<String, String> parameterMap = new HashMap<>();

        request.getParameterNames().asIterator().forEachRemaining(paramName -> parameterMap.put(paramName, request.getParameter(paramName)));
        return parameterMap;
    }

}
