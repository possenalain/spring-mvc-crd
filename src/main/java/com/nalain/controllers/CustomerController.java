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

@Controller
public class CustomerController {

    CustomerService customerService;

    @Autowired
    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }

    @RequestMapping("/customers")
    public String listAllCustomers(Model model){
        model.addAttribute("customers",customerService.findAllCustomers());
        return "customers";
    }


    @RequestMapping("/customers/{customerId}")
    public String findCustomerByid(@PathVariable Integer customerId, Model model){

        model.addAttribute("customer", customerService.findCustomerById(customerId));
        return "customer";
    }

    @RequestMapping("/customers/new")
    public String newCustomer(Model model){

        model.addAttribute("customer",new Customer());
        return "customerform";
    }


    @PostMapping("/customers")
    public String saveOrUpdateCustomer(Customer customer){
        Customer savedCustomer= customerService.saveOrUpdateProduct(customer);
        return "redirect:/customers/"+savedCustomer.getId();
    }

    @RequestMapping("/customers/edit/{customerId}")
    public String editCustomer(@PathVariable Integer customerId, Model model){

        model.addAttribute("customer", customerService.findCustomerById(customerId));
        return "customerform";
    }
    @RequestMapping("/customers/delete/{customerId}")
    public String deleteCustomer(@PathVariable Integer customerId){
        customerService.deleteCustomer(customerId);
        return "redirect:/customers";
    }


}
