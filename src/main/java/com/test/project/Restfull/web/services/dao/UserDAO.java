package com.test.project.Restfull.web.services.dao;

import com.test.project.Restfull.web.services.models.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Component
public class UserDAO {
    static List<User> users = new ArrayList<>();
    static int userId;
    static{
        users.add(new User(++userId,"Dino",new Date()));
        users.add(new User(++userId,"Riju",new Date()));
        users.add(new User(++userId,"Anoy",new Date()));
        users.add(new User(++userId,"Ayu",new Date()));
    }
    public List<User> findAll(){
        return users;
    }

    public Optional<User> findbyId(int id){
        return users.stream().filter(user->user.getId()==id).findFirst();
    }

    public User save(User user){
        User newUser = new User(++userId,user.getName(),user.getDob());
        users.add(newUser);
        return newUser;
    }
}
