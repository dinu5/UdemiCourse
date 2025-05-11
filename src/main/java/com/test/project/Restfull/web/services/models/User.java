package com.test.project.Restfull.web.services.models;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;


@Getter
@Setter
@AllArgsConstructor
public class User {
    private int id;
    @Size(min=2,message = "Name should be minimum 2 characters")
    private String name;
    @Past(message = "DOB should be past date")
    private Date dob;
}
