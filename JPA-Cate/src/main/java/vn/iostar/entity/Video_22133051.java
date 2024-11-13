package vn.iostar.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "videos")
public class Video_22133051 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long videoId;

    private String title;
    private String poster;
    private Integer views;
    private String description;
    private Boolean active;

    @ManyToOne
    @JoinColumn(name = "categoryId")
    private Category_22133051 category;

    @OneToMany(mappedBy = "video")
    private List<Favorite_22133051> favorites;

    @OneToMany(mappedBy = "video")
    private List<Share_22133051> shares;

	public Long getVideoId() {
		return videoId;
	}

	public void setVideoId(Long videoId) {
		this.videoId = videoId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPoster() {
		return poster;
	}

	public void setPoster(String poster) {
		this.poster = poster;
	}

	public Integer getViews() {
		return views;
	}

	public void setViews(Integer views) {
		this.views = views;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public Category_22133051 getCategory() {
		return category;
	}

	public void setCategory(Category_22133051 category) {
		this.category = category;
	}

	public List<Favorite_22133051> getFavorites() {
		return favorites;
	}

	public void setFavorites(List<Favorite_22133051> favorites) {
		this.favorites = favorites;
	}

	public List<Share_22133051> getShares() {
		return shares;
	}

	public void setShares(List<Share_22133051> shares) {
		this.shares = shares;
	}

    // Getters and Setters
    
}

