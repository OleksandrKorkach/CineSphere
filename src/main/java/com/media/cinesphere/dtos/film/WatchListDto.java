package com.media.cinesphere.dtos.film;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.media.cinesphere.entities.WatchList;

import java.util.Set;
import java.util.stream.Collectors;

@JsonIgnoreProperties(ignoreUnknown = true)
public class WatchListDto {
    private Long id;
    private String name;
    private Set<FilmDto> films;

    public static WatchListDto fromWatchList(WatchList watchList){
        WatchListDto dto = new WatchListDto();
        dto.setId(watchList.getId());
        dto.setName(watchList.getName());
        Set<FilmDto> filmsDto = watchList.getFilms().stream()
                .map(FilmDto::fromFilm)
                .collect(Collectors.toSet());
        dto.setFilms(filmsDto);
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

    public Set<FilmDto> getFilms() {
        return films;
    }

    public void setFilms(Set<FilmDto> films) {
        this.films = films;
    }
}
