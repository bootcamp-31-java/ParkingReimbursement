/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bootcamp.SpringSecurity.services;

import bootcamp.SpringSecurity.entities.Employee;
import bootcamp.SpringSecurity.repositories.EmployeeRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Lee Tae Yong
 */
@Service
public class EmployeeService {
    
    @Autowired
    private EmployeeRepository employeeRepository;
    
    public Iterable<Employee> getAll(){
        return employeeRepository.findAll();
    }
    
    public Optional<Employee> getById(String id){
        return employeeRepository.findById(id);
    }
    
    public void delete(Employee employee){
        employeeRepository.delete(employee);
    }
    
    public Employee save(Employee employee){
        return employeeRepository.save(employee);
    }
    
}
