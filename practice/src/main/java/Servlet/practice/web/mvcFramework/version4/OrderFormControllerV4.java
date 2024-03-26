package Servlet.practice.web.mvcFramework.version4;


import java.util.Map;

public class OrderFormControllerV4 implements ControllerV4 {

    @Override
    public String process(Map<String, String> parameterMap, Map<String, Object> model) {
        return "new-form";
    }
}
