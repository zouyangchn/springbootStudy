package com.montnets.springbootMybatis;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;  
import org.springframework.boot.CommandLineRunner;  
import org.springframework.boot.SpringApplication;  
import org.springframework.boot.autoconfigure.SpringBootApplication;  
  
@SpringBootApplication  
public class Application implements CommandLineRunner{  
	
	private static final Logger LOG = LoggerFactory.getLogger(Application.class);  
  
    @Autowired  
    DataSource dataSource;  
    public static void main(String[] args) {  
        SpringApplication.run(Application.class, args);  
    }  
      
    /** 
     * 查看用了什么数据库连接池 
     */  
    public void run(String... args) throws Exception {  
    	LOG.info("数据库连接池："+dataSource);  
        System.out.println("DATASOURCE = " + dataSource);  
    }  
} 