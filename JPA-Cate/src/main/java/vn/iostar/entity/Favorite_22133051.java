package vn.iostar.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import java.util.Date;

@Entity
@Table(name = "favorites")
public class Favorite_22133051 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long favoriteId;

    private Date likedDate;

    @ManyToOne
    @JoinColumn(name = "videoId")
    private Video_22133051 video;

    @ManyToOne
    @JoinColumn(name = "username")
    private User_22133051 user;

	public Long getFavoriteId() {
		return favoriteId;
	}

	public void setFavoriteId(Long favoriteId) {
		this.favoriteId = favoriteId;
	}

	public Date getLikedDate() {
		return likedDate;
	}

	public void setLikedDate(Date likedDate) {
		this.likedDate = likedDate;
	}

	public Video_22133051 getVideo() {
		return video;
	}

	public void setVideo(Video_22133051 video) {
		this.video = video;
	}

	public User_22133051 getUser() {
		return user;
	}

	public void setUser(User_22133051 user) {
		this.user = user;
	}

    // Getters and Setters
    
}
