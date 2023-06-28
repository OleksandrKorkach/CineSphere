package com.media.cinesphere.services.impl;

import com.media.cinesphere.dtos.film.FilmDto;
import com.media.cinesphere.entities.Film;
import com.media.cinesphere.repositories.FilmRepository;
import com.media.cinesphere.services.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FilmServiceImpl implements FilmService {
    private final FilmRepository filmRepository;

    @Autowired
    public FilmServiceImpl(FilmRepository filmRepository) {
        this.filmRepository = filmRepository;
    }

    @Override
    public FilmDto getFilmById(Long id) {
        Film film = filmRepository.getById(id);
        return FilmDto.fromFilm(film);
    }

    @Override
    public List<FilmDto> getAllFilms() {
        List<Film> films = filmRepository.findAll();
        return films.stream().map(FilmDto::fromFilm).collect(Collectors.toList());
    }
}
