package com.brume.mp5.portfolio.controller;

import com.brume.mp5.portfolio.entity.User;
import com.brume.mp5.portfolio.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(path = "user")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @ResponseStatus(value = HttpStatus.CREATED)
    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    public void creer(@RequestBody User user) {
    this.userService.creer(user);
    }

    @GetMapping(produces = APPLICATION_JSON_VALUE)
    public List<User> rechercher(){
        return this.userService.rechercher();
    }

    @GetMapping(path = "{id}" ,produces = APPLICATION_JSON_VALUE)
    public User lire(@PathVariable int id) {
        return this.userService.lire(id);
    }

}
