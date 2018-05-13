package com.cursapp.controller;

import com.cursapp.Entity.AnimalsEntity;
import com.cursapp.model.Animal;
import com.cursapp.model.Product;
import com.cursapp.service.interfaces.AnimalService;
import com.cursapp.service.interfaces.ProductService;
import com.cursapp.service.interfaces.ProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Controller
public class AnimalController {
    @Autowired
    @Resource(name = "animalService")
    AnimalService animalService;

    @Autowired
    @Resource(name="providerService")
    ProviderService providerService;

    @GetMapping("/animals")
    public String getAnimalsPage(Model model){
        List<AnimalsEntity> animalsList=animalService.List();
        List<Animal> listForModel=new ArrayList<Animal>();
        for (AnimalsEntity ae:animalsList
             ) {
            Animal animal=new Animal(ae);
            if(animal.getProviderID()!=-1) {
                animal.setProviderName(providerService.getProviderById(animal.getProviderID()).getName());
            } else {
                animal.setProviderName("NOT FOUND");
            }
            listForModel.add(animal);
        }
        model.addAttribute("animals", listForModel);

        return "animalspage";
    }

    @GetMapping("/animals/add")
    public String GetAnimalAddPage(Model model){
        model.addAttribute("animal", new Animal());
        return "addanimal";
    }
    @PostMapping("/animals/add")
    public String PostAnimalAddPage(@ModelAttribute("animal") Animal animal, BindingResult result){
        if(result.hasErrors()){
            return "/products/add";
        }
        animalService.add(new AnimalsEntity((animal)));
        return "redirect:/animals";
    }
    @GetMapping("/animals/delete/{id}")
    public String DeleteAnimal(@PathVariable int id, Model model){
        animalService.remove(id);
        return "redirect:/animals";
    }
    @GetMapping("/animals/edit/{id}")
    public String GetAnimalEditPage(@PathVariable int id, Model model){
        Animal animal = new Animal(animalService.getById(id));
        model.addAttribute("animal", animal);
        return "editanimal";
    }
    @PostMapping("/animals/edit/{id}")
    public String PostAnimalEditPage(@ModelAttribute("animal") Animal animal, @PathVariable int id, Model model){
        AnimalsEntity animalsEntity=new AnimalsEntity(animal);
        animalsEntity.setAnimalId(id);
        animalService.update(animalsEntity);
        return "redirect:/animals";
    }
}
