package com.example.rest.webServices.Restfull.User;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by Acer on 2019-12-14.
 */
@Component
public class UserDAOService {
    private static List<User> users = new ArrayList<>();
    private static int usersCount = 3;
    static {
        users.add(new User(1,"Adam", new Date()));
        users.add(new User(2,"Eve", new Date()));
        users.add(new User(3,"Jack", new Date()));
    }

    public List<User> findAll(){
        return users;
    }

    public User findOne(int id){
        Iterator<User> it = users.iterator();
        while(it.hasNext()){
            User temp = it.next();
            if(temp.getId() == id ){
                return temp;
            }
        } return null;

    }

    public User save(User user){
        if(user.getId()== null){
            user.setId(++usersCount);
        }
        users.add(user);
        return user;
    }

    public User deleteById(int id){
        Iterator<User> it = users.iterator();
        while(it.hasNext()){
            User temp = it.next();
            if(temp.getId() == id){
                it.remove();
                return temp;
            }
        }
        return null;

    }
}
