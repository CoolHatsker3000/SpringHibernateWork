package com.cursapp.controller;

import com.cursapp.Entity.ProductsEntity;
import com.cursapp.model.Product;
import com.cursapp.service.interfaces.ProductService;
import com.cursapp.service.interfaces.ProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Controller
public class ProductController {
    @Autowired
    @Resource(name = "productService")
    ProductService productService;

    @Autowired
    @Resource(name="providerService")
    ProviderService providerService;
    @Autowired(required = true)
    @Qualifier(value = "productService")
    public void setService(ProductService ps) {
        this.productService = ps;
    }

    @GetMapping("/products")
    public String getProductsListPage(Model model){
        List<ProductsEntity> productsList=productService.List();


        List<Product> ListForModel=new ArrayList<Product>();

        for (ProductsEntity pe:productsList
             ) {
            System.out.println("Entity: "+pe.getName());
            Product product=new Product(pe);
            if(!product.getProviderID().equals("")) {
                product.setProviderName(providerService.getProviderById(Integer.parseInt(product.getProviderID())).getName());
            } else {
                product.setProviderName("NOT FOUND");
            }
            ListForModel.add(product);
        }
        model.addAttribute("products",ListForModel);
        return "productspage";
    }
    @GetMapping("/products/add")
    public String addProductPage(Model model){
        model.addAttribute("product", new Product());
        return "addproduct";
    }
    @PostMapping("/products/add")
    public String addProduct(@ModelAttribute("product") Product product, BindingResult result){
        if(result.hasErrors()){
            return "/products/add";
        }
        productService.add(new ProductsEntity(product));
        return "redirect:/products";
    }
    @GetMapping("/products/delete/{id}")
    public String deleteProductGet(@PathVariable String id){
        productService.remove(Integer.parseInt(id));
        return "redirect:/products";
    }
    @GetMapping("products/edit/{id}")
    public String editProductGet(@PathVariable int id, Model model){
        Product product=new Product(productService.getById(id));
        model.addAttribute("product",product);
        return "editproduct";
    }
    @PostMapping("products/edit/{id}")
    public String editProductPost(@ModelAttribute("product") Product product,
                                  @PathVariable int id,
                                  Model model)
    {
        ProductsEntity productsEntity=new ProductsEntity(product);
        productsEntity.setId(id);
        productService.update(productsEntity);
        return "redirect:/products";
    }
}
