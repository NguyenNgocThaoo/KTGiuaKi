package vn.iostar.dao;

import java.util.List;

import vn.iostar.entity.Category_22133051;

public interface ICategoryDao_22133051 {

	Long countCategory(String searchValue);

	List<Category_22133051> searchCate(String searchValue, int start, int length);

	Long count();

	Category_22133051 getCategoryById(Long cateId);

	void deleteCategory(Long cateId) throws Exception;

	void updateCategory(Category_22133051 cate);

	void addCategory(Category_22133051 cate);

	List<Category_22133051> getAllCates(int page, int pagesize);

	List<Category_22133051> getAllCategory();

}
