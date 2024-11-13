package vn.iostar.entity;

import jakarta.persistence.*;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "categories")
@NamedQuery(name = "Category_22133051.findAll", query = "SELECT c FROM Category_22133051 c")
public class Category_22133051 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long categoryId;

    private String categoryName;
    private String categoryCode;
    private String images;
    private Boolean status;

    @OneToMany(mappedBy = "category")
    @JsonIgnore
    private List<Video_22133051> videos;

	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getCategoryCode() {
		return categoryCode;
	}

	public void setCategoryCode(String categoryCode) {
		this.categoryCode = categoryCode;
	}

	public String getImages() {
		return images;
	}

	public void setImages(String images) {
		this.images = images;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public List<Video_22133051> getVideos() {
		return videos;
	}

	public void setVideos(List<Video_22133051> videos) {
		this.videos = videos;
	}

    // Getters and Setters
    
}
