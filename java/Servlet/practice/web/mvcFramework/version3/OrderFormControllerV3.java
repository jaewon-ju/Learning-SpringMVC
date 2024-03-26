package Servlet.practice.web.mvcFramework.version3;


import Servlet.practice.web.mvcFramework.ModelView;

import java.util.Map;

public class OrderFormControllerV3 implements ControllerV3 {
    @Override
    public ModelView process(Map<String, String> parameterMap) {
        return new ModelView("new-form");
    }
}
