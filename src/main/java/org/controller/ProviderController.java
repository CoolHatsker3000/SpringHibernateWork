package org.controller;

import org.Entity.ProvidersEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.service.ProviderService;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/")
public class ProviderController {
    @Resource(name="providerService")
    ProviderService providerService;

    @GetMapping("/providers")
    public String getProvidersListPage(Model model){
        List<ProvidersEntity> providers=providerService.ProviderList();
        model.addAttribute("providers", providers);
        return "providerspage";
    }
    @GetMapping("/providers/add")
    public String getAddProviderPage(Model model){
        model.addAttribute("provider", new ProvidersEntity());
        return "addpage";
    }
    @PostMapping("/providers/add")
    public String addProvider(@ModelAttribute("provider") ProvidersEntity providersEntity){
        providerService.addProvider(providersEntity);
        return "providerspage";
    }
    @GetMapping("/providers/delete")
    public String getDeleteProviderPage(@RequestParam(name="providerid") String providerID){
        providerService.removeProvider(Integer.parseInt(providerID));
        return "redirect:/providers";
    }
    @GetMapping("/providers/edit")
    public String getEditProviderPage(@RequestParam(value = "id", required = true)int id, Model model){
        model.addAttribute("providerAttribute",providerService.getProviderById(id));
        return "editpage";
    }
    @PostMapping("/providers/edit")
    public String editProvider(@ModelAttribute("providerAttribute") ProvidersEntity providersEntity,
                               @RequestParam(value = "id") int id,
                               Model model){
        providersEntity.setId(id);
        providerService.updateProvider(providersEntity);
        model.addAttribute("id", id);
        return "editpage";
    }

}
