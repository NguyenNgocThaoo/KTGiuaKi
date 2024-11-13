package  vn.iostar.dao.impl;

import java.util.List;


import jakarta.persistence.Query;
import  vn.iostar.configs.JPAConfig;
import  vn.iostar.dao.IUserDao_22133051;
import  vn.iostar.entity.User_22133051;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;


public class UserDao_22133051 implements IUserDao_22133051{
	@Override
	public List<User_22133051> getAllUsers(int page, int pagesize) {
		EntityManager enma = JPAConfig.getEntityManager();
		TypedQuery<User_22133051> query = enma.createNamedQuery("User.findAll", User_22133051.class);
		query.setFirstResult(page * pagesize);
		query.setMaxResults(pagesize);
		return query.getResultList();
	}

	@Override
	public void addUser(User_22133051 user) {
		EntityManager enma = JPAConfig.getEntityManager();
		EntityTransaction trans = enma.getTransaction();
		try {

			trans.begin();
			enma.persist(user);
			trans.commit();

		} catch (Exception e) {

			e.printStackTrace();

			trans.rollback();

			throw e;

		} finally {

			enma.close();

		}

	}

	@Override
	public void updateUser(User_22133051 user) {
		EntityManager enma = JPAConfig.getEntityManager();
		EntityTransaction trans = enma.getTransaction();
		try {

			trans.begin();
			enma.merge(user);
			trans.commit();

		} catch (Exception e) {

			e.printStackTrace();

			trans.rollback();

			throw e;

		} finally {

			enma.close();

		}
	}

	@Override
	public void deleteUser(Long userId) throws Exception {
		EntityManager enma = JPAConfig.getEntityManager();
		EntityTransaction trans = enma.getTransaction();
		try {

			trans.begin();
			User_22133051 user = enma.find(User_22133051.class, userId);
			if (user != null) {
				enma.remove(user);
			} else {
				throw new Exception("Khong tim thay");
			}
			trans.commit();

		} catch (Exception e) {

			e.printStackTrace();

			trans.rollback();

			throw e;

		} finally {

			enma.close();

		}
	}

	@Override
	public User_22133051 getUserById(Long userId) {
		EntityManager enma = JPAConfig.getEntityManager();
		User_22133051 user = enma.find(User_22133051.class, userId);
		return user;
	}

	@Override
	public User_22133051 findUserByEmail(String email) {
		EntityManager entityManager = JPAConfig.getEntityManager();
		String queryStr = "SELECT u FROM User u WHERE u.email = :email";
		TypedQuery<User_22133051> query = entityManager.createQuery(queryStr, User_22133051.class);
		query.setParameter("email", email);

		try {
			return query.getSingleResult(); // Trả về đối tượng User nếu tìm thấy
		} catch (Exception e) {
			return null; // Nếu không tìm thấy người dùng, trả về null
		}
	}

	@Override
	public Long count() {
		EntityManager entityManager = JPAConfig.getEntityManager();
		String queryStr = "SELECT COUNT(u) FROM User u";
		try {
			Query query = entityManager.createQuery("SELECT COUNT(u) FROM User u");
			return (Long) query.getSingleResult();
		} finally {
			entityManager.close();
		}
	}

	@Override
	public List<User_22133051> searchUser(String searchValue, int start, int length) {
		EntityManager enma = JPAConfig.getEntityManager();
		// Tạo truy vấn với điều kiện tìm kiếm nếu có
		String jpql = "SELECT u FROM User u";
		if (searchValue != null && !searchValue.isEmpty()) {
			jpql += " WHERE u.fullname LIKE :searchValue OR u.email LIKE :searchValue";
		}

		// Tạo truy vấn JPA
		TypedQuery<User_22133051> query = enma.createQuery(jpql, User_22133051.class);
		if (searchValue != null && !searchValue.isEmpty()) {
			query.setParameter("searchValue", "%" + searchValue + "%");
		}

		// Thiết lập phân trang cho truy vấn
		query.setFirstResult(start);
		query.setMaxResults(length);

		// Thực thi truy vấn và trả về danh sách kết quả
		return query.getResultList();
	}

	@Override
	public Long countUsers(String searchValue) {
		EntityManager enma = JPAConfig.getEntityManager();
		// Tạo truy vấn đếm số lượng bản ghi với điều kiện tìm kiếm
		String jpql = "SELECT COUNT(u) FROM User_22133051 u";
		if (searchValue != null && !searchValue.isEmpty()) {
			jpql += " WHERE u.fullname LIKE :searchValue OR u.email LIKE :searchValue";
		}

		TypedQuery<Long> query = enma.createQuery(jpql, Long.class);
		if (searchValue != null && !searchValue.isEmpty()) {
			query.setParameter("searchValue", "%" + searchValue + "%");
		}

		// Trả về kết quả đếm
		return query.getSingleResult();
	}

	@Override
	public User_22133051 findUserByUsername(String username) {
		EntityManager entityManager = JPAConfig.getEntityManager();
		String queryStr = "SELECT u FROM User_22133051 u WHERE u.username = :username";
		TypedQuery<User_22133051> query = entityManager.createQuery(queryStr, User_22133051.class);
		query.setParameter("username", username);

		try {
			return query.getSingleResult(); // Trả về đối tượng User nếu tìm thấy
		} catch (Exception e) {
			return null; // Nếu không tìm thấy người dùng, trả về null
		}
	}
}
