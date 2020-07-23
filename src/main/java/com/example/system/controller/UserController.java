package com.example.system.controller;

import com.example.system.entity.User;
import com.example.system.repository.UserReprository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private UserReprository userReprository;
    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String test() throws Exception {
        User user = userReprository.findById(new Integer(3)).get();

//        User user1 = userReprository.getUserD(new Integer(3));
//        User user2 = userReprository.getBydd(new Integer(4));
//
//        List<User> user3 = userReprository.findAllByNameLike("test%");
        if (user==null){
            user = new User();
            throw new Exception("1");
        }
        return user.toString();
    }
}
