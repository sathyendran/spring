package org.sathya.api;

import org.sathya.user.api.UserService;
import org.sathya.user.messaging.UserRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController("/user")
public class UserController {

    @Autowired
    private UserService userService;

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);


    @PostMapping
    public UserRequest create(@RequestBody UserRequest userRequest) {
        logger.info("Creating the new user : {}", userRequest);
        return userService.create(userRequest);
    }

    @PutMapping
    public UserRequest update(@RequestBody UserRequest userRequest) {
        logger.info("Updating the new user : {}", userRequest);
        return userService.update(userRequest);
    }


}
