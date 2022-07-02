package com.nalain.controllers;

import com.nalain.domain.Product;
import com.nalain.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
    @RequestMapping("/products/delete/{productId}")
    public String deleteProduct(@PathVariable Integer productId){
        productService.deleteProduct(productId);
        return "redirect:/products";
    }

    @RequestMapping("/products/edit/{productId}")
    public String editProduct(@PathVariable Integer productId, Model model){

        model.addAttribute("product", productService.getProductById(productId));
        return "productform";
    }

    @RequestMapping("/products/new")
    public String newProduct(Model model){

        model.addAttribute("product",new Product());
        return "productform";
    }

    @PostMapping("/products")
    public String saveOrUpdateProduct(Product product){

        Product saveProduct= productService.saveOrUpdateProduct(product);

        return "redirect:/products/"+saveProduct.getId();
    }

}
