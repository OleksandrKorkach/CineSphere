package com.media.cinesphere.dtos.film;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.media.cinesphere.entities.Film;
import com.media.cinesphere.entities.Professional;
import com.media.cinesphere.entities.enums.Genre;

import java.util.Set;
import java.util.stream.Collectors;

@JsonIgnoreProperties(ignoreUnknown = true)
public class FilmDto {
    private Long id;
    private String type;
    private String title;
    private Integer duration;
    private String description;
    private Set<String> directors;
    private Set<String> stars;
    private Set<String> actors;
    private Set<String> writers;
    private Set<Genre> genres;
    private Integer releaseYear;
    private Double overallRating;

    public static FilmDto fromFilm(Film film){
        FilmDto dto = new FilmDto();
        dto.setId(film.getId());
        dto.setTitle(film.getTitle());
        dto.setType(film.getType());
        dto.setDescription(film.getDescription());
        dto.setGenres(film.getGenres());
        dto.setReleaseYear(film.getReleaseYear());
        dto.setDuration(film.getDuration());
        dto.setOverallRating(film.getOverallRating());
        Set<String> directors = film.getDirectors().stream()
                        .map(Professional::getName).collect(Collectors.toSet());
        Set<String> stars = film.getStars().stream()
                .map(Professional::getName).collect(Collectors.toSet());
        Set<String> actors = film.getActors().stream()
                .map(Professional::getName).collect(Collectors.toSet());
        Set<String> writers = film.getWriters().stream()
                .map(Professional::getName).collect(Collectors.toSet());
        dto.setDirectors(directors);
        dto.setStars(stars);
        dto.setActors(actors);
        dto.setWriters(writers);
        return dto;
    }


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

    public Set<String> getDirectors() {
        return directors;
    }

    public void setDirectors(Set<String> directors) {
        this.directors = directors;
    }

    public Set<String> getStars() {
        return stars;
    }

    public void setStars(Set<String> stars) {
        this.stars = stars;
    }

    public Set<String> getActors() {
        return actors;
    }

    public void setActors(Set<String> actors) {
        this.actors = actors;
    }

    public Set<String> getWriters() {
        return writers;
    }

    public void setWriters(Set<String> writers) {
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
