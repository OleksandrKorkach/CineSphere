package com.media.cinesphere.dtos.film;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.media.cinesphere.entities.Film;
import com.media.cinesphere.entities.Professional;
import com.media.cinesphere.entities.enums.Genre;

import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
public class FilmDto {
    private Long id;
    private String name;
    private String description;
    private Set<Genre> genres;
    private Integer releaseYear;
    private Integer duration;
    private Double overallRating;
    private Set<Professional> directors;
    private Set<Professional> writers;
    private Set<Professional> stars;
    private Set<Professional> actors;

    public static FilmDto fromFilm(Film film){
        FilmDto dto = new FilmDto();
        dto.setId(film.getId());
        dto.setName(film.getTitle());
        dto.setDescription(film.getDescription());
        dto.setGenres(film.getGenres());
        dto.setReleaseYear(film.getReleaseYear());
        dto.setDuration(film.getDuration());
        dto.setOverallRating(film.getOverallRating());
        dto.setDirectors(film.getDirectors());
        dto.setWriters(film.getWriters());
        dto.setStars(film.getStars());
        dto.setActors(film.getActors());
        return dto;
    }


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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public Double getOverallRating() {
        return overallRating;
    }

    public void setOverallRating(Double overallRating) {
        this.overallRating = overallRating;
    }

    public Set<Professional> getDirectors() {
        return directors;
    }

    public void setDirectors(Set<Professional> directors) {
        this.directors = directors;
    }

    public Set<Professional> getWriters() {
        return writers;
    }

    public void setWriters(Set<Professional> writers) {
        this.writers = writers;
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
}
