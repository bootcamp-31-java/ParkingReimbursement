/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bootcamp.SpringSecurity.repositories;

import bootcamp.SpringSecurity.entities.Vehicle;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Lee Tae Yong
 */
public interface VehicleRepository extends CrudRepository<Vehicle, Integer> {
    
}
