package com.media.cinesphere.controllers;

import com.media.cinesphere.dtos.film.FilmDto;
import com.media.cinesphere.services.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/title")
public class FilmController {
    private final FilmService filmService;

    @Autowired
    public FilmController(FilmService filmService) {
        this.filmService = filmService;
    }

    @GetMapping("/{titleId}")
    public ResponseEntity<?> getFilmById(@PathVariable Long titleId){
        FilmDto film = filmService.getFilmById(titleId);
        return ResponseEntity.ok(film);
    }
}
