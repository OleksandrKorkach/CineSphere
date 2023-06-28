package com.media.cinesphere.services;

import com.media.cinesphere.dtos.film.FilmDto;

import java.util.List;

public interface FilmService {
    FilmDto getFilmById(Long id);
    List<FilmDto> getAllFilms();
}
