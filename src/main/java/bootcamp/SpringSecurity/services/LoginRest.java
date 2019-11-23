/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bootcamp.SpringSecurity.services;

import bootcamp.SpringSecurity.entities.LoginData;
import bootcamp.SpringSecurity.entities.api.EmployeeLogin;
import javafx.scene.media.Media;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author Lee Tae Yong
 */
@Service
public class LoginRest {

    @Value("${data.api.url}")
    private String uri;

    @Value("${data.api.key}")
    private String key;

    private static final RestTemplate restTemplate = new RestTemplate();

    private HttpHeaders getHeaders() {
        return new HttpHeaders() {
            {
                String authHeader = "Bootcamp " + key;
                set("Authorization", authHeader);
                setContentType(MediaType.APPLICATION_JSON);
            }
        };
    }

    public EmployeeLogin login(LoginData loginData) {
        HttpEntity<LoginData> request = new HttpEntity<LoginData>(loginData, getHeaders());
        System.out.println(request.getBody().getEmail() + " - " + request.getBody().getPassword());

        ResponseEntity<EmployeeLogin> responseEntitiy = restTemplate.exchange(
                uri + "/login",
                HttpMethod.POST,
                request,
                new ParameterizedTypeReference<EmployeeLogin>() {
        }
        );
        EmployeeLogin result = responseEntitiy.getBody();
        return result;
    }
}
