package vn.iostar.controller;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vn.iostar.service.*;
import vn.iostar.service.impl.*;
import vn.iostar.entity.*;
@WebServlet("/video-details")
public class VideoDetailsController_22133051  extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	IVideoService_22133051 videoService = new VideoServiceImpl_22133051();
	IFavoriteService_22133051 favService = new FavoriteServiceImpl_22133051();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String videoId = request.getParameter("id");
       Video_22133051 video = videoService.findVideoDetails(Long.parseLong(videoId));
       Category_22133051 cate = video.getCategory();
       Long likeCount = favService.countLikesByVideoId(Long.parseLong(videoId));
        // Fetch book details based on bookId and set it in request attributes
        // Forward to a JSP page to display book details
        request.setAttribute("cate", cate);
        request.setAttribute("video", video);
        request.setAttribute("likeCount", likeCount);
        request.getRequestDispatcher("/views/video-details-22133051.jsp").forward(request, response);

	}
}
