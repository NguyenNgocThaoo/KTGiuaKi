package vn.iostar.dao.impl;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import vn.iostar.configs.JPAConfig;
import vn.iostar.dao.ICategoryDao_22133051;
import vn.iostar.entity.Category_22133051;

public class CategoryDao_22133051 implements ICategoryDao_22133051{
	@Override
	public List<Category_22133051> getAllCates(int page, int pagesize) {
		EntityManager enma = JPAConfig.getEntityManager();
		TypedQuery<Category_22133051> query = enma.createNamedQuery("Category_22133051.findAll", Category_22133051.class);
		query.setFirstResult(page * pagesize);
		query.setMaxResults(pagesize);
		return query.getResultList();
	}
	@Override
	public List<Category_22133051> getAllCategory() {
		EntityManager enma = JPAConfig.getEntityManager();
		TypedQuery<Category_22133051> query = enma.createNamedQuery("Category_22133051.findAll", Category_22133051.class);
		return query.getResultList();
	}

	@Override
	public void addCategory(Category_22133051 cate) {
		EntityManager enma = JPAConfig.getEntityManager();
		EntityTransaction trans = enma.getTransaction();
		try {

			trans.begin();
			enma.persist(cate);
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
	public void updateCategory(Category_22133051 cate) {
		EntityManager enma = JPAConfig.getEntityManager();
		EntityTransaction trans = enma.getTransaction();
		try {

			trans.begin();
			enma.merge(cate);
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
	public void deleteCategory(Long cateId) throws Exception {
		EntityManager enma = JPAConfig.getEntityManager();
		EntityTransaction trans = enma.getTransaction();
		try {

			trans.begin();
			Category_22133051 cate = enma.find(Category_22133051.class, cateId);
			if (cate != null) {
				enma.remove(cate);
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
	public Category_22133051 getCategoryById(Long cateId) {
		EntityManager enma = JPAConfig.getEntityManager();
		Category_22133051 cate = enma.find(Category_22133051.class, cateId);
		return cate;
	}


	@Override
	public Long count() {
		EntityManager entityManager = JPAConfig.getEntityManager();
		String queryStr = "SELECT COUNT(u) FROM Category_22133051 u";
		try {
			Query query = entityManager.createQuery("SELECT COUNT(u) FROM Category_22133051 u");
			return (Long) query.getSingleResult();
		} finally {
			entityManager.close();
		}
	}

	@Override
	public List<Category_22133051> searchCate(String searchValue, int start, int length) {
		EntityManager enma = JPAConfig.getEntityManager();
		// Tạo truy vấn với điều kiện tìm kiếm nếu có
		String jpql = "SELECT u FROM Category_22133051 u";
		if (searchValue != null && !searchValue.isEmpty()) {
			jpql += " WHERE u.categoryName LIKE :searchValue";
		}

		// Tạo truy vấn JPA
		TypedQuery<Category_22133051> query = enma.createQuery(jpql, Category_22133051.class);
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
	public Long countCategory(String searchValue) {
		EntityManager enma = JPAConfig.getEntityManager();
		// Tạo truy vấn đếm số lượng bản ghi với điều kiện tìm kiếm
		String jpql = "SELECT COUNT(u) FROM Category_22133051 u";
		if (searchValue != null && !searchValue.isEmpty()) {
			jpql += " WHERE u.categoryName LIKE :searchValue ";
		}

		TypedQuery<Long> query = enma.createQuery(jpql, Long.class);
		if (searchValue != null && !searchValue.isEmpty()) {
			query.setParameter("searchValue", "%" + searchValue + "%");
		}

		// Trả về kết quả đếm
		return query.getSingleResult();
	}
}
