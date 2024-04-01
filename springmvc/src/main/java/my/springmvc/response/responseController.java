package my.springmvc.response;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import my.springmvc.Order;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;

@Slf4j
@Controller
@RequestMapping("/response-body")
public class responseController {

    @RequestMapping("/text/v1")
    public void process1(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.getWriter().write("ok");
    }

    @RequestMapping("/text/v2")
    public ResponseEntity<String> process2(){
        return new ResponseEntity<>("ok", HttpStatus.OK);
    }
    // ResponseEntity 객체를 반환하면 스프링이 응답 메시지 바디에 "ok" 를 넣어준다.

    @ResponseBody
    @RequestMapping("/text/v3")
    public String process3() {
        return "ok";
    }
    // @ResponseBody를 붙이면 리턴한 문자열을 응답 메시지의 바디에 넣어준다.

    @RequestMapping("/json/v1")
    public ResponseEntity<Order> process4(){
        Order order = new Order();
        order.setProduct("speaker");
        order.setCount(1);
        return new ResponseEntity<>(order, HttpStatus.OK);
    }

    @ResponseBody
    @RequestMapping("/json/v2")
    public Order process5() {
        Order order = new Order();
        order.setProduct("speaker");
        order.setCount(1);
        return order;
    }
}
