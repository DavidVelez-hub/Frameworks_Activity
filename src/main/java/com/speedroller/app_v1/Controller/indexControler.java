package com.speedroller.app_v1.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class indexControler {

    @GetMapping("home")
    public String Home() {
        return "index";
    }

    @GetMapping("/mision")
    public String Mision() {
        return "mision";
    }

    @GetMapping("/vision")
    public String vision() {
        return "vision";
    }

    @GetMapping("/valores")
    public String valores() {
        return "valores";
    }

    @GetMapping("/servicios")
    public String servicios() {
        return "servicios";
    }

    @GetMapping("/eventos")
    public String eventos() {
        return "eventos";
    }

}
