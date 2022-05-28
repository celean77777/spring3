package com.celean.spring3.controllers;

import com.celean.spring3.model.Product;
import com.celean.spring3.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ProductsController {

    private ProductService productService;

    @Autowired
    public ProductsController(ProductService productService) {
        this.productService = productService;
    }

    // GET http://localhost:8080/app/show_all
    @GetMapping(value = "/show_all")
    public String showProductsPage(Model model){
        model.addAttribute("products", productService.findAll());
        return "products";
    }

    // GET http://localhost:8080/app/show/{id}
    @GetMapping(value = "/show/{id}")
    public String showProductPageById(Model model, @PathVariable Long id){
        model.addAttribute("product", productService.findById(id));
        return "product_info";
    }

    // GET http://localhost:8080/app/create
    @GetMapping(value = "/create")
    public String createProduct(){
        return "create_product";
    }

    // POST http://localhost:8080/app/create
    @PostMapping(value = "/create")
    public String saveProduct(@RequestParam Long id, @RequestParam String name, @RequestParam double cost){
        productService.save(new Product(id, name, cost));
        return "redirect:/show_all";
    }

}
