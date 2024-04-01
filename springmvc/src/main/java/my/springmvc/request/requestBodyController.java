package my.springmvc.request;

import jakarta.servlet.ServletInputStream;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

@Slf4j
@Controller
@RequestMapping("/test/request-body")
class requestBodyController {

    @ResponseBody
    @PostMapping("/v1")
    public String process(HttpServletRequest request) throws IOException {
        ServletInputStream inputStream = request.getInputStream();
        String body = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8);

        log.info("messageBody = {}",body);

        return "ok";
    }

    @ResponseBody
    @PostMapping("/v2")
    public String process2(InputStream inputStream) throws IOException {
        String body = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8);

        log.info("messageBody = {}",body);
        return "ok";
    }


    @ResponseBody
    @PostMapping("/v3")
    public String process3(HttpEntity<String> httpEntity) {
        String body = httpEntity.getBody();

        log.info("messageBody = {}",body);
        return "ok";
    }

    @ResponseBody
    @PostMapping("/v4")
    public String process4(@RequestBody String body) {
        log.info("messageBody = {}",body);
        return "ok";
    }
}