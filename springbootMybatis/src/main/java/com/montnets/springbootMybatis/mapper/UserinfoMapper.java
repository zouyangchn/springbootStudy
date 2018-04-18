package com.montnets.springbootMybatis.mapper;

import com.montnets.springbootMybatis.entity.Userinfo;
import java.util.List;

public interface UserinfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Userinfo record);

    Userinfo selectByPrimaryKey(Integer id);

    List<Userinfo> selectAll();

    int updateByPrimaryKey(Userinfo record);
}