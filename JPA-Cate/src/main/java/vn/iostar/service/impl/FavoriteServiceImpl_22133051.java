package vn.iostar.service.impl;
import vn.iostar.service.*;
import vn.iostar.dao.impl.*;
import vn.iostar.dao.*;
public class FavoriteServiceImpl_22133051 implements IFavoriteService_22133051{
	IFavoriteDao_22133051 favDao = new FavoriteDao_22133051();
	@Override
	public Long countLikesByVideoId(Long videoId) {
		return favDao.countLikesByVideoId(videoId);
	}
}
