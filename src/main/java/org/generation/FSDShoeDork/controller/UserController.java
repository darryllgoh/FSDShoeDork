package org.generation.FSDShoeDork.controller;

//import com.azure.storage.blob.BlobClient;
//import com.azure.storage.blob.BlobContainerClient;
//import com.azure.storage.blob.BlobServiceClient;
//import com.azure.storage.blob.BlobServiceClientBuilder;

import org.generation.FSDShoeDork.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.generation.FSDShoeDork.repository.entity.User;
import org.generation.FSDShoeDork.controller.dto.UserDTO;

import java.io.IOException;

//request mapping is to provide a url route for frontend to cal the API endpoints
@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    //dependency injection of itemService object so controller can call many methods in the ItemServiceMySQL class
    public UserController( @Autowired UserService userService )
    {
        this.userService = userService;
    }

    //API endpoint - to be able to return all products to frontend. frontend will issue a GET http request
    //not in a valid domain, local host is not a valid domain.
    //You can add a @CrossOrigin annotation in order to enable CORS on it (by default @CrossOrigin allows all origins and the HTTP methods specified in the @RequestMapping annotation
    //https://spring.io/blog/2015/06/08/cors-support-in-spring-framework browser will prohibit any fetch calls unless
    // you have @CrossOrigin enabled.

    @CrossOrigin
    @GetMapping( "/all" )
    public Iterable<User> getUser()
    {

        //return in controller represents a response to the client
        return this.userService.all();
    }

    //view record by ID
    //the id value will be sent from the front-end through the API URL parameter
    @CrossOrigin
    @GetMapping( "/{id}" )
    public User findUserById( @PathVariable Integer id )
    {
        return userService.findById( id );
    }

    //delete record
    @CrossOrigin
    @DeleteMapping( "/{id}" )
    public void delete( @PathVariable Integer id )
    {
        userService.delete( id );
    }

    //set up post mapping and request

    @CrossOrigin
    @PostMapping("/add")
    public void save(  @RequestParam(name="username", required = true) String username,
                       @RequestParam(name="password", required = true) String password)
    {
        UserDTO userDTO = new UserDTO(username, new BCryptPasswordEncoder().encode(password));
        userService.save(new User(userDTO));
    }
}