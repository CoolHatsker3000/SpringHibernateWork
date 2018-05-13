package com.cursapp.controller;

import com.cursapp.Entity.AnimalsEntity;
import com.cursapp.Entity.ProductsEntity;
import com.cursapp.Entity.ProvidersEntity;
import com.cursapp.service.interfaces.AnimalService;
import com.cursapp.service.interfaces.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import com.cursapp.service.interfaces.ProviderService;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class ProviderController {
    @Autowired
    @Resource(name="providerService")
    ProviderService providerService;

    @Autowired
    @Resource(name = "productService")
    ProductService productService;

    @Autowired
    @Resource(name = "animalService")
    AnimalService animalService;
    @Autowired(required = true)
    @Qualifier(value = "providerService")
    public void setService(ProviderService ps) {
        this.providerService = ps;
    }


    @GetMapping("/providers")
    public String getProvidersListPage(Model model){
        List<ProvidersEntity> providers=providerService.ProviderList();
        model.addAttribute("providers", providers);
        return "providerspage";
    }
    @GetMapping("/providers/add")
    public String getAddProviderPage(Model model){
        model.addAttribute("provider", new ProvidersEntity());
        return "addprovider";
    }
    @PostMapping("/providers/add")
    public String addProvider(@ModelAttribute("provider") ProvidersEntity providersEntity, BindingResult result){
        if (result.hasErrors()) {
            return "/providers/add";
        }
        providerService.addProvider(providersEntity);
        return "redirect:/providers";
    }
    @GetMapping("/providers/delete/{id}")
    public String getDeleteProviderPage(@PathVariable int id){
        for (ProductsEntity pe: productService.List()
             ) {
            if(pe.getProvidersByProviderId()==null){continue;}else {
                if (pe.getProvidersByProviderId().getId() == id) {
                    pe.setProvidersByProviderId(null);
                    productService.update(pe);
                }
            }
        }
        for (AnimalsEntity ae:animalService.List()){
            if (ae.getProvidersByProviderId()==null){continue;}else {
                if ((ae.getProvidersByProviderId().getId() == id)) {
                    ae.setProvidersByProviderId(null);
                    animalService.update(ae);
                }
            }
        }

        providerService.removeProvider(id);
        return "redirect:/providers";
    }
    @GetMapping("/providers/edit/{id}")
    public String getEditProviderPage(@PathVariable int id, Model model){
        model.addAttribute("provider",providerService.getProviderById(id));
        return "editprovider";
    }
    @PostMapping("/providers/edit/{id}")
    public String editProvider(@ModelAttribute("provider") ProvidersEntity providersEntity,
                               @PathVariable int id,
                               Model model){
        providersEntity.setId(id);
        providerService.updateProvider(providersEntity);
        return "redirect:/providers";
    }

}
