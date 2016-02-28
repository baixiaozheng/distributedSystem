package com.my.ds.rpc.domain.impl; 

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.my.ds.model.User;
import com.my.ds.rpc.domain.UserDomain;
import com.my.ds.service.UserServices;
import com.my.ds.util.MD5Util;
import com.my.ds.util.ValidateUtil;

@Component("userDomain")
public class UserDomainImpl implements UserDomain{

	@Resource(name="userService")
	private UserServices userService;
	
	@Override
	public List<User> getAll() {
		return userService.getAll();
	}

    @Override
    public User add(User user) {
        Date now = new Date();
        user.setEnable(true);
        user.setRegTime(now);
        user.setPassword(MD5Util.digest(user.getPassword()));
        return userService.add(user);
    }
	
    @Override
	public User getUserByEmail(String email) {
		if (ValidateUtil.isEmpty(email))
			return null;
		return userService.getUserByEmail(email);
	}

	@Override
	public User getUserByMobile(String mobile) {
		if (ValidateUtil.isEmpty(mobile)) {
			return null;
		}
		return userService.getUserByMobile(mobile);
	}
	
	@Override
	public User getById(int id){
		return userService.getById(id);
	}
	
	@Override
    public User update(User user) {
        return userService.update(user);
    }

	@Override
	public void updateUserIpAndLastestLoginTime(User user, String ip) {
		user.setLastestLoginIp(ip);
		user.setLastestLoginTime(new Date());
		userService.update(user);
	}

}
 