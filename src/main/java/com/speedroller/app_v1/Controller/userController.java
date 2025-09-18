package com.speedroller.app_v1.Controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import com.speedroller.app_v1.Model.userModel;
import com.speedroller.app_v1.Service.userService;

@Controller
@RequestMapping("/user")
public class userController {

    @Autowired
    private userService userService;

    @GetMapping("/listar")
    public String listarUsuarios(Model model) {
        List<userModel> usuarios = userService.listarUser();
        model.addAttribute("usuarios", usuarios);
        return "user/listar_user"; // 👈 Vista en carpeta user/
    }

    @GetMapping("/nuevo")
    public String mostrarFormulario(Model model) {
        model.addAttribute("usuario", new userModel());
        return "user/form_user"; // 👈 Mismo formulario para crear/editar
    }

    @PostMapping("/guardar")
    public String guardarUsuario(@Valid @ModelAttribute("usuario") userModel usuario, BindingResult result) {
        if (result.hasErrors()) {
            return "user/form_user"; // 👈 Vuelve al mismo formulario si hay error
        }
        userService.guardar(usuario);
        System.out.println("¡Usuario guardado: " + usuario.getName());
        return "redirect:/user/listar"; // 👈 Redirige a lista
    }
}