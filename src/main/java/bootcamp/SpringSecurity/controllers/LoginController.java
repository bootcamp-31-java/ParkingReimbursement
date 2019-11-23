/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bootcamp.SpringSecurity.controllers;

import bootcamp.SpringSecurity.entities.Employee;
import bootcamp.SpringSecurity.entities.LoginData;
import bootcamp.SpringSecurity.entities.api.EmployeeLogin;
import bootcamp.SpringSecurity.services.EmployeeService;
import bootcamp.SpringSecurity.services.LoginRest;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author Lee Tae Yong
 */
@Controller
public class LoginController {

    @Autowired
    private LoginRest rest;

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/login")
    public String login() {

        return "login";
    }

    @PostMapping("/verifikasi")
    public String verification(LoginData loginData) {
        String result = "";
        EmployeeLogin employeeLogin = rest.login(loginData);
        System.out.println(employeeLogin.getStatus());
        if (employeeLogin.getStatus().equalsIgnoreCase("Login Success")) {
            User user = new User(employeeLogin.getEmployee().getId(), "", getAuthorities(employeeLogin));
            Employee employee = new Employee(employeeLogin.getEmployee().getId(),
                    employeeLogin.getEmployee().getFirstName() + " " + employeeLogin.getEmployee().getLastName(),
                    employeeLogin.getEmployee().getEmail());
            PreAuthenticatedAuthenticationToken authentication = new PreAuthenticatedAuthenticationToken(user, "", user.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(authentication);
            employeeService.save(employee);
            
                result = "redirect:/";
          

        } else {
            result = "redirect:/login";
        }
        return result;
    }

    private static Collection<? extends GrantedAuthority> getAuthorities(EmployeeLogin employeeLogin) {
        final List<SimpleGrantedAuthority> authorities = new LinkedList<>();
        for (String role : employeeLogin.getEmployee().getRoles()) {
            authorities.add(new SimpleGrantedAuthority(role));
        }
        return authorities;
    }
}
