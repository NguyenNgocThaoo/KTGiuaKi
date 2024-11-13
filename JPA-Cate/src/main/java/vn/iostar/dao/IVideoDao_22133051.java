package vn.iostar.dao;

import java.util.List;

import vn.iostar.entity.Video_22133051;

public interface IVideoDao_22133051 {

	List<Video_22133051> getVideosByCategoryId(Long categoryId);

	Video_22133051 findVideoDetails(Long id);

}
