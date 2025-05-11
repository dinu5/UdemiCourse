package com.test.project.Restfull.web.services.controllers;

import com.test.project.Restfull.web.services.models.Name;
import com.test.project.Restfull.web.services.models.Person;
import com.test.project.Restfull.web.services.models.PersonV2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersioningTestController {

    @GetMapping("/v1/getPerson")
    public Person getFirstVersionOfPerson(){
        return new Person("Dino Chakraborty");
    }
    @GetMapping("/v2/getPerson")
    public PersonV2 getSecondVersionOfPerson(){
        return new PersonV2(new Name("Dino","Chakraborty"));
    }
}
