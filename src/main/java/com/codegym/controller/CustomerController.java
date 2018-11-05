package com.codegym.controller;

import com.codegym.model.Customer;
import com.codegym.service.CustomerService;
import com.codegym.service.CustomerServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class CustomerController {
    private CustomerService customerService = new CustomerServiceImpl();

    @GetMapping("/index")
    public ModelAndView view() {
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("customers", customerService.findAll());
        return modelAndView;
    }

    @GetMapping("/customer/create")
    public ModelAndView create() {
        ModelAndView modelAndView = new ModelAndView("create");
        modelAndView.addObject("customer", new Customer());
        return modelAndView;
    }

    @PostMapping("/customer/save")
    public String save(Customer customer, RedirectAttributes redirect) {
        customer.setId((int) (Math.random() * 10000));
        customerService.save(customer);
        redirect.addFlashAttribute("success", "Save customer successfully");
        return "redirect:/index";
    }
}
