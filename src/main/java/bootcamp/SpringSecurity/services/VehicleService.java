/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bootcamp.SpringSecurity.services;

import bootcamp.SpringSecurity.entities.Vehicle;
import bootcamp.SpringSecurity.repositories.VehicleRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Lee Tae Yong
 */
@Service
public class VehicleService {
    
    @Autowired
    private VehicleRepository vehicleRepository;
    
    public Iterable<Vehicle> getAll(){
        return vehicleRepository.findAll();
    }
    
    public Optional<Vehicle> getById(Integer id){
        return vehicleRepository.findById(id);
    }
    
    public void deleteById(int id){
        vehicleRepository.deleteById(id);
    }
    
    public Vehicle save(Vehicle employee){
        return vehicleRepository.save(employee);
    }
    
}
