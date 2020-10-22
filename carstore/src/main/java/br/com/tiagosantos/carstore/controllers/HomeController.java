package br.com.tiagosantos.carstore.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class HomeController {
    @RequestMapping("/home")
    public String index() {
        return "index.html";
    }
}
