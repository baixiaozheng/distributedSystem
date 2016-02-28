package com.my.ds.dao; 

import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.my.ds.model.User;


@Repository(value="userDao")
public class UserDao  extends BaseDao{

	@Override
	protected Class<?> entityClass() {
		return User.class;
	}

	public List<User> getAll(){
		return super.list();
	}
	
	public User add(User user) {
        return super.add(user);
    }
	
	public User update(User user){
	    return super.update(user);
	}
	
	public User getById(int id) {
		return super.get(id);
	}
	
	/**
	 * @Description: 根据Email获取用户
	 * @param email
	 * @return User
	 * @throws
	 */
	public User getUserByEmail(String email) {
		Session session = getSessionFactory().getCurrentSession();
		String hql = "from User where email = :email";
		Object object = session.createQuery(hql)
				.setParameter("email", email).uniqueResult();
		return object == null ? null : (User) object;
	}

	/**
	 * @Description: 根据手机号获取用户
	 * @param mobile
	 * @return User
	 * @throws
	 */
	public User getUserByMobile(String mobile) {
		Session session = getSessionFactory().getCurrentSession();
		String hql = "from User where mobile = :mobile";
		Object object = session.createQuery(hql)
				.setParameter("mobile", mobile).uniqueResult();
		return object == null ? null : (User) object;
	}
}
 