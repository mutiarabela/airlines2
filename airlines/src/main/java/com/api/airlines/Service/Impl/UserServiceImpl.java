package com.api.airlines.Service.Impl;

import com.api.airlines.Model.Request.UserDetail;
import com.api.airlines.Model.Response.UserRest;
import com.api.airlines.Service.UserService;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class UserServiceImpl implements UserService {

    UserRest returnValue;

    HashMap<String, UserRest> users;

    @Override
    public UserRest createUser(UserDetail userDetail) {
        UserRest returnValue = new UserRest();

        returnValue.setUserId(userDetail.getUserId());
        String userId = returnValue.getUserId();

        returnValue.setFirstName(userDetail.getFirstName());
        returnValue.setLastName(userDetail.getLastName());
        returnValue.setPhoneNum(userDetail.getPhoneNum());
        returnValue.setUserName(userDetail.getUserName());
        returnValue.setEmail(userDetail.getEmail());
        returnValue.setPassword(userDetail.getPassword());

        if (users == null) {
            users = new HashMap<>();
            users.put(userId, returnValue);
        }

        return returnValue;
    }

    public UserRest getUser (String userId) {
        return users.get(userId);
    }
}
