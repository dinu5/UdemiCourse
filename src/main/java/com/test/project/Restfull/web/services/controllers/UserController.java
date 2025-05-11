package com.test.project.Restfull.web.services.controllers;

import com.test.project.Restfull.web.services.dao.UserDAO;
import com.test.project.Restfull.web.services.exceptions.UserNotFoundException;
import com.test.project.Restfull.web.services.models.User;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Locale;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private MessageSource messageSource;

    @Autowired
    private UserDAO userDAO;

    @GetMapping("/findAll")
    public List<User> findAllUser(){
        return userDAO.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> findById(@PathVariable int id){
        if(userDAO.findbyId(id).isEmpty()){
            throw new UserNotFoundException("User does not exist.");
        }
        User user = userDAO.findbyId(id).get();
        return new ResponseEntity<>(user, HttpStatus.ACCEPTED);
    }

    @PostMapping()
    public ResponseEntity<User> save(@Valid @RequestBody User user){
        User savedUser = userDAO.save(user);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path(("/{id}"))
                .buildAndExpand(savedUser.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @GetMapping("/getMessage")
    public String goodMoringInternationalization(){
        Locale locale = LocaleContextHolder.getLocale();
        return messageSource.getMessage("good.morning.message", null, "Default Message", locale);
    }
}
