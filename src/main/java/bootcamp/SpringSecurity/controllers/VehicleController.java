/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bootcamp.SpringSecurity.controllers;

import bootcamp.SpringSecurity.entities.Vehicle;
import bootcamp.SpringSecurity.services.VehicleService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Lee Tae Yong
 */
@Controller
@RequestMapping("vehicle")
public class VehicleController {

    @Autowired
    private VehicleService vehicleService;

    @GetMapping("")
    public String index(Model model) {
        model.addAttribute("vehicles", vehicleService.getAll());

        return "vehicle";
    }

    @PostMapping("add")
    public String addVehicles(Model model, Vehicle vehicle) {
       
        model.addAttribute("addvehicle", vehicleService.save(vehicle));

        return "redirect:/vehicle";
    }
    
    @GetMapping("delete/{id}")
    public String deleteVehicles(@PathVariable("id") int id, Model model){
        vehicleService.deleteById(id);
        return "redirect:/vehicle";
    } 

}
