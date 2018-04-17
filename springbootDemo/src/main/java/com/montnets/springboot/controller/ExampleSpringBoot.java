package com.montnets.springboot.controller;

import java.util.Date;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.montnets.springboot.bean.User;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

@RestController  
public class ExampleSpringBoot {  
	@ApiOperation(value="��ȡ�Ñ���ϸ��Ϣ", notes="����URL�е�userId����ȡ�Ñ���ϸ��Ϣ")
    @ApiImplicitParam(name = "userId", value = "�Ñ�ID", required = true, dataType = "Long",paramType="path")
    @RequestMapping(value="/user/{userId}",method=RequestMethod.GET)  
   public User getUser(@PathVariable Long userId) {  
		System.out.println(userId);
    	User user = new User();
    	user.setCreateTime(new Date());
    	user.setAge(12);
    	user.setUsername("zy");
        return user;  
    }  
}  
