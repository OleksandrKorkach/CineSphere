package com.media.cinesphere.services.impl;

import com.media.cinesphere.dtos.film.FilmDto;
import com.media.cinesphere.dtos.professional.ProfessionalDto;
import com.media.cinesphere.entities.Film;
import com.media.cinesphere.entities.Professional;
import com.media.cinesphere.repositories.FilmRepository;
import com.media.cinesphere.repositories.ProfessionalRepository;
import com.media.cinesphere.services.ModeratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class ModeratorServiceImpl implements ModeratorService {
    private final FilmRepository filmRepository;
    private final ProfessionalRepository professionalRepository;

    @Autowired
    public ModeratorServiceImpl(FilmRepository filmRepository, ProfessionalRepository professionalRepository) {
        this.filmRepository = filmRepository;
        this.professionalRepository = professionalRepository;
    }

    @Override
    public void addFilmToDb(FilmDto filmDto) {
        Film film = new Film();
        setCommonFilmAttributes(film, filmDto);
        setFilmProfessionals(film, filmDto);
        filmRepository.save(film);
    }

    public void setCommonFilmAttributes(Film film, FilmDto filmDto){
        film.setType(filmDto.getType());
        film.setTitle(filmDto.getTitle());
        film.setDescription(filmDto.getDescription());
        film.setDuration(filmDto.getDuration());
        film.setGenres(filmDto.getGenres());
        film.setOverallRating(0.0);
        film.setReleaseYear(filmDto.getReleaseYear());
    }

    public void setFilmProfessionals(Film film, FilmDto filmDto){
        Set<Professional> stars = getProfessionalsFromStringSet(filmDto.getStars());
        film.setStars(stars);
        Set<Professional> directors = getProfessionalsFromStringSet(filmDto.getDirectors());
        film.setDirectors(directors);
        Set<Professional> actors = getProfessionalsFromStringSet(filmDto.getActors());
        film.setActors(actors);
        Set<Professional> writers = getProfessionalsFromStringSet(filmDto.getWriters());
        film.setWriters(writers);
    }

    public Set<Professional> getProfessionalsFromStringSet(Set<String> professionalsFromDto){
        Set<Professional> professionals = new HashSet<>();
        if (professionalsFromDto == null){
            return professionals;
        }
        for (String professional: professionalsFromDto){
            Professional pro = professionalRepository.findProfessionalByName(professional);
            if (pro == null){
                continue;
            }
            professionals.add(pro);
        }
        return professionals;
    }

    @Override
    public void deleteFilmFromDb(Long id) {
        professionalRepository.deleteById(id);
    }

    @Override
    public void addProfessionalToDb(ProfessionalDto professionalDto) {
        Professional professional = professionalDto.toProfessional(professionalDto);
        professionalRepository.save(professional);
    }

    @Override
    public void deleteProfessionalFromDb(Long professionalId) {
        professionalRepository.deleteById(professionalId);
    }
}
