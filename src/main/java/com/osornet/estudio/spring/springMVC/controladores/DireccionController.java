package com.osornet.estudio.spring.springMVC.controladores;



import com.osornet.estudio.spring.pojo.Admin;
import com.osornet.estudio.spring.pojo.Direccion;
import com.osornet.estudio.spring.service.AdminService;
import com.osornet.estudio.spring.service.DireccionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


/**
 * AdminController
 */
@Controller
@SessionAttributes("admin")
public class DireccionController {

    @Autowired
    private AdminService adminService;
    @Autowired
    private DireccionService direccionService;

    @RequestMapping("/direccion/{idAd}")
    public String getAll(@PathVariable("idAd") int idAd, Model model, @ModelAttribute("resultado") String resultado){
        
        Admin admin = this.adminService.findById(idAd);
        model.addAttribute("admin", admin);
        model.addAttribute("direccion", new Direccion());
        model.addAttribute("resultado", resultado); 
        model.addAttribute("direcciones", this.direccionService.findAll(idAd));   
        return "direccion";
    }
    @PostMapping("/direccion/save")
    public String save(@ModelAttribute("direccion") Direccion direccion, 
    @SessionAttribute("admin") Admin admin, RedirectAttributes rd){
        this.direccionService.save(admin, direccion);
        rd.addFlashAttribute("resultado", "Direccion Agregada con éxito");
        return "redirect:/direccion/"+admin.getIdAd();
    }
    @RequestMapping("/direccion/{idDir}/update")
    public String showDireccionUpdate(@PathVariable("idDir") int idDir, 
    @SessionAttribute("admin")Admin admin, Model model){
        Direccion direccion = this.direccionService.findById(idDir);
        model.addAttribute("direccion", direccion);
        return "direccion";
    }
    @RequestMapping("/direccion/{idDir}/delete")
    public String delete(@PathVariable("idDir")int idDir,
    @SessionAttribute("admin")Admin admin,RedirectAttributes rd) {
        this.direccionService.delete(idDir);
        rd.addFlashAttribute("resultado", "se eliminó la dirección correctamente");
        return "redirect:/direccion/"+admin.getIdAd();
    }

}