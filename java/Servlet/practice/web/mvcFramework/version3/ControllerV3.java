package Servlet.practice.web.mvcFramework.version3;

import Servlet.practice.web.mvcFramework.ModelView;

import java.util.Map;

public interface ControllerV3 {
    ModelView process(Map<String, String> parameterMap);
    // ControllerV3의 구현객체는 서블릿 기술을 전혀 사용하지 않는다.
    // HttpServletRequest, HttpServletResponse 를 쓰지 않는다.
    // 파라미터는 frontController에서 분석해서 넘겨준다.
}
