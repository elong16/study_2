package com.example._work2.controller;


import com.example._work2.bean.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;


@Slf4j
@RestController
public class UserController {




    //POST接口
    @RequestMapping(value = "/user",method = RequestMethod.POST)
    public String saveUser(@RequestParam(value = "uname") String uname,
                           @RequestParam(value = "password") String password,
                           HttpServletRequest request){
        User user = new User(uname,password);
        if (user.selectById()!=null){
           return "用户已经存在";
        }else {
            user.insert();
            log.info(request.getRemoteHost()+"添加用户"+uname);
        }
        return "添加用户"+user.getUerName()+"成功";
    }

    //GET接口
    @RequestMapping(value = "/user",method = RequestMethod.GET)
    public String getUser(@RequestParam(value = "uname") String uname,
                          @RequestParam(value = "password") String password,
                          HttpServletRequest request){
        User user = new User(uname,password);
        if (user.selectById()!=null){
            log.info(request.getRemoteHost()+"获取了"+uname+"信息");
            return user.toString();

        }else {
            return "未查找到该用户";
        }
    }

    //DELETE接口
    @RequestMapping(value = "/user",method = RequestMethod.DELETE)
    public String delUser(@RequestParam(value = "uname") String uname,
                          @RequestParam(value = "password") String password,
                          HttpServletRequest request){
        User user = new User(uname,password);
        if (user.selectById()!=null){
            if(user.getPassWord().equals(password)) {
                user.deleteById();
                log.info(request.getRemoteHost()+"将用户"+uname+"删除");
                return "已删用户" + user.getUerName();
            }else{
                return "密码错误，无法删除";
            }
        }else {
            return "该用户不存在";
        }
    }

    //PUT接口
    @RequestMapping(value = "/user",method = RequestMethod.PUT)
    public String updateUser(@RequestParam(value = "uname") String uname,
                             @RequestParam(value = "password") String password,
                             HttpServletRequest request){
        User user = new User(uname, password);
        User user1 = user.selectById();
        if (user1 !=null){
           user.updateById();
           log.info(request.getRemoteHost()+"将"+uname+"的密码修改");
            return "修改前密码为"+user1.getPassWord()+"\n"+"修改后密码为"+user.getPassWord();
        }else {
            return"该用户不存在";
        }
    }

}
