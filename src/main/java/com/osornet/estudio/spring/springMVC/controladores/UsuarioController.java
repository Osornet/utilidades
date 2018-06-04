package com.osornet.estudio.spring.springMVC.controladores;

import java.util.List;

import com.osornet.estudio.spring.pojo.Usuario;
import com.osornet.estudio.spring.service.UsuarioService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * UsuarioController
 */
@Controller
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @RequestMapping("/usuario")
    public String showForm(Model model){
        
        List<Usuario> usuarios = this.usuarioService.findAll();
        model.addAttribute("usuario",new Usuario());
        model.addAttribute("usuarios", usuarios);
        return "usuario";
    }
    @RequestMapping("/usuario/save")
    public String save(RedirectAttributes rd,@ModelAttribute Usuario usuario){
        this.usuarioService.save(usuario);
               
        return "redirect:/usuario";
    }
}