package vn.iostar.service.impl;

import java.util.List;

import vn.iostar.entity.Video_22133051;
import vn.iostar.dao.*;
import vn.iostar.dao.impl.*;
import vn.iostar.service.*;
public class VideoServiceImpl_22133051 implements IVideoService_22133051{
	IVideoDao_22133051 videoDao = new VideoDao_22133051();
	@Override
	public List<Video_22133051> getVideosByCategoryId(Long categoryId){
		return videoDao.getVideosByCategoryId(categoryId);
	}
	
	@Override
	public Video_22133051 findVideoDetails(Long id) {
		return videoDao.findVideoDetails(id);
	}
}
