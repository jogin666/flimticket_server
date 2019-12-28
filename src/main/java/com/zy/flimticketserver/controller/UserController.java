package com.zy.flimticketserver.controller;

import com.zy.flimticketserver.entity.UserEntity;
import com.zy.flimticketserver.service.UserService;
import com.zy.flimticketserver.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/userLogin")
    public String login(String useraccount,String password){
        boolean exit = userService.finUserByAccountAndPass(useraccount, password);
        if (exit){
            return "{result:true}";
        }
        return "{result:false}";
    }

    @RequestMapping("/findUserInfo")
    public String findUserInfoByAccount(HttpServletRequest request){
        String account=request.getParameter("useraccount");
        UserEntity entity=userService.findUserByAccount(account);
        return entity.toString();
    }

    @RequestMapping("/updateUserInfo")
    public String updateUserInfo(UserEntity userEntity){
        if (userEntity!=null && StringUtils.isEmpty(userEntity.getUseraccount())){
            boolean result=userService.updateUserInfo(userEntity);
            if (result){
                return "{result:true}";
            }
        }
        return "{result:false}";
    }

    @RequestMapping("/updateUserPassword")
    public String updateUserass(UserEntity userEntity){
        if (userEntity!=null && StringUtils.isEmpty(userEntity.getUseraccount())){
            String account=userEntity.getUseraccount();
            String password=userEntity.getPassword();
            boolean result=userService.updatePassword(account,password);
            if (result){
                return "{result:true}";
            }
        }
        return "{result:false}";
    }

    @RequestMapping("/addUser")
    public String addUser(UserEntity userEntity){
        if (userEntity!=null && StringUtils.isEmpty(userEntity.getUseraccount())){
            String account=userEntity.getUseraccount();
            boolean result=userService.add(account);
            if (result){
                return "{result:true}";
            }
        }
        return "{result:false}";
    }

    @RequestMapping("/isExitUser")
    public String isExit(String useraccount){
        if (StringUtils.isEmpty(useraccount)){
            if(userService.findUserByAccount(useraccount)!=null){
                return "{result:true}";
            }
        }
        return "{result:false}";
    }

}
