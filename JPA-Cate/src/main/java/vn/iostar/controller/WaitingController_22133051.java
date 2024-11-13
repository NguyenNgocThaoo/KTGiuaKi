package vn.iostar.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import vn.iostar.entity.User_22133051;

import java.io.IOException;

/**
 * Servlet implementation class WaitingController
 */
@SuppressWarnings("serial")
@WebServlet(urlPatterns = "/waiting")
public class WaitingController_22133051 extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(true);
		if (session != null && session.getAttribute("account") != null) {
			User_22133051 u = (User_22133051) session.getAttribute("account");
			session.setAttribute("account", u);
			req.setAttribute("account", u);
			resp.sendRedirect(req.getContextPath() + "/home");
		} else {
			resp.sendRedirect(req.getContextPath() + "/home");
		}
	}
}
