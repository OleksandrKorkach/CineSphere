package com.media.cinesphere.controllers;

import com.media.cinesphere.dtos.film.FilmDto;
import com.media.cinesphere.services.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/titles")
    public ResponseEntity<?> getFilms(){
        return ResponseEntity.ok(filmService.getAllFilms());
    }

}
