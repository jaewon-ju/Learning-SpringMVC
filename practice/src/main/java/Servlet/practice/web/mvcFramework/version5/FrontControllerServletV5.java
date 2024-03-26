package Servlet.practice.web.mvcFramework.version5;


import Servlet.practice.web.mvcFramework.ModelView;
import Servlet.practice.web.mvcFramework.MyView;
import Servlet.practice.web.mvcFramework.version3.OrderFormControllerV3;
import Servlet.practice.web.mvcFramework.version3.OrderListControllerV3;
import Servlet.practice.web.mvcFramework.version3.OrderSaveControllerV3;
import Servlet.practice.web.mvcFramework.version4.OrderFormControllerV4;
import Servlet.practice.web.mvcFramework.version4.OrderListControllerV4;
import Servlet.practice.web.mvcFramework.version4.OrderSaveControllerV4;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(name = "frontControllerServletV5", urlPatterns = "/front-controller/v5/*")
public class FrontControllerServletV5 extends HttpServlet {

    private final Map<String, Object> handlerMap = new HashMap<>();
    private final List<MyHandlerAdapter> handlerAdapters = new ArrayList<>();

    public FrontControllerServletV5(){
        initHandlerMap();
        initHandlerAdapters();
    }

    public void initHandlerMap() {
        handlerMap.put("/front-controller/v5/v3/orders/new-form", new OrderFormControllerV3());
        handlerMap.put("/front-controller/v5/v3/orders/save", new OrderSaveControllerV3());
        handlerMap.put("/front-controller/v5/v3/orders", new OrderListControllerV3());

        handlerMap.put("/front-controller/v5/v4/orders/new-form", new OrderFormControllerV4());
        handlerMap.put("/front-controller/v5/v4/orders/save", new OrderSaveControllerV4());
        handlerMap.put("/front-controller/v5/v4/orders", new OrderListControllerV4());
        // 프론트 컨트롤러가 생성될 때 handlerMap에 컨트롤러들을 저장
    }

    private void initHandlerAdapters(){
        handlerAdapters.add(new ControllerV3Adapter());
        handlerAdapters.add(new ControllerV4Adapter());
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 요청 URI에 해당되는 컨트롤러 구현객체를 가져옴
        String requestURI = request.getRequestURI();
        Object handler = handlerMap.get(requestURI);
        if(handler == null) {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return;
        }
        // ------------------------------------

        // 핸들러에 맞는 어댑터를 가져옴
        MyHandlerAdapter myHandlerAdapter = null;

        for(MyHandlerAdapter adapter : handlerAdapters){
            if(adapter.support(handler)){
                myHandlerAdapter = adapter;
            }
        }
        // ------------------------------------

        ModelView modelView = myHandlerAdapter.handle(request, response, handler);

        String viewPath = viewResolve(modelView.getViewName());
        MyView myView = new MyView(viewPath);
        myView.render(modelView.getModel(),request, response);
    }

    private String viewResolve(String viewName) {
        return "/WEB-INF/views/" + viewName + ".jsp";
    }
}
