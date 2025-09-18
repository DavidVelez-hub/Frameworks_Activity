package com.speedroller.app_v1.Controller;

import com.speedroller.app_v1.Service.RegistroService;
import com.speedroller.app_v1.dto.AspiranteDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class AuthController {

    @Autowired
    private RegistroService registroService;

    // Mostrar formulario de registro
    @GetMapping("/user/register")
    public String showRegisterForm(Model model) {
        model.addAttribute("aspirante", new AspiranteDto());
        return "user/form_user"; // 👈 Vista en carpeta user/
    }

    // Procesar registro
    @PostMapping("/register")
    public String register(@ModelAttribute AspiranteDto aspiranteDto) {
        registroService.registrarAspirante(aspiranteDto);
        return "redirect:/login"; // 👈 Redirige al login después de registrar
    }

}