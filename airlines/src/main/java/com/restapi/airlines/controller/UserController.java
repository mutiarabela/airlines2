package com.restapi.airlines.controller;

import com.restapi.airlines.exception.UserNotFoundException;
import com.restapi.airlines.model.Request.UserDetailsRequestModel;
import com.restapi.airlines.model.Response.UserRest;
import com.restapi.airlines.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collection;

@RestController
@RequestMapping("/Users")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping(path = "/{userId}",
                produces = { MediaType.APPLICATION_JSON_VALUE,
                             MediaType.APPLICATION_XML_VALUE  })
    public ResponseEntity getUser(@PathVariable String userId){
        UserRest returnValue = userService.getUser(userId);
        if (returnValue != null) {
            return new ResponseEntity<>(returnValue, HttpStatus.OK);
        } else {
            throw new UserNotFoundException();
        }
    }

    @GetMapping()
    public ResponseEntity getAllUser(){
        Collection returnValue = userService.getAllUser();
        if (returnValue != null) {
            return new ResponseEntity<>(returnValue, HttpStatus.OK);
        } else {
            throw new UserNotFoundException("No User yet!");
        }
    }

    @PostMapping(consumes = { MediaType.APPLICATION_XML_VALUE,
                              MediaType.APPLICATION_JSON_VALUE },
                 produces = { MediaType.APPLICATION_XML_VALUE,
                              MediaType.APPLICATION_JSON_VALUE }
    )
    public ResponseEntity createUser(@Valid @RequestBody UserDetailsRequestModel userDetails){
        UserRest returnValue = userService.createUser(userDetails);
        return new ResponseEntity<>(returnValue, HttpStatus.CREATED);
    }

    @PutMapping(path = "/{userId}",
                consumes = { MediaType.APPLICATION_XML_VALUE,
                             MediaType.APPLICATION_JSON_VALUE },
                produces = { MediaType.APPLICATION_XML_VALUE,
                             MediaType.APPLICATION_JSON_VALUE }
    )
    public ResponseEntity<UserRest> updateUser(@PathVariable String userId, @RequestBody UserDetailsRequestModel userDetails){
        UserRest returnValue = userService.updateUser(userId, userDetails);
        if (returnValue != null) {
            return new ResponseEntity<>(returnValue, HttpStatus.OK);
        } else {
            throw new UserNotFoundException("Update Failed, User not Found");
        }
    }

    @DeleteMapping(path = "/{userId}")
    public ResponseEntity deleteUser(@PathVariable String userId){
        UserRest returnValue = userService.deleteUser(userId);
        if (returnValue != null) {
            return new ResponseEntity<>(returnValue, HttpStatus.OK);
        } else {
            throw new UserNotFoundException("Delete Failed, User not Found");
        }
    }
}
