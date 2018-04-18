package com.montnets.springbootMybatis.service.impl;

import java.util.List;  

import org.springframework.beans.factory.annotation.Autowired;  
import org.springframework.stereotype.Service;  

import com.montnets.springbootMybatis.entity.User;
import com.montnets.springbootMybatis.mapper.UserMapper;
import com.montnets.springbootMybatis.service.UserService;  
  

  
@Service  
public class UserServiceImpl implements UserService{  
  
    @Autowired  
    private UserMapper userMapper;  
  
    public List<User> getUserInfo(){  
        return userMapper.findUserInfo();  
    }  
  
      
    public void insert(User user) {  
        userMapper.addUserInfo(user);  
          
    }  
}  
