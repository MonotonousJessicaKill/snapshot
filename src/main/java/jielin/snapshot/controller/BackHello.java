package jielin.snapshot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BackHello {
    @GetMapping(value = "/back")
    public String hello() {
        return "backend";
    }
}
