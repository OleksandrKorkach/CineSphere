package com.media.cinesphere.entities;

import com.media.cinesphere.entities.enums.Genre;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "films")
public class Film {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "type")
    private String type;

    @Column(name = "title")
    private String title;

    @Column(name = "duration")
    private Integer duration;

    @Column(name = "description")
    private String description;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Professional> directors;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Professional> stars;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Professional> actors;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Professional> writers;

    @ElementCollection
    @Column(name = "genres")
    private Set<Genre> genres;

    @Column(name = "release_year")
    private Integer releaseYear;

    @Column(name = "overall_rating")
    private Double overallRating;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<Professional> getDirectors() {
        return directors;
    }

    public void setDirectors(Set<Professional> directors) {
        this.directors = directors;
    }

    public Set<Professional> getStars() {
        return stars;
    }

    public void setStars(Set<Professional> stars) {
        this.stars = stars;
    }

    public Set<Professional> getActors() {
        return actors;
    }

    public void setActors(Set<Professional> actors) {
        this.actors = actors;
    }

    public Set<Professional> getWriters() {
        return writers;
    }

    public void setWriters(Set<Professional> writers) {
        this.writers = writers;
    }

    public Set<Genre> getGenres() {
        return genres;
    }

    public void setGenres(Set<Genre> genres) {
        this.genres = genres;
    }

    public Integer getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(Integer releaseYear) {
        this.releaseYear = releaseYear;
    }

    public Double getOverallRating() {
        return overallRating;
    }

    public void setOverallRating(Double overallRating) {
        this.overallRating = overallRating;
    }
}
