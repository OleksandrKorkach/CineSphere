package com.media.cinesphere.controllers;

import com.media.cinesphere.dtos.film.FilmDto;
import com.media.cinesphere.dtos.professional.ProfessionalDto;
import com.media.cinesphere.services.ModeratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/moderator")
public class ModeratorController {
    private final ModeratorService moderatorService;

    @Autowired
    public ModeratorController(ModeratorService moderatorService) {
        this.moderatorService = moderatorService;
    }

    @PostMapping("/add/title")
    public ResponseEntity<?> addFilmToDb(@RequestBody FilmDto filmDto){
        moderatorService.addFilmToDb(filmDto);
        return ResponseEntity.ok("Successfully added title to Database");
    }

    @PostMapping("/delete/title/{titleId}")
    public ResponseEntity<?> deleteFilmFromDb(@PathVariable Long titleId){
        moderatorService.deleteFilmFromDb(titleId);
        return ResponseEntity.ok("Deleted from Database successfully!");
    }

    @PostMapping("/add/professional")
    public ResponseEntity<?> addProfessionalToDb(@RequestBody ProfessionalDto professionalDto){
        moderatorService.addProfessionalToDb(professionalDto);
        return ResponseEntity.ok("Professional added!");
    }

    @PostMapping("/delete/professional/{professionalId}")
    public ResponseEntity<?> deleteProfessionalsFromDb(@PathVariable Long professionalId){
        moderatorService.deleteProfessionalFromDb(professionalId);
        return ResponseEntity.ok("Professional deleted!");
    }
}
