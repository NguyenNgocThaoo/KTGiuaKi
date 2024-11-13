package vn.iostar.service.impl;

import vn.iostar.entity.Category_22133051;
import vn.iostar.service.ICategoryService_22133051;

import java.util.List;

import vn.iostar.dao.*;
import vn.iostar.dao.impl.*;
public class CategoryServiceImpl_22133051 implements ICategoryService_22133051{
	ICategoryDao_22133051 cateDao = new CategoryDao_22133051();
	
	@Override
	public Category_22133051 getCategoryById(Long cateId) {
		return cateDao.getCategoryById(cateId);
	}
	
	@Override
	public Long count() {
		return cateDao.count()	;
	}
	@Override
	public List<Category_22133051> searchCate(String searchValue, int start, int length){
		return cateDao.searchCate(searchValue, start, length);
	}
	
	@Override
	public Long countCategory(String searchValue) {
		return cateDao.countCategory(searchValue);
	}
	
	@Override
	public void deleteCategory(Long cateId) throws Exception{
		 cateDao.deleteCategory(cateId);
	}
	@Override
	public void updateCategory(Category_22133051 cate) {
		cateDao.updateCategory(cate);
	}
	@Override
	public void addCategory(Category_22133051 cate) {
		cateDao.addCategory(cate);
	}
	@Override
	public List<Category_22133051> getAllCategory(){
		return cateDao.getAllCategory();
	}
}
