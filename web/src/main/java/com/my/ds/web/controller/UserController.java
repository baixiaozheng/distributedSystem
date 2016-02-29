package com.my.ds.web.controller;

import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.my.ds.model.User;
import com.my.ds.rpc.domain.UserDomain;

@Controller
@RequestMapping("/")
public class UserController {
    @Resource(name="userDomain")
	private UserDomain userDomain;
    
    @ResponseBody
    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public User add(){
        User user = new User();
        user.setEmail("email");
        user.setEnable(true);
        user.setGithub("github");
        user.setLastestLoginIp("");
        user.setLastestLoginTime(null);
        user.setMobile("18888888888");
        user.setNickname("nickname");
        user.setPassword("aaaaaa");
        user.setQq("qq");
        user.setRealName("realName");
        user.setRegTime(new Date());
        user.setWebsite("webSite");
        user = userDomain.add(user);
        return user;
    }
}
 