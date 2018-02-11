package jielin.snapshot.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 静态页面处理类
 * /wade
 */
@Controller
public class HelloController {
    @GetMapping(value = "")
    public String hello() {
        return "index";
    }
}
