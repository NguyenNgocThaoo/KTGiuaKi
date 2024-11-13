package  vn.iostar.service.impl;

import java.util.List;

import  vn.iostar.dao.IUserDao_22133051;
import  vn.iostar.dao.impl.UserDao_22133051;
import  vn.iostar.entity.User_22133051;
import  vn.iostar.service.IUserService_22133051;

public class UserServiceImpl_22133051 implements IUserService_22133051{
	IUserDao_22133051 userDao = new UserDao_22133051();

	@Override
	public List<User_22133051> getAllUsers(int page, int pagesize) {
		return userDao.getAllUsers(page, pagesize);
	}

	@Override
	public void addUser(User_22133051 user) {
		userDao.addUser(user);
	}

	@Override
	public void updateUser(User_22133051 user) {
		userDao.updateUser(user);

	}

	@Override
	public void deleteUser(Long userId) throws Exception {
		try {
			userDao.deleteUser(userId);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("Error while deleting video");
		}
	}

	@Override
	public User_22133051 getUserById(Long userId) {
		return userDao.getUserById(userId);
	}

	@Override
	public User_22133051 findUserByEmail(String email) {
		return userDao.findUserByEmail(email);
	}

	@Override
	public User_22133051 login(String username, String password) {
		User_22133051 user = this.findUserByUsername(username);
		if (user != null && password.equals(user.getPassword()) && user.getActive()) {
			return user;
		}
		return null;
	}

	@Override
	public Long count() {
		return userDao.count();
	}

	@Override
	public List<User_22133051> searchUsers(String searchValue, int start, int length) {
		return userDao.searchUser(searchValue, start, length);
	}

	@Override
	public Long countUsers(String searchValue) {
		return userDao.countUsers(searchValue);
	}

	@Override
	public User_22133051 findUserByUsername(String username) {
		return userDao.findUserByUsername(username);
	}

}
