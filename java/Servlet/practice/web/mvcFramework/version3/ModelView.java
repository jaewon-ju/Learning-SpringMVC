package Servlet.practice.web.mvcFramework.version3;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

@Getter @Setter
public class ModelView {
    //ModelView 객체는 뷰의 논리적인 이름을 저장한다.

    private String viewName;
    private Map<String, Object> model = new HashMap<>();

    public ModelView(String viewName){
        this.viewName = viewName;
    }
}
