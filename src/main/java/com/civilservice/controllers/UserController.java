package com.civilservice.controllers;

import com.civilservice.dto.User;
import com.civilservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController
{
    @Autowired
    private UserService userService;

    @GetMapping(value = "/users50MLondon" , produces = "application/json")
    public ResponseEntity getUsersWithin50MLondon()
    {
        List<User> users =  userService.getUsers();
        return ResponseEntity.ok(users);
    }
}
