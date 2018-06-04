package com.osornet.estudio.spring.springMVC.controladores;



import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;



/**
 * IndexController
 */
@Controller
//si queremos que se tomen mas resultados
//@SessionAttributes({"resultado", "mensaje"})
@SessionAttributes("resultado")
public class IndexController {

    @RequestMapping("/")
    public String showIndex(Model model) {
        model.addAttribute("resultado", "Resultado desde Session");
       
        return "index";
    }
    @RequestMapping("/about")
    public String showAbout() {
        
        return "about";
    }
    @RequestMapping("/login")
    public String login(){
        return "login";
    }
   /* @RequestMapping("/salida")
    public String logout(){
        return "redirect: /";
    }  */
   

}