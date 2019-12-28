package com.zy.flimticketserver.mapper;

import com.zy.flimticketserver.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.transaction.annotation.Transactional;

@Mapper
public interface UserMapper {

    //新增用户
    @Transactional
    int add(String account);

    //更新用户信息
    @Transactional
    int update(UserEntity user);

    //更改密码
    @Transactional
    int updatePassword(String account,String newPassword);

    //用户是否存在
    UserEntity findUserByAccountAndPass(String account,String password);

    //根据 account 查询用户信息
    UserEntity findUserByAccount(String account);
}
