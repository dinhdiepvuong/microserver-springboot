package com.diepvuong.user.controller;

import com.diepvuong.user.VO.ResponseTemplateVO;
import com.diepvuong.user.entity.User;
import com.diepvuong.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/api/v1/user")
    public ResponseEntity<User> saveUser(@RequestBody User user){
        return new ResponseEntity<>(userService.saveUser(user), HttpStatus.CREATED);
    }

    @GetMapping("/api/v1/user/{userId}")
    public ResponseEntity<ResponseTemplateVO> getUserWithDepartment(@PathVariable("userId") long userId){
        return new ResponseEntity<>(userService.getUserWithDepartment(userId), HttpStatus.OK);
    }
}
