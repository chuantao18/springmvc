package spitter.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Controller
@RequestMapping(value = "/", method = GET)
public class HomeController {
    @RequestMapping(method = GET)
    public String home() {
        return "home";
    }
}