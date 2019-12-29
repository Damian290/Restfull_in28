package com.example.rest.webServices.Restfull.User;

//import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;
import com.example.rest.webServices.Restfull.Exceptions.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.hateoas.EntityModel;
//import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

/**
 * Created by Acer on 2019-12-14.
 */
@RestController
public class UserResource {

    @Autowired
    private UserDAOService service;

    @GetMapping("/users")
    public List<User> retriveAllUsers(){

        return service.findAll();
    }

    @GetMapping("/users/{id}")
    public Resource<User> retriveUser(@PathVariable int id){
        User user = service.findOne(id);
        if (user == null){
            throw new UserNotFoundException("id-" + id);
        }
        //FOr SpringBoot >2.2.0
//        EntityModel<User> model = new EntityModel<>(user);
//        WebMvcLinkBuilder linkTo = linkTo(methodOn(this.getClass()).retriveAllUsers());
//        model.add(linkTo.withRel("all-users"));

        Resource<User> resource = new Resource<User>(user);
        ControllerLinkBuilder linkTo = linkTo(methodOn(this.getClass()).retriveAllUsers());
        resource.add(linkTo.withRel("all-users"));

        return resource;
    }

    @PostMapping("/users")
    public ResponseEntity<Object> CreateUser(@Valid @RequestBody User user){
        User savedUser = service.save(user);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("{id}").buildAndExpand(savedUser.getId()).toUri();

        return ResponseEntity.created(location).build();
    }


    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable int id){
        User user = service.deleteById(id);

        if (user == null){
            throw new UserNotFoundException("id-" + id);
        }

    }

}
