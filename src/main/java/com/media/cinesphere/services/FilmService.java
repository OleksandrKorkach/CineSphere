package com.media.cinesphere.services;

import com.media.cinesphere.dtos.film.FilmDto;

public interface FilmService {
    FilmDto getFilmById(Long id);
}
