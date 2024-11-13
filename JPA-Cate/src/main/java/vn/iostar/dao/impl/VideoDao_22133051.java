package vn.iostar.dao.impl;
import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import vn.iostar.configs.JPAConfig;
import vn.iostar.entity.*;
import vn.iostar.dao.*;
public class VideoDao_22133051 implements IVideoDao_22133051{
	
	
	@Override
	public List<Video_22133051> getVideosByCategoryId(Long categoryId) {
		EntityManager enma = JPAConfig.getEntityManager();
        List<Video_22133051> videos = null;

        try {
        	enma.getTransaction().begin();
            
            // Sử dụng JPQL để truy vấn dựa trên quan hệ giữa Video và Category
            String jpql = "SELECT v FROM Video_22133051 v WHERE v.category.categoryId = :categoryId";
            TypedQuery<Video_22133051> query = enma.createQuery(jpql, Video_22133051.class);
            query.setParameter("categoryId", categoryId);
            
            // Lấy kết quả danh sách video
            videos = query.getResultList();

            enma.getTransaction().commit();
        } catch (Exception e) {
        	enma.getTransaction().rollback();
            e.printStackTrace();
        } finally {
        	enma.close();
        }

        return videos;
    }
	
	 @Override
		public Video_22133051 findVideoDetails(Long id) {
			EntityManager enma = JPAConfig.getEntityManager();
			TypedQuery<Video_22133051> query = enma.createQuery("SELECT b FROM Video_22133051 b JOIN FETCH b.category  where b.videoId = :videoId ", Video_22133051.class);
			 query.setParameter("videoId",id);
			 Video_22133051 video =  query.getSingleResult();
			
	        return video;
			
		}
}
