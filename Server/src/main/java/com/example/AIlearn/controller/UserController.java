package com.example.AIlearn.controller;

import com.example.AIlearn.model.User;
import com.example.AIlearn.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class UserController
{
  @Autowired
  private final UserService userService;

  public UserController(UserService userService)
  {
    this.userService = userService;
  }


  @PostMapping("/login")
  public Map<String, Object> login(@RequestBody User loginUser) {
    return userService.loginUser(loginUser.getEmail(), loginUser.getPassword());
  }
}
