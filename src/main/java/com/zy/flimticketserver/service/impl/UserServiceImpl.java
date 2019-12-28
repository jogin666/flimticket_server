package com.zy.flimticketserver.service.impl;

import com.zy.flimticketserver.entity.UserEntity;
import com.zy.flimticketserver.mapper.UserMapper;
import com.zy.flimticketserver.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public boolean updateUserInfo(UserEntity user) {
        int row = userMapper.update(user);
        return isSuccess(row);
    }

    @Override
    public boolean add(String account) {
        int row = userMapper.add(account);
        return isSuccess(row);
    }

    @Override
    public UserEntity findUserByAccount(String account) {
        return userMapper.findUserByAccount(account);
    }


    @Override
    public boolean updatePassword(String account, String newPassword) {
        int row = userMapper.updatePassword(account, newPassword);
        return isSuccess(row);
    }

    @Override
    public boolean finUserByAccountAndPass(String account,String password) {
        UserEntity user = userMapper.findUserByAccountAndPass(account, password);
        if (user!=null){
            return true;
        }
        return false;
    }

    private boolean isSuccess(int row){
        if (row==1){
            return true;
        }
        return false;
    }
}
