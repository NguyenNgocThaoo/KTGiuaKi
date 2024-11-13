package vn.iostar.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import vn.iostar.entity.User_22133051;
import vn.iostar.service.IUserService_22133051;
import vn.iostar.service.impl.UserServiceImpl_22133051;

@WebServlet("/login")
public class LoginController_22133051 extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Hiển thị trang login (form đăng nhập)
		request.getRequestDispatcher("/views/login_22133051.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		Boolean isRememberMe = "on".equals(req.getParameter("remember"));
//			boolean isRememberMe = false;
		String alertMsg = "";
//			if("on".equals(isRememberMe)){
//				 isRememberMe = true;
//				 }
		if (username.isEmpty() || password.isEmpty()) {
			alertMsg = "Tài khoản hoặc mật khẩu không được rỗng";
			req.setAttribute("alert", alertMsg);
			req.getRequestDispatcher("/views/login.jsp").forward(req, resp);
			return;
		}
		IUserService_22133051 userService = new UserServiceImpl_22133051();
		User_22133051 user = userService.login(username, password);
		if (user != null) {
			HttpSession session = req.getSession(true);
			session.setAttribute("account", user);
			if (isRememberMe) {
				saveRemeberMe(resp, username);
			} else {
				deleteRememberMe(resp);
			}

			resp.sendRedirect(req.getContextPath() + "/waiting");
		} else {
			alertMsg = "Tài khoản hoặc mật khẩu không chính xác";
			req.setAttribute("alert", alertMsg);
			req.getRequestDispatcher("/views/login_22133051.jsp").forward(req, resp);
		}
	}

	private void saveRemeberMe(HttpServletResponse response, String email) {
		Cookie cookie = new Cookie("email", email);
		cookie.setMaxAge(30*10);
		cookie.setPath("/");
		response.addCookie(cookie);
	}

	private void deleteRememberMe(HttpServletResponse response) {
		Cookie cookie = new Cookie("email", "");
		cookie.setMaxAge(30*10); // Xóa cookie ngay lập tức
		cookie.setPath("/");
		response.addCookie(cookie);
	}

}
