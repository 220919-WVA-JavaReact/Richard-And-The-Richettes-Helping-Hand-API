package com.revature.helpinghandapi.controllers;

import com.revature.helpinghandapi.entities.Request;
import com.revature.helpinghandapi.services.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/requests")
public class RequestController {

    @Autowired
    private RequestService rs;
    private HttpServletRequest req;

    public RequestController(RequestService rs){
        System.out.println("RequestController Created!");
        this.rs = rs;

    }




}
