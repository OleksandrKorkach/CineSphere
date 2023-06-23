package com.media.cinesphere.services;

import com.media.cinesphere.dtos.film.FilmDto;
import com.media.cinesphere.dtos.professional.ProfessionalDto;
import com.media.cinesphere.entities.Professional;

public interface ModeratorService {
    void addFilmToDb(FilmDto filmDto);

    void deleteFilmFromDb(Long filmId);

    void addProfessionalToDb(ProfessionalDto professionalDto);

    void deleteProfessionalFromDb(Long professionalId);
}
