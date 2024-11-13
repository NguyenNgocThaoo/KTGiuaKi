package vn.iostar.entity;

import java.util.List;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
@NamedQuery(name = "User_22133051.findAll", query = "SELECT c FROM User_22133051 c")
public class User_22133051 {
    @Id
    private String username;

    private String password;
    private String phone;
    private String fullname;
    private String email;
    private Boolean admin;
    private Boolean active;
    private String images;

    @OneToMany(mappedBy = "user")
    private List<Favorite_22133051> favorites;

    @OneToMany(mappedBy = "user")
    private List<Share_22133051> shares;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Boolean getAdmin() {
		return admin;
	}

	public void setAdmin(Boolean admin) {
		this.admin = admin;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public String getImages() {
		return images;
	}

	public void setImages(String images) {
		this.images = images;
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

