package com.media.cinesphere.entities;

import javax.persistence.*;
import java.util.List;

@Entity
public class Watchlist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "media_quantity")
    private Integer mediaQuantity;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "watchlist")
    private List<WatchlistMedia> titles;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getMediaQuantity() {
        return mediaQuantity;
    }

    public void setMediaQuantity(Integer mediaQuantity) {
        this.mediaQuantity = mediaQuantity;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<WatchlistMedia> getTitles() {
        return titles;
    }

    public void setTitles(List<WatchlistMedia> titles) {
        this.titles = titles;
    }
}
