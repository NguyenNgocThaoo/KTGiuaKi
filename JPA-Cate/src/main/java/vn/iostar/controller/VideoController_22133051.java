package vn.iostar.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import vn.iostar.service.*;
import vn.iostar.service.impl.*;
import vn.iostar.entity.*;
@WebServlet("/videos")
public class VideoController_22133051 extends HttpServlet{
	ICategoryService_22133051 cateService = new CategoryServiceImpl_22133051();
	IVideoService_22133051 videoService = new VideoServiceImpl_22133051();
	 @Override
	    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	    	 List<Category_22133051> cates = cateService.getAllCategory();
	        Map<Category_22133051, List<Video_22133051>> cateVideos = new HashMap<>();
	        
	        for (Category_22133051 cate : cates) {
	            List<Video_22133051> videos = videoService.getVideosByCategoryId(cate.getCategoryId());
	            cateVideos.put(cate, videos);
	        }
	        

	        req.setAttribute("cateVideos", cateVideos);
	        req.getRequestDispatcher("/views/video-list-22133051.jsp").forward(req, resp);
	    }
}
