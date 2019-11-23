/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bootcamp.SpringSecurity.controllers;

import bootcamp.SpringSecurity.services.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 *
 * @author Lee Tae Yong
 */
@Controller
public class RequestController {
         @Autowired
    private RequestService requestService;
}
