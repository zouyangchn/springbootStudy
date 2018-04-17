package com.montnets.springboot.bean;

import java.util.Date;

import lombok.Data;

@Data
public class User {

	private String username;
	
	private Integer age;
	
	private Date createTime;
	
}
