package com.nalain.controllers;


import com.nalain.domain.Customer;
import com.nalain.domain.Product;
import com.nalain.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/customers")
@Controller
public class CustomerController {

    CustomerService customerService;

    @Autowired
    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }

    @RequestMapping("")
    public String listAllCustomers(Model model){
        model.addAttribute("customers",customerService.listAll());
        return "customer/customers";
    }


    @RequestMapping("/{customerId}")
    public String findById(@PathVariable Integer customerId, Model model){

        model.addAttribute("customer", customerService.getById(customerId));
        return "customer/customer";
    }

    @RequestMapping("/new")
    public String newCustomer(Model model){

        model.addAttribute("customer",new Customer());
        return "customer/customerform";
    }


    @PostMapping("/customers")
    public String saveOrUpdateCustomer(Customer customer){

        Customer savedCustomer= customerService.save(customer);
        return "redirect:customers"+savedCustomer.getId();
    }

    @RequestMapping("/edit/{customerId}")
    public String editCustomer(@PathVariable Integer customerId, Model model){

        model.addAttribute("customer", customerService.getById(customerId));
        return "customer/customerform";
    }
    @RequestMapping("/delete/{customerId}")
    public String deleteCustomer(@PathVariable Integer customerId){
        customerService.delete(customerId);
        return "redirect:/customers";
    }


}
