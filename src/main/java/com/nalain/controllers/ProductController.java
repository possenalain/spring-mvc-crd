package com.nalain.controllers;

import com.nalain.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ProductController {

    private ProductService productService;

    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }



    @RequestMapping("/products")
    public String listAllProducts(Model model){

        model.addAttribute("products", productService.listAllProducts());

        return "products";
    }

    @RequestMapping("/products/{productId}")
    public String getProduct(@PathVariable Integer productId, Model model){

        model.addAttribute("product", productService.getProductById(productId));
        return "product";
    }
}
