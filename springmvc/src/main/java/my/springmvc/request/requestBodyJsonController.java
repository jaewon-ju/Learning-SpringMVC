package my.springmvc.request;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletInputStream;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import my.springmvc.Order;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

@Slf4j
@Controller
@RequestMapping("/test/request-body-json")
public class requestBodyJsonController {

    private ObjectMapper objectMapper = new ObjectMapper();

    @ResponseBody
    @PostMapping("/v1")
    public String process1(HttpServletRequest request) throws IOException {
        ServletInputStream inputStream = request.getInputStream();
        String body = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8);

        Order order = objectMapper.readValue(body, Order.class);
        log.info("message body = {}, product = {}, count = {}", body, order.getProduct(),order.getCount());

        return "ok";
    }

    @ResponseBody
    @PostMapping("/v2")
    public String process2(@RequestBody String body) throws IOException{
        Order order = objectMapper.readValue(body, Order.class);
        log.info("message body = {}, product = {}, count = {}", body, order.getProduct(),order.getCount());

        return "ok";
    }

    @ResponseBody
    @PostMapping("/v3")
    public String process3(HttpEntity<Order> httpEntity) throws IOException{
        Order order = httpEntity.getBody();
        log.info("product = {}, count = {}", order.getProduct(),order.getCount());

        return "ok";
    }
    @ResponseBody
    @PostMapping("/v4")
    public String process4(@RequestBody Order order) throws IOException{
        log.info("product = {}, count = {}", order.getProduct(),order.getCount());

        return "ok";
    }
}
