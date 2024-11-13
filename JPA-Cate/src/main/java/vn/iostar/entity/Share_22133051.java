package vn.iostar.entity;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "shares")
public class Share_22133051 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long shareId;

    private String emails;

    private Date sharedDate;

    @ManyToOne
    @JoinColumn(name = "username")
    private User_22133051 user;

    @ManyToOne
    @JoinColumn(name = "videoId")
    private Video_22133051 video;

    // Getters and Setters
}
