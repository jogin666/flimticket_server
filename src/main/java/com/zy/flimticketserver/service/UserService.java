package com.zy.flimticketserver.service;

import com.zy.flimticketserver.entity.UserEntity;

public interface UserService {

    boolean updateUserInfo(UserEntity user);

    boolean add(String account);

    UserEntity findUserByAccount(String account);

    boolean finUserByAccountAndPass(String account,String password);

    boolean updatePassword(String account,String newPassword);
}
