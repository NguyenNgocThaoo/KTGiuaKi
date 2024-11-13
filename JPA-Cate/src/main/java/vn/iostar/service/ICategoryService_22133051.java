package vn.iostar.service;

import java.util.List;

import vn.iostar.entity.Category_22133051;

public interface ICategoryService_22133051 {

	void addCategory(Category_22133051 cate);

	void updateCategory(Category_22133051 cate);

	void deleteCategory(Long cateId) throws Exception;

	Long countCategory(String searchValue);

	List<Category_22133051> searchCate(String searchValue, int start, int length);

	Long count();

	Category_22133051 getCategoryById(Long cateId);

	List<Category_22133051> getAllCategory();

}
