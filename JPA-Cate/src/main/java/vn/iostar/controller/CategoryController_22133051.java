package vn.iostar.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vn.iostar.entity.Category_22133051;
import vn.iostar.service.*;
import vn.iostar.service.impl.*;
@WebServlet(name = "CategoryController_22133051", urlPatterns = { "/admin/category", "/admin/category/save", "/admin/category/add",
		"/admin/category/edit", "/admin/category/update", "/admin/category/delete" })
public class CategoryController_22133051 extends HttpServlet {
	ICategoryService_22133051 categoryService = new CategoryServiceImpl_22133051();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getServletPath();
		switch (action) {
		case "/admin/category/add":
			req.getRequestDispatcher("/views/admin/category-add-22133051.jsp").forward(req, resp);
			break;
		case "/admin/category/edit":
			loadcategoryForEdit(req, resp); // Load category data for edit
			break;
		default:
			req.getRequestDispatcher("/views/admin/category-list-22133051.jsp").forward(req, resp);
			break;
		}
	}
		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			String action = req.getServletPath();

			switch (action) {
			case "/admin/category":
				getcategorysWithPagination(req, resp);
				break;
			case "/admin/category/save":
				addcategory(req, resp);
				break;
			case "/admin/category/update":
				updatecategory(req, resp);
				break;
			case "/admin/category/delete":
				deletecategory(req, resp);
				break;
			default:
				resp.sendRedirect("category");
				break;
			}
		}

		private void loadcategoryForEdit(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			String categoryIdParam = request.getParameter("categoryid");
			Long categoryId = Long.parseLong(categoryIdParam);
			Category_22133051 category = categoryService.getCategoryById(categoryId);

			if (category != null) {
				request.setAttribute("category", category);
				request.getRequestDispatcher("/views/admin/category-edit-22133051.jsp").forward(request, response);
			} else {
				response.sendRedirect(request.getContextPath() + "/admin/category");
			}
		}

		private void getcategorysWithPagination(HttpServletRequest request, HttpServletResponse response) throws IOException {
			// Lấy các tham số phân trang từ DataTable
			int start = Integer.parseInt(request.getParameter("start"));
			int length = Integer.parseInt(request.getParameter("length"));
			String searchValue = request.getParameter("search[value]");

			// Đếm tổng số bản ghi trong bảng Category
			Long totalRecords = categoryService.count();

			List<Category_22133051> books = categoryService.searchCate(searchValue, start, length);

			// Đếm số bản ghi sau khi tìm kiếm
			Long filteredRecords = categoryService.countCategory(searchValue);

			// Đóng gói dữ liệu JSON phản hồi cho DataTable
			Map<String, Object> jsonResponse = new HashMap<>();
			jsonResponse.put("draw", request.getParameter("draw"));
			jsonResponse.put("recordsTotal", totalRecords);
			jsonResponse.put("recordsFiltered", filteredRecords);
			jsonResponse.put("data", books);

			// Gửi phản hồi JSON về cho DataTable
			response.setContentType("application/json");
			response.getWriter().write(new ObjectMapper().writeValueAsString(jsonResponse));
		}

		private void addcategory(HttpServletRequest request, HttpServletResponse response) throws IOException {
//			Category_22133051 category = new Category_22133051();
//			category.setEmail(request.getParameter("email"));
//			category.setFullname(request.getParameter("fullname"));
//			category.setPhone(request.getParameter("phone"));
//			Boolean isRememberMe = "on".equals(request.getParameter("remember"));
//			category.setIs_admin(isRememberMe);
//			categoryService.addCategory(category);
//			response.sendRedirect(request.getContextPath() + "/admin/category");
			Category_22133051 category = new Category_22133051();
			category.setCategoryName(request.getParameter("categoryName"));
			category.setCategoryCode(request.getParameter("categoryCode"));
			category.setImages(request.getParameter("images"));

			// Assuming "status" is being passed as "on" or empty, like a checkbox
			Boolean isStatusActive = "on".equals(request.getParameter("status"));
			category.setStatus(isStatusActive);

			categoryService.addCategory(category);
			response.sendRedirect(request.getContextPath() + "/admin/category");

		}

		private void updatecategory(HttpServletRequest request, HttpServletResponse response) throws IOException {
//			String categoryIdParam = request.getParameter("id");
//			Long categoryId = Long.parseLong(categoryIdParam);
//			Category_22133051 category = categoryService.getcategoryById(categoryId);
//			if (category != null) {
//				category.setEmail(request.getParameter("email"));
//				category.setFullname(request.getParameter("fullname"));
//				category.setPhone(request.getParameter("phone"));
//				String bool = request.getParameter("is_admin");
//				if (bool.equals("on")) {
//					category.setIs_admin(true);
//				}
//				else {
//					category.setIs_admin(false);
//				}
//				categoryService.updateCategory(category);
//			}
//			response.sendRedirect(request.getContextPath() + "/admin/category");
			String categoryIdParam = request.getParameter("categoryId");
			Long categoryId = Long.parseLong(categoryIdParam);
			Category_22133051 category = categoryService.getCategoryById(categoryId);

			if (category != null) {
			    category.setCategoryName(request.getParameter("categoryName"));
			    category.setCategoryCode(request.getParameter("categoryCode"));
			    category.setImages(request.getParameter("images"));
			    
			    // Handling the status field as a Boolean
			    String statusParam = request.getParameter("status");
			    if ("on".equals(statusParam)) {
			        category.setStatus(true);
			    } else {
			        category.setStatus(false);
			    }
			    
			    categoryService.updateCategory(category);
			}

			response.sendRedirect(request.getContextPath() + "/admin/category");

		}

		private void deletecategory(HttpServletRequest request, HttpServletResponse response) throws IOException {
			String categoryIdParam = request.getParameter("categoryid");
			Long categoryId = Long.parseLong(categoryIdParam);
			try {
				categoryService.deleteCategory(categoryId);
				// Trả về phản hồi cho client
				response.setContentType("application/json");
				response.setCharacterEncoding("UTF-8");
				response.getWriter().write("{\"status\": \"success\"}");
				response.sendRedirect(request.getContextPath() + "/admin/category");

			} catch (Exception e) {
				response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
				response.getWriter().write("{\"status\": \"error\", \"message\": \"Có lỗi xảy ra khi xóa category.\"}");
				e.printStackTrace();
			}
		}
}
