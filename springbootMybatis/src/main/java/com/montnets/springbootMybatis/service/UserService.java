package com.montnets.springbootMybatis.service;

import java.util.List;

import com.montnets.springbootMybatis.entity.User;  
  
  
public interface UserService {  
    public List<User> getUserInfo();  
      
    public void insert(User user);  
}  

