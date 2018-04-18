package com.montnets.springbootMybatis.mapper;

import java.util.List;  

import org.apache.ibatis.annotations.Mapper;

import com.montnets.springbootMybatis.entity.User;  
  
  
@Mapper  
public interface UserMapper {  
  
    public List<User> findUserInfo();  
    public int addUserInfo(User user);  
    public int delUserInfo(int id);  
}  
