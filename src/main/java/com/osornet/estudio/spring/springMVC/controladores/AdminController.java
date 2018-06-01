package com.osornet.estudio.spring.springMVC.controladores;

import java.util.List;

import com.osornet.estudio.spring.pojo.Admin;
import com.osornet.estudio.spring.service.AdminService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * AdminController
 */
@Controller
public class AdminController {

    @Autowired
    private AdminService adminService;

    @RequestMapping("/admin")
    public String showAdmin(Model model, @ModelAttribute("resultado") String resultado) {

        List<Admin> admins = this.adminService.findAll();

        Admin admin = new Admin();

        model.addAttribute("admin", admin);
        model.addAttribute("resultado", resultado);
        model.addAttribute("admins", admins);
        return "admin";
    }

    // @RequestMapping(value="/admin/save", method = RequestMethod.POST)
    @PostMapping("/admin/save")
    public String handleAdmin(@ModelAttribute("admin") Admin adminForm, Model model, RedirectAttributes redireccion,
            @RequestParam("estado") String estado) {
        this.adminService.saveOrUpdate(adminForm);
        redireccion.addFlashAttribute("resultado", "cambios realizados con exito");

        return "redirect:/admin";
    }

    @RequestMapping("/admin/{idAd}/update")
    public String showUpdateAdmin(@PathVariable("idAd") int id, Model model) {
        Admin admin = this.adminService.findById(id);
        model.addAttribute("admin",admin);
        return "admin";
    }

    @RequestMapping("/admin/{idAd}/delete")
    public String delete(@PathVariable("idAd") int idAd, RedirectAttributes rd) {
        
        this.adminService.delete(idAd);
        rd.addFlashAttribute("resultado", "Se ha eliminado el registro correctamente");
        return "redirect:/admin";
    }

}