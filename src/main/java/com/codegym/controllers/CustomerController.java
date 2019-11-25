package com.codegym.controllers;

import com.codegym.models.Customer;
import com.codegym.models.Province;
import com.codegym.services.customer.CustomerService;
import com.codegym.services.province.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class CustomerController {
    @Autowired
    private CustomerService customerService;
    @Autowired
    private ProvinceService provinceService;
    @GetMapping("/customers")
    public String customerList(Model model) {
        List<Customer> customers = customerService.findAll();
        model.addAttribute("customers", customers);
        return "customers/list";
    }
    @GetMapping("/create-customer")
    public String createCustomer(Model model) {
        model.addAttribute("customer", new Customer());
        return "customers/create";
    }
    @PostMapping("/create-customer")
    public String saveNewCustomer(Customer customer, Model model) {
        customerService.save(customer);
        model.addAttribute("message", "Added new customer");
        return "customers/create";
    }
    @GetMapping("/edit-customer/{id}")
    public String editCustomer(@PathVariable Long id, Model model) {
        Customer customer = customerService.findById(id);
        model.addAttribute("customer", customer);
        return "customers/edit";
    }
    @PostMapping("/edit-customer")
    public String saveEditCustomer(Model model, Customer customer) {
        customerService.save(customer);
        model.addAttribute("message","Saved");
        return "customers/edit";
    }
    @GetMapping("/delete-customer/{id}")
    public String deleteCustomer(@PathVariable Long id, Model model) {
        Customer customer = customerService.findById(id);
        model.addAttribute("customer", customer);
        return "customers/delete";
    }
    @PostMapping("/delete-customer")
    public String saveDeleteCustomer(Customer customer) {
        customerService.remove(customer.getId());
        return "customers/delete";
    }
    @ModelAttribute("provinces")
    public List<Province> provinces(){
        return provinceService.findAll();
    }
}
