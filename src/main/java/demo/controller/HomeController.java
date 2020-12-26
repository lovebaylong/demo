package demo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    private final String appName;

    public HomeController(@Value("${spring.application.name}") String appName) {
        this.appName = appName;
    }

    @GetMapping("/")
    public String welcome(Model model) {
        model.addAttribute("appName", appName);
        return "home";
    }
}
