package com.codegym.controllers;

import com.codegym.models.Province;
import com.codegym.models.Province;
import com.codegym.services.province.ProvinceService;
import com.codegym.services.province.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
@Controller
public class ProvinceController {
    @Autowired
    private ProvinceService provinceService;
    @GetMapping("/provinces")
    public String provinceList(Model model){
        List<Province> provinces = provinceService.findAll();
        model.addAttribute("provinces",provinces);
        return "provinces/list";
    }
    @GetMapping("/")
    public String homePage(){
        return "home";
    }
    @GetMapping("/create-province")
    public String createProvince(Model model) {
        model.addAttribute("province", new Province());
        return "provinces/create";
    }
    @PostMapping("/create-province")
    public String saveNewProvince(Province province, Model model) {
        provinceService.save(province);
        model.addAttribute("message", "Added new province");
        return "provinces/create";
    }
    @GetMapping("/edit-province/{id}")
    public String editProvince(@PathVariable Long id, Model model) {
        Province province = provinceService.findById(id);
        model.addAttribute("province", province);
        return "provinces/edit";
    }
    @PostMapping("/edit-province")
    public String saveEditProvince(Model model, Province province) {
        provinceService.save(province);
        model.addAttribute("message","Saved");
        return "provinces/edit";
    }
    @GetMapping("/delete-province/{id}")
    public String deleteProvince(@PathVariable Long id, Model model) {
        Province province = provinceService.findById(id);
        model.addAttribute("province", province);
        return "provinces/delete";
    }
    @PostMapping("/delete-province")
    public String saveDeleteProvince(Province province) {
        provinceService.remove(province.getId());
        return "provinces/delete";
    }
}
