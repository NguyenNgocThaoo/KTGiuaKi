package vn.iostar.dao.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;
import vn.iostar.configs.JPAConfig;
import vn.iostar.dao.IFavoriteDao_22133051;

public class FavoriteDao_22133051 implements IFavoriteDao_22133051{
	
	
	@Override
	public Long countLikesByVideoId(Long videoId) {
		EntityManager em = JPAConfig.getEntityManager();
        Long likeCount = 0L;

        try {
            // Bắt đầu giao dịch
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();

            // Tạo câu truy vấn JPQL để đếm số lượt thích
            String jpql = "SELECT COUNT(f) FROM Favorite_22133051 f WHERE f.video.videoId = :videoId";
            Query query = em.createQuery(jpql);
            query.setParameter("videoId", videoId);

            // Lấy kết quả đếm số lượt thích
            likeCount = (Long) query.getSingleResult();

            // Hoàn thành giao dịch
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }

        return likeCount;
    }
}
