/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bootcamp.SpringSecurity.controllers;

import bootcamp.SpringSecurity.entities.Vehicle;
import bootcamp.SpringSecurity.services.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Lee Tae Yong
 */
@Controller
public class MainController {
    @Autowired
    private VehicleService vehicleService;
    @RequestMapping("/")
    public String home(){
        return "home";
    }
    
    @RequestMapping("vehicle")
    public String vehicle(){
        
        return "vehicle";
    }
    
    @RequestMapping("reimbursement")
    public String reimbursement(){
        return "reimbursement";
    }
    
    
}
