package com.restapi.airlines.service.implement;

import com.restapi.airlines.model.Request.UserDetailsRequestModel;
import com.restapi.airlines.model.Response.UserRest;
import com.restapi.airlines.service.UserService;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;

@Service
public class UserServiceImplement implements UserService {
    UserRest returnValue;

    HashMap<String, UserRest> users;

    @Override
    public UserRest createUser(UserDetailsRequestModel userDetails) {
        returnValue = new UserRest();

        returnValue.setUserId(userDetails.getUserId());
        String userId = returnValue.getUserId();

        returnValue.setUserId(userDetails.getUserId());
        returnValue.setFirstName(userDetails.getFirstName());
        returnValue.setLastName(userDetails.getLastName());
        returnValue.setPhoneNum(userDetails.getPhoneNum());
        returnValue.setUserName(userDetails.getUserName());
        returnValue.setEmail(userDetails.getEmail());
        returnValue.setPassword(userDetails.getPassword());

        if (users == null) {
            users = new HashMap<>();
        }

        users.put(userId, returnValue);
        return returnValue;
    }

    public UserRest getUser (String userId) {
        return users.get(userId);
    }

    public Collection <UserRest> getAllUser(){
        return users.values();
    }

    public UserRest deleteUser(String userId){
        return users.remove(userId);
    }

    public UserRest updateUser (String userId, UserDetailsRequestModel userDetails) {
        if(users.containsKey(userId)){
            UserRest storedUser = users.get(userId);
            storedUser.setPhoneNum(userDetails.getPhoneNum());

            users.put(userId, storedUser);
        }
        return users.get(userId);
    }
}
