package com.yangdage.controller;

import com.yangdage.model.TUser;
import com.yangdage.model.TUserExample;
import com.yangdage.service.TUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    TUserService userService;


    @RequestMapping("/getUser")
    @ResponseBody
    public List<TUser> getUser() {
        return userService.selectByExample(new TUserExample());
    }
}
