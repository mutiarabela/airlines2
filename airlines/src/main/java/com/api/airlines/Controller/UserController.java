package com.api.airlines.Controller;

import com.api.airlines.Model.Request.UserDetail;
import com.api.airlines.Model.Request.UpdateUserDetail;
import com.api.airlines.Model.Response.UserRest;
import com.api.airlines.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Map;

@RestController
@RequestMapping("/users")
public class UserController {

//    Map<String, UserRest> users;

    @Autowired
    UserService userService;


    @GetMapping(value = "/{userId}"
            , produces = {
            MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_XML_VALUE }
    )
    public ResponseEntity getUser(@PathVariable String userId) {
        UserRest returnValue = userService.getUser(userId);
        if (returnValue != null) {
            return new ResponseEntity<>(returnValue, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @PostMapping(value = "/add" , produces = {
            MediaType.APPLICATION_XML_VALUE,
            MediaType.APPLICATION_JSON_VALUE},
            consumes = {
                    MediaType.APPLICATION_XML_VALUE,
                    MediaType.APPLICATION_JSON_VALUE }
    )
    public ResponseEntity createUser(@Valid @RequestBody UserDetail userDetail)
    {
        UserRest returnValue = userService.createUser(userDetail);
        return new ResponseEntity<>(returnValue, HttpStatus.CREATED);
    }

//    @PutMapping(path = "/{userId}",
//            consumes = { MediaType.APPLICATION_XML_VALUE,
//                    MediaType.APPLICATION_JSON_VALUE },
//            produces = { MediaType.APPLICATION_XML_VALUE,
//                    MediaType.APPLICATION_JSON_VALUE })
//    public UserRest updateUser(@PathVariable String userId, @Valid @RequestBody UpdateUserDetail userDetail){
//        UserRest storedUserDetail = users.get(userId);
//        storedUserDetail.setFirstName(userDetail.getFirstName());
//        storedUserDetail.setLastName(userDetail.getLastName());
//        storedUserDetail.setPhoneNum(userDetail.getPhoneNum());
//        storedUserDetail.setEmail(userDetail.getEmail());
//        storedUserDetail.setPassword(userDetail.getPassword());
//
//        users.put(userId, storedUserDetail);
//
//        return storedUserDetail;
//    }

//    //Delete
//    @DeleteMapping(path = "/{id}")
//    public ResponseEntity deleteUser(@PathVariable String id){
//        users.remove(id);
//        return ResponseEntity.noContent().build();
//    }
}