package com.example.dtodemo.controller;

import com.example.dtodemo.dto.UserLocationDTO;
import com.example.dtodemo.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    Logger logger = LoggerFactory.getLogger("HomeController.class");
    @Autowired
    private UserService userService;
    @GetMapping("/users-location")
    public List<UserLocationDTO> getAllUsersLocation(){
        return userService.getAllUsersLocations();
    }
}
