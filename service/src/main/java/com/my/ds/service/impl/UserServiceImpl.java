package com.my.ds.service.impl; 

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.my.ds.dao.UserDao;
import com.my.ds.model.User;
import com.my.ds.service.UserServices;
import com.my.ds.util.ValidateUtil;

@Service(value = "userService")
public class UserServiceImpl implements UserServices{

	@Resource(name="userDao")
	private UserDao userDao;
	
	@Override
	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public List<User> getAll() {
		return userDao.getAll();
	}

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = java.lang.RuntimeException.class)
    public User add(User user) {
        return userDao.add(user);
    }
	
    @Override
	@Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
	public User getUserByEmail(String email) {
		if (ValidateUtil.isEmpty(email))
			return null;
		return userDao.getUserByEmail(email);
	}

	@Override
	@Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
	public User getUserByMobile(String mobile) {
		if (ValidateUtil.isEmpty(mobile)) {
			return null;
		}
		return userDao.getUserByMobile(mobile);
	}
	
	@Override
	@Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
	public User getById(int id){
		return userDao.getById(id);
	}
	
	@Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = java.lang.RuntimeException.class)
    public User update(User user) {
        return userDao.update(user);
    }

	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = java.lang.RuntimeException.class)
	public void updateUserIpAndLastestLoginTime(User user, String ip) {
		userDao.update(user);
	}

}
 