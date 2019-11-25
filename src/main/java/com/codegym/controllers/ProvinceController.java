package com.codegym.controllers;

import com.codegym.models.Customer;
import com.codegym.models.Province;
import com.codegym.services.customer.CustomerService;
import com.codegym.services.province.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
@Controller
public class ProvinceController {
    @Autowired
    private ProvinceService provinceService;
    @Autowired
    private CustomerService customerService;
    @GetMapping("/view-provinces/{id}")
    public String viewProvince(@PathVariable Long id, Model model){
        Province province = provinceService.findById(id);
        if(province == null){
            return "/error.404";
        }
        List<Customer> customers = customerService.findAllByProvince(province);
        model.addAttribute("customers",customers);
        model.addAttribute("province",province);
        return "provinces/view";
    }
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
}
