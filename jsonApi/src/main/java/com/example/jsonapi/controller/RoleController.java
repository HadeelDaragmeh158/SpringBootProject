package com.example.jsonapi.controller;

import com.example.jsonapi.Service.RoleService;
import com.example.jsonapi.model.Role;
import com.example.jsonapi.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Service
public class RoleController {

    @Autowired
    RoleRepository roleRepository;
    @Autowired
    RoleService roleService;

    @GetMapping ("/")
    public String getIndex(){
        return "index.html";
    }

    @GetMapping("/role")
    public List<Role>getAllRole(){
       return roleService.getall();
    }


}
