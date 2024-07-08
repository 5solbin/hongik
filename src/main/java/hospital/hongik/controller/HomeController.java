package hospital.hongik.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j // 로깅에 대한 추상 레이어를 제공하는 인터페이스의 모음
public class HomeController {

    @RequestMapping("/")
    public String hone() {
        log.info("home controller");
        return "home";
    }
}
