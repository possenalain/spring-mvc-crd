package com.nalain.controllers;

import com.nalain.domain.Product;
import com.nalain.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
@RequestMapping("/products")
@Controller
public class ProductController {

    private ProductService productService;

    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }


    @RequestMapping("")
    public String listAllProducts(Model model){

        model.addAttribute("products", productService.listAll());

        return "product/products";
    }

    @RequestMapping("/{productId}")
    public String getProduct(@PathVariable Integer productId, Model model){

        model.addAttribute("product", productService.getById(productId));
        return "product/product";
    }
    @RequestMapping("/delete/{productId}")
    public String deleteProduct(@PathVariable Integer productId){
        productService.delete(productId);
        return "redirect:/products";
    }

    @RequestMapping("/edit/{productId}")
    public String editProduct(@PathVariable Integer productId, Model model){

        model.addAttribute("product", productService.getById(productId));
        return "product/productform";
    }

    @RequestMapping("/new")
    public String newProduct(Model model){

        model.addAttribute("product",new Product());
        return "product/productform";
    }

    @PostMapping("/")
    public String saveOrUpdateProduct(Product product){

        Product saveProduct= productService.save(product);

        return "redirect:/products"+saveProduct.getId();
    }

}
